package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetWithMatchingKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object value = "value";

        // Adding an entry to the MultiKeyMap
        multiKeyMap.put(key1, key2, key3, value);

        // Test the get method
        Object result = multiKeyMap.get(key1, key2, key3);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonMatchingKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";

        // Test the get method when no entry exists
        Object result = multiKeyMap.get(key1, key2, key3);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object value = "value";

        // Adding an entry with null keys
        multiKeyMap.put(null, null, null, value);

        // Test the get method with null keys
        Object result = multiKeyMap.get(null, null, null);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeyTypes() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = 1; // Integer key
        Object key2 = 2.0; // Double key
        Object key3 = "key3"; // String key
        Object value = "value";

        // Adding an entry with different key types
        multiKeyMap.put(key1, key2, key3, value);

        // Test the get method with the same key types
        Object result = multiKeyMap.get(key1, key2, key3);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithPartialKeyMatch() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object value = "value";

        // Adding an entry to the MultiKeyMap
        multiKeyMap.put(key1, key2, key3, value);

        // Test the get method with a partial key match
        Object result = multiKeyMap.get(key1, "wrongKey", key3);
        assertNull(result);
    }

}