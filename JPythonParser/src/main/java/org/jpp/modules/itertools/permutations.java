/* Copyright (c) Jython Developers */
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

@ExposedType(name = "itertools.permutations", base = PyObject.class, doc = permutations.permutations_doc)
public class permutations extends PyIterator {
    public static final PyType TYPE = PyType.fromClass(permutations.class);
    private PyIterator iter;

    public static final String permutations_doc =
        "permutations(iterable[, r]) --> permutations object\n\n" +
        "Return successive r-length permutations of elements in the iterable.\n\n" +
        "permutations(range(3), 2) --> (0,1), (0,2), (1,0), (1,2), (2,0), (2,1)";

    public permutations() {
        super();
    }

    public permutations(PyType subType) {
        super(subType);
    }

    public permutations(PyObject iterable, int r) {
        super();
        permutations___init__(iterable, r);
    }

    @ExposedNew
    @ExposedMethod
    final void permutations___init__(PyObject[] args, String[] kwds) {
        if (args.length > 2) {
            throw Py.TypeError("permutations() takes at most 2 arguments (3 given)");
        }
        ArgParser ap = new ArgParser("permutations", args, kwds, "iterable", "r");
        PyObject iterable = ap.getPyObject(0);
        PyObject r = ap.getPyObject(1, Py.None);

        int perm_length;
        if (r == Py.None) {
            perm_length = iterable.__len__();
        }
        else {
            perm_length = r.asInt();
            if (perm_length < 0) {
                throw Py.ValueError("r must be non-negative");
            }
        }

        permutations___init__(iterable, perm_length);
    }

    private void permutations___init__(final PyObject iterable, final int r) {
        final PyTuple pool = PyTuple.fromIterable(iterable);
        final int n = pool.__len__();
        final int indices[] = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        final int cycles[] = new int[r];
        for (int i = 0; i < r; i++) {
            cycles[i] = n - i;
        }
        iter = new itertools.ItertoolsIterator() {
            boolean firstthru = true;

            @Override
            public PyObject __next__() {
                if (r > n) return null;
                if (firstthru) {
                    firstthru = false;
                    return itertools.makeIndexedTuple(pool, indices, r);
                }
                for (int i = r - 1; i >= 0; i--) {
                    cycles[i] -= 1;
                    if (cycles[i] == 0) {
                        // rotate indices at the ith position
                        int first = indices[i];
                        for (int j = i; j < n - 1; j++) {
                            indices[j] = indices[j + 1];
                        }
                        indices[n - 1] = first;
                        cycles[i] = n - i;
                    } else {
                        int j = cycles[i];
                        int index = indices[i];
                        indices[i] = indices[n - j];
                        indices[n - j] = index;
                        return itertools.makeIndexedTuple(pool, indices, r);
                    }
                }
                return null;
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
