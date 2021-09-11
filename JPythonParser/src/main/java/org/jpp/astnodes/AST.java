package org.jpp.astnodes;

import org.jpp.heart.Py;
import org.jpp.heart.PyException;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.heart.Untraversable;
import org.jpp.exposers.ExposedType;

@Untraversable
@ExposedType(name = "_ast.AST", base = PyObject.class)
public class AST extends PyObject {
    public static final PyType TYPE = PyType.fromClass(AST.class);
    
    public AST() {
    }

    public AST(PyType objtype) {
        super(objtype);
    }

    public static boolean check(int nargs, int expected, boolean takesZeroArgs) {
        if (nargs == expected) {
            return true;
        }
        if (takesZeroArgs && nargs == 0) {
            return true;
        }
        return false;
    }

    public static PyException unexpectedCall(int expected, String name) {
        String message = " constructor takes 0 positional arguments";
        if (expected != 0) {
            message = " constructor takes either 0 or " + expected + " arguments";
        }
        return Py.TypeError(name + message);
    }
}
