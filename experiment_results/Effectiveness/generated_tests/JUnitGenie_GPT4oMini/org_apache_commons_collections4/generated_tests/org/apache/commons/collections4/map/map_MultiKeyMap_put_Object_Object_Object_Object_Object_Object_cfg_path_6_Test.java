package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testPutWithValidKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // First insertion should return null
        assertNull(multiKeyMap.put(key1, key2, key3, key4, key5, value));

        // Inserting again with the same keys should return the old value
        String newValue = "newValue";
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, newValue);
        assertEquals(value, oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithNullKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = null;
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        try {
            multiKeyMap.put(key1, key2, key3, key4, key5, value);
            fail("Expected an exception to be thrown due to null key");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPutWithEqualKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // Insert the first value
        multiKeyMap.put(key1, key2, key3, key4, key5, value);

        // Now insert with the same keys but different value
        String newValue = "newValue";
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, newValue);
        assertEquals(value, oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithDifferentKeySize() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // Insert with 5 keys
        multiKeyMap.put(key1, key2, key3, key4, key5, value);

        // Now insert with only 4 keys
        String newValue = "newValue";
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, null, newValue);
        assertNull(oldValue);
    }

}