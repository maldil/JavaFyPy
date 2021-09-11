// Autogenerated AST node on 08/11/2020, 15:59:03
package org.jpp.astnodes.ast;
import org.antlr.runtime.Token;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.adapter.AstAdapters;
import org.jpp.astnodes.base.expr;
import org.jpp.heart.ArgParser;
import org.jpp.heart.AstList;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyUnicode;
import org.jpp.heart.PyStringMap;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedSet;
import org.jpp.exposers.ExposedType;

import java.util.ArrayList;

@ExposedType(name = "_ast.Set", base = expr.class)
public class Set extends expr {
public static final PyType TYPE = PyType.fromClass(Set.class);
    private java.util.List<expr> elts;
    public java.util.List<expr> getInternalElts() {
        return elts;
    }
    @ExposedGet(name = "elts")
    public PyObject getElts() {
        return new AstList(elts, AstAdapters.exprAdapter);
    }
    @ExposedSet(name = "elts")
    public void setElts(PyObject elts) {
        this.elts = AstAdapters.py2exprList(elts);
    }


    private final static PyUnicode[] fields =
    new PyUnicode[] {new PyUnicode("elts")};
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes =
    new PyUnicode[] {new PyUnicode("lineno"), new PyUnicode("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    public Set(PyType subType) {
        super(subType);
    }
    public Set() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void Set___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("Set", args, keywords, new String[]
            {"elts", "lineno", "col_offset"}, 1, true);
        setElts(ap.getPyObject(0, Py.None));
        int lin = ap.getInt(1, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(2, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public Set(PyObject elts) {
        setElts(elts);
    }

    public Set(Token token, java.util.List<expr> elts) {
        super(token);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    public Set(Integer ttype, Token token, java.util.List<expr> elts) {
        super(ttype, token);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    public Set(PythonTree tree, java.util.List<expr> elts) {
        super(tree);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Set";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Set(");
        sb.append("elts=");
        sb.append(dumpThis(elts));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitSet(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (elts != null) {
            for (PythonTree t : elts) {
                if (t != null)
                    t.accept(visitor);
            }
        }
    }

    public PyObject __dict__;

    @Override
    public PyObject fastGetDict() {
        ensureDict();
        return __dict__;
    }

    @ExposedGet(name = "__dict__")
    public PyObject getDict() {
        return fastGetDict();
    }

    private void ensureDict() {
        if (__dict__ == null) {
            __dict__ = new PyStringMap();
        }
    }

    private int lineno = -1;
    @ExposedGet(name = "lineno")
    public int getLineno() {
        if (lineno != -1) {
            return lineno;
        }
        return getLine();
    }

    @ExposedSet(name = "lineno")
    public void setLineno(int num) {
        lineno = num;
    }

    private int col_offset = -1;
    @ExposedGet(name = "col_offset")
    public int getCol_offset() {
        if (col_offset != -1) {
            return col_offset;
        }
        return getCharPositionInLine();
    }

    @ExposedSet(name = "col_offset")
    public void setCol_offset(int num) {
        col_offset = num;
    }

}
