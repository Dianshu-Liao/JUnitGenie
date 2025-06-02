package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Add a MultiKey to the map
        MultiKey<String> multiKey = new MultiKey<>("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");

        // Call the removeAll method with matching keys
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");

        // Assert that the entry was removed
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(multiKey));
    }

    @Test(timeout = 4000)
    public void testRemoveAllNoMatch() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Add a MultiKey to the map
        MultiKey<String> multiKey = new MultiKey<>("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");

        // Call the removeAll method with non-matching keys
        boolean result = multiKeyMap.removeAll("key4", "key5", "key6");

        // Assert that the entry was not removed
        assertFalse(result);
        assertTrue(multiKeyMap.containsKey(multiKey));
    }

    @Test(timeout = 4000)
    public void testRemoveAllEmptyMap() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Call the removeAll method on an empty map
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");

        // Assert that the result is false since the map is empty
        assertFalse(result);
    }

}