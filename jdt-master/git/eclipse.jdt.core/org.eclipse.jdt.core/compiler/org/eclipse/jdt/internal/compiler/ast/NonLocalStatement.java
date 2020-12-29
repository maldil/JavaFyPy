package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;

public class NonLocalStatement extends Statement {
    public Expression expression;
    public SubRoutineStatement[] subroutines;
    public LocalVariableBinding saveValueVariable;
    public int initStateIndex = -1;

    public NonLocalStatement(Expression expression, int sourceStart, int sourceEnd) {
        this.sourceStart = sourceStart;
        this.sourceEnd = sourceEnd;
        this.expression = expression;
    }

    public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {
        return null;
    }

    public void generateCode(BlockScope currentScope, CodeStream codeStream) {

    }

    public StringBuffer printStatement(int indent, StringBuffer output) {
        printIndent(indent, output).append("nonlocal "); //$NON-NLS-1$
        if (this.expression != null )
            this.expression.printExpression(0, output) ;
        return output.append(';');
    }

    public void resolve(BlockScope scope) {

    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            if (this.expression != null)
                this.expression.traverse(visitor, scope);
        }
        visitor.endVisit(this, scope);
    }
}
