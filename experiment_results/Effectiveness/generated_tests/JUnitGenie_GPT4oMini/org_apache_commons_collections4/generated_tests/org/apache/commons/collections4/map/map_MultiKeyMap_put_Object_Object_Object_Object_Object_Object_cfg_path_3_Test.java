package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutWithValidKeysAndValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // First insertion should return null
        Object result = multiKeyMap.put(key1, key2, key3, key4, key5, value);
        assertNull(result);

        // Inserting again with the same keys should return the old value
        Object oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, "newValue");
        assertEquals(value, oldValue);
    }

    @Test(timeout = 4000)
    public void testPutWithNullKeys() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String value = "value";

        try {
            multiKeyMap.put(null, "key2", "key3", "key4", "key5", value);
            fail("Expected an exception to be thrown due to null key1");
        } catch (NullPointerException e) {
            // Expected exception
        }

        try {
            multiKeyMap.put("key1", null, "key3", "key4", "key5", value);
            fail("Expected an exception to be thrown due to null key2");
        } catch (NullPointerException e) {
            // Expected exception
        }

        try {
            multiKeyMap.put("key1", "key2", null, "key4", "key5", value);
            fail("Expected an exception to be thrown due to null key3");
        } catch (NullPointerException e) {
            // Expected exception
        }

        try {
            multiKeyMap.put("key1", "key2", "key3", null, "key5", value);
            fail("Expected an exception to be thrown due to null key4");
        } catch (NullPointerException e) {
            // Expected exception
        }

        try {
            multiKeyMap.put("key1", "key2", "key3", "key4", null, value);
            fail("Expected an exception to be thrown due to null key5");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}