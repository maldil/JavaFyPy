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
package org.eclipse.jdt.internal.compiler.impl;

public class CharConstant extends Constant {

	char value;

	public CharConstant(char value) {
		this.value = value;
	}
	public byte byteValue() {
		return (byte) value;
	}
	public char charValue() {
		return this.value;
	}
	public double doubleValue() {
		return value; // implicit cast to return type
	}
	public float floatValue() {
		return value; // implicit cast to return type
	}
	public int intValue() {
		return value; // implicit cast to return type
	}
	public long longValue() {
		return value; // implicit cast to return type
	}
	public short shortValue() {
		return (short) value;
	}
	public String stringValue() {
		//spec 15.17.11
		
		String s = new Character(value).toString() ;
		if (s == null) return "null"; //$NON-NLS-1$
		return s;
	}
	public String toString(){
	
		return "(char)" + value; //$NON-NLS-1$
	}
	public int typeID() {
		return T_char;
	}
}
