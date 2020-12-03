package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

import java.util.ArrayList;

public class PyGenerators extends OperatorExpression implements IPolyExpression{
//    ConditionalExpression ::= TupleExpression GeneratorHeader_List
    private Expression target=null;
    public ArrayList<PyComparator> comparetors=null;

    public PyGenerators() {
        this.comparetors = new ArrayList<PyComparator>();
    }

    public void updateIndices(){
        this.sourceStart = target.sourceStart;
        this.sourceEnd = comparetors.get(comparetors.size()-1).sourceEnd;
    }

    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.target.printExpression(indent, output);//$NON-NLS-1$
        if (this.comparetors!=null) {
            for (int j = 0; j < this.comparetors.size(); ++j) {
                (this.comparetors.get(j)).printExpressionNoParenthesis(indent, output);
            }
        }
        return output;
    }


    public Expression getTarget() {
        return target;
    }

    public ArrayList<PyComparator> getComparetors() {
        return comparetors;
    }

    public void setTarget(Expression target) {
        this.target = target;
    }

    public void setComparetor(PyComparator comparetor) {
        this.comparetors.add(comparetor);
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            this.target.traverse(visitor, scope);

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
