/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package java.lang;

import java.io.InputStream;

public class Class<T> {
	public String getName() {
		return null;
	}
	public InputStream getResourceAsStream(String s) {
		return null;
	}
	
    public native Class<? super T> getSuperclass();
    
    public T newInstance() throws InstantiationException, IllegalAccessException {
    	return null;
    }
    
    public static Class<?> forName(String className) throws ClassNotFoundException {
    	return null;
    }
}
