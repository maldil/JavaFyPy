package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class TupleExpression extends OperatorExpression{
    public Expression left;
    public Expression right;

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.left.printExpression(indent, output).append(" pyjavatuple "); //$NON-NLS-1$
        return this.right.print(0, output);
    }


    public TupleExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        right.bits |= IgnoreRawTypeCheck;
        this.bits |= INSTANCEOF << OperatorSHIFT;
        this.sourceStart = left.sourceStart;
        this.sourceEnd = right.sourceEnd;
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            this.left.traverse(visitor, scope);
            this.right.traverse(visitor, scope);

        }
        visitor.endVisit(this, scope);
    }

    @Override
    public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {return flowInfo;}

    @Override
    public void generateCode(BlockScope currentScope, CodeStream codeStream) {}

    @Override
    public void resolve(BlockScope upperScope) {}

}
