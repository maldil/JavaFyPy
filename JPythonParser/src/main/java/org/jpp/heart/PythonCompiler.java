package org.jpp.heart;

import org.jpp.astnodes.base.mod;

public interface PythonCompiler {

    PythonCodeBundle compile(mod node, String name, String filename,
            boolean linenumbers, boolean printResults, CompilerFlags cflags)
            throws Exception;

}
