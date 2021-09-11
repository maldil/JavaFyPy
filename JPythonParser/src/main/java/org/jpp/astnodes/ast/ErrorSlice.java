package org.jpp.astnodes.ast;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.base.slice;


public class ErrorSlice extends slice {

    public ErrorSlice(PythonTree tree) {
        super(tree);
    }

    public String toString() {
        return "ErrorSlice";
    }

    public String toStringTree() {
        return "ErrorSlice";
    }

    public int getLineno() {
        return getLine();
    }

    public int getCol_offset() {
        return getCharPositionInLine();
    }

    public <R> R accept(VisitorIF<R> visitor) {
        return null;
    }

    public void traverse(VisitorIF visitor) throws Exception {
        //no op.
    }

}
