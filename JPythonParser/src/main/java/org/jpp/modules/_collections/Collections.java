package org.jpp.modules._collections;

import org.jpp.heart.PyObject;
import org.jpp.exposers.ExposedModule;
import org.jpp.exposers.ModuleInit;

/**
 * Collections - This module adds the ability to use high performance data 
 *               structures.
 *               - deque:  ordered collection accessible from endpoints only
 *               - defaultdict:  dict subclass with a default value factory
 */
@ExposedModule(name = "_collections")
public class Collections {

    @ModuleInit
    public static void classDictInit(PyObject dict) {
        dict.__setitem__("deque", PyDeque.TYPE);
        dict.__setitem__("defaultdict", PyDefaultDict.TYPE);
        // xxx OrderedDict missing
    }
}
