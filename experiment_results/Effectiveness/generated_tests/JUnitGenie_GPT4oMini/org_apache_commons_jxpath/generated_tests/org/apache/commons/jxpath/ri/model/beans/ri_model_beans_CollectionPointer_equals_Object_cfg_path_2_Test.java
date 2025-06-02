package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_beans_CollectionPointer_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
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
    public void testEquals_SameValues() {
        Object collection = new Object();
        CollectionPointer pointer1 = new CollectionPointer(collection, null);
        CollectionPointer pointer2 = new CollectionPointer(collection, null);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCollections() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), null);
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentIndexes() {
        Object collection = new Object();
        CollectionPointer pointer1 = new CollectionPointer(collection, null);
        CollectionPointer pointer2 = new CollectionPointer(collection, null);
        
        // Assuming there is a method to set the index, we will use a hypothetical setter method
        pointer1.setIndex(0); // Hypothetical setter method
        pointer2.setIndex(1); // Hypothetical setter method
        
        assertFalse(pointer1.equals(pointer2));
    }


}