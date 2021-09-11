package org.jpp.heart;

import java.util.Iterator;

public class JavaIterator extends PyIterator {

    final private Iterator<Object> proxy;

    public JavaIterator(Iterable<Object> proxy) {
        this(proxy.iterator());
    }

    public JavaIterator(Iterator<Object> proxy) {
        this.proxy = proxy;
    }

    public PyObject __next__() {
        return proxy.hasNext() ? Py.java2py(proxy.next()) : null;
    }
}
