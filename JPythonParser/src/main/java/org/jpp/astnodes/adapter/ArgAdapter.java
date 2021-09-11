package org.jpp.astnodes.adapter;

import org.jpp.astnodes.ast.arg;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;

import java.util.ArrayList;
import java.util.List;

public class ArgAdapter implements AstAdapter {
    public Object py2ast(PyObject o) {
        if (o instanceof arg) {
            return o;
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
        List<arg> args = new ArrayList<arg>();
        if (iter != Py.None) {
            for(Object o : (Iterable)iter) {
                args.add((arg)py2ast((PyObject)o));
            }
        }
        return args;
    }
}
