package org.jpp.astnodes.ast;

import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.base.mod;

public class ErrorMod extends mod {

    public ErrorMod(PythonTree tree) {
        super(tree);
    }

    public String toString() {
        return "ErrorMod";
    }

    public String toStringTree() {
        return "ErrorMod";
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
