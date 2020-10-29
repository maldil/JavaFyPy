package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

import java.util.ArrayList;

public class PyGenerators extends OperatorExpression implements IPolyExpression{
 //   ConditionalExpression ::= TupleExpression 'for' TupleExpression ':' ConditionalExpression 'if' ConditionalOrExpression
    private Expression target=null;
    private Expression value=null;
    public ArrayList<LocalDeclaration> typeValues=null;
    private Expression iterator=null;
    private Expression binaryExpression=null;
    public void updateIndices(){
        this.sourceStart = target.sourceStart;
        this.sourceEnd = binaryExpression.sourceEnd;
    }

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.target.printExpression(indent, output).append(" for "); //$NON-NLS-1$
        if(this.value!=null)
            this.value.printExpression(0, output).append(" : "); //$NON-NLS-1$
        if (this.typeValues!=null){
            for(int j = 0; j < this.typeValues.size(); ++j) {
                (this.typeValues.get(j)).printAsExpression(0, output);
                if (j!=this.typeValues.size()-1)
                    output.append(',');
            }
            output.append(':');
        }
        if (iterator!=null) {
            this.iterator.printExpression(0, output).append(" if ");
        }
        return binaryExpression.printExpression(0, output) ;
    }

    public ArrayList<LocalDeclaration> getTypeValues() {
        return typeValues;
    }

    public Expression getTarget() {
        return target;
    }

    public Expression getValue() {
        return value;
    }

    public Expression getIterator() {
        return iterator;
    }

    public Expression getBinaryExpression() {
        return binaryExpression;
    }

    public void setTypeValues(ArrayList<LocalDeclaration> typeValues) {
        this.typeValues = typeValues;
    }

    public void setTarget(Expression target) {
        this.target = target;
    }

    public void setValue(Expression value) {
        this.value = value;
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
            this.target.traverse(visitor, scope);
            if (value!=null){this.value.traverse(visitor, scope);}
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
