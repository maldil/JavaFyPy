// Copyright (c) Corporation for National Research Initiatives

package org.jpp.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpp.astnodes.ParseException;
import org.jpp.astnodes.Visitor;
import org.jpp.astnodes.ast.Name;
import org.jpp.astnodes.ast.Suite;
import org.jpp.astnodes.ast.Tuple;
import org.jpp.astnodes.ast.arg;
import org.jpp.astnodes.ast.arguments;
import org.jpp.astnodes.ast.expr_contextType;
import org.jpp.astnodes.base.expr;
import org.jpp.astnodes.base.stmt;
import org.jpp.heart.Py;

public class ArgListCompiler extends Visitor
{
    public boolean arglist, keywordlist;
    public List<expr> defaults;
    public List<String> names;
    public Map<String, expr> kw_defaults;
    public int kwonlyargcount;
    public List<String> fpnames;
    public List<stmt> init_code;
    public Map<String, expr> annotations;

    public ArgListCompiler() {
        arglist = keywordlist = false;
        annotations = new HashMap<>();
        defaults = null;
        names = new ArrayList<String>();
        kw_defaults = new HashMap<>();
        fpnames = new ArrayList<String>();
        init_code = new ArrayList<stmt>();
    }

    public void reset() {
        arglist = keywordlist = false;
        annotations.clear();
        defaults = null;
        names.clear();
        kw_defaults.clear();
        init_code.clear();
    }

    public void appendInitCode(Suite node) {
        node.getInternalBody().addAll(0, init_code);
    }

    public List<expr> getDefaults() {
        return defaults;
    }

    public void addAnnotation(String name, expr annotation) {
        if (annotation != null) annotations.put(name, annotation);
    }

    public void visitArgs(arguments args) throws Exception {
        List<arg> argslist = args.getInternalArgs();
        String name;
        for (int i = 0; i < argslist.size(); i++) {
            name = argslist.get(i).getInternalArg();
            names.add(name);
            addAnnotation(name, argslist.get(i).getInternalAnnotation());
        }
        if (args.getInternalVararg() != null) {
            arglist = true;
            name = args.getInternalVararg().getInternalArg();
            if (name == null) {
                name = ""; // empty name for anonymous star var
            }
            names.add(name);
            addAnnotation(name, args.getInternalVararg().getInternalAnnotation());
        }
        kwonlyargcount = args.getInternalKwonlyargs().size();
        List<arg> kwonlyargs = args.getInternalKwonlyargs();
        for (int i = 0; i < kwonlyargcount; i++) {
            name = kwonlyargs.get(i).getInternalArg();
            names.add(name);
            addAnnotation(name, kwonlyargs.get(i).getInternalAnnotation());
        }
        if (args.getInternalKwarg() != null) {
            keywordlist = true;
            name = args.getInternalKwarg().getInternalArg();
            names.add(name);
            addAnnotation(name, args.getInternalKwarg().getInternalAnnotation());
        }

        List<expr> kwdefaults = args.getInternalKw_defaults();
        for (int i = 0; i < kwonlyargcount; i++) {
            expr kwDefault = kwdefaults.get(i);
            if (kwDefault != null) {
                kw_defaults.put(kwonlyargs.get(i).getInternalArg(), kwDefault);
            }
        }

        defaults = new ArrayList<expr>();
        List<expr> internalDefaults = args.getInternalDefaults();
        for (int i = 0; i < internalDefaults.size(); i++) {
            expr val = internalDefaults.get(i);
            if (val == null && ! defaults.isEmpty()) {
                 throw new ParseException(
                    "non-default argument follows default argument",
                    args.getInternalArgs().get(args.getInternalArgs().size() - defaults.size() + i));
            }
            if (val != null) {
                defaults.add(val);
            }
        }
        if (names.size() > 255) {
            throw Py.SyntaxError("more than 255 arguments");
        }
    }

    @Override
    public Object visitName(Name node) throws Exception {
        //FIXME: do we need Store and Param, or just Param?
        if (node.getInternalCtx() != expr_contextType.Store && node.getInternalCtx() != expr_contextType.Param) {
            return null;
        } 

        if (fpnames.contains(node.getInternalId())) {
            throw new ParseException("duplicate argument name found: " +
                                     node.getInternalId(), node);
        }
        fpnames.add(node.getInternalId());
        return node.getInternalId();
    }

    @Override
    public Object visitTuple(Tuple node) throws Exception {
        StringBuffer name = new StringBuffer("(");
        int n = node.getInternalElts().size();
        for (int i = 0; i < n-1; i++) {
            name.append(visit(node.getInternalElts().get(i)));
            name.append(", ");
        }
        name.append(visit(node.getInternalElts().get(n - 1)));
        name.append(")");
        return name.toString();
    }
}
