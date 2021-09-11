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
package org.eclipse.jdt.internal.compiler.codegen;

public class DoubleCache {
	private double keyTable[];
	private int valueTable[]; 
	private int elementSize;
/**
 * Constructs a new, empty hashtable. A default capacity and
 * load factor is used. Note that the hashtable will automatically 
 * grow when it gets full.
 */
public DoubleCache() {
	this(13);
}
/**
 * Constructs a new, empty hashtable with the specified initial
 * capacity.
 * @param initialCapacity int
 *  the initial number of buckets
 */
public DoubleCache(int initialCapacity) {
	elementSize = 0;
	keyTable = new double[initialCapacity];
	valueTable = new int[initialCapacity];
}
/**
 * Clears the hash table so that it has no more elements in it.
 */
public void clear() {
	for (int i = keyTable.length; --i >= 0;) {
		keyTable[i] = 0.0;
		valueTable[i] = 0;
	}
	elementSize = 0;
}
/** Returns true if the collection contains an element for the key.
 *
 * @param key <CODE>double</CODE> the key that we are looking for
 * @return boolean
 */
public boolean containsKey(double key) {
	if (key == 0.0) {
		for (int i = 0, max = elementSize; i < max; i++) {
			if (keyTable[i] == 0.0) {
				long value1 = Double.doubleToLongBits(key);
				long value2 = Double.doubleToLongBits(keyTable[i]);
				if (value1 == -9223372036854775808L && value2 == -9223372036854775808L)
					return true;
				if (value1 == 0 && value2 == 0)
					return true;
			}
		}
	} else {
		for (int i = 0, max = elementSize; i < max; i++) {
			if (keyTable[i] == key) {
				return true;
			}
		}
	}
	return false;
}
/** Gets the object associated with the specified key in the
 * hashtable.
 * @param key <CODE>double</CODE> the specified key
 * @return int the element for the key or -1 if the key is not
 *  defined in the hash table.
 */
public int get(double key) {
	if (key == 0.0) {
		for (int i = 0, max = elementSize; i < max; i++) {
			if (keyTable[i] == 0.0) {
				long value1 = Double.doubleToLongBits(key);
				long value2 = Double.doubleToLongBits(keyTable[i]);
				if (value1 == -9223372036854775808L && value2 == -9223372036854775808L)
					return valueTable[i];
				if (value1 == 0 && value2 == 0)
					return valueTable[i];
			}
		}
	} else {
		for (int i = 0, max = elementSize; i < max; i++) {
			if (keyTable[i] == key) {
				return valueTable[i];
			}
		}
	}
	return -1;
}
/**
 * Puts the specified element into the hashtable, using the specified
 * key.  The element may be retrieved by doing a get() with the same key.
 * 
 * @param key <CODE>double</CODE> the specified key in the hashtable
 * @param value <CODE>int</CODE> the specified element
 * @return int value
 */
public int put(double key, int value) {
	if (elementSize == keyTable.length) {
		// resize
		System.arraycopy(keyTable, 0, (keyTable = new double[elementSize * 2]), 0, elementSize);
		System.arraycopy(valueTable, 0, (valueTable = new int[elementSize * 2]), 0, elementSize);
	}
	keyTable[elementSize] = key;
	valueTable[elementSize] = value;
	elementSize++;
	return value;
}
/**
 * Converts to a rather lengthy String.
 *
 * @return String the ascii representation of the receiver
 */
public String toString() {
	int max = elementSize;
	StringBuffer buf = new StringBuffer();
	buf.append("{"); //$NON-NLS-1$
	for (int i = 0; i < max; ++i) {
		if ((keyTable[i] != 0) || ((keyTable[i] == 0) &&(valueTable[i] != 0))) {
			buf.append(keyTable[i]).append("->").append(valueTable[i]); //$NON-NLS-1$
		}
		if (i < max) {
			buf.append(", "); //$NON-NLS-1$
		}
	}
	buf.append("}"); //$NON-NLS-1$
	return buf.toString();
}
}
