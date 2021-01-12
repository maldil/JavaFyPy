package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class EnhancedForStatementWithElse extends Statement{
    /**
     * The "parameter" structural property of this node type (child type: {@link SingleVariableDeclaration}).
     */
    public static final ChildPropertyDescriptor PARAMETER_PROPERTY =
            new ChildPropertyDescriptor(EnhancedForStatementWithElse.class, "parameter", SingleVariableDeclaration.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildListPropertyDescriptor PARAMETERS_PROPERTY =
            new ChildListPropertyDescriptor(EnhancedForStatementWithElse.class, "parameters", SingleVariableDeclaration.class, CYCLE_RISK);


    /**
     * The "expression" structural property of this node type (child type: {@link Expression}).
     */
    public static final ChildPropertyDescriptor EXPRESSION_PROPERTY =
            new ChildPropertyDescriptor(EnhancedForStatementWithElse.class, "expression", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    /**
     * The "body" structural property of this node type (child type: {@link Statement}).
     */
    public static final ChildPropertyDescriptor BODY_PROPERTY =
            new ChildPropertyDescriptor(EnhancedForStatementWithElse.class, "body", Statement.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildPropertyDescriptor ELSE_BODY_PROPERTY =
            new ChildPropertyDescriptor(EnhancedForStatementWithElse.class, "elsebody", Statement.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$
    /**
     * A list of property descriptors (element type:
     * {@link StructuralPropertyDescriptor}),
     * or null if uninitialized.
     */

    private static final List PROPERTY_DESCRIPTORS;

    static {
        List properyList = new ArrayList(5);
        createPropertyList(EnhancedForStatementWithElse.class, properyList);
        addProperty(PARAMETER_PROPERTY, properyList);
        addProperty(EXPRESSION_PROPERTY, properyList);
        addProperty(BODY_PROPERTY, properyList);
        addProperty(PARAMETERS_PROPERTY,properyList);
        addProperty(ELSE_BODY_PROPERTY,properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
    }

    /**
     * Returns a list of structural property descriptors for this node type.
     * Clients must not modify the result.
     *
     * @param apiLevel the API level; one of the
     * <code>AST.JLS*</code> constants

     * @return a list of property descriptors (element type:
     * {@link StructuralPropertyDescriptor})
     */
    public static List propertyDescriptors(int apiLevel) {
        return PROPERTY_DESCRIPTORS;
    }

    /**
     * The parameter; lazily initialized; defaults to a unspecified,
     * legal node.
     */
    private SingleVariableDeclaration parameter = null;

    private ASTNode.NodeList parameters =
            new ASTNode.NodeList(PARAMETERS_PROPERTY);

    private Expression expression = null;

    /**
     * The body statement; lazily initialized; defaults to an empty block
     * statement.
     */
    private Statement body = null;

    private Statement elseBody = null;


    EnhancedForStatementWithElse(AST ast) {
        super(ast);
    }

    @Override
    final List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == PARAMETER_PROPERTY) {
            if (get) {
                return getParameter();
            } else {
                setParameter((SingleVariableDeclaration) child);
                return null;
            }
        }
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

        if (property == ELSE_BODY_PROPERTY) {
            if (get) {
                return getElseBody();
            } else {
                setElseBody((Statement) child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }

    @Override
    final int getNodeType0() {
        return ENHANCED_FOR_STATEMENT_WITH_ELSE;
    }

    @Override
    ASTNode clone0(AST target) {
        EnhancedForStatementWithElse result = new EnhancedForStatementWithElse(target);
        result.setSourceRange(getStartPosition(), getLength());
        for (Object o : this.parameters) {
            result.parameters.add(((ASTNode)o).clone(target));
        }
        result.copyLeadingComment(this);
        result.setParameter((SingleVariableDeclaration) getParameter().clone(target));
        result.setExpression((Expression) getExpression().clone(target));
        result.setBody(
                (Statement) ASTNode.copySubtree(target, getBody()));
        if (this.elseBody!=null){
            result.setElseBody(
                    (Statement) ASTNode.copySubtree(target, getElseBody()));
        }
        return result;
    }

    @Override
    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order

            acceptChild(visitor,getParameter());
            for (Object o : parameters) {
                acceptChild(visitor, (SingleVariableDeclaration)o);
            }

            acceptChild(visitor, getExpression());
            acceptChild(visitor, getBody());
            if (this.elseBody!=null){
                acceptChild(visitor,getElseBody());
            }
        }
        visitor.endVisit(this);
    }


    @Override
    final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        // dispatch to correct overloaded match method
        return matcher.match(this, other);
    }

    public SingleVariableDeclaration getParameter() {
        if (this.parameter == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.parameter == null) {
                    preLazyInit();
                    this.parameter = this.ast.newSingleVariableDeclaration();
                    postLazyInit(this.parameter, PARAMETER_PROPERTY);
                }
            }
        }
        return this.parameter;
    }

    public void setParameter(SingleVariableDeclaration parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.parameter;
        preReplaceChild(oldChild, parameter, PARAMETER_PROPERTY);
        this.parameter = parameter;
        postReplaceChild(oldChild, parameter, PARAMETER_PROPERTY);
    }

    public void setParameters(ArrayList<SingleVariableDeclaration> elementVariables) {
        if (elementVariables == null) {
            throw new IllegalArgumentException();
        }
        this.parameters.addAll(elementVariables);
    }

    public ASTNode.NodeList Parameters() {
        return parameters;
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

    public Statement getElseBody() {
//		if (this.elseBody == null) {
//			// lazy init must be thread-safe for readers
//			synchronized (this) {
//				if (this.elseBody == null) {
//					preLazyInit();
//					this.elseBody = new Block(this.ast);
//					postLazyInit(this.elseBody, ELSE_BODY_PROPERTY);
//				}
//			}
//		}
        return this.elseBody;
    }

    public void setElseBody(Statement statement) {
        if (statement == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.elseBody;
        preReplaceChild(oldChild, statement, ELSE_BODY_PROPERTY);
        this.elseBody = statement;
        postReplaceChild(oldChild, statement, ELSE_BODY_PROPERTY);
    }

    @Override
    int memSize() {
        return super.memSize() + 3 * 4;
    }

    @Override
    int treeSize() {
        return
                memSize() + (this.parameter == null ? 0 : parameter.treeSize())
                        + (this.parameters == null ? 0 : parameters.listSize())
                        + (this.expression == null ? 0 : getExpression().treeSize())
                        + (this.body == null ? 0 : getBody().treeSize());
    }
}
