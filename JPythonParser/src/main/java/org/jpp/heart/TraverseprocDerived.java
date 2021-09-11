package org.jpp.heart;

/**
 * This is used like {@link org.jpp.heart.Traverseproc},
 * but traverses only the {@code slots[]}-array of
 * {@code fooDerived}-classes. This way we avoid that the traverse
 * method of a traversable {@link org.jpp.heart.PyObject} is
 * overwritten by the derived version.
 * {@link org.jpp.modules.gc#traverse(PyObject, Visitproc, Object)} takes care of
 * exploiting both traverse methods.
 */
public interface TraverseprocDerived {
    /**
     * Traverses all reachable {@code PyObject}s.
     * Like in CPython, {@code arg} must be passed
     * unmodified to {@code visit} as its second parameter.
     */
    public int traverseDerived(Visitproc visit, Object arg);
}
