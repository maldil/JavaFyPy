package org.jpp.modules.bz2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.jpp.heart.ArgParser;
import org.jpp.heart.Py;
import org.jpp.heart.PyBytes;
import org.jpp.heart.PyException;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyList;
import org.jpp.heart.PyLong;
import org.jpp.heart.PyNone;
import org.jpp.heart.PyObject;
import org.jpp.heart.PySequence;
import org.jpp.heart.PyType;
import org.jpp.heart.Untraversable;
import org.jpp.heart.finalization.FinalizablePyObject;
import org.jpp.heart.finalization.FinalizableBuiltin;
import org.jpp.heart.finalization.FinalizeTrigger;
import org.jpp.heart.io.BinaryIOWrapper;
import org.jpp.heart.io.BufferedReader;
import org.jpp.heart.io.BufferedWriter;
import org.jpp.heart.io.IOBase;
import org.jpp.heart.io.StreamIO;
import org.jpp.heart.io.TextIOBase;
import org.jpp.heart.io.UniversalIOWrapper;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@Untraversable
@ExposedType(name = "bz2.BZ2File")
public class PyBZ2File extends PyObject implements FinalizablePyObject, FinalizableBuiltin {

    public static final PyType TYPE = PyType.fromClass(PyBZ2File.class);
    private int buffering;

    @ExposedGet(name = "newlines")
    public PyObject PyBZ2File_newlines() {
        if (buffer != null) {
            return buffer.getNewlines();
        } else {
            return Py.None;
        }
    }

    private TextIOBase buffer;
    private String fileName = null;
    private boolean inIterMode = false;
    private boolean inUniversalNewlineMode = false;
    private boolean needReadBufferInit = false;
    private boolean inReadMode = false;
    private boolean inWriteMode = false;

    public PyBZ2File() {
        super(TYPE);
        FinalizeTrigger.ensureFinalizer(this);
    }

    public PyBZ2File(PyType subType) {
        super(subType);
        FinalizeTrigger.ensureFinalizer(this);
    }

    @Override
    public void __del_builtin__() {
        BZ2File_close();
    }

    @ExposedNew
    @ExposedMethod
    final void BZ2File___init__(PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("bz2file", args, kwds, new String[] {
                "filename", "mode", "buffering", "compresslevel" }, 1);

        PyObject filename = ap.getPyObject(0);
        if (!(filename instanceof PyBytes)) {
            throw Py.TypeError("coercing to Unicode: need string, '"
                    + filename.getType().fastGetName() + "' type found");
        }

        String mode = ap.getString(1, "r");
        int buffering = ap.getInt(2, 0);
        int compresslevel = ap.getInt(3, 9);
        BZ2File___init__((PyBytes) filename, mode, buffering, compresslevel);
    }

    private void BZ2File___init__(PyBytes inFileName, String mode,
                                  int buffering, int compresslevel) {
        try {
            fileName = inFileName.asString();
            this.buffering = buffering;

            // check universal newline mode
            if (mode.contains("U")) {
                inUniversalNewlineMode = true;
            }

            if (mode.contains("w")) {
                inWriteMode = true;
                File f = new File(fileName);
                if (!f.exists()) {
                    f.createNewFile();
                }

                BZip2CompressorOutputStream writeStream = new BZip2CompressorOutputStream(
                        new FileOutputStream(fileName), compresslevel);
                buffer = new BinaryIOWrapper(
                            new BufferedWriter(
                                new SkippableStreamIO(writeStream, true),
                                buffering));
            } else {
                File f = new File(fileName);
                if (!f.exists()) {
                    throw new FileNotFoundException();
                }

                inReadMode = true;
                needReadBufferInit = true;
            }
        } catch (IOException e) {
            throw Py.IOError("File " + fileName + " not found,");
        }
    }

