package org.jpp.modules._io;

import org.jpp.heart.BufferProtocol;
import org.jpp.heart.BuiltinDocs;
import org.jpp.heart.Py;
import org.jpp.heart.PyBUF;
import org.jpp.heart.PyLong;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedType;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

@ExposedType(name = "_io.BufferedWriter")
public class PyBufferedWriter extends PyObject {
    public static final PyType TYPE = PyType.fromClass(PyBufferedWriter.class);

    private BufferedOutputStream output;
    private FileChannel fileChannel;

    public PyBufferedWriter(OutputStream out) {
        output = new BufferedOutputStream(out);
    }

    public PyBufferedWriter(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            output = new BufferedOutputStream(fileOutputStream);
            fileChannel = fileOutputStream.getChannel();
        } catch (FileNotFoundException e) {
            throw Py.IOError(e);
        }
    }

    @ExposedMethod(doc = BuiltinDocs.BufferedWriter_write_doc)
    public final PyObject BufferedWriter_write(PyObject b) {
        if (!(b instanceof BufferProtocol)) {
            throw Py.TypeError("bytes-like object expected");
        }
        try {
            output.write(((BufferProtocol) b).getBuffer(PyBUF.FULL_RO).getNIOByteBuffer().array());
            return new PyLong(b.__len__());
        } catch (IOException e) {
            throw Py.IOError(e);
        }
    }

    @ExposedMethod(doc = BuiltinDocs.BufferedWriter_flush_doc)
    public final void BufferedWriter_flush() {
        try {
            output.flush();
        } catch (IOException e) {
            throw Py.IOError(e);
        }
    }

    @ExposedMethod(doc = BuiltinDocs.BufferedWriter_tell_doc)
    public final PyObject BufferedWriter_tell() {
        try {
            return new PyLong(fileChannel.position());
        } catch (IOException e) {
            throw Py.IOError(e);
        }
    }
}
