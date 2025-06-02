package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class bidimap_TreeBidiMap_previousKey_Comparable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousKey() {
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        // Populate the bidiMap with some values
        bidiMap.put("key1", "value1");
        bidiMap.put("key2", "value2");
        bidiMap.put("key3", "value3");

        String key = "key2"; // This key is not null and is comparable
        try {
            String result = bidiMap.previousKey(key);
            assertEquals("key1", result); // Expecting the previous key to be "key1"
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPreviousKeyWithNull() {
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        try {
            bidiMap.previousKey(null); // This should throw an exception
            fail("Expected an exception to be thrown for null key");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPreviousKeyWithNonComparable() {
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        try {
            bidiMap.previousKey("nonComparableKey"); // This should throw an exception
            fail("Expected an exception to be thrown for non-comparable key");
        } catch (Exception e) {
            // Expected exception
        }
    }

}