package org.jpp.modules;

import org.jpp.heart.ClassDictInit;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyStringMap;

public class _systemrestart implements ClassDictInit {
    /**
     * Jython-specific exception for restarting the interpreter. Currently
     * supported only by jython.java, when executing a file (i.e,
     * non-interactive mode).
     *
     * WARNING: This is highly *experimental* and subject to change.
     */
    public static PyObject SystemRestart;

    public static void classDictInit(PyObject dict) {
        SystemRestart = Py.makeClass(
                "_systemrestart.SystemRestart", Py.BaseException,
                new PyStringMap() {{
                    __setitem__("__doc__",
                            Py.newString("Request to restart the interpreter. " +
                                         "(Jython-specific)"));
                }});
        dict.__delitem__("classDictInit");
    }
}
