package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetWithNonMatchingKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // Adding an entry with keys of length 4
        multiKeyMap.put("key1", "key2", "key3", "key4", "value");

        // Attempting to retrieve with keys of length 5
        Object result = multiKeyMap.get("key1", "key2", "key3", "key4", "key5");
        assertNull(result); // Should return null as keys do not match
    }

    @Test(timeout = 4000)
    public void testGetWithMatchingKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // Adding an entry with keys of length 4
        multiKeyMap.put("key1", "key2", "key3", "key4", "value");

        // Attempting to retrieve with matching keys
        Object result = multiKeyMap.get("key1", "key2", "key3", "key4");
        assertEquals("value", result); // Should return the value associated with the keys
    }

    @Test(timeout = 4000)
    public void testGetWithNullEntry() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // Attempting to retrieve from an empty map
        Object result = multiKeyMap.get("key1", "key2", "key3", "key4", "key5");
        assertNull(result); // Should return null as there are no entries
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeyLength() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // Adding an entry with keys of length 4
        multiKeyMap.put("key1", "key2", "key3", "key4", "value");

        // Attempting to retrieve with keys of length 3
        Object result = multiKeyMap.get("key1", "key2", "key3");
        assertNull(result); // Should return null as keys do not match
    }

}