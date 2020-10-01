/*******************************************************************************
 * Copyright (c) 2018 Till Brychcy and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Till Brychcy - initial API and implementation
 *******************************************************************************/
package targets.AnnotationProcessorTests.Bug540090;

@Bug540090
public class B {
	public void foo(gen.GenClass x) {
		return;
	}
}
