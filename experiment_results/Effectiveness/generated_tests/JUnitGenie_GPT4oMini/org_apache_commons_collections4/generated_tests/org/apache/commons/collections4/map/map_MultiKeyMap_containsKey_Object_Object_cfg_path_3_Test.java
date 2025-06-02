package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_containsKey_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContainsKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Assuming we have a method to add entries to the MultiKeyMap for testing
        // multiKeyMap.put(key1, key2, value); // This method is hypothetical
        
        Object key1 = new Object();
        Object key2 = new Object();
        
        // Hypothetical method to add a key-value pair to the map
        // multiKeyMap.put(key1, key2, new Object());
        
        // Test the containsKey method
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsKeyWithNullEntry() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        Object key1 = null;
        Object key2 = null;
        
        // Test the containsKey method with null keys
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsKeyWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        Object key1 = new Object();
        Object key2 = new Object();
        
        // Test the containsKey method with keys that do not exist
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertFalse(result);
    }

}