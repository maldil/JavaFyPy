package org.jpp.astnodes.ast;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.base.stmt;

public class ErrorStmt extends stmt {

    public ErrorStmt(PythonTree tree) {
        super(tree);
    }

    public String toString() {
        return "ErrorStmt";
    }

    public String toStringTree() {
        return "ErrorStmt";
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
