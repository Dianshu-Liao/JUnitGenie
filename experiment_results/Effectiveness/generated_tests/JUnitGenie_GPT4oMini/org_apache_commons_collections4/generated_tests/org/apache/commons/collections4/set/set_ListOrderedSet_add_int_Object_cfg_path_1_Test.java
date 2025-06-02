package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class set_ListOrderedSet_add_int_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddMethod() {
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();

        // Define the parameters
        int index = 0;
        String object = "testObject";

        // Ensure object is not contained before addition
        assertFalse(listOrderedSet.contains(object));

        // Add the object at the specified index
        try {
            listOrderedSet.add(index, object);
        } catch (Exception e) {
            fail("An exception should not have been thrown: " + e.getMessage());
        }

        // Verify that the object is added
        assertTrue(listOrderedSet.contains(object));
        
        // Since setOrder is private, we cannot access it directly. 
        // Instead, we can check the size and the contents of the ListOrderedSet.
        assertEquals(1, listOrderedSet.size()); // Check that the size is 1
        assertTrue(listOrderedSet.contains(object)); // Check that the object is present
    }


}