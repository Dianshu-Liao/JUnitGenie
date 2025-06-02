package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should update the existing entry and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value2");
        assertEquals("value1", oldValue);
        
        // Verify that the value has been updated
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithNewKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // This should add a new entry and return null
        String oldValue = multiKeyMap.put("newKey1", "newKey2", "newKey3", "newValue");
        assertNull(oldValue);
        
        // Verify that the new entry is present
        assertEquals("newValue", multiKeyMap.put("newKey1", "newKey2", "newKey3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should update the existing entry to null and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", null);
        assertEquals("value1", oldValue);
        
        // Verify that the value has been updated to null
        assertNull(multiKeyMap.put("key1", "key2", "key3", null));
    }

    @Test(timeout = 4000)
    public void testPutWithDifferentKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "value1");
        
        // This should add a new entry and return null
        String oldValue = multiKeyMap.put("differentKey1", "differentKey2", "differentKey3", "value2");
        assertNull(oldValue);
        
        // Verify that both entries are present
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", null));
        assertEquals("value2", multiKeyMap.put("differentKey1", "differentKey2", "differentKey3", null));
    }

}