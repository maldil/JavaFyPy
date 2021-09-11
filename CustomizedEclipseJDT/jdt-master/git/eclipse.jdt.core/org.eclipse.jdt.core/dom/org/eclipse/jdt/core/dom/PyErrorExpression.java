package org.eclipse.jdt.core.dom;

import java.util.List;

public class PyErrorExpression extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     * This node is to identify error Python Expression.
     * @param ast the AST that is to own this node
     */
    PyErrorExpression(AST ast) {
        super(ast);
    }

    List internalStructuralPropertiesForType(int apiLevel) {
        return null;
    }

    int getNodeType0() {
        return 0;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return false;
    }

    ASTNode clone0(AST target) {
        return null;
    }

    void accept0(ASTVisitor visitor) {

    }

    int treeSize() {
        return 0;
    }

    int memSize() {
        return 0;
    }
}
