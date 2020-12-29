package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PyNonLocalStatement extends Statement{
    /**
     * Creates a new AST node for a statement owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildPropertyDescriptor EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyNonLocalStatement.class, "expression", Expression.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$

    private static final List PROPERTY_DESCRIPTORS;
    private Expression expression = null;
    static {
        List propertyList = new ArrayList(2);
        createPropertyList(PyNonLocalStatement.class, propertyList);
        addProperty(EXPRESSION_PROPERTY, propertyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
    }

    PyNonLocalStatement(AST ast) {
        super(ast);
    }

    @Override
    final List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }


    int getNodeType0() {
        return PY_NON_LOCAL;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    @Override
    ASTNode clone0(AST target) {
        PyNonLocalStatement result = new PyNonLocalStatement(target);
        result.setSourceRange(getStartPosition(), getLength());
        result.copyLeadingComment(this);
        result.setExpression(
                (Expression) ASTNode.copySubtree(target, getExpression()));
        return result;
    }

    public Expression getExpression() {
        return this.expression;
    }


    public void setExpression(Expression expression) {
        ASTNode oldChild = this.expression;
        preReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
        this.expression = expression;
        postReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
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
                        + (this.expression == null ? 0 : getExpression().treeSize());
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
}
