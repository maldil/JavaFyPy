package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

import java.util.ArrayList;

public class PyComparator extends OperatorExpression implements IPolyExpression{
    public ArrayList<LocalDeclaration> typeValues=null;
    private Expression iterator=null;
    private Expression binaryExpression=null;

    public void updateIndices(){
        this.sourceStart = typeValues.get(0).sourceStart-3;
        if (binaryExpression!=null){
            this.sourceEnd = binaryExpression.sourceEnd;
        }
        else {
            this.sourceEnd = iterator.sourceEnd;
        }
    }

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        output.append(" for "); //$NON-NLS-1$

        if (this.typeValues!=null){
            for(int j = 0; j < this.typeValues.size(); ++j) {
                (this.typeValues.get(j)).printAsExpression(0, output);
                if (j!=this.typeValues.size()-1)
                    output.append(',');
            }
            output.append(':');
        }
        if (binaryExpression==null) {
            return this.iterator.printExpression(0, output);
        }
        else{
            this.iterator.printExpression(0, output).append(" if ");
            return binaryExpression.printExpression(0, output) ;
        }
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
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

    public ArrayList<LocalDeclaration> getTypeValues() {
        return typeValues;
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

    public void setIterator(Expression iterator) {
        this.iterator = iterator;
    }

    public void setBinaryExpression(Expression binaryExpression) {
        this.binaryExpression = binaryExpression;
    }

}
