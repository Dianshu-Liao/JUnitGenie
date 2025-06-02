package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetReturnsNullWhenEntryIsNotFound() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";

        // The entry is not present, so we expect null
        Object result = multiKeyMap.get(key1, key2, key3, key4);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetReturnsValueWhenEntryIsFound() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object value = "value";

        // Manually add an entry to the map
        multiKeyMap.put(key1, key2, key3, key4, value);

        // Now we should be able to retrieve the value
        Object result = multiKeyMap.get(key1, key2, key3, key4);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetHandlesNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object value = "value";

        // Add an entry with null keys
        multiKeyMap.put(null, null, null, null, value);

        // Retrieve the value using null keys
        Object result = multiKeyMap.get(null, null, null, null);
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeysReturnsNull() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object value = "value";

        // Add an entry with specific keys
        multiKeyMap.put(key1, key2, key3, key4, value);

        // Attempt to retrieve with different keys
        Object result = multiKeyMap.get("differentKey1", "differentKey2", "differentKey3", "differentKey4");
        assertNull(result);
    }

}