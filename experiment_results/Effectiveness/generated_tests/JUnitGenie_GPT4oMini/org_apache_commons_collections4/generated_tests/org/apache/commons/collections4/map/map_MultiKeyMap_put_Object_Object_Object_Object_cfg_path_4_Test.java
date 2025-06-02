package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // Test updating an existing entry
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value2");
        assertEquals("value1", oldValue); // Verify the old value is returned
    }

    @Test(timeout = 4000)
    public void testPutWithNewEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // Test adding a new entry
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value1");
        assertNull(oldValue); // Verify that null is returned for a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // Test adding an entry with a null value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", null);
        assertNull(oldValue); // Verify that null is returned for a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithNullKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // Test adding an entry with null keys
        String oldValue = multiKeyMap.put(null, null, null, "value1");
        assertNull(oldValue); // Verify that null is returned for a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithMultipleEntries() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        multiKeyMap.put("key4", "key5", "key6", "value2");
        
        // Test updating an existing entry
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value3");
        assertEquals("value1", oldValue); // Verify the old value is returned
    }

}