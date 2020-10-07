package org.eclipse.jdt.core.dom;
import java.util.ArrayList;
import java.util.List;

public class PyWithStatement extends Statement{
    /**
     * Creates a new AST node for a statement owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildPropertyDescriptor EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(PyWithStatement.class, "expression", Expression.class, MANDATORY, CYCLE_RISK);
    public static final ChildPropertyDescriptor BODY_PROPERTY =
            new ChildPropertyDescriptor(PyWithStatement.class, "body", Statement.class, MANDATORY, CYCLE_RISK);

    private static final List PROPERTY_DESCRIPTORS;

    static {
        List propertyList = new ArrayList(3);
        createPropertyList(PyWithStatement.class, propertyList);
        addProperty(EXPRESSION_PROPERTY, propertyList);
        addProperty(BODY_PROPERTY, propertyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
    }

    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }
    private Expression expression = null;
    private Statement body = null;

    PyWithStatement(AST ast) {
        super(ast);
    }
    @Override
    List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    @Override
    int getNodeType0() {
        return PY_WITH_STATEMENT;
    }

    @Override
    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return false;
    }

    @Override
    ASTNode clone0(AST target) {
        PyWithStatement result = new PyWithStatement(target);
        result.setSourceRange(getStartPosition(), getLength());
        result.copyLeadingComment(this);
        result.setExpression((Expression) getExpression().clone(target));
        result.setBody((Statement) getBody().clone(target));
        return result;
    }

    @Override
    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order
            acceptChild(visitor, getExpression());
            acceptChild(visitor, getBody());
        }
        visitor.endVisit(this);
    }

    @Override
    int treeSize() {
        return
                memSize()
                        + (this.expression == null ? 0 : getExpression().treeSize())
                        + (this.body == null ? 0 : getBody().treeSize());
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
        if (property == BODY_PROPERTY) {
            if (get) {
                return getBody();
            } else {
                setBody((Statement) child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }

    public void setExpression(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.expression;
        preReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
        this.expression = expression;
        postReplaceChild(oldChild, expression, EXPRESSION_PROPERTY);
    }

    public Statement getBody() {
        if (this.body == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.body == null) {
                    preLazyInit();
                    this.body = new Block(this.ast);
                    postLazyInit(this.body, BODY_PROPERTY);
                }
            }
        }
        return this.body;
    }

    public void setBody(Statement statement) {
        if (statement == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.body;
        preReplaceChild(oldChild, statement, BODY_PROPERTY);
        this.body = statement;
        postReplaceChild(oldChild, statement, BODY_PROPERTY);
    }

    public Expression getExpression() {
        if (this.expression == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.expression == null) {
                    preLazyInit();
                    this.expression = new SimpleName(this.ast);
                    postLazyInit(this.expression, EXPRESSION_PROPERTY);
                }
            }
        }
        return this.expression;
    }

    @Override
    int memSize() {
        return super.memSize() + 2 * 4;
    }



}
