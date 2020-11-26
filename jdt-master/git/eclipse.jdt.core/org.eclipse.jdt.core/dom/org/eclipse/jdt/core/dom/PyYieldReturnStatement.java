package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PyYieldReturnStatement extends Statement {
    /**
     * Creates a new AST node for a statement owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    PyYieldReturnStatement(AST ast) {
        super(ast);
    }

    public static final ChildPropertyDescriptor EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyYieldReturnStatement.class, "expression", Expression.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$

    private static final List PROPERTY_DESCRIPTORS;

    static {
        List propertyList = new ArrayList(2);
        createPropertyList(PyYieldReturnStatement.class, propertyList);
        addProperty(EXPRESSION_PROPERTY, propertyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
    }
    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    /**
     * The expression; <code>null</code> for none; defaults to none.
     */
    private Expression optionalExpression = null;

    @Override
    final List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == EXPRESSION_PROPERTY) {
            if (get) {
                return getExpression();
            } else {
                setExpression((Expression) child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }

    int getNodeType0() {
        return PY_YIELD_RETURN_STATEMENT;
    }


    @Override
    ASTNode clone0(AST target) {
        PyYieldReturnStatement result = new PyYieldReturnStatement(target);
        result.setSourceRange(getStartPosition(), getLength());
        result.copyLeadingComment(this);
        result.setExpression(
                (Expression) ASTNode.copySubtree(target, getExpression()));
        return result;
    }

    public Expression getExpression() {
        return this.optionalExpression;
    }

    public void setExpression(Expression expression) {
        ASTNode oldChild = this.optionalExpression;
        preReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
        this.optionalExpression = expression;
        postReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
    }

    @Override
    final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        // dispatch to correct overloaded match method
        return matcher.match(this, other);
    }

    @Override
    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            acceptChild(visitor, getExpression());
        }
        visitor.endVisit(this);
    }

    @Override
    int memSize() {
        return super.memSize() + 1 * 4;
    }

    @Override
    int treeSize() {
        return
                memSize()
                        + (this.optionalExpression == null ? 0 : getExpression().treeSize());
    }
}
