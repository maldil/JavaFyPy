package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PyListComprehension extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildListPropertyDescriptor COMPARATOR= new ChildListPropertyDescriptor(PyListComprehension.class, "parameters", PyComparator.class, CYCLE_RISK);

    public static final ChildPropertyDescriptor TARGET_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyListComprehension.class, "targetExpression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$


    private ASTNode.NodeList comparator = new ASTNode.NodeList(COMPARATOR);
    private Expression targetExpression = null;
    private static final List PROPERTY_DESCRIPTORS;

    static {
        List properyList = new ArrayList(5);
        createPropertyList(PyListComprehension.class, properyList);
        addProperty(COMPARATOR, properyList);
        addProperty(TARGET_EXPRESSION_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    PyListComprehension(AST ast) {
        super(ast);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == TARGET_EXPRESSION_PROPERTY) {
            if (get) {
                return getTargetExpression();
            } else {
                setTargetExpression((Expression) child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }


    public NodeList getComparator() {
        return this.comparator;
    }

    public Expression getTargetExpression() {
        if (this.targetExpression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.targetExpression == null) {
                    preLazyInit();
                    this.targetExpression = new SimpleName(this.ast);
                    postLazyInit(this.targetExpression, TARGET_EXPRESSION_PROPERTY);
                }
            }
        }
        return targetExpression;
    }

    public void setTargetExpression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.targetExpression;
        preReplaceChild(oldChild, expression, TARGET_EXPRESSION_PROPERTY);
        this.targetExpression = expression;
        postReplaceChild(oldChild, expression, TARGET_EXPRESSION_PROPERTY);
    }

    @Override
    List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    int getNodeType0() {
        return PY_LIST_COMPREHENSION_EXPRESSION;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    ASTNode clone0(AST target) {
        PyListComprehension pyGenerator = new PyListComprehension(target);
        pyGenerator.setSourceRange(getStartPosition(), getLength());

        pyGenerator.setTargetExpression(
                (Expression) getTargetExpression().clone(target));
        for (Object o : comparator) {
            pyGenerator.comparator.add(
                    ((PyComparator) o).clone(target));
        }
        return pyGenerator;
    }

    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order

            for (Object o : comparator) {
                acceptChild(visitor, (ASTNode) o);
            }
            acceptChild(visitor, getTargetExpression());
        }
        visitor.endVisit(this);
    }

    int treeSize() {
        return
                memSize()
                        + (this.comparator == null ? 0 : comparator.listSize())
                        + (this.targetExpression == null ? 0 : getTargetExpression().treeSize());
    }

    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }
}
