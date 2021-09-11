package org.jpp.heart;

public interface Slotted {

    public PyObject getSlot(int index);

    public void setSlot(int index, PyObject value);
}
