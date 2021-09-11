// Autogenerated AST node on 08/11/2020, 15:59:03
package org.jpp.astnodes.ast;
import org.antlr.runtime.Token;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.adapter.AstAdapters;
import org.jpp.astnodes.base.expr;
import org.jpp.heart.ArgParser;
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

@ExposedType(name = "_ast.IfExp", base = expr.class)
public class IfExp extends expr {
public static final PyType TYPE = PyType.fromClass(IfExp.class);
    private expr test;
    public expr getInternalTest() {
        return test;
    }
    @ExposedGet(name = "test")
    public PyObject getTest() {
        return test;
    }
    @ExposedSet(name = "test")
    public void setTest(PyObject test) {
        this.test = AstAdapters.py2expr(test);
    }

    private expr body;
    public expr getInternalBody() {
        return body;
    }
    @ExposedGet(name = "body")
    public PyObject getBody() {
        return body;
    }
    @ExposedSet(name = "body")
    public void setBody(PyObject body) {
        this.body = AstAdapters.py2expr(body);
    }

    private expr orelse;
    public expr getInternalOrelse() {
        return orelse;
    }
    @ExposedGet(name = "orelse")
    public PyObject getOrelse() {
        return orelse;
    }
    @ExposedSet(name = "orelse")
    public void setOrelse(PyObject orelse) {
        this.orelse = AstAdapters.py2expr(orelse);
    }


    private final static PyUnicode[] fields =
    new PyUnicode[] {new PyUnicode("test"), new PyUnicode("body"), new PyUnicode("orelse")};
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes =
    new PyUnicode[] {new PyUnicode("lineno"), new PyUnicode("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    public IfExp(PyType subType) {
        super(subType);
    }
    public IfExp() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void IfExp___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("IfExp", args, keywords, new String[]
            {"test", "body", "orelse", "lineno", "col_offset"}, 3, true);
        setTest(ap.getPyObject(0, Py.None));
        setBody(ap.getPyObject(1, Py.None));
        setOrelse(ap.getPyObject(2, Py.None));
        int lin = ap.getInt(3, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(4, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public IfExp(PyObject test, PyObject body, PyObject orelse) {
        setTest(test);
        setBody(body);
        setOrelse(orelse);
    }

    public IfExp(Token token, expr test, expr body, expr orelse) {
        super(token);
        this.test = test;
        addChild(test);
        this.body = body;
        addChild(body);
        this.orelse = orelse;
        addChild(orelse);
    }

    public IfExp(Integer ttype, Token token, expr test, expr body, expr orelse) {
        super(ttype, token);
        this.test = test;
        addChild(test);
        this.body = body;
        addChild(body);
        this.orelse = orelse;
        addChild(orelse);
    }

    public IfExp(PythonTree tree, expr test, expr body, expr orelse) {
        super(tree);
        this.test = test;
        addChild(test);
        this.body = body;
        addChild(body);
        this.orelse = orelse;
        addChild(orelse);
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "IfExp";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("IfExp(");
        sb.append("test=");
        sb.append(dumpThis(test));
        sb.append(",");
        sb.append("body=");
        sb.append(dumpThis(body));
        sb.append(",");
        sb.append("orelse=");
        sb.append(dumpThis(orelse));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitIfExp(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (test != null)
            test.accept(visitor);
        if (body != null)
            body.accept(visitor);
        if (orelse != null)
            orelse.accept(visitor);
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
