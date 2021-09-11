package org.jpp.heart;

import org.jpp.astnodes.base.mod;
import org.jpp.compiler.LegacyCompiler;

/**
 * Facade for different org.jpp.compiler implementations.
 * 
 * The static methods of this class act as a Facade for the org.jpp.compiler subsystem.
 * This is so that the rest of Jython (even generated code) can statically link
 * to the static interface of this class, while allowing for different
 * implementations of the various components of the org.jpp.compiler subsystem.
 * 
 * @author Tobias Ivarsson
 */
public class CompilerFacade {
    
    private static volatile PythonCompiler compiler = loadDefaultCompiler();

    public static void setCompiler(PythonCompiler compiler) {
        CompilerFacade.compiler = compiler;
    }

    private static PythonCompiler loadDefaultCompiler() {
        return new LegacyCompiler();
    }

    public static PyCode compile(mod node, String name, String filename,
            boolean linenumbers, boolean printResults, CompilerFlags cflags) {
        try {
            PythonCodeBundle bundle = compiler.compile(node, name, filename,
                    linenumbers, printResults, cflags);
            return bundle.loadCode();
        } catch (Throwable t) {
            throw ParserFacade.fixParseError(null, t, filename);
        }
    }
}