    private void makeReadBuffer() {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(fin);
            BZip2CompressorInputStream bZin = new BZip2CompressorInputStream(
                    bin, true);
            BufferedReader bufferedReader = new BufferedReader(
                    new SkippableStreamIO(bZin, true), buffering);

            if (inUniversalNewlineMode) {
                buffer = new UniversalIOWrapper(bufferedReader);
            } else {
                buffer = new BinaryIOWrapper(bufferedReader);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            throw Py.IOError(fileNotFoundException);
        } catch (IOException ioe) {
            throw Py.EOFError(ioe.getMessage());
        }
    }

    @Override
    @ExposedMethod
    public void __del__() {
        BZ2File_close();
    }

    @ExposedMethod
    public void BZ2File_close() {
        needReadBufferInit = false;
        BZ2File_flush();
        if (buffer != null) {
            buffer.close();
        }
    }

    private void BZ2File_flush() {
        if (buffer != null) {
            buffer.flush();
        }
    }

    @ExposedMethod
    public PyObject BZ2File_read(PyObject[] args, String[] kwds) {
        checkInIterMode();
        checkReadBufferInit();

        ArgParser ap = new ArgParser("read", args, kwds,
                new String[] { "size" }, 0);

        int size = ap.getInt(0, -1);

        if (size == 0) { return Py.EmptyByte; }
        if (size < 0) { return new PyBytes(buffer.readall()); }
        StringBuilder data = new StringBuilder(size);
        while (data.length() < size) {
            String chunk = buffer.read(size - data.length());
            if (chunk.length() == 0) {
                break;
            }
            data.append(chunk);
        }
        return new PyBytes(data.toString());
    }

    @ExposedMethod
    public PyObject BZ2File_next(PyObject[] args, String[] kwds) {
        checkReadBufferInit();

        if (buffer == null || buffer.closed()) {
            throw Py.ValueError("Cannot call next() on closed file");
        }

        inIterMode = true;
        return null;
    }

    @ExposedMethod
    public PyBytes BZ2File_readline(PyObject[] args, String[] kwds) {
        checkInIterMode();
        checkReadBufferInit();

        ArgParser ap = new ArgParser("read", args, kwds,
                new String[] { "size" }, 0);

        int size = ap.getInt(0, -1);

        return new PyBytes(buffer.readline(size));
    }

    @ExposedMethod
    public PyList BZ2File_readlines(PyObject[] args, String[] kwds) {
        checkInIterMode();
        checkReadBufferInit();

        // make sure file data valid
        if (buffer == null || buffer.closed()) {
            throw Py.ValueError("Cannot call readlines() on a closed file");
        }
        PyList lineList = new PyList();

        PyBytes line = null;
        while (!(line = BZ2File_readline(args, kwds)).equals(Py.EmptyByte)) {
            lineList.add(line);
        }

        return lineList;
    }

    private void checkInIterMode() {
        if (inReadMode && inIterMode) {
            throw Py.ValueError("Cannot mix iteration and reads");
        }
    }

    private void checkReadBufferInit() {
        if (inReadMode && needReadBufferInit) {
            makeReadBuffer();
            needReadBufferInit = false;
        }
    }

    @ExposedMethod
    public PyList BZ2File_xreadlines() {
        return BZ2File_readlines(new PyObject[0], new String[0]);
    }

    @ExposedMethod
    public void BZ2File_seek(PyObject[] args, String[] kwds) {
        if (!inReadMode) {
            Py.IOError("seek works only while reading");
        }

        ArgParser ap = new ArgParser("seek", args, kwds, new String[] {
                "offset", "whence" }, 1);

        checkReadBufferInit();

        int newOffset = ap.getInt(0);
        int whence = ap.getInt(1, 0);

        // normalise offset
        long currentPos = buffer.tell();

        long finalOffset = 0;
        switch (whence) {
        case 0: // offset from start of file
            finalOffset = newOffset;
            break;
        case 1: // move relative to current position
            finalOffset = currentPos + newOffset;

            break;
        case 2: // move relative to end of file
            long fileSize = currentPos;

            // in order to seek from the end of the stream we need to fully read
            // the decompressed stream to get the size
            for (;;) {
                final String data = buffer.read(IOBase.DEFAULT_BUFFER_SIZE);
                if (data.isEmpty()) {
                    break;
                }
                fileSize += data.length();
            }

            finalOffset = fileSize + newOffset;

            // close and reset the buffer
            buffer.close();
            makeReadBuffer();

            break;
        }

        if (finalOffset < 0) {
            finalOffset = 0;
        }

        // can't seek backwards so close and reopen the stream at the start
        if (whence != 2 && finalOffset < currentPos) {
            buffer.close();
            makeReadBuffer();
        }

        // seek operation
        buffer.seek(finalOffset, 0);
    }

