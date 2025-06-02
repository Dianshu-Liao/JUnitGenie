package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class set_ListOrderedSet_add_int_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddWhenObjectNotContained() {
        ListOrderedSet<Object> set = new ListOrderedSet<>();
        int index = 0;
        Object object = new Object();

        // Ensure the object is not contained before adding
        assertTrue(!set.contains(object));

        // Call the focal method
        set.add(index, object);

        // Verify that the object has been added
        assertTrue(set.contains(object));
    }

}