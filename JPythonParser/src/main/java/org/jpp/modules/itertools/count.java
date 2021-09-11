/* Copyright (c) 2012 Jython Developers */
package org.jpp.modules.itertools;

import org.jpp.heart.ArgParser;
import org.jpp.heart.Py;
import org.jpp.heart.PyException;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyLong;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyTuple;
import org.jpp.heart.PyType;
import org.jpp.heart.PyUnicode;
import org.jpp.heart.Visitproc;
import org.jpp.heart.imp;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "itertools.count", base = PyObject.class, doc = count.count_doc)
public class count extends PyIterator {

    public static final PyType TYPE = PyType.fromClass(count.class);
    private PyIterator iter;
    private PyObject counter;
    private PyObject stepper;

    private static PyObject NumberClass;
    private static synchronized PyObject getNumberClass() {
        if (NumberClass == null) {
            NumberClass = imp.importName("numbers", true).__getattr__("Number");
        }
        return NumberClass;
    }

    public static final String count_doc =
        "count(start=0, step=1) --> count object\n\n" +
        "Return a count object whose .next() method returns consecutive values.\n" +
        "  Equivalent to:\n" +
        "\n" +
        "      def count(firstval=0, step=1):\n" +
        "      x = firstval\n" +
        "      while 1:\n" +
        "          yield x\n" +
        "          x += step\n";

    public count(PyType subType) {
        super(subType);
    }

    /**
     * Creates an iterator that returns consecutive numbers starting at 0.
     */
    public count() {
        super();
        count___init__(Py.Zero, Py.One);
    }

    /**
     * Creates an iterator that returns consecutive numbers starting at <code>start</code>.
     */
    public count(final PyObject start) {
        super();
        count___init__(start, Py.One);
    }

    /**
     * Creates an iterator that returns consecutive numbers starting at <code>start</code> with <code>step</code> step.
     */
    public count(final PyObject start, final PyObject step) {
        super();
        count___init__(start, step);
    }

    // TODO: move into Py, although NumberClass import time resolution becomes
    // TODO: a bit trickier
    private static PyObject getNumber(PyObject obj) {
        if (Py.isInstance(obj, getNumberClass())) {
            return obj;
        }
        try {
            PyObject intObj = obj.__int__();
            if (Py.isInstance(obj, getNumberClass())) {
                return intObj;
            }
            throw Py.TypeError("a number is required");
        } catch (PyException exc) {
            if (exc.match(Py.ValueError)) {
                throw Py.TypeError("a number is required");
            }
            throw exc;
        }
    }

    @ExposedNew
    @ExposedMethod
    final void count___init__(final PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("count", args, kwds, new String[] {"start", "step"}, 0);
        PyObject start = getNumber(ap.getPyObject(0, Py.Zero));
        PyObject step = getNumber(ap.getPyObject(1, Py.One));
        count___init__(start, step);
    }

    private void count___init__(final PyObject start, final PyObject step) {
        counter = start;
        stepper = step;

        iter = new PyIterator() {

            public PyObject __next__() {
                PyObject result = counter;
                counter = counter._add(stepper);
                return result;
            }

        };
    }

    @ExposedMethod
    public PyObject count___copy__() {
        return new count(counter, stepper);
    }

    @ExposedMethod
    final PyObject count___reduce_ex__(PyObject protocol) {
        return __reduce_ex__(protocol);
    }

    @ExposedMethod
    final PyObject count___reduce__() {
        return __reduce_ex__(Py.Zero);
    }


    public PyObject __reduce_ex__(PyObject protocol) {
        if (stepper == Py.One) {
            return new PyTuple(getType(), new PyTuple(counter));
        } else {
            return new PyTuple(getType(), new PyTuple(counter, stepper));
        }
    }

    @ExposedMethod
    public PyUnicode __repr__() {
        if (stepper instanceof PyLong && stepper._cmp(Py.One) == 0) {
            return Py.newUnicode(String.format("count(%s)", counter));
        }
        return Py.newUnicode(String.format("count(%s, %s)", counter, stepper));
    }

    public PyObject __next__() {
        return iter.__next__();
    }

    @ExposedMethod
    public final PyObject count___next__() {
        return doNext(__next__());
    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal;
        if (iter != null) {
            retVal = visit.visit(iter, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (counter != null) {
            retVal = visit.visit(counter, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        if (stepper != null) {
            retVal = visit.visit(stepper, arg);
            if (retVal != 0) {
                return retVal;
            }
        }
        return super.traverse(visit, arg);
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && (iter == ob || counter == ob
            || stepper == ob || super.refersDirectlyTo(ob));
    }
}
