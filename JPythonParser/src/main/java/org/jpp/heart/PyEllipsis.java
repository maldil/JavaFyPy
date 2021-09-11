// Copyright (c) Corporation for National Research Initiatives
package org.jpp.heart;

import java.io.Serializable;

import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

/**
 * A class representing the singleton Ellipsis <code>...</code> object.
 */
@Untraversable
@ExposedType(name = "ellipsis", base = PyObject.class, isBaseType = false)
public class PyEllipsis extends PySingleton implements Serializable {

    public static final PyType TYPE = PyType.fromClass(PyEllipsis.class);
    private static PyEllipsis INST = new PyEllipsis();

    private PyEllipsis() {
        super(TYPE, "Ellipsis");
    }

    @ExposedNew
    final static PyObject ellipsis_new(PyNewWrapper new_, boolean init, PyType subtype,
            PyObject[] args, String[] keywords) {
        return INST;
    }

    public static PyEllipsis getInstance() {
        return INST;
    }

    private Object writeReplace() {
        return new Py.SingletonResolver("Ellipsis");
    }
}
