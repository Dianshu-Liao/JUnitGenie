package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Create an instance of MultiKeyMap
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Populate the MultiKeyMap with some data
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");

        // Test case where keys exist
        boolean result = multiKeyMap.removeAll("key1", "key2");
        assertTrue(result); // Expecting true since the keys exist and should be removed

        // Test case where keys do not exist
        result = multiKeyMap.removeAll("key5", "key6");
        assertFalse(result); // Expecting false since the keys do not exist

        // Test case with a MultiKey that has less than 2 keys
        MultiKey<String> multiKeyWithOneKey = new MultiKey<>(new String[]{"key7"});
        multiKeyMap.put(multiKeyWithOneKey, "value3");
        result = multiKeyMap.removeAll("key7", "key8");
        assertFalse(result); // Expecting false since the MultiKey does not match the criteria
    }


}