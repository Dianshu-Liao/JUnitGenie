package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.MapIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Populate the MultiKeyMap with some data
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value3");

        // Call the removeAll method with keys that exist in the map
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2", "key3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert that the map was modified
        assertTrue(modified);
        // Assert that the keys have been removed
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test(timeout = 4000)
    public void testRemoveAllNoMatch() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Populate the MultiKeyMap with some data
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");

        // Call the removeAll method with keys that do not exist in the map
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2", "key3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert that the map was not modified
        assertFalse(modified);
    }

    @Test(timeout = 4000)
    public void testRemoveAllWithLessThanThreeKeys() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Populate the MultiKeyMap with some data
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");

        // Call the removeAll method with keys that exist in the map
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2", "key3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert that the map was not modified
        assertFalse(modified);
    }

}