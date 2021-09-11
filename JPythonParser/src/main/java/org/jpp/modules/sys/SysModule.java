package org.jpp.modules.sys;

import org.jpp.heart.BuiltinDocs;
import org.jpp.heart.Py;
import org.jpp.heart.PyException;
import org.jpp.heart.PyFrame;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyTuple;
import org.jpp.heart.PyUnicode;
import org.jpp.exposers.ExposedConst;
import org.jpp.exposers.ExposedFunction;
import org.jpp.exposers.ExposedModule;
import org.jpp.exposers.ModuleInit;

import java.util.concurrent.Callable;

@ExposedModule(name = "sys")
public class SysModule {
    @ExposedConst(name = "maxunicode")
    public static final int MAXUNICODE = 0x10FFFF;

    @ModuleInit
    public static final void classDictInit(PyObject dict) {
        dict.__setitem__("hash_info", new HashInfo());
    }

    @ExposedFunction(names = "exc_info", doc = BuiltinDocs.sys_exc_info_doc)
    public static PyObject sys_exc_info() {
        PyException exc = Py.getThreadState().exceptions.peek();
        if (exc == null) {
            return new PyTuple(Py.None, Py.None, Py.None);
        }
        PyObject tb = exc.traceback;
        PyObject value = exc.value;
        return new PyTuple(exc.type, value == null ? Py.None : value, tb == null ? Py.None : tb);
    }

    @ExposedFunction
    public static PyObject getfilesystemencoding() {
        return Py.getSystemState().getfilesystemencoding();
    }

    @ExposedFunction(defaults = "-1")
    public static PyObject _getframe(int depth) {
        PyFrame f = Py.getFrame();

        while (depth > 0 && f != null) {
            f = f.f_back;
            --depth;
        }
        if (f == null) {
            throw Py.ValueError("call stack is not deep enough");
        }
        return f;
    }

    @ExposedFunction
    public static void settrace(PyObject tracefunc) {
        Py.getSystemState().settrace(tracefunc);
    }

    @ExposedFunction
    public static final PyObject gettrace() {
        return Py.getSystemState().gettrace();
    }

    @ExposedFunction
    public static PyObject registerCloser(final PyObject closer) {
        Callable<Void> resourceCloser = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                closer.__call__();
                return null;
            }
        };
        Py.getSystemState().registerCloser(resourceCloser);
        return Py.None;
    }

    @ExposedFunction
    public static PyObject unregisterCloser(Callable<Void> resourceCloser) {
        return Py.newBoolean(Py.getSystemState().unregisterCloser(resourceCloser));
    }

    /**
     * Exit a Python program with the given status.
     *
     * @param status the value to exit with
     * @exception Py.SystemExit always throws this exception. When caught at top level the program
     *                will exit.
     */
    @ExposedFunction(defaults = {"null"})
    public static void exit(PyObject status) {
        throw new PyException(Py.SystemExit, status);
    }

    // Java API
    public static void setObject(String name, PyObject value) {
        PyObject sysdict = Py.getSystemState().sysdict;
        sysdict.__setitem__(name, value);
    }

    public static PyObject getObject(String name) {
        PyObject sysdict = Py.getSystemState().sysdict;
        return sysdict.__getitem__(name);
    }

    @ExposedFunction
    public static PyObject intern(PyObject s) {
        return new PyUnicode(s.toString().intern(), true);
    }
}
