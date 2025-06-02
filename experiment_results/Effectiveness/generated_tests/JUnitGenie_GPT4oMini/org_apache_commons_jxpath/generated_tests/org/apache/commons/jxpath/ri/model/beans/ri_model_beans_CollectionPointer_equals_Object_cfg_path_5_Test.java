package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_model_beans_CollectionPointer_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CollectionPointer pointer = new CollectionPointer(new Object(), null);
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        CollectionPointer pointer = new CollectionPointer(new Object(), null);
        String differentTypeObject = "Not a CollectionPointer";
        assertFalse(pointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualPointers() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), null);
        // Assuming CollectionPointer has a method to get its internal state for comparison
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null); // Create a new instance for comparison
        assertFalse(pointer1.equals(pointer2)); // Assuming different internal states
    }

}