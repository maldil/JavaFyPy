package org.jpp.astnodes.adapter;

import org.jpp.heart.PyObject;

import java.util.List;
/**
 * AstAdapters turn Objects into Ast nodes.
 */
public interface AstAdapter {

	PyObject ast2py(Object o);
	Object py2ast(PyObject o);
	List iter2ast(PyObject o);

}
