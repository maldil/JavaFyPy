/*******************************************************************************
 * Copyright (c) 2015, 2016 Google, Inc and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Stefan Xenos (Google) - Initial implementation
 *******************************************************************************/
package org.eclipse.jdt.core.tests.nd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.jdt.core.tests.junit.extension.TestCase;
import org.eclipse.jdt.core.tests.nd.indexer.IndexerTest;

import junit.framework.Test;
import junit.framework.TestSuite;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RunIndexTests extends junit.framework.TestCase {
public RunIndexTests(String name) {
	super(name);
}
public static Class[] getAllTestClasses() {
	return new Class[] {
		BTreeTests.class,
		ChunkWriterTests.class,
		DatabaseTest.class,
		FieldBackPointerTest.class,
		FieldListTest.class,
		FieldOneToOneTest.class,
		IndexerTest.class,
		InheritenceTests.class,
		LargeBlockTest.class,
		SearchKeyTests.class
	};
}
public static Test suite() {
	TestSuite ts = new TestSuite(RunIndexTests.class.getName());

	Class[] testClasses = getAllTestClasses();
	// Reset forgotten subsets of tests
	TestCase.TESTS_PREFIX = null;
	TestCase.TESTS_NAMES = null;
	TestCase.TESTS_NUMBERS = null;
	TestCase.TESTS_RANGE = null;
	TestCase.RUN_ONLY_ID = null;

	for (int i = 0; i < testClasses.length; i++) {
		Class testClass = testClasses[i];

		// call the suite() method and add the resulting suite to the suite
		try {
			Method suiteMethod = testClass.getDeclaredMethod("suite", new Class[0]); //$NON-NLS-1$
			Test suite = (Test)suiteMethod.invoke(null, new Object[0]);
			ts.addTest(suite);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	return ts;
}
}
