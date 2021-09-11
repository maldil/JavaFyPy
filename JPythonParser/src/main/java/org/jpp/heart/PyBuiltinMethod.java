package org.jpp.heart;

import org.jpp.exposers.ExposeAsSuperclass;

public abstract class PyBuiltinMethod extends PyBuiltinCallable implements ExposeAsSuperclass,
        Cloneable, Traverseproc {

    protected PyObject self;

    protected PyBuiltinMethod(PyType type, PyObject self, Info info) {
        super(type, info);
        this.self = self;
    }

    protected PyBuiltinMethod(PyObject self, Info info) {
        super(info);
        this.self = self;
    }

    protected PyBuiltinMethod(String name) {
        this(null, new DefaultInfo(name));
    }

    @Override
    public PyBuiltinCallable bind(PyObject bindTo) {
        if(self == null) {
            PyBuiltinMethod bindable;
            try {
                bindable = (PyBuiltinMethod)clone();
            } catch(CloneNotSupportedException e) {
                throw new RuntimeException("Didn't expect PyBuiltinMethodto throw " +
                                           "CloneNotSupported since it implements Cloneable", e);
            }
            bindable.self = bindTo;
            return bindable;
        }
        return this;
    }

    public PyObject getSelf(){
        return self;
    }

    public PyMethodDescr makeDescriptor(PyType t) {
        return new PyMethodDescr(t, this);
    }

    @Override
    public int hashCode() {
        int hashCode = self == null ? 0 : self.hashCode();
        return hashCode ^ getClass().hashCode();
    }

    /* Traverseproc implementation */
    @Override
    public int traverse(Visitproc visit, Object arg) {
        return self != null ? visit.visit(self, arg) : 0;
    }

    @Override
    public boolean refersDirectlyTo(PyObject ob) {
        return ob != null && ob == self;
    }
}
