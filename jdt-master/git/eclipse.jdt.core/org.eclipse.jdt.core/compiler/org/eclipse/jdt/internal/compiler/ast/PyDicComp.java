package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

import java.util.ArrayList;

public class PyDicComp extends OperatorExpression implements IPolyExpression{
//    ConditionalExpression ::= TupleExpression '::' TupleExpression  EnhancedForStatementHeaderInit  '::' Expression 'if' ConditionalOrExpression
    private Expression target1=null;
    private Expression target2=null;
//    public ArrayList<LocalDeclaration> typeValues=null;
//    private Expression iterator=null;
//    private Expression binaryExpression=null;
    public ArrayList<PyComparator> comparetors=null;
    public void updateIndices(){
        this.sourceStart = target1.sourceStart;
        this.sourceEnd = comparetors.get(comparetors.size()-1).sourceEnd;
    }

    public PyDicComp() {
        this.comparetors = new ArrayList<PyComparator>();
    }

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.target1.printExpression(indent, output).append(" ::: "); //$NON-NLS-1$
        this.target2.printExpression(indent, output);

        if (this.comparetors!=null) {
            for (int j = 0; j < this.comparetors.size(); ++j) {
                (this.comparetors.get(j)).printExpressionNoParenthesis(indent, output);
            }
        }
        return output;
    }

    public Expression getTarget1() {
        return target1;
    }

    public Expression getTarget2() {
        return target2;
    }

    public void setTarget1(Expression target1) {
        this.target1 = target1;
    }

    public void setTarget2(Expression target2) {
        this.target2 = target2;
    }

    public ArrayList<PyComparator> getComparetors() {
        return comparetors;
    }

    public void setComparetor(PyComparator comparetor) {
        this.comparetors.add(comparetor);
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            this.target1.traverse(visitor, scope);
            this.target2.traverse(visitor, scope);
            if (comparetors!=null)
            {
                for (PyComparator typeValue : comparetors) {
                    typeValue.traverse(visitor,scope);
                }
            }
        }
        visitor.endVisit(this, scope);
    }
    @Override
    public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext,
                                FlowInfo flowInfo) {return flowInfo;}

    @Override
    public void generateCode(
            BlockScope currentScope,
            CodeStream codeStream,
            boolean valueRequired) {}
    @Override
    public TypeBinding resolveType(BlockScope scope) {return null;}
}
