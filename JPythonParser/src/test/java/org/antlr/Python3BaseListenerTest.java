package org.antlr;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Python3BaseListenerTest {

    @Test
    public void testEnterSingle_input() {
        try {
            Python3Lexer python3Lexer = new Python3Lexer(new ANTLRFileStream("src/test/resources/testast1.py"));
            CommonTokenStream commonTokenStream = new CommonTokenStream(python3Lexer);
            Python3Parser python3Parser = new Python3Parser(commonTokenStream);
            List<String> ruleNamesList = Arrays.asList(python3Parser.getRuleNames());

            Python3Parser.File_inputContext fi = python3Parser.file_input();
            MyPython3Visitor visitor = new MyPython3Visitor(ruleNamesList);
            visitor.visit(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testEnterSingle_input1() {
//        try {
//            CharStream input = CharStreams.fromPath(Paths.get("src/test/resources/testast1.py"));
//            Python3Lexer lexer = new Python3Lexer(input);
//            CommonTokenStream tokens = new CommonTokenStream(lexer);
//            Python3Parser parser = new Python3Parser(tokens);
//            parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
//            try {
//                parser.stat();  // STAGE 1
//            }
//            catch (Exception ex) {
//                tokens.reset(); // rewind input stream
//                parser.reset();
//                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
//                parser.stat();  // STAGE 2
//                // if we parse ok, it's LL not SLL
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}



