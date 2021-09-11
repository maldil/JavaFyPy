package org.jpp.heart;

import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

/**
 * The staticmethod descriptor.
 */
@ExposedType(name = "staticmethod", doc = BuiltinDocs.staticmethod_doc)
public class PyStaticMethod extends PyObject implements Traverseproc {

    public static final PyType TYPE = PyType.fromClass(PyStaticMethod.class);

    @ExposedGet(name = "__func__")
    protected PyObject callable;

    public PyStaticMethod(PyObject callable) {
        super(TYPE);
        this.callable = callable;
    }

    @ExposedNew
    final static PyObject staticmethod_new(PyNewWrapper new_, boolean init, PyType subtype,
                                           PyObject[] args, String[] keywords) {
        if (keywords.length != 0) {
            throw Py.TypeError("staticmethod does not accept keyword arguments");
        }
        if (args.length != 1) {
            throw Py.TypeError("staticmethod expected 1 argument, got " + args.length);
        }
        return new PyStaticMethod(args[0]);
    }

    public PyObject __get__(PyObject obj, PyObject type) {
        return staticmethod___get__(obj, type);
    }

    @ExposedMethod(defaults = "null", doc = BuiltinDocs.staticmethod___get___doc)
    final PyObject staticmethod___get__(PyObject obj, PyObject type) {
        return callable;
    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        return callable != null ? visit.visit(callable, arg) : 0;
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && ob == callable;
    }
}
