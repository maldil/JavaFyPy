package org.eclipse.jdt.core.dom;

import org.eclipse.jdt.internal.compiler.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class PyTupleExpression extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildListPropertyDescriptor EXPRESSIONS_PROPERTY =
            new ChildListPropertyDescriptor(PyTupleExpression.class, "expressions", Expression.class, CYCLE_RISK);
    private static final List PROPERTY_DESCRIPTORS;

    private Expression.NodeList expressions =
            new Expression.NodeList(EXPRESSIONS_PROPERTY);

    static {
        List properyList = new ArrayList(1);
        createPropertyList(PyTupleExpression.class, properyList);

        addProperty(EXPRESSIONS_PROPERTY,properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    PyTupleExpression(AST ast) {
        super(ast);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    int getNodeType0() {
        return TUPLE_EXPRESSION;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    ASTNode clone0(AST target) {
        PyTupleExpression result = new PyTupleExpression(target);
        result.setSourceRange(getStartPosition(), getLength());
        result.expressions().addAll(
                ASTNode.copySubtrees(target, expressions()));
        return result;
    }

    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            acceptChildren(visitor, this.expressions);
        }
        visitor.endVisit(this);
    }

    public List expressions() {
        return this.expressions;
    }
    int treeSize() {
        return memSize() + this.expressions.listSize();
    }

    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }


}
