package org.jpp.heart.finalization;

import org.jpp.heart.PyObject;

/**
 * Reserved for use by JyNI.
 */
public interface FinalizeTriggerFactory {

    public FinalizeTrigger makeTrigger(PyObject toFinalize);
}
