/*******************************************************************************
 * Copyright (c) 2015 Google, Inc. and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     het@google.com - initial API and implementation
 *******************************************************************************/
package targets.AnnotationProcessorTests.Bug456986;

import gen.anno.Annos.GenAnno;

@Bug456986
public class B {
	public void foo(@GenAnno int x) {
		return;
	}
}
