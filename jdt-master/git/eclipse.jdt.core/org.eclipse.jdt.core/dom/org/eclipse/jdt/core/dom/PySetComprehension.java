package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PySetComprehension extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    PySetComprehension(AST ast) {
        super(ast);
    }

    public static final ChildPropertyDescriptor CONDITIONAL_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PySetComprehension.class, "conditionalExpression", Expression.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildPropertyDescriptor ITERATOR_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PySetComprehension.class, "iteratorExpression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildListPropertyDescriptor VALUE_EXPRESSION_PROPERTY =
            new ChildListPropertyDescriptor(PySetComprehension.class, "parameters", SingleVariableDeclaration.class, CYCLE_RISK);

    public static final ChildPropertyDescriptor TARGET_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PySetComprehension.class, "targetExpression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    private Expression conditionalExpression = null;
    private Expression iteratorExpression = null;
    private ASTNode.NodeList valueExpression = new ASTNode.NodeList(VALUE_EXPRESSION_PROPERTY);
    private Expression targetExpression = null;
    private static final List PROPERTY_DESCRIPTORS;

    static {
        List properyList = new ArrayList(5);
        createPropertyList(PySetComprehension.class, properyList);
        addProperty(CONDITIONAL_EXPRESSION_PROPERTY, properyList);
        addProperty(ITERATOR_EXPRESSION_PROPERTY, properyList);
        addProperty(VALUE_EXPRESSION_PROPERTY, properyList);
        addProperty(TARGET_EXPRESSION_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == CONDITIONAL_EXPRESSION_PROPERTY) {
            if (get) {
                return getConditionalExpression();
            } else {
                setConditionalExpression((Expression) child);
                return null;
            }
        }
        if (property == ITERATOR_EXPRESSION_PROPERTY) {
            if (get) {
                return getIteratorExpression();
            } else {
                setIteratorExpression((Expression) child);
                return null;
            }
        }

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

    public Expression getConditionalExpression() {

        if (this.conditionalExpression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.conditionalExpression == null) {
                    preLazyInit();
                    this.conditionalExpression = new SimpleName(this.ast);
                    postLazyInit(this.conditionalExpression, CONDITIONAL_EXPRESSION_PROPERTY);
                }
            }
        }

        return conditionalExpression;
    }

    public Expression internalGetConditionalExpression(){
        return conditionalExpression;
    }

    public Expression getIteratorExpression() {
        if (this.iteratorExpression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.iteratorExpression == null) {
                    preLazyInit();
                    this.iteratorExpression = new SimpleName(this.ast);
                    postLazyInit(this.iteratorExpression, ITERATOR_EXPRESSION_PROPERTY);
                }
            }
        }
        return iteratorExpression;
    }

    public NodeList getValueExpression() {
        return this.valueExpression;
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

    public void setConditionalExpression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.conditionalExpression;
        preReplaceChild(oldChild, expression, CONDITIONAL_EXPRESSION_PROPERTY);
        this.conditionalExpression = expression;
        postReplaceChild(oldChild, expression, CONDITIONAL_EXPRESSION_PROPERTY);
    }

    public void setIteratorExpression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.iteratorExpression;
        preReplaceChild(oldChild, expression, ITERATOR_EXPRESSION_PROPERTY);
        this.iteratorExpression = expression;
        postReplaceChild(oldChild, expression, ITERATOR_EXPRESSION_PROPERTY);

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
        return PY_SET_COMPREHENSION_EXPRESSION;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    ASTNode clone0(AST target) {
        PySetComprehension pyGenerator = new PySetComprehension(target);
        pyGenerator.setSourceRange(getStartPosition(), getLength());
        if (internalGetConditionalExpression()!=null){
            pyGenerator.setConditionalExpression((Expression) internalGetConditionalExpression().clone(target));
        }
        pyGenerator.setTargetExpression(
                (Expression) getTargetExpression().clone(target));
        for (Object o : valueExpression) {
            pyGenerator.valueExpression.add(
                    ((SingleVariableDeclaration) o).clone(target));
        }
        pyGenerator.setIteratorExpression(
                (Expression) getIteratorExpression().clone(target));
        return pyGenerator;
    }

    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order
            if ( internalGetConditionalExpression()!=null){
                acceptChild(visitor, internalGetConditionalExpression());
            }
            acceptChild(visitor, getIteratorExpression());
            for (Object o : valueExpression) {
                acceptChild(visitor, (ASTNode) o);
            }
            acceptChild(visitor, getTargetExpression());
        }
        visitor.endVisit(this);
    }

    int treeSize() {
        return
                memSize()
                        + (this.conditionalExpression == null ? 0 : getConditionalExpression().treeSize())
                        + (this.iteratorExpression == null ? 0 : getIteratorExpression().treeSize())
                        + (this.valueExpression == null ? 0 : valueExpression.listSize())
                        + (this.targetExpression == null ? 0 : getTargetExpression().treeSize());
    }

    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }
}
