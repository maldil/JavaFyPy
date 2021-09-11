package org.jpp.modules;

import org.jpp.heart.BuiltinDocs;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

import java.util.HashMap;
import java.util.Map;

/**
 * namespace object implementation
 */
@ExposedType(name = "SimpleNamespace", doc = BuiltinDocs.SimpleNamespace_doc)
public class PyNamespace extends PyObject {
    public static final PyType TYPE = PyType.fromClass(PyNamespace.class);

    @ExposedGet(name = "__dict__")
    public Map<String, PyObject> dict;

    public PyNamespace(PyType subtype) {
        super(subtype);
        this.dict = new HashMap<>();
    }

    public PyNamespace(Map<String, PyObject> dict) {
        super(TYPE);
        this.dict = dict;
    }

    @ExposedNew
    @ExposedMethod(doc = BuiltinDocs.SimpleNamespace___init___doc)
    final void SimpleNamespace___init__(PyObject[] args, String[] kwds) {
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder("namespace(");
        boolean first = true;
        for (String key : dict.keySet()) {
            if (!first) {
                items.append(", ");
            } else {
                first = false;
            }
            items.append(key).append("=").append(dict.get(key));
        }
        return items.append(")").toString();
    }

    final PyObject SimpleNamespace___eq__(PyObject other) {
        return Py.newBoolean(dict.equals(other.__getattr__("__dict__")));
    }

    @ExposedMethod(doc = BuiltinDocs.SimpleNamespace___getattribute___doc)
    final PyObject SimpleNamespace___getattribute__(PyObject name) {
        return dict.get(name.asString());
    }

    @ExposedMethod(doc = BuiltinDocs.SimpleNamespace___setattr___doc)
    final PyObject SimpleNamespace___setattr__(PyObject name, PyObject value) {
        dict.put(name.asString(), value);
        return Py.None;
    }

    @Override
    public void __setattr__(String name, PyObject value) {
        dict.put(name, value);
    }
}
