package org.eclipse.jdt.internal.compiler.ast;

import java.util.ArrayList;

public class TupleTypeExpression extends OperatorExpression{
    public TupleTypeExpression(ArrayList<LocalDeclaration> elementVariablesExtras) {
        this.localDeclarations = elementVariablesExtras;
    }

    private ArrayList<LocalDeclaration> localDeclarations;
    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        int i=0;
        for (LocalDeclaration elementVariablesExtra : localDeclarations) {
            if (i== localDeclarations.size()-1){
                break;
            }
            elementVariablesExtra.printAsExpression(indent, output).append(" , ");
            i+=1;
        }
        return this.localDeclarations.get(i).print(0, output);
    }

    public ArrayList<LocalDeclaration> getLocalDeclarations() {
        return localDeclarations;
    }

    public void setLocalDeclarations(ArrayList<LocalDeclaration> localDeclarations) {
        this.localDeclarations = localDeclarations;
    }
}
