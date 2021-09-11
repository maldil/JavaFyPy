package org.jpp.heart;

import java.io.OutputStream;

public interface PythonCodeBundle {

    PyCode loadCode() throws Exception;

    void writeTo(OutputStream stream) throws Exception;

}
