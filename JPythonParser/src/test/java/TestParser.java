import org.antlr.runtime.*;
import org.jpp.astnodes.*;

import org.jpp.astnodes.ast.Name;
import org.jpp.astnodes.base.mod;
import org.testng.annotations.Test;

import java.util.List;
import org.testng.Assert;

public class TestParser {
    public class AnalyzingParser extends BaseParser {
        public AnalyzingParser(CharStream stream, String filename, String encoding) {
            super(stream, filename, encoding);
            errorHandler = new RecordingErrorHandler();
        }
        public List<RecognitionException> getRecognitionErrors() {
            return ((RecordingErrorHandler)errorHandler).errs;
        }
        @Override
        protected PythonParser setupParser(boolean single) {
            PythonParser parser = super.setupParser(single);
            parser.setTreeAdaptor(new org.jpp.astnodes.AnalyzingParser.AnalyzerTreeAdaptor());
            return parser;
        }
    }
    public static class AnalyzerTreeAdaptor extends PythonTreeAdaptor {
        /**
         * Make sure a parenthesized {@link Name} expr has its start/stop bounds
         * set to the bounds of the identifier.
         */
        @Override
        public void setTokenBoundaries(Object t, Token startToken, Token stopToken) {
            //XXX: should do this for all expr types, and have a prop list on Expr
            //that records all enclosing paren locations for IDE use cases.
            if (!(t instanceof Name)
                    || startToken == null
                    || stopToken == null
                    || startToken.getType() != PythonParser.LPAREN
                    || stopToken.getType() != PythonParser.RPAREN) {
                super.setTokenBoundaries(t, startToken, stopToken);
            }
        }
    }
    @Test
    public void testClassFunc() {
        System.out.println("test");
        CharStream in = null;
        try {
            in = new ANTLRFileStream("src/test/resources/testast1.py");
        } catch (Exception x) {
            x.printStackTrace();
        }
        org.jpp.astnodes.AnalyzingParser p = new org.jpp.astnodes.AnalyzingParser(in, "src/test/resources/testast1.py", "ascii");
        mod ast = p.parseModule();
        Assert.assertEquals(ast.getChildren().size(),3);

//        if (ast != null) {
//            System.out.println("parse result: \n" + ast.toStringTree());
//        } else {
//            System.out.println("failure: \n" + p.getRecognitionErrors());
//        }
    }
    @Test
    public void testStatements() throws Exception {
        System.out.println("test");
        CharStream in = null;
        try {
            in = new ANTLRFileStream("src/test/resources/testast2.py");
        } catch (Exception x) {
            x.printStackTrace();
        }
        AnalyzingParser p = new AnalyzingParser(in, "src/test/resources/testast2.py", "ascii");
        mod ast = p.parseModule();
        TestVisitor v = new TestVisitor();
        ast.accept(v);

        Assert.assertEquals(ast.getChildren().size(),3);
        if (ast != null) {
            System.out.println("parse result: \n" + ast.toStringTree());
        } else {
            System.out.println("failure: \n" + p.getRecognitionErrors());
        }
    }
    @Test
    public void testTryExcept() {
        System.out.println("test");
        CharStream in = null;

        try {
            in = new ANTLRFileStream("src/test/resources/testast4.py");
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.out.println(in);
        org.jpp.astnodes.AnalyzingParser p = new org.jpp.astnodes.AnalyzingParser(in, "src/test/resources/testast4.py", "ascii");
        mod ast = p.parseModule();
        Assert.assertEquals(ast.getChildren().size(),4);
        if (ast != null) {
            System.out.println("parse result: \n" + ast.toStringTree());
        } else {
            System.out.println("failure: \n" + p.getRecognitionErrors());
        }
    }
    @Test
    public void testListComp() {
        System.out.println("test");
        CharStream in = null;
        try {
            in = new ANTLRFileStream("src/test/resources/testast5.py");
        } catch (Exception x) {
            x.printStackTrace();
        }
        org.jpp.astnodes.AnalyzingParser p = new org.jpp.astnodes.AnalyzingParser(in, "src/test/resources/testast5.py", "ascii");
        mod ast = p.parseModule();
        Assert.assertEquals(ast.getChildren().size(),4);

        System.out.println(p.getRecognitionErrors());
        if (ast != null) {
            System.out.println("parse result: \n" + ast.toStringTree());
        } else {
            System.out.println("failure: \n" + p.getRecognitionErrors());
        }
    }
    @Test
    public void testcase6() {
        System.out.println("test");
        CharStream in = null;
        try {
            in = new ANTLRFileStream("src/test/resources/testast6.py");
        } catch (Exception x) {
            x.printStackTrace();
        }
        org.jpp.astnodes.AnalyzingParser p = new org.jpp.astnodes.AnalyzingParser(in, "src/test/resources/testast6.py", "ascii");
        mod ast = p.parseModule();
        Assert.assertEquals(ast.getChildren().size(),32);

        System.out.println(p.getRecognitionErrors());
        if (ast != null) {
            System.out.println("parse result: \n" + ast.toStringTree());
        } else {
            System.out.println("failure: \n" + p.getRecognitionErrors());
        }
    }
}
