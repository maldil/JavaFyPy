// Copyright (c) Corporation for National Research Initiatives
package org.jpp.heart;

/**
 * Interface implemented by compiled org.jpp.modules which allow access to
 * to the module code object.
 */

public interface PyRunnable {
    /**
     * Return the org.jpp.modules code object.
     */
    abstract public PyCode getMain();
}
