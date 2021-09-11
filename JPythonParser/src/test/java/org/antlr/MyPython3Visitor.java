package org.antlr;

import org.jpp.util.TreeUtils;

import java.util.List;

public class MyPython3Visitor extends Python3BaseVisitor <String>{
    List<String> ruleNamesList =null;
    public MyPython3Visitor(List<String> ruleNaList) {
        super();
        ruleNamesList=ruleNaList;

    }

    @Override
    public String visitFuncdef(Python3Parser.FuncdefContext ctx) {
        System.out.println(ctx.NAME());
        System.out.println(ctx.suite().getText());
        System.out.println(ctx.children);
        System.out.println(TreeUtils.toPrettyTree(ctx,ruleNamesList));
        return visitChildren(ctx);

    }

    @Override
    public String visitReturn_stmt(Python3Parser.Return_stmtContext ctx) {
        System.out.println(ruleNamesList);
        System.out.println(TreeUtils.toPrettyTree(ctx, (List<String>) ruleNamesList));
//        for (ParseTree child : ctx.children) {
//            System.out.println("child");
//
//
//
//        }


        return super.visitReturn_stmt(ctx);
    }
}
