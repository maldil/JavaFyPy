/* Copyright (c) Jython Developers */
package org.jpp.modules._weakref;

import org.jpp.heart.PyObject;
import org.jpp.heart.PyType;
import org.jpp.exposers.ExposedMethod;
import org.jpp.exposers.ExposedType;

/**
 * ProxyType with __call__.
 */
@ExposedType(name = "weakcallableproxy", isBaseType = false)
public class CallableProxyType extends ProxyType {

    public static final PyType TYPE = PyType.fromClass(CallableProxyType.class);

    public CallableProxyType(GlobalRef ref, PyObject callback) {
        super(TYPE, ref, callback);
    }

    public PyObject __call__(PyObject[] args, String[] kws) {
        return weakcallableproxy___call__(args, kws);
    }

    @ExposedMethod
    final PyObject weakcallableproxy___call__(PyObject[] args, String[] kws) {
        return py().__call__(args, kws);
    }
}
