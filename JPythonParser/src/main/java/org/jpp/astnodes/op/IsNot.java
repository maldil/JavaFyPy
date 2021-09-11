// Autogenerated AST node on 08/11/2020, 15:59:03
package org.jpp.astnodes.op;

import org.jpp.astnodes.base.cmpop;
import org.jpp.astnodes.PythonTree;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyUnicode;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedType;

@ExposedType(name = "_ast.IsNot", base = cmpop.class)
public class IsNot extends PythonTree {
    public static final PyType TYPE = PyType.fromClass(IsNot.class);

public IsNot() {
}

public IsNot(PyType subType) {
    super(subType);
}

@ExposedNew
@ExposedMethod
public void IsNot___init__(PyObject[] args, String[] keywords) {}

    private final static PyUnicode[] fields = new PyUnicode[0];
    @ExposedGet(name = "_fields")
    public PyUnicode[] get_fields() { return fields; }

    private final static PyUnicode[] attributes = new PyUnicode[0];
    @ExposedGet(name = "_attributes")
    public PyUnicode[] get_attributes() { return attributes; }

    @ExposedMethod
    public PyObject __int__() {
        return IsNot___int__();
    }

    final PyObject IsNot___int__() {
        return Py.newInteger(8);
    }

}
