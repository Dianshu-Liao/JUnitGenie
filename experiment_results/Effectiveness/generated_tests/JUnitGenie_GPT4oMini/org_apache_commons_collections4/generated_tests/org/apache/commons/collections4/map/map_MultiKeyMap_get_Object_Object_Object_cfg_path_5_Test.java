package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Assuming we have a method to add entries to the MultiKeyMap
        // Here we are adding a valid entry to ensure the hash code matches
        multiKeyMap.put("key1", "key2", "key3", "value");

        // Test with valid keys that should return the corresponding value
        Object result = multiKeyMap.get("key1", "key2", "key3");
        assertEquals("value", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey1() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        multiKeyMap.put("key1", "key2", "key3", "value");

        try {
            multiKeyMap.get(null, "key2", "key3");
            fail("Expected an exception to be thrown due to null key1");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey2() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        multiKeyMap.put("key1", "key2", "key3", "value");

        try {
            multiKeyMap.get("key1", null, "key3");
            fail("Expected an exception to be thrown due to null key2");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey3() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        multiKeyMap.put("key1", "key2", "key3", "value");

        try {
            multiKeyMap.get("key1", "key2", null);
            fail("Expected an exception to be thrown due to null key3");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();

        // Test with keys that do not exist in the map
        Object result = multiKeyMap.get("nonExistentKey1", "nonExistentKey2", "nonExistentKey3");
        assertNull(result);
    }

}