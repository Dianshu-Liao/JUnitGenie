package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.PredicatedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class list_PredicatedList_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        // Create a PredicatedList instance with a non-null predicate
        PredicatedList<Object> list1 = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);
        PredicatedList<Object> list2 = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);

        // Ensure that the decorated() method returns a different collection
        assertFalse(list1.equals(list2)); // This should return false as they are different instances
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        // Create a PredicatedList instance with a non-null predicate
        PredicatedList<Object> list = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);

        // Test equality with itself
        assertTrue(list.equals(list)); // This should return true as it is the same instance
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        // Create a PredicatedList instance with a non-null predicate
        PredicatedList<Object> list = new PredicatedList<>(new java.util.ArrayList<>(), o -> true);

        // Test equality with null
        assertFalse(list.equals(null)); // This should return false as the object is null
    }


}