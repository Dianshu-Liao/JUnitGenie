package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Prepare keys and value
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        Object value = "value";

        // Insert the entry into the MultiKeyMap
        multiKeyMap.put(key1, key2, key3, key4, key5, value);

        // Test the get method
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4, key5);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Prepare keys and value
        Object key1 = null; // This key is null
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        Object value = "value";

        // Insert the entry into the MultiKeyMap
        multiKeyMap.put("key1", key2, key3, key4, key5, value);

        // Test the get method
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4, key5);
        } catch (Exception e) {
            // Expected behavior, as key1 is null
            assertNotNull(e);
        }

        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Prepare keys that do not exist in the map
        Object key1 = "nonExistentKey1";
        Object key2 = "nonExistentKey2";
        Object key3 = "nonExistentKey3";
        Object key4 = "nonExistentKey4";
        Object key5 = "nonExistentKey5";

        // Test the get method
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4, key5);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNull(result);
    }

}