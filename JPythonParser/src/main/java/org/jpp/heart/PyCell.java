/* Copyright (c) Jython Developers */
package org.jpp.heart;

import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedType;

/**
 * The Python cell type.
 *
 * Cells are used to implement variables referenced by multiple scopes.
 */
@ExposedType(name = "cell", isBaseType = false)
public class PyCell extends PyObject implements Traverseproc {

    public static final PyType TYPE = PyType.fromClass(PyCell.class);

    /** The underlying content of the cell, or null. */
    public PyObject ob_ref;

    public PyCell() {
        super(TYPE);
    }

    @ExposedGet(name = "cell_contents")
    public PyObject getCellContents() {
        if (ob_ref == null) {
            throw Py.ValueError("Cell is empty");
        }
        return ob_ref;
    }

    @Override
    public String toString() {
        if (ob_ref == null) {
            return String.format("<cell at %s: empty>", Py.idstr(this));
        }
        return String.format("<cell at %s: %.80s object at %s>", Py.idstr(this),
                             ob_ref.getType().getName(), Py.idstr(ob_ref));
    }

    @Override
    public PyObject richCompare(PyObject other, CompareOp op) {
        if (!(other instanceof PyCell)) {
            return Py.NotImplemented;
        }
        PyObject a = ob_ref;
        PyObject b = ((PyCell) other).ob_ref;
        if (a != null && b != null) {
            return a.richCompare(b, op);
        }
        int result = (a == null ? 0 : 1) - (b == null ? 0 : 1);
        return op.bool(result);
    }

    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        return ob_ref != null ? visit.visit(ob_ref, arg) : 0;
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && ob_ref == ob;
    }
}
