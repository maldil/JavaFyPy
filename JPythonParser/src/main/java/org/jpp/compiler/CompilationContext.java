
package org.jpp.compiler;

import org.jpp.astnodes.PythonTree;

public interface CompilationContext {

    public Future getFutures();
    public void error(String msg,boolean err,PythonTree node)
        throws Exception;

    public String getFilename();


    public ScopeInfo getScopeInfo(PythonTree node);
}
