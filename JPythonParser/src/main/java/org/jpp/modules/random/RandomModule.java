package org.jpp.modules.random;

import org.jpp.heart.ClassDictInit;
import org.jpp.heart.Py;
import org.jpp.heart.PyObject;

public class RandomModule implements ClassDictInit {

    private RandomModule() {}

    public static void classDictInit(PyObject dict) {
        dict.invoke("clear");
        dict.__setitem__("Random", PyRandom.TYPE);
        dict.__setitem__("__name__", Py.newString("_random"));
    }
}
