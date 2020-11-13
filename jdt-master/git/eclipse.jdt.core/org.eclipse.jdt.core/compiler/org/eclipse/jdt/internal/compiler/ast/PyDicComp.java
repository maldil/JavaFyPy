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
    public ArrayList<LocalDeclaration> typeValues=null;
    private Expression iterator=null;
    private Expression binaryExpression=null;

    public void updateIndices(){
        this.sourceStart = target1.sourceStart;
        if (binaryExpression!=null){
            this.sourceEnd = binaryExpression.sourceEnd;
        }
        this.sourceEnd = iterator.sourceEnd;
    }

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.target1.printExpression(indent, output).append(" :: "); //$NON-NLS-1$
        this.target2.printExpression(indent, output).append(" for ");
        if (this.typeValues!=null){
            for(int j = 0; j < this.typeValues.size(); ++j) {
                (this.typeValues.get(j)).printAsExpression(0, output);
                if (j!=this.typeValues.size()-1)
                    output.append(',');
            }
            output.append("::");
        }
        if (binaryExpression==null) {
            return this.iterator.printExpression(0, output);
        }
        else{
            this.iterator.printExpression(0, output).append(" if ");
            return binaryExpression.printExpression(0, output) ;
        }

    }

    public Expression getTarget1() {
        return target1;
    }

    public Expression getTarget2() {
        return target2;
    }

    public ArrayList<LocalDeclaration> getTypeValues() {
        return typeValues;
    }

    public Expression getIterator() {
        return iterator;
    }

    public Expression getBinaryExpression() {
        return binaryExpression;
    }

    public void setTarget1(Expression target1) {
        this.target1 = target1;
    }

    public void setTarget2(Expression target2) {
        this.target2 = target2;
    }

    public void setTypeValues(ArrayList<LocalDeclaration> typeValues) {
        this.typeValues = typeValues;
    }

    public void setIterator(Expression iterator) {
        this.iterator = iterator;
    }

    public void setBinaryExpression(Expression binaryExpression) {
        this.binaryExpression = binaryExpression;
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            this.target1.traverse(visitor, scope);
            this.target2.traverse(visitor, scope);
            if (typeValues!=null)
            {
                for (LocalDeclaration typeValue : typeValues) {
                    typeValue.traverse(visitor,scope);
                }
            }
            this.iterator.traverse(visitor, scope);
            if (binaryExpression!=null){
                this.binaryExpression.traverse(visitor, scope);
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
