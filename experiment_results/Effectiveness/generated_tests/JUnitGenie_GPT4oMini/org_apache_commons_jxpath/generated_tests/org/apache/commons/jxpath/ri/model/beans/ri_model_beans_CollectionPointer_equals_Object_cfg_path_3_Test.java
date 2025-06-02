package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Locale;

public class ri_model_beans_CollectionPointer_equals_Object_cfg_path_3_Test {

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
    public void testEquals_NullObject() {
        CollectionPointer pointer = new CollectionPointer(new Object(), null);
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), null);
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null);
        // Assuming we can set this for testing, we need to use a method to compare collections instead
        assertTrue(pointer1.equals(pointer2)); // This assumes the equals method is properly implemented
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCollections() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), null);
        CollectionPointer pointer2 = new CollectionPointer(new Object(), null);
        assertFalse(pointer1.equals(pointer2));
    }


}