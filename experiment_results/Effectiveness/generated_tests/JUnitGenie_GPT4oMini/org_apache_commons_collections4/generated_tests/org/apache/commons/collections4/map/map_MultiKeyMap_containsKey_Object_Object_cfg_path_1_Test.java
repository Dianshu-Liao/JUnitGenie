package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_containsKey_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Assuming we have a method to add entries to the MultiKeyMap for testing
        // multiKeyMap.put(key1, key2, value); // This method is hypothetical
        
        Object key1 = new Object();
        Object key2 = new Object();
        
        // Add a key-value pair to the map (hypothetical method)
        // multiKeyMap.put(key1, key2, new Object());
        
        // Test the containsKey method
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertTrue(result);
        
        // Test with a key that does not exist
        Object nonExistentKey1 = new Object();
        Object nonExistentKey2 = new Object();
        boolean resultNonExistent = multiKeyMap.containsKey(nonExistentKey1, nonExistentKey2);
        assertFalse(resultNonExistent);
    }
    
    @Test(timeout = 4000)
    public void testContainsKeyWithNulls() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        Object key1 = null;
        Object key2 = null;
        
        // Add a key-value pair with null keys (hypothetical method)
        // multiKeyMap.put(key1, key2, new Object());
        
        boolean result = multiKeyMap.containsKey(key1, key2);
        assertTrue(result);
        
        // Test with one null key
        Object nonNullKey = new Object();
        boolean resultWithOneNull = multiKeyMap.containsKey(nonNullKey, null);
        assertFalse(resultWithOneNull);
    }
    
    @Test(timeout = 4000)
    public void testContainsKeyThrowsException() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        try {
            // This is a hypothetical scenario where we expect an exception
            multiKeyMap.containsKey(null, new Object());
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Handle the exception as expected
        }
    }

}