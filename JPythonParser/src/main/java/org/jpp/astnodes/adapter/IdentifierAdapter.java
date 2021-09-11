package org.jpp.astnodes.adapter;

import java.util.ArrayList;
import java.util.List;

import org.jpp.heart.Py;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyBytes;

public class IdentifierAdapter implements AstAdapter {

    public Object py2ast(PyObject o) {
        if (o == null || o == Py.None) {
            return null;
        }
        return o.toString();
    }

    public PyObject ast2py(Object o) {
        if (o == null) {
            return Py.None;
        }
        return new PyBytes(o.toString());
    }

    public List iter2ast(PyObject iter) {
        List<String> identifiers = new ArrayList<String>();
        if (iter != Py.None) {
            for(Object o : (Iterable)iter) {
                identifiers.add((String)py2ast((PyObject)o));
            }
        }
        return identifiers;
    }
}
