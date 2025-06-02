package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        
        // This should update the existing entry and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value2");
        assertEquals("value1", oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithNewKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // This should add a new entry and return null
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        assertNull(oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        
        // This should update the existing entry with a null value and return the old value
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", null);
        assertEquals("value1", oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithNullKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // This should add a new entry with null keys and return null
        String oldValue = multiKeyMap.put(null, null, null, null, null, "value1");
        assertNull(oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithMixedKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        
        // This should add a new entry with different keys and return null
        String oldValue = multiKeyMap.put("key6", "key7", "key8", "key9", "key10", "value2");
        assertNull(oldValue);
    }

}