package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_containsKey_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Adding a key-value pair to the map using MultiKey
        MultiKey key1 = new MultiKey("key1", "value1");
        multiKeyMap.put(key1, "someValue"); // Store a value with MultiKey
        
        // Test case where the keys exist in the map
        boolean result = multiKeyMap.containsKey(key1);
        assertTrue(result);
        
        // Test case where the keys do not exist in the map
        MultiKey key2 = new MultiKey("key2", "value2");
        result = multiKeyMap.containsKey(key2);
        assertFalse(result);
        
        // Test case with null keys
        result = multiKeyMap.containsKey(new MultiKey(null, null));
        assertFalse(result);
        
        // Test case with one null key
        result = multiKeyMap.containsKey(new MultiKey("key1", null));
        assertFalse(result);
    }


}