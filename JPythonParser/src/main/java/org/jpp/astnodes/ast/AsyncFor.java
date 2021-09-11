// Autogenerated AST node on 08/11/2020, 15:59:03
package org.jpp.astnodes.ast;
import org.antlr.runtime.Token;
import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.adapter.AstAdapters;
import org.jpp.astnodes.base.expr;
import org.jpp.astnodes.base.stmt;
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

@ExposedType(name = "_ast.AsyncFor", base = stmt.class)
public class AsyncFor extends stmt {
public static final PyType TYPE = PyType.fromClass(AsyncFor.class);
    private expr target;
    public expr getInternalTarget() {
        return target;
    }
    @ExposedGet(name = "target")
    public PyObject getTarget() {
        return target;
    }
    @ExposedSet(name = "target")
    public void setTarget(PyObject target) {
        this.target = AstAdapters.py2expr(target);
    }

    private expr iter;
    public expr getInternalIter() {
        return iter;
    }
    @ExposedGet(name = "iter")
    public PyObject getIter() {
        return iter;
    }
    @ExposedSet(name = "iter")
    public void setIter(PyObject iter) {
        this.iter = AstAdapters.py2expr(iter);
    }

    private java.util.List<stmt> body;
    public java.util.List<stmt> getInternalBody() {
        return body;
    }
    @ExposedGet(name = "body")
    public PyObject getBody() {
        return new AstList(body, AstAdapters.stmtAdapter);
    }
    @ExposedSet(name = "body")
    public void setBody(PyObject body) {
        this.body = AstAdapters.py2stmtList(body);
    }

    private java.util.List<stmt> orelse;
    public java.util.List<stmt> getInternalOrelse() {
        return orelse;
    }
    @ExposedGet(name = "orelse")
    public PyObject getOrelse() {
        return new AstList(orelse, AstAdapters.stmtAdapter);
    }
    @ExposedSet(name = "orelse")
    public void setOrelse(PyObject orelse) {
        this.orelse = AstAdapters.py2stmtList(orelse);
    }


    private final static PyUnicode[] fields =
    new PyUnicode[] {new PyUnicode("target"), new PyUnicode("iter"), new PyUnicode("body"), new
                      PyUnicode("orelse")};
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes =
    new PyUnicode[] {new PyUnicode("lineno"), new PyUnicode("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    public AsyncFor(PyType subType) {
        super(subType);
    }
    public AsyncFor() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void AsyncFor___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("AsyncFor", args, keywords, new String[]
            {"target", "iter", "body", "orelse", "lineno", "col_offset"}, 4, true);
        setTarget(ap.getPyObject(0, Py.None));
        setIter(ap.getPyObject(1, Py.None));
        setBody(ap.getPyObject(2, Py.None));
        setOrelse(ap.getPyObject(3, Py.None));
        int lin = ap.getInt(4, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(5, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public AsyncFor(PyObject target, PyObject iter, PyObject body, PyObject orelse) {
        setTarget(target);
        setIter(iter);
        setBody(body);
        setOrelse(orelse);
    }

    public AsyncFor(Token token, expr target, expr iter, java.util.List<stmt> body,
    java.util.List<stmt> orelse) {
        super(token);
        this.target = target;
        addChild(target);
        this.iter = iter;
        addChild(iter);
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.orelse = orelse;
        if (orelse == null) {
            this.orelse = new ArrayList<stmt>();
        }
        for(PythonTree t : this.orelse) {
            addChild(t);
        }
    }

    public AsyncFor(Integer ttype, Token token, expr target, expr iter, java.util.List<stmt> body,
    java.util.List<stmt> orelse) {
        super(ttype, token);
        this.target = target;
        addChild(target);
        this.iter = iter;
        addChild(iter);
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.orelse = orelse;
        if (orelse == null) {
            this.orelse = new ArrayList<stmt>();
        }
        for(PythonTree t : this.orelse) {
            addChild(t);
        }
    }

    public AsyncFor(PythonTree tree, expr target, expr iter, java.util.List<stmt> body,
    java.util.List<stmt> orelse) {
        super(tree);
        this.target = target;
        addChild(target);
        this.iter = iter;
        addChild(iter);
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.orelse = orelse;
        if (orelse == null) {
            this.orelse = new ArrayList<stmt>();
        }
        for(PythonTree t : this.orelse) {
            addChild(t);
        }
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "AsyncFor";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("AsyncFor(");
        sb.append("target=");
        sb.append(dumpThis(target));
        sb.append(",");
        sb.append("iter=");
        sb.append(dumpThis(iter));
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
        return visitor.visitAsyncFor(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (target != null)
            target.accept(visitor);
        if (iter != null)
            iter.accept(visitor);
        if (body != null) {
            for (PythonTree t : body) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (orelse != null) {
            for (PythonTree t : orelse) {
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
