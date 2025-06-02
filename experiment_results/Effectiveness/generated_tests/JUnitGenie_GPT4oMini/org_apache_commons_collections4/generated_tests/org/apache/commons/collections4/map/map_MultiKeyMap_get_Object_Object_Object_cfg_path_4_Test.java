package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object value = new Object();

        // Simulate adding an entry to the map
        multiKeyMap.put(key1, key2, key3, value);

        // Test the get method
        Object result = multiKeyMap.get(key1, key2, key3);
        assertNotNull(result);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object value = new Object();

        // Simulate adding an entry with null keys
        multiKeyMap.put(null, null, null, value);

        // Test the get method with null keys
        Object result = multiKeyMap.get(null, null, null);
        assertNotNull(result);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();

        // Test the get method with keys that do not exist
        Object result = multiKeyMap.get(key1, key2, key3);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object value = new Object();

        // Simulate adding an entry to the map
        multiKeyMap.put(key1, key2, key3, value);

        // Test the get method with different keys
        Object result = multiKeyMap.get(new Object(), new Object(), new Object());
        assertNull(result);
    }

}