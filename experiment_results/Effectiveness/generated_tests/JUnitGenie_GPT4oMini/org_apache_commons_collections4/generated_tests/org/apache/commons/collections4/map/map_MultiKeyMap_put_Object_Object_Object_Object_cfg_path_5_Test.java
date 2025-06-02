package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPutWithNewEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value = "value";

        // This should add a new entry as the map is currently empty.
        Object result = multiKeyMap.put(key1, key2, key3, value);
        assertNull(result); // Expecting null as this is a new entry.
    }

    @Test(timeout = 4000)
    public void testPutWithExistingEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value1 = "value1";
        String value2 = "value2";

        // Adding an entry first
        multiKeyMap.put(key1, key2, key3, value1);
        
        // This should update the existing entry and return the old value
        Object result = multiKeyMap.put(key1, key2, key3, value2);
        assertEquals(value1, result); // Expecting the old value to be returned.
        
        // Verify the updated value
        assertEquals(value2, multiKeyMap.put(key1, key2, key3, null)); // Check with null value
        assertNull(multiKeyMap.put(key1, key2, key3, null)); // Check that old value is returned when setting to null
    }

    @Test(timeout = 4000)
    public void testPutWithNullValues() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = null;
        String key2 = null;
        String key3 = null;
        String value = "value";

        // Should be able to add an entry with null keys
        Object result = multiKeyMap.put(key1, key2, key3, value);
        assertNull(result); // Expecting null as this is a new entry for null keys.
    }

    @Test(timeout = 4000)
    public void testPutHandlingException() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value = "value";

        try {
            // Forcing to create an exceptional condition (this is context dependent)
            Object result = multiKeyMap.put(null, null, null, null);
            assertNull(result);
        } catch (Exception e) {
            fail("Expected no exception to be thrown");
        }
    }

}