    @ExposedMethod
    public PyLong BZ2File_tell() {
        checkReadBufferInit();
        if (buffer == null) {
            return Py.newLong(0);
        } else {
            return Py.newLong(buffer.tell());
        }
    }

    @ExposedMethod
    public void BZ2File_write(PyObject[] args, String[] kwds) {
        checkFileWritable();

        ArgParser ap = new ArgParser("write", args, kwds,
                new String[] { "data" }, 0);

        PyObject data = ap.getPyObject(0);
        if (data.getType() == PyNone.TYPE) {
            throw Py.TypeError("Expecting str argument");
        }

        buffer.write(ap.getString(0));
    }

    @ExposedMethod
    public void BZ2File_writelines(PyObject[] args, String[] kwds) {
        checkFileWritable();

        ArgParser ap = new ArgParser("writelines", args, kwds,
                new String[] { "sequence_of_strings" }, 0);

        PySequence seq = (PySequence) ap.getPyObject(0);
        for (Iterator<PyObject> iterator = seq.asIterable().iterator(); iterator
                .hasNext();) {
            PyObject line = iterator.next();

            BZ2File_write(new PyObject[] { line }, new String[] { "data" });

        }

    }

    private void checkFileWritable() {
        if (inReadMode) {
            throw Py.IOError("File in read-only mode");
        }

        if (buffer == null || buffer.closed()) {
            throw Py.ValueError("Stream closed");
        }
    }

    @Override
    @ExposedMethod
    public PyObject __iter__() {
        return new BZ2FileIterator();
    }

    private class BZ2FileIterator extends PyIterator {

        @Override
        public PyObject __next__() {
            PyBytes s = BZ2File_readline(new PyObject[0], new String[0]);

            if (s.equals(Py.EmptyByte)) {
                return null;
            } else {
                return s;
            }
        }

    }

    @ExposedMethod
    public PyObject BZ2File___enter__() {
        if (inWriteMode) {
            if (buffer == null) {
                throw Py.ValueError("Stream closed");
            }
        } else if (inReadMode && !needReadBufferInit) {
            if (buffer == null || buffer.closed()) {
                throw Py.ValueError("Stream closed");
            }
        }

        return this;
    }

    @ExposedMethod
    public boolean BZ2File___exit__(PyObject exc_type, PyObject exc_value,
            PyObject traceback) {
        BZ2File_close();
        return false;
    }

    private static class SkippableStreamIO extends StreamIO {
        private long position = 0;

        public SkippableStreamIO(InputStream inputStream, boolean closefd) {
            super(inputStream, closefd);
        }

        public SkippableStreamIO(OutputStream outputStream, boolean closefd) {
            super(outputStream, closefd);
        }

        @Override
        public int readinto(ByteBuffer buf) {
            int bytesRead = 0;
            try {
                bytesRead = super.readinto(buf);
            } catch (PyException pyex) {
                // translate errors on read of decompressed stream to EOFError
                throw Py.EOFError(pyex.value.asStringOrNull());
            }

            position += bytesRead;
            return bytesRead;
        }

        @Override
        public long tell() {
            return position;
        }

        @Override
        public long seek(long offset, int whence) {
            long skipBytes = offset - position;
            if (whence != 0 || skipBytes < 0) {
                throw Py.IOError("can only seek forward");
            }

            if (skipBytes == 0) {
                return position;
            } else {
                long skipped = 0;
                try {
                    skipped = asInputStream().skip(skipBytes);
                } catch (IOException ex) {
                    throw Py.IOError(ex);
                }
                long newPosition = position + skipped;
                position = newPosition;

                return newPosition;
            }
        }
    }
}
