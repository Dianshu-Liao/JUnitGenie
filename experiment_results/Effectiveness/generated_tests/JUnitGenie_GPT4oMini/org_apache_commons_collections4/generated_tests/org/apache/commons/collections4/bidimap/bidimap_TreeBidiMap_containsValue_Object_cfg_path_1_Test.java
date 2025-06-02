package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class bidimap_TreeBidiMap_containsValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsValue_withValidComparableValue() {
        TreeBidiMap<String, Integer> bidiMap = new TreeBidiMap<>();
        bidiMap.put("one", 1);
        bidiMap.put("two", 2);
        
        // Valid comparable value
        String value = "one";
        boolean result = false;
        try {
            result = bidiMap.containsValue(value);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsValue_withNullValue() {
        TreeBidiMap<String, Integer> bidiMap = new TreeBidiMap<>();
        bidiMap.put("one", 1);
        
        // Null value should throw an exception
        Object value = null;
        try {
            boolean result = bidiMap.containsValue(value);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testContainsValue_withNonComparableValue() {
        TreeBidiMap<String, Integer> bidiMap = new TreeBidiMap<>();
        bidiMap.put("one", 1);
        
        // Non-comparable value
        Object value = new Object();
        try {
            boolean result = bidiMap.containsValue(value);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }

}