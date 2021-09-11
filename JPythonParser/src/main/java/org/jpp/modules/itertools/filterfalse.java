/* Copyright (c) Jython Developers */
package org.jpp.modules.itertools;
import org.jpp.heart.ArgParser;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.heart.Visitproc;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "itertools.filterfalse", base = PyObject.class,
    doc = filterfalse.filterfalse_doc)
public class filterfalse extends PyIterator {

    public static final PyType TYPE = PyType.fromClass(filterfalse.class);
    private PyIterator iter;

    public filterfalse() {
        super();
    }

    public filterfalse(PyType subType) {
        super(subType);
    }

    public filterfalse(PyObject predicate, PyObject iterable) {
        super();
        filterfalse___init__(predicate, iterable);
    }

    public static final String filterfalse_doc =
        "'filterfalse(function or None, sequence) --> filterfalse object\n\n" +
        "Return those items of sequence for which function(item) is false.\n" +
        "If function is None, return the items that are false.'";

    /**
     * Creates an iterator that returns the items of the iterable for which
     * <code>predicate(item)</code> is <code>false</code>. If <code>predicate</code> is null
     * (None) return the items that are false.
     */
    @ExposedNew
    @ExposedMethod
    final void filterfalse___init__(PyObject[] args, String[] kwds) {
        ArgParser ap = new ArgParser("filter", args, kwds, new String[] {"predicate", "iterable"}, 2);
        ap.noKeywords();
        PyObject predicate = ap.getPyObject(0);
        PyObject iterable = ap.getPyObject(1);
        filterfalse___init__(predicate, iterable);
    }

    public void filterfalse___init__(PyObject predicate, PyObject iterable) {
        iter = new itertools.FilterIterator(predicate, iterable, false);
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
