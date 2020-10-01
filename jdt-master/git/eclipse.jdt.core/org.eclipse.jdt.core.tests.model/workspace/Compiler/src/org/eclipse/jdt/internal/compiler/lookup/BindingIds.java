/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.compiler.lookup;

public interface BindingIds {
	final int FIELD = 1;
	final int LOCAL = 2;
	final int VARIABLE = FIELD | LOCAL;
	final int TYPE = 4;
	final int METHOD = 8;
	final int PACKAGE = 16;
	final int IMPORT = 32;
}
