package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class bidimap_TreeBidiMap_containsValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsValue_withComparableValue() {
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        bidiMap.put("key1", "value1");
        
        Object valueToCheck = "value1"; // Non-null and comparable
        boolean result = false;
        
        try {
            result = bidiMap.containsValue(valueToCheck);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid comparable value: " + e.getMessage());
        }
        
        assertTrue("The value should be found in the bidi map.", result);
    }

    @Test(timeout = 4000)
    public void testContainsValue_withNonComparableValue() {
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        bidiMap.put("key1", "value1");
        
        Object valueToCheck = new Object(); // Non-comparable value
        boolean result = false;
        
        try {
            result = bidiMap.containsValue(valueToCheck);
        } catch (Exception e) {
            // Handle the exception as expected behavior
            assertTrue("Exception should be thrown for a non-comparable value.", true);
            return; // Exit the test as we expect an exception
        }
        
        fail("An exception should have been thrown for a non-comparable value.");
    }

}