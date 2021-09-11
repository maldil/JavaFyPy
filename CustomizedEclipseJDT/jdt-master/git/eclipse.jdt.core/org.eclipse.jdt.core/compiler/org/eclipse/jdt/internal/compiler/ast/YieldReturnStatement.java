package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;

public class YieldReturnStatement extends Statement {
    public Expression expression;
    public SubRoutineStatement[] subroutines;
    public LocalVariableBinding saveValueVariable;
    public int initStateIndex = -1;
    private boolean implicitReturn;

    public YieldReturnStatement(Expression expression, int sourceStart, int sourceEnd) {
        this(expression, sourceStart, sourceEnd, false);
    }
    public YieldReturnStatement(Expression expression, int sourceStart, int sourceEnd, boolean implicitReturn) {
        this.sourceStart = sourceStart;
        this.sourceEnd = sourceEnd;
        this.expression = expression;
        this.implicitReturn = implicitReturn;
    }
    public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {
        return null;
    }

    @Override
    public boolean doesNotCompleteNormally() {
        return true;
    }

    @Override
    public boolean canCompleteNormally() {
        return false;
    }

    @Override
    public StringBuffer printStatement(int tab, StringBuffer output){
        printIndent(tab, output).append("yield "); //$NON-NLS-1$
        if (this.expression != null )
            this.expression.printExpression(0, output) ;
        return output.append(';');
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            if (this.expression != null)
                this.expression.traverse(visitor, scope);
        }
        visitor.endVisit(this, scope);
    }

    public void generateCode(BlockScope currentScope, CodeStream codeStream) {

    }


    public void resolve(BlockScope scope) {

    }
}
