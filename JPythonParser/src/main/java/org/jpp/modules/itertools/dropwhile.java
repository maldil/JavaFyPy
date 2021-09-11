/* Copyright (c) Jython Developers */
package org.jpp.modules.itertools;

import org.jpp.heart.ArgParser;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.heart.Visitproc;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "itertools.dropwhile", base = PyObject.class, doc = dropwhile.dropwhile_doc)
public class dropwhile extends PyIterator {

    public static final PyType TYPE = PyType.fromClass(dropwhile.class);
    private PyIterator iter;

    public dropwhile() {
        super();
    }

    public dropwhile(PyType subType) {
        super(subType);
    }

    public dropwhile(PyObject predicate, PyObject iterable) {
        super();
        dropwhile___init__(predicate, iterable);
    }

    public static final String dropwhile_doc =
        "dropwhile(predicate, iterable) --> dropwhile object\n\n" +
        "Drop items from the iterable while predicate(item) is true.\n" +
        "Afterwards, return every element until the iterable is exhausted.";

    /**
     * Create an iterator that drops items from the iterable while <code>predicate(item)</code>
     * equals true. After which every remaining item of the iterable is returned.
     */
    @ExposedNew
    @ExposedMethod
    final void dropwhile___init__(PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("dropwhile", args, kwds, new String[] {"predicate", "iterable"}, 2);
        ap.noKeywords();
        PyObject predicate = ap.getPyObject(0);
        PyObject iterable = ap.getPyObject(1);
        dropwhile___init__(predicate, iterable);
    }

    private void dropwhile___init__(PyObject predicate, PyObject iterable) {
        iter = new itertools.WhileIterator(predicate, iterable, true);
    }

    public PyObject __next__() {
        return iter.__next__();
    }

    @ExposedMethod
    @Override
    public PyObject next() {
        return doNext(__next__());
    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal = super.traverse(visit, arg);
        if (retVal != 0) {
            return retVal;
        }
        return iter != null ? visit.visit(iter, arg) : 0;
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && (iter == ob || super.refersDirectlyTo(ob));
    }
}
