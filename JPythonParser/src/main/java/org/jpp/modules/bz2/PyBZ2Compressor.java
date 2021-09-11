package org.jpp.modules.bz2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.jpp.heart.ArgParser;
import org.jpp.heart.Py;
import org.jpp.heart.PyBytes;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.heart.Untraversable;
import org.jpp.heart.util.StringUtil;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@Untraversable
@ExposedType(name = "bz2.BZ2Compressor")
public class PyBZ2Compressor extends PyObject {

    private CaptureStream captureStream = null;
    private BZip2CompressorOutputStream compressStream = null;

    public static final PyType TYPE = PyType.fromClass(PyBZ2Compressor.class);

    public PyBZ2Compressor() {
        super(TYPE);
    }

    public PyBZ2Compressor(PyType subType) {
        super(subType);
    }

    @ExposedNew
    final void BZ2Compressor___init__(PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("bz2compressor", args, kwds,
                new String[] { "compresslevel" }, 0);

        int compresslevel = ap.getInt(0, 9);

        try {
            captureStream = new CaptureStream();
            compressStream = new BZip2CompressorOutputStream(captureStream,
                    compresslevel);
        } catch (IOException e) {
            throw Py.IOError(e.getMessage());
        }
    }

    @ExposedMethod
    public PyBytes BZ2Compressor_compress(PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("compress", args, kwds,
                new String[] { "data" }, 1);

        byte[] buf = Py.unwrapBuffer(ap.getPyObject(0));

        PyBytes returnData = null;
        try {
            compressStream.write(buf);

            returnData = readData();
        } catch (IOException e) {
            throw Py.IOError(e.getMessage());
        }

        return returnData;
    }

    private PyBytes readData() {
        if (!captureStream.hasData()) {
            return Py.EmptyByte;
        }
        
        byte[] buf = captureStream.readData();
        captureStream.resetByteArray();
        return new PyBytes(StringUtil.fromBytes(buf));
    }

    @ExposedMethod
    public PyBytes BZ2Compressor_flush(PyObject[] args, String[] kwds) {
        PyBytes finalData = Py.EmptyByte;
        try {
            compressStream.finish();
            compressStream.close();

            finalData = readData();

            captureStream.close();
        } catch (IOException e) {
            throw Py.IOError(e.getMessage());
        }

        return finalData;
    }

    private class CaptureStream extends OutputStream {

        private final ByteArrayOutputStream capturedData = new ByteArrayOutputStream();

        @Override
        public void write(int byteData) throws IOException {
            capturedData.write(byteData);
        }

        public byte[] readData() {
            return capturedData.toByteArray();
        }

        public void resetByteArray() {
            capturedData.reset();
        }

        public boolean hasData() {
            return capturedData.size() > 0;
        }

    }
}
