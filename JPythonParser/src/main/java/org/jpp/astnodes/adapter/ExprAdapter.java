package org.jpp.astnodes.adapter;

import java.util.ArrayList;
import java.util.List;

import org.jpp.astnodes.ast.Num;
import org.jpp.astnodes.ast.Str;
import org.jpp.astnodes.base.expr;
import org.jpp.heart.Py;
import org.jpp.heart.PyBytes;
import org.jpp.heart.PyComplex;
import org.jpp.heart.PyFloat;
import org.jpp.heart.PyInteger;
import org.jpp.heart.PyLong;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyUnicode;

public class ExprAdapter implements AstAdapter {

    public Object py2ast(PyObject o) {
        if (o instanceof expr) {
            return o;
        }
        if (o instanceof PyInteger || o instanceof PyLong || o instanceof PyFloat || o instanceof PyComplex) {
            return new Num(o);
        }
        if (o instanceof PyBytes || o instanceof PyUnicode) {
            return new Str(o);
        }
        return null;
    }

    public PyObject ast2py(Object o) {
        if (o == null) {
            return Py.None;
        }
        return (PyObject)o;
    }

    public List iter2ast(PyObject iter) {
        List<expr> exprs = new ArrayList<expr>();
        if (iter != Py.None) {
            for(Object o : (Iterable)iter) {
                exprs.add((expr)py2ast((PyObject)o));
            }
        }
        return exprs;
    }
}
