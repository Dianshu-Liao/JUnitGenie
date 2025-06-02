package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should update the existing entry and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value2");
        assertEquals("value1", oldValue);
        
        // Verify that the value has been updated
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithNewEntry() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // This should add a new entry
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value1");
        assertNull(oldValue);
        
        // Verify that the value is correctly stored
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should update the existing entry to null and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", null);
        assertEquals("value1", oldValue);
        
        // Verify that the value is now null
        assertNull(multiKeyMap.put("key1", "key2", "key3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithDifferentKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should add a new entry since the keys are different
        String oldValue = multiKeyMap.put("key4", "key5", "key6", "value2");
        assertNull(oldValue);
        
        // Verify that both entries exist
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", null));
        assertEquals("value2", multiKeyMap.put("key4", "key5", "key6", null));
    }

}