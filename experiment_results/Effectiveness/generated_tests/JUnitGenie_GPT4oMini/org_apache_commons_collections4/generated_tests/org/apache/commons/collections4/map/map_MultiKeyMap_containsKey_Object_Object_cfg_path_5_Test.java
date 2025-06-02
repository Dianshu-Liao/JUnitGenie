package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_containsKey_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testContainsKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Assuming we have a method to add entries to the MultiKeyMap for testing
        // multiKeyMap.put(key1, key2, value); // This method is hypothetical
        
        Object key1 = "key1";
        Object key2 = "key2";
        
        // Add a key-value pair to the map (hypothetical method)
        // multiKeyMap.put(key1, key2, "value");
        
        // Test the containsKey method
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertTrue(result);
        
        // Test with a non-existing key
        Object nonExistingKey1 = "nonExistingKey1";
        Object nonExistingKey2 = "nonExistingKey2";
        boolean nonResult = multiKeyMap.containsKey(nonExistingKey1, nonExistingKey2);
        assertFalse(nonResult);
    }

    @Test(timeout = 4000)
    public void testContainsKeyWithNull() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        Object key1 = null;
        Object key2 = "key2";
        
        // Add a key-value pair with a null key (hypothetical method)
        // multiKeyMap.put(key1, key2, "value");
        
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertTrue(result);
        
        Object nonExistingKey1 = null;
        Object nonExistingKey2 = "nonExistingKey2";
        boolean nonResult = multiKeyMap.containsKey(nonExistingKey1, nonExistingKey2);
        assertFalse(nonResult);
    }

}