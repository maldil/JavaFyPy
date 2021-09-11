/* Copyright (c) Jython Developers */
package org.jpp.modules.itertools;

import org.jpp.heart.Py;
import org.jpp.heart.PyException;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyNone;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyTuple;
import org.jpp.heart.Visitproc;
import org.jpp.exposers.ExposedFunction;
import org.jpp.exposers.ExposedModule;
import org.jpp.exposers.ModuleInit;

/**
 * Functional tools for creating and using iterators. Java implementation of the CPython module
 * itertools.
 * 
 * @since 2.5
 */
@ExposedModule(doc = itertools.__doc__)
public class itertools {

    public static final String __doc__ =
            "Functional tools for creating and using iterators.\n\nInfinite iterators:\n" +
            "count([n]) --> n, n+1, n+2, ...\n" +
            "cycle(p) --> p0, p1, ... plast, p0, p1, ...\n" +
            "repeat(elem [,n]) --> elem, elem, elem, ... endlessly or up to n times\n\n" +
        
            "Iterators terminating on the shortest input sequence:\n" +
            "chain(p, q, ...) --> p0, p1, ... plast, q0, q1, ...\n" +
            "compress(data, selectors) --> (d[0] if s[0]), (d[1] if s[1]), ...\n" +
            "dropwhile(pred, seq) --> seq[n], seq[n+1], starting when pred fails\n" +
            "groupby(iterable[, keyfunc]) --> sub-iterators grouped by value of keyfunc(v)\n" +
            "ifilter(pred, seq) --> elements of seq where pred(elem) is True\n" +
            "filterfalse(pred, seq) --> elements of seq where pred(elem) is False\n" +
            "islice(seq, [start,] stop [, step]) --> elements from seq[start:stop:step]\n" +
            "imap(fun, p, q, ...) --> fun(p0, q0), fun(p1, q1), ...\n" +
            "starmap(fun, seq) --> fun(*seq[0]), fun(*seq[1]), ...\n" +
            "tee(it, n=2) --> (it1, it2 , ... itn) splits one iterator into n\n" +
            "takewhile(pred, seq) --> seq[0], seq[1], until pred fails\n" +
            "izip(p, q, ...) --> (p[0], q[0]), (p[1], q[1]), ...\n" +
            "izip_longest(p, q, ...) --> (p[0], q[0]), (p[1], q[1]), ...\n\n" +

            "Combinatoric generators:\n" +
            "product(p, q, ... [repeat=1]) --> cartesian product\n" +
            "permutations(p[, r])\n" +
            "combinations(p, r)\n" +
            "combinations_with_replacement(p, r)";

    /**
     * Iterator base class used by most methods.
     */
    static abstract class ItertoolsIterator extends PyIterator {

        /**
         * Returns the next element from an iterator. If it raises/throws StopIteration just store
         * the Exception and return null according to PyIterator practice.
         */
        protected PyObject nextElement(PyObject pyIter) {
            return pyIter.__next__();
        }
    }

    @ModuleInit
    public static void init(PyObject dict) {
        dict.__setitem__("chain", chain.TYPE);
        dict.__setitem__("combinations", combinations.TYPE);
        dict.__setitem__("combinations_with_replacement", combinationsWithReplacement.TYPE);
        dict.__setitem__("compress", compress.TYPE);
        dict.__setitem__("cycle", cycle.TYPE);
        dict.__setitem__("count", count.TYPE);
        dict.__setitem__("dropwhile", dropwhile.TYPE);
        dict.__setitem__("groupby", groupby.TYPE);
        dict.__setitem__("imap", imap.TYPE);
        dict.__setitem__("filterfalse", filterfalse.TYPE);
        dict.__setitem__("islice", islice.TYPE);
        dict.__setitem__("izip", izip.TYPE);
        dict.__setitem__("izip_longest", izipLongest.TYPE);
        dict.__setitem__("permutations", permutations.TYPE);
        dict.__setitem__("product", product.TYPE);
        dict.__setitem__("repeat", repeat.TYPE);
        dict.__setitem__("starmap", starmap.TYPE);
        dict.__setitem__("takewhile", takewhile.TYPE);
    }

    static int py2int(PyObject obj, int defaultValue, String msg) {
        if (obj instanceof PyNone) {
            return defaultValue;
        } else {
            int value = defaultValue;
            try {
                value = Py.py2int(obj);
            }
            catch (PyException pyEx) {
                if (pyEx.match(Py.TypeError)) {
                    throw Py.ValueError(msg);
                } else {
                    throw pyEx;
                }
            }
            return value;
        }
    }

