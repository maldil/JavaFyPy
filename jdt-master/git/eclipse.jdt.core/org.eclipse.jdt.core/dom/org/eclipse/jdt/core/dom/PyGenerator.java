package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PyGenerator extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildListPropertyDescriptor COMPARATOR= new ChildListPropertyDescriptor(PyGenerator.class, "parameters", PyComparator.class, CYCLE_RISK);


    public static final ChildPropertyDescriptor TARGET_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyGenerator.class, "targetExpression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$



    private Expression targetExpression = null;
    private ASTNode.NodeList comparator = new ASTNode.NodeList(COMPARATOR);

    PyGenerator(AST ast) {
        super(ast);
    }


    private static final List PROPERTY_DESCRIPTORS;

    static {
        List properyList = new ArrayList(2);
        createPropertyList(PyGenerator.class, properyList);
        addProperty(COMPARATOR, properyList);
        addProperty(TARGET_EXPRESSION_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }
    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
//        if (property == VALUE_EXPRESSION_PROPERTY) {
//            if (get) {
//                return getValueExpression();
//            } else {
//                setValueExpression((Expression) child);
//                return null;
//            }
//        }
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

    public NodeList getComparators() {
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
    @Override
    int getNodeType0() {
        return PY_GENERATOR_EXPRESSION;
    }
    @Override
    ASTNode clone0(AST target) {
        PyGenerator pyGenerator = new PyGenerator(target);
        pyGenerator.setSourceRange(getStartPosition(), getLength());

        for (Object o : comparator) {
            pyGenerator.comparator.add(
                    ((PyComparator) o).clone(target));
        }

        return pyGenerator;
    }
    @Override
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
    @Override
    final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        // dispatch to correct overloaded match method
        return matcher.match(this, other);
    }
    @Override
    int treeSize() {
        return
                memSize()
                        + (this.comparator == null ? 0 : comparator.listSize())
                        + (this.targetExpression == null ? 0 : getTargetExpression().treeSize());
    }
    @Override
    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }



}
