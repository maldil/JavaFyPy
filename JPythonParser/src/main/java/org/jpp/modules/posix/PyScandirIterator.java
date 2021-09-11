package org.jpp.modules.posix;

import org.jpp.heart.Py;
import org.jpp.heart.PyIterator;
import org.jpp.heart.PyObject;
import org.jpp.exposers.ExposedType;

import java.nio.file.Path;
import java.util.Iterator;

/**
 * Created by isaiah on 7/16/16.
 */
@ExposedType(name = "posix.ScandirIterator")
public class PyScandirIterator extends PyIterator {
    Iterator<Path> iter;
    public PyScandirIterator(Iterator<Path> iter) {
        this.iter = iter;
    }

    @Override
    public PyObject __next__() {
        if (!iter.hasNext()) throw Py.StopIteration();
        return new PyDirEntry(iter.next());
    }
}
