/* Copyright (c) 2007 Jython Developers */
package org.jpp.heart.io;

import org.jpp.heart.Py;
import org.jpp.heart.PyObject;

/**
 * Jython file descriptor management.
 *
 * File descriptor objects in Jython are instances of RawIOBase.
 *
 * @author Philip Jenvey
 */
public class FileDescriptors {

    /**
     * Return the RawIOBase associated with the specified file descriptor.
     *
     * Raises a Python exception is the file descriptor is invalid
     *
     * @param fd
     *            a Jython file descriptor object
     * @return the RawIOBase associated with the file descriptor
     */
    public static RawIOBase get(PyObject fd) {
        return Py.tojava(fd, RawIOBase.class);
    }
}