    /**
     * Iterator base class for iterators returned by <code>ifilter</code> and
     * <code>filterfalse</code>.
     */
    static class FilterIterator extends ItertoolsIterator {
        private PyObject predicate;

        private PyObject iterator;

        private boolean filterTrue;

        FilterIterator(PyObject predicate, PyObject iterable, boolean filterTrue) {
            if (predicate instanceof PyNone) {
                this.predicate = null;
            } else {
                this.predicate = predicate;
            }
            this.iterator = iterable.__iter__();
            this.filterTrue = filterTrue;
        }

        public PyObject __next__() {

            while (true) {
                PyObject element = nextElement(iterator);
                if (element != null) {
                    // the boolean value of calling predicate with the element
                    // or if predicate is null/None of the element itself
                    boolean booleanValue = predicate != null ? predicate
                            .__call__(element).__bool__() : element
                            .__bool__();
                    if (booleanValue == filterTrue) {
                        // if the boolean value is the same as filterTrue return
                        // the element
                        // for ifilter filterTrue is always true, for
                        // filterfalse always false
                        return element;
                    }
                } else {
                    return null;
                }
            }
        }


        /* Traverseproc implementation */
        @Override
        public int traverse(Visitproc visit, Object arg) {
            int retVal = super.traverse(visit, arg);
            if (retVal != 0) {
                return retVal;
            }
            if (iterator != null) {
                retVal = visit.visit(iterator, arg);
                if (retVal != 0) {
                    return retVal;
                }
            }
            return predicate != null ? visit.visit(predicate, arg) : 0;
        }

        @Override
        public boolean refersDirectlyTo(PyObject ob) {
            return ob != null && (ob == iterator || ob == predicate ||
                    super.refersDirectlyTo(ob));
        }
    }

    /**
     * Iterator base class used by <code>dropwhile()</code> and <code>takewhile</code>.
     */
    static class WhileIterator extends ItertoolsIterator {
        private PyObject iterator;

        private PyObject predicate;

        // flag that indicates if the iterator shoul drop or return arguments "while" the predicate is true
        private boolean drop;

        // flag that is set once the predicate is satisfied
        private boolean predicateSatisfied;

        WhileIterator(PyObject predicate, PyObject iterable, boolean drop) {
            this.predicate = predicate;
            iterator = iterable.__iter__();
            this.drop = drop;
        }

        public PyObject __next__() {

            while (true) {
                PyObject element = nextElement(iterator);
                if (element != null) {
                    if (!predicateSatisfied) {
                        // the predicate is not satisfied yet (or still satisfied in the case of drop beeing 
                        // false), so we need to check it
                        if (predicate.__call__(element).__bool__() != drop) {
                            predicateSatisfied = drop;
                            return element;
                        }
                        predicateSatisfied = !drop;
                    } else {
                        if (drop) {
                            return element;
                        } else {
                            // end iteration if predicate is false and drop is false
                            return null;
                        }
                    }
                } else {
                    // end iteration
                    return null;
                }

            }
        }


        /* Traverseproc implementation */
        @Override
        public int traverse(Visitproc visit, Object arg) {
            int retVal = super.traverse(visit, arg);
            if (retVal != 0) {
                return retVal;
            }
            if (iterator != null) {
                retVal = visit.visit(iterator, arg);
                if (retVal != 0) {
                    return retVal;
                }
            }
            return predicate != null ? visit.visit(predicate, arg) : 0;
        }

        @Override
        public boolean refersDirectlyTo(PyObject ob) {
            return ob != null && (ob == iterator || ob == predicate ||
                    super.refersDirectlyTo(ob));
        }
    }

    public static final String __doc__tee = "tee(iterable, n=2) --> tuple of n independent iterators.";

    /**
     * Create a tuple of iterators, each of which is effectively a copy of iterable.
     */
    @ExposedFunction(defaults = {"2"}, doc = __doc__tee)
    public static PyTuple tee(PyObject iterable, final int n) {
        return new PyTuple(PyTeeIterator.makeTees(iterable, n));
    }

    static PyTuple makeIndexedTuple(PyTuple pool, int indices[]) {
        return makeIndexedTuple(pool, indices, indices.length);
    }
    
    static PyTuple makeIndexedTuple(PyTuple pool, int indices[], int end) {
        PyObject items[] = new PyObject[end];
        for (int i = 0; i < end; i++) {
            items[i] = pool.__getitem__(indices[i]);
        }
        return new PyTuple(items);
    }
}
