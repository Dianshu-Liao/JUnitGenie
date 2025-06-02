package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Prepare test data
        MultiKey<String> key1 = new MultiKey<>("key1", "key2", "key3");
        MultiKey<String> key2 = new MultiKey<>("key4", "key5", "key6");
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");

        // Test case where keys match
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(result); // Expecting true as the keys match and an entry is removed
        assertNull(multiKeyMap.get(key1)); // The entry should be removed

        // Test case where keys do not match
        result = multiKeyMap.removeAll("nonexistentKey1", "nonexistentKey2", "nonexistentKey3");
        assertFalse(result); // Expecting false as no keys match
        assertNotNull(multiKeyMap.get(key2)); // The entry should still exist
    }

    @Test(timeout = 4000)
    public void testRemoveAllWithLessThanThreeKeys() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Prepare test data with less than three keys
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        multiKeyMap.put(key1, "value1");

        // Attempt to remove with three keys
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        assertFalse(result); // Expecting false as the MultiKey has less than three keys
    }

}