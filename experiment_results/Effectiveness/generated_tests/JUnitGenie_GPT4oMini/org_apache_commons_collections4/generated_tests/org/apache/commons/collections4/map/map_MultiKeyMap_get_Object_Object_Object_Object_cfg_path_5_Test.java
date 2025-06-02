package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        Object value = new Object();

        // Adding an entry to the map to test retrieval
        multiKeyMap.put(key1, key2, key3, key4, value);

        // Testing the get method
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = null;
        Object key2 = null;
        Object key3 = null;
        Object key4 = null;

        // Testing the get method with null keys
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();

        // Testing the get method for non-existent keys
        Object result = null;
        try {
            result = multiKeyMap.get(key1, key2, key3, key4);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNull(result);
    }

}