package org.jpp.modules.itertools;

import org.jpp.heart.ArgParser;
import org.jpp.heart.Py;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyTuple;
import org.jpp.heart.PyType;
import org.jpp.heart.Visitproc;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "itertools.combinations", base = PyObject.class, doc = combinations.combinations_doc)
public class combinations extends PyIterator {

    public static final PyType TYPE = PyType.fromClass(combinations.class);
    private PyIterator iter;

    public static final String combinations_doc =
        "combinations(iterable, r) --> combinations object\n\n" +
        "Return successive r-length combinations of elements in the iterable.\n\n" +
        "combinations(range(4), 3) --> (0,1,2), (0,1,3), (0,2,3), (1,2,3)";

    public combinations() {
        super();
    }

    public combinations(PyType subType) {
        super(subType);
    }

    public combinations(PyObject iterable, int r) {
        super();
        combinations___init__(iterable, r);
    }

    @ExposedNew
    @ExposedMethod
    final void combinations___init__(PyObject[] args, String[] kwds) {
        if (args.length > 2) {
            throw Py.TypeError(String.format(
                "combinations_with_replacement() takes at most 2 arguments (%d given)", args.length));
        }
        ArgParser ap = new ArgParser("combinations_with_replacement", args, kwds, "iterable", "r");
        PyObject iterable = ap.getPyObject(0);
        int r = ap.getInt(1);
        if (r < 0) {
            throw Py.ValueError("r must be non-negative");
        }
        combinations___init__(iterable, r);
    }

    private void combinations___init__(PyObject iterable, final int r) {
        if (r < 0) throw Py.ValueError("r must be non-negative");
        final PyTuple pool = PyTuple.fromIterable(iterable);
        final int n = pool.__len__();
        final int indices[] = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = i;
        }

        iter = new itertools.ItertoolsIterator() {
            boolean firstthru = true;

            @Override
            public PyObject __next__() {
                if (r > n) { return null; }
                if (firstthru) {
                    firstthru = false;
                    return itertools.makeIndexedTuple(pool, indices);
                }
                int i;
                for (i = r-1; i >= 0 && indices[i] == i+n-r ; i--);
                if (i < 0) return null;
                indices[i]++;
                for (int j = i+1; j < r; j++) {
                    indices[j] = indices[j-1] + 1;
                }
                return itertools.makeIndexedTuple(pool, indices);
            }
        };
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
