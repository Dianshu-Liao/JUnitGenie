package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_beans_CollectionPointer_equals_Object_cfg_path_4_Test {

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
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null);
        setPointerFields(pointer1, 0, new Object()); // Use a new Object for collection
        setPointerFields(pointer2, 0, new Object()); // Use a new Object for collection
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualPointers() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), null);
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null);
        setPointerFields(pointer1, 0, new Object()); // Use a new Object for collection
        setPointerFields(pointer2, 1, new Object()); // Different index
        assertFalse(pointer1.equals(pointer2));
    }

    // Helper method to set the index and collection fields
    private void setPointerFields(CollectionPointer pointer, int index, Object collection) {
        // Assuming we have access to modify these fields through reflection or a setter method
        try {
            java.lang.reflect.Field indexField = CollectionPointer.class.getDeclaredField("index");
            indexField.setAccessible(true);
            indexField.set(pointer, index);

            java.lang.reflect.Field collectionField = CollectionPointer.class.getDeclaredField("collection");
            collectionField.setAccessible(true);
            collectionField.set(pointer, collection);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}