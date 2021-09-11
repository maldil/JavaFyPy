/* Copyright (c) Jython Developers */
package org.jpp.modules._collections;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.jpp.heart.Py;
import org.jpp.heart.PyDictionary;
import org.jpp.heart.PyObject;
import org.jpp.heart.PyTuple;
import org.jpp.heart.PyType;
import org.jpp.heart.Traverseproc;
import org.jpp.heart.Visitproc;
import org.jpp.exposers.ExposedDelete;
import org.jpp.exposers.ExposedGet;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedNew;
import org.jpp.exposers.ExposedSet;
import org.jpp.exposers.ExposedType;

import org.jpp.heart.BuiltinDocs;

/**
 * PyDefaultDict - This is a subclass of the builtin dict(PyDictionary) class. It supports
 * one additional method __missing__ and adds one writable instance variable
 * defaultFactory. The remaining functionality is the same as for the dict class.
 *
 * collections.defaultdict([defaultFactory[, ...]]) - returns a new dictionary-like
 * object. The first argument provides the initial value for the defaultFactory attribute;
 * it defaults to None.  All remaining arguments are treated the same as if they were
 * passed to the dict constructor, including keyword arguments.
 */
@ExposedType(name = "collections.defaultdict")
public class PyDefaultDict extends PyDictionary implements Traverseproc {

    public static final PyType TYPE = PyType.fromClass(PyDefaultDict.class);
    /**
     * This attribute is used by the __missing__ method; it is initialized from the first
     * argument to the constructor, if present, or to None, if absent.
     */
    private PyObject defaultFactory = Py.None;
    private final LoadingCache<PyObject, PyObject> backingMap;

    public ConcurrentMap<PyObject, PyObject> getMap() {
        return backingMap.asMap();
    }

    public PyDefaultDict() {
        this(TYPE);
    }

    public PyDefaultDict(PyType subtype) {
        super(subtype, false);
        backingMap = CacheBuilder.newBuilder().build(
                new CacheLoader<PyObject, PyObject>() {
                    public PyObject load(PyObject key) {
                        return __missing__(key);
                    }
                });
    }

    public PyDefaultDict(PyType subtype, Map<PyObject, PyObject> map) {
        this(subtype);
        getMap().putAll(map);
    }

    @ExposedMethod
    @ExposedNew
    final void defaultdict___init__(PyObject[] args, String[] kwds) {
        int nargs = args.length - kwds.length;
        if (nargs != 0) {
            defaultFactory = args[0];
            if (!(defaultFactory == Py.None || defaultFactory.isCallable())) {
                throw Py.TypeError("first argument must be callable");
            }
            PyObject newargs[] = new PyObject[args.length - 1];
            System.arraycopy(args, 1, newargs, 0, newargs.length);
            dict___init__(newargs, kwds);
        }
    }

    public PyObject __missing__(PyObject key) {
        return defaultdict___missing__(key);
    }

    /**
     * This method does NOT call __setitem__ instead it relies on the fact that it is
     * called within the context of `CacheLoader#load` to actually insert the value
     * into the dict.
     */
    @ExposedMethod
    final PyObject defaultdict___missing__(PyObject key) {
        if (defaultFactory == Py.None) {
            throw Py.KeyError(key);
        }
        return defaultFactory.__call__();
    }

    @Override
    public PyObject __reduce__() {
        return defaultdict___reduce__();
    }

    @ExposedMethod
    final PyObject defaultdict___reduce__() {
        PyTuple args = null;
        if (defaultFactory == Py.None) {
            args = new PyTuple();
        } else {
            PyObject[] ob = {defaultFactory};
            args = new PyTuple(ob);
        }
        return new PyTuple(getType(), args, Py.None, Py.None, dict_iteritems());
    }

    @Override
    public PyDictionary copy() {
        return defaultdict_copy();
    }

    @ExposedMethod(names = {"copy", "__copy__"})
    final PyDefaultDict defaultdict_copy() {
        PyDefaultDict ob = new PyDefaultDict(TYPE, getMap());
        ob.defaultFactory = defaultFactory;
        return ob;
    }

    @Override
    public String toString() {
        return defaultdict_toString();
    }

    @ExposedMethod(names = "__repr__")
    final String defaultdict_toString() {
        return String.format("defaultdict(%s, %s)", defaultFactory, super.toString());
    }

    @ExposedGet(name = "default_factory")
    public PyObject getDefaultFactory() {
        return defaultFactory;
    }

    @ExposedSet(name = "default_factory")
    public void setDefaultFactory(PyObject value) {
        defaultFactory = value;
    }

    @ExposedDelete(name = "default_factory")
    public void delDefaultFactory() {
        defaultFactory = Py.None;
    }

    @Override
    public PyObject __finditem__(PyObject key) {
        return defaultdict___getitem__(key);
    }

    @ExposedMethod(doc = BuiltinDocs.dict___getitem___doc)
    protected final PyObject defaultdict___getitem__(PyObject key) {
        try {
            return backingMap.get(key);
        } catch (Exception ex) {
            throw Py.KeyError(key);
        }
    }

    public PyObject get(PyObject key, PyObject defaultObj) {
        PyObject value = getMap().get(key);
        if (value != null) {
            return value;
        } else {
            return defaultObj;
        }
    }


    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        int retVal = super.traverse(visit, arg);
        if (retVal != 0) {
            return retVal;
        }
        retVal = visit.visit(defaultFactory, arg);
        if (retVal != 0) {
            return retVal;
        }
        if (backingMap != null) {
            for (Map.Entry<PyObject, PyObject> ent: backingMap.asMap().entrySet()) {
                retVal = visit.visit(ent.getKey(), arg);
                if (retVal != 0) {
                    return retVal;
                }
                if (ent.getValue() != null) {
                    retVal = visit.visit(ent.getValue(), arg);
                    if (retVal != 0) {
                        return retVal;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        if (ob == null) {
            return false;
        } else if (super.refersDirectlyTo(ob)) {
            return true;
        }
        if (backingMap == null) {
            return false;
        }
        return backingMap.asMap().containsKey(ob) || backingMap.asMap().containsValue(ob);
    }
}
