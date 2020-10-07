package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class WithStatement extends Statement{
    public Expression header;
    public Statement statement;

    int postCollectionInitStateIndex = -1;
    int mergedInitStateIndex = -1;

    public WithStatement (Expression header, Statement statement, int s, int e) {
        this.header = header;
        this.statement = statement;
        if (statement instanceof EmptyStatement) statement.bits |= IsUsefulEmptyStatement;
        this.sourceStart = s;
        this.sourceEnd = e;


    }
    @Override
    public FlowInfo analyseCode(BlockScope currentScope, FlowContext flowContext, FlowInfo flowInfo) {
        return null;
    }
    @Override
    public void generateCode(BlockScope currentScope, CodeStream codeStream) {
        if ((this.bits & IsReachable) == 0) {
            return;
        }

        if (this.statement != null) {
            statement.generateCode(currentScope, codeStream);
        }
    }
    @Override
    public StringBuffer printStatement(int indent, StringBuffer output) {
        printIndent(indent, output).append("withstmt (");
        this.header.printExpression(0, output).append(')');
        if (this.statement == null)
            output.append(';');
        else
            this.statement.printStatement(indent + 1, output);
        return output;
    }
    @Override
    public void resolve(BlockScope scope) {
        if (this.statement != null)
            this.statement.resolve(scope);
    }
    @Override
    public void traverse(
            ASTVisitor visitor,
            BlockScope blockScope){

        if (visitor.visit(this, blockScope)) {
            if (this.header!=null){
                this.header.traverse(visitor, blockScope);
            }
            if (this.statement != null){
                this.statement.traverse(visitor, blockScope);
            }
        }
        visitor.endVisit(this, blockScope);

    }

    @Override
    public boolean doesNotCompleteNormally() {
        if (this.statement == null || this.statement.breaksOut(null)){
            return false;
        }
        return this.statement.doesNotCompleteNormally() && !this.statement.completesByContinue();
    }

    @Override
    public boolean completesByContinue(){
        return this.statement.continuesAtOuterLabel();
    }

    @Override
    public boolean canCompleteNormally() {
        return true;
    }

    @Override
    public boolean continueCompletes(){
        return this.statement.continuesAtOuterLabel();
    }
}
