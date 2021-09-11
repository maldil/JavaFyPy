package org.jpp.modules._io;

import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "_io.BufferedRandom")
public class PyBufferedRandom extends PyObject {

    public static final PyType TYPE = PyType.fromClass(PyBufferedRandom.class);

    public PyBufferedRandom() {
        super(TYPE);
    }
}
