package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class PyDictComprehension  extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    PyDictComprehension(AST ast) {
        super(ast);
    }

    public static final ChildListPropertyDescriptor COMPARATOR= new ChildListPropertyDescriptor(PyDictComprehension.class, "comparator", PyComparator.class, CYCLE_RISK);


    public static final ChildPropertyDescriptor TARGET1_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyDictComprehension.class, "target1Expression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildPropertyDescriptor TARGET2_EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyDictComprehension.class, "target2Expression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

//    private Expression conditionalExpression = null;
//    private Expression iteratorExpression = null;
    // private Expression valueExpression = null;
    private ASTNode.NodeList comparator = new ASTNode.NodeList(COMPARATOR);
    private Expression target1Expression = null;
    private Expression target2Expression = null;

    private static final List PROPERTY_DESCRIPTORS;

    static {
        List properyList = new ArrayList(6);
        createPropertyList(PyDictComprehension.class, properyList);
//        addProperty(CONDITIONAL_EXPRESSION_PROPERTY, properyList);
//        addProperty(ITERATOR_EXPRESSION_PROPERTY, properyList);
        addProperty(COMPARATOR, properyList);
        addProperty(TARGET1_EXPRESSION_PROPERTY, properyList);
        addProperty(TARGET2_EXPRESSION_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
//        if (property == CONDITIONAL_EXPRESSION_PROPERTY) {
//            if (get) {
//                return getConditionalExpression();
//            } else {
//                setConditionalExpression((Expression) child);
//                return null;
//            }
//        }
//        if (property == ITERATOR_EXPRESSION_PROPERTY) {
//            if (get) {
//                return getIteratorExpression();
//            } else {
//                setIteratorExpression((Expression) child);
//                return null;
//            }
//        }
//        if (property == VALUE_EXPRESSION_PROPERTY) {
//            if (get) {
//                return getValueExpression();
//            } else {
//                setValueExpression((Expression) child);
//                return null;
//            }
//        }
        if (property == TARGET1_EXPRESSION_PROPERTY) {
            if (get) {
                return getTarget1Expression();
            } else {
                setTarget1Expression((Expression) child);
                return null;
            }
        }

        if (property == TARGET2_EXPRESSION_PROPERTY) {
            if (get) {
                return getTarget2Expression();
            } else {
                setTarget2Expression((Expression) child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }

    public NodeList getComparator(){return comparator;};

    public Expression getTarget1Expression() {
        if (this.target1Expression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.target1Expression == null) {
                    preLazyInit();
                    this.target1Expression = new SimpleName(this.ast);
                    postLazyInit(this.target1Expression, TARGET1_EXPRESSION_PROPERTY);
                }
            }
        }
        return target1Expression;
    }

    public Expression getTarget2Expression() {
        if (this.target2Expression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.target2Expression == null) {
                    preLazyInit();
                    this.target2Expression = new SimpleName(this.ast);
                    postLazyInit(this.target2Expression, TARGET2_EXPRESSION_PROPERTY);
                }
            }
        }
        return target2Expression;
    }

    public void setTarget1Expression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.target1Expression;
        preReplaceChild(oldChild, expression, TARGET1_EXPRESSION_PROPERTY);
        this.target1Expression = expression;
        postReplaceChild(oldChild, expression, TARGET1_EXPRESSION_PROPERTY);
    }

    public void setTarget2Expression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.target2Expression;
        preReplaceChild(oldChild, expression, TARGET2_EXPRESSION_PROPERTY);
        this.target2Expression = expression;
        postReplaceChild(oldChild, expression, TARGET2_EXPRESSION_PROPERTY);
    }

    @Override
    List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    @Override
    int getNodeType0() {
        return PY_DICT_COMPREHENSION_EXPRESSION;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    ASTNode clone0(AST target) {
        PyDictComprehension pyDictComp = new PyDictComprehension(target);
        pyDictComp.setSourceRange(getStartPosition(), getLength());

        for (Object o : comparator) {
            pyDictComp.comparator.add(
                    ((PyComparator) o).clone(target));
        }
        pyDictComp.setTarget1Expression(
                (Expression) getTarget1Expression().clone(target));
        pyDictComp.setTarget2Expression(
                (Expression) getTarget2Expression().clone(target));
        return pyDictComp;
    }

    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order

            for (Object o : comparator) {
                acceptChild(visitor, (ASTNode) o);
            }
            acceptChild(visitor, getTarget1Expression());
            acceptChild(visitor, getTarget2Expression());
        }
        visitor.endVisit(this);
    }

    int treeSize() {
        return
                memSize()
                        + (this.comparator == null ? 0 : comparator.listSize())
                        + (this.target1Expression == null ? 0 : getTarget1Expression().treeSize())
                        +(this.target2Expression == null ? 0 : getTarget2Expression().treeSize());
    }

    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }
}
