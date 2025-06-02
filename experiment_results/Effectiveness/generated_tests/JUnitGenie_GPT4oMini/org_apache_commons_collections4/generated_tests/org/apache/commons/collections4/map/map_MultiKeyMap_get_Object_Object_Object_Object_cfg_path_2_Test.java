package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object value = "value";

        // Adding an entry to the map
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
        Object value = "value";

        // Adding an entry with null keys
        multiKeyMap.put(null, null, null, null, value);

        // Testing the get method with null keys
        Object result = null;
        try {
            result = multiKeyMap.get(null, null, null, null);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();

        // Testing the get method with non-existent keys
        Object result = null;
        try {
            result = multiKeyMap.get("nonExistentKey1", "nonExistentKey2", "nonExistentKey3", "nonExistentKey4");
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNull(result);
    }

}