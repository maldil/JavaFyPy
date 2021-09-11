// Hand copied from stmt.
// XXX: autogenerate this.
package org.jpp.astnodes.base;
import org.antlr.runtime.Token;
import org.jpp.astnodes.AST;
import org.jpp.astnodes.PythonTree;
import org.jpp.heart.PyBytes;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "_ast.unaryop", base = AST.class)
public abstract class unaryop extends PythonTree {

    public static final PyType TYPE = PyType.fromClass(unaryop.class);
    private final static PyBytes[] fields = new PyBytes[0];
    @ExposedGet(name = "_fields")
    public PyBytes[] get_fields() { return fields; }

    private final static PyBytes[] attributes =
    new PyBytes[] {new PyBytes("lineno"), new PyBytes("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyBytes[] get_attributes() { return attributes; }

    public unaryop() {
    }

    public unaryop(PyType subType) {
    }

    public unaryop(int ttype, Token token) {
        super(ttype, token);
    }

    public unaryop(Token token) {
        super(token);
    }

    public unaryop(PythonTree node) {
        super(node);
    }

}
