package org.jpp.heart;

public interface Visitproc {

    /**
     * Must not be called with {@code object == null}.
     */
    public int visit(PyObject object, Object arg);
}
