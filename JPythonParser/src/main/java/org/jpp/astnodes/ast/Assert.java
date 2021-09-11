// Autogenerated AST node on 08/11/2020, 15:59:03
package org.jpp.astnodes.ast;
import org.antlr.runtime.Token;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.adapter.AstAdapters;
import org.jpp.astnodes.base.expr;
import org.jpp.astnodes.base.stmt;
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

@ExposedType(name = "_ast.Assert", base = stmt.class)
public class Assert extends stmt {
public static final PyType TYPE = PyType.fromClass(Assert.class);
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

    private expr msg;
    public expr getInternalMsg() {
        return msg;
    }
    @ExposedGet(name = "msg")
    public PyObject getMsg() {
        return msg;
    }
    @ExposedSet(name = "msg")
    public void setMsg(PyObject msg) {
        this.msg = AstAdapters.py2expr(msg);
    }


    private final static PyUnicode[] fields =
    new PyUnicode[] {new PyUnicode("test"), new PyUnicode("msg")};
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes =
    new PyUnicode[] {new PyUnicode("lineno"), new PyUnicode("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    public Assert(PyType subType) {
        super(subType);
    }
    public Assert() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void Assert___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("Assert", args, keywords, new String[]
            {"test", "msg", "lineno", "col_offset"}, 2, true);
        setTest(ap.getPyObject(0, Py.None));
        setMsg(ap.getPyObject(1, Py.None));
        int lin = ap.getInt(2, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(3, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public Assert(PyObject test, PyObject msg) {
        setTest(test);
        setMsg(msg);
    }

    public Assert(Token token, expr test, expr msg) {
        super(token);
        this.test = test;
        addChild(test);
        this.msg = msg;
        addChild(msg);
    }

    public Assert(Integer ttype, Token token, expr test, expr msg) {
        super(ttype, token);
        this.test = test;
        addChild(test);
        this.msg = msg;
        addChild(msg);
    }

    public Assert(PythonTree tree, expr test, expr msg) {
        super(tree);
        this.test = test;
        addChild(test);
        this.msg = msg;
        addChild(msg);
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Assert";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Assert(");
        sb.append("test=");
        sb.append(dumpThis(test));
        sb.append(",");
        sb.append("msg=");
        sb.append(dumpThis(msg));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitAssert(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (test != null)
            test.accept(visitor);
        if (msg != null)
            msg.accept(visitor);
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
