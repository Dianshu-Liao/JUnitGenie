package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.junit.Test;
import java.util.function.Predicate;
import static org.junit.Assert.assertFalse;

public class set_ListOrderedSet_removeIf_Predicate_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveIfWithNullFilter() {
        ListOrderedSet<String> set = new ListOrderedSet<>();
        set.add("test");
        
        // Testing with a null filter
        boolean result = set.removeIf(null);
        
        // Asserting that the result is false when filter is null
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveIfWithNonMatchingFilter() {
        ListOrderedSet<String> set = new ListOrderedSet<>();
        set.add("test");
        
        // Testing with a filter that does not match any elements
        Predicate<String> filter = s -> s.equals("nonexistent");
        boolean result = set.removeIf(filter);
        
        // Asserting that the result is false when no elements are removed
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveIfWithMatchingFilter() {
        ListOrderedSet<String> set = new ListOrderedSet<>();
        set.add("test");
        
        // Testing with a filter that matches the element
        Predicate<String> filter = s -> s.equals("test");
        boolean result = set.removeIf(filter);
        
        // Asserting that the result is true when an element is removed
        assertFalse(set.contains("test"));
        assertFalse(result);
    }

}