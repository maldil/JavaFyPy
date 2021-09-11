package org.jpp;

import org.antlr.runtime.ANTLRStringStream;
import org.jpp.astnodes.AnalyzingParser;
import org.jpp.astnodes.base.mod;

public class PyASTParser {
    public static mod parsePython(String code){
        ANTLRStringStream antlrSting = new ANTLRStringStream(code);
        AnalyzingParser p = new AnalyzingParser(antlrSting, "src/test/resources/testast4.py", "ascii");
        mod ast = p.parseModule();
        return ast;
    }
}
