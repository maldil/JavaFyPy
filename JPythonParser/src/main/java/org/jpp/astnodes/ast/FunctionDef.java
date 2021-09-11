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

@ExposedType(name = "_ast.FunctionDef", base = stmt.class)
public class FunctionDef extends stmt {
public static final PyType TYPE = PyType.fromClass(FunctionDef.class);
    private String name;
    public String getInternalName() {
        return name;
    }
    @ExposedGet(name = "name")
    public PyObject getName() {
        if (name == null) return Py.None;
        return new PyUnicode(name);
    }
    @ExposedSet(name = "name")
    public void setName(PyObject name) {
        this.name = AstAdapters.py2identifier(name);
    }

    private arguments args;
    public arguments getInternalArgs() {
        return args;
    }
    @ExposedGet(name = "args")
    public PyObject getArgs() {
        return args;
    }
    @ExposedSet(name = "args")
    public void setArgs(PyObject args) {
        this.args = AstAdapters.py2arguments(args);
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

    private java.util.List<expr> decorator_list;
    public java.util.List<expr> getInternalDecorator_list() {
        return decorator_list;
    }
    @ExposedGet(name = "decorator_list")
    public PyObject getDecorator_list() {
        return new AstList(decorator_list, AstAdapters.exprAdapter);
    }
    @ExposedSet(name = "decorator_list")
    public void setDecorator_list(PyObject decorator_list) {
        this.decorator_list = AstAdapters.py2exprList(decorator_list);
    }

    private expr returns;
    public expr getInternalReturns() {
        return returns;
    }
    @ExposedGet(name = "returns")
    public PyObject getReturns() {
        return returns;
    }
    @ExposedSet(name = "returns")
    public void setReturns(PyObject returns) {
        this.returns = AstAdapters.py2expr(returns);
    }


    private final static PyUnicode[] fields =
    new PyUnicode[] {new PyUnicode("name"), new PyUnicode("args"), new PyUnicode("body"), new
                      PyUnicode("decorator_list"), new PyUnicode("returns")};
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes =
    new PyUnicode[] {new PyUnicode("lineno"), new PyUnicode("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    public FunctionDef(PyType subType) {
        super(subType);
    }
    public FunctionDef() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void FunctionDef___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("FunctionDef", args, keywords, new String[]
            {"name", "args", "body", "decorator_list", "returns", "lineno", "col_offset"}, 5, true);
        setName(ap.getPyObject(0, Py.None));
        setArgs(ap.getPyObject(1, Py.None));
        setBody(ap.getPyObject(2, Py.None));
        setDecorator_list(ap.getPyObject(3, Py.None));
        setReturns(ap.getPyObject(4, Py.None));
        int lin = ap.getInt(5, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(6, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public FunctionDef(PyObject name, PyObject args, PyObject body, PyObject decorator_list,
    PyObject returns) {
        setName(name);
        setArgs(args);
        setBody(body);
        setDecorator_list(decorator_list);
        setReturns(returns);
    }

    public FunctionDef(Token token, String name, arguments args, java.util.List<stmt> body,
    java.util.List<expr> decorator_list, expr returns) {
        super(token);
        this.name = name;
        this.args = args;
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
        this.returns = returns;
        addChild(returns);
    }

    public FunctionDef(Integer ttype, Token token, String name, arguments args,
    java.util.List<stmt> body, java.util.List<expr> decorator_list, expr returns) {
        super(ttype, token);
        this.name = name;
        this.args = args;
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
        this.returns = returns;
        addChild(returns);
    }

    public FunctionDef(PythonTree tree, String name, arguments args, java.util.List<stmt> body,
    java.util.List<expr> decorator_list, expr returns) {
        super(tree);
        this.name = name;
        this.args = args;
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
        this.returns = returns;
        addChild(returns);
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "FunctionDef";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("FunctionDef(");
        sb.append("name=");
        sb.append(dumpThis(name));
        sb.append(",");
        sb.append("args=");
        sb.append(dumpThis(args));
        sb.append(",");
        sb.append("body=");
        sb.append(dumpThis(body));
        sb.append(",");
        sb.append("decorator_list=");
        sb.append(dumpThis(decorator_list));
        sb.append(",");
        sb.append("returns=");
        sb.append(dumpThis(returns));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitFunctionDef(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (args != null)
            args.accept(visitor);
        if (body != null) {
            for (PythonTree t : body) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (decorator_list != null) {
            for (PythonTree t : decorator_list) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (returns != null)
            returns.accept(visitor);
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

    // Support for indexer below
    private Name nameNode;
    public Name getInternalNameNode() {
        return nameNode;
    }
    private expr returnNode;
    public expr getInternalReturnNode() {
        return returnNode;
    }
    public FunctionDef(Token token, Name name, arguments args, java.util.List<stmt> body, expr returnNode) {
        super(token);
        this.name = name.getText();
        this.nameNode = name;
        this.args = args;
        this.body = body;
        this.returnNode = returnNode;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = new ArrayList<>();
    }
    public void setDecorator_list(java.util.List<expr> decorator_list) {
        if (decorator_list != null) {
            this.decorator_list = decorator_list;
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
    }
    // End indexer support
}
