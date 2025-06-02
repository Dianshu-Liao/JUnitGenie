package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPutWithValidParameters() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // Ensure the put method works correctly
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, value);
        assertNull(oldValue); // Expecting null since it is a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithExistingKey() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value1 = "value1";
        String value2 = "value2";

        // First put
        multiKeyMap.put(key1, key2, key3, key4, key5, value1);
        // Update with a new value
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, value2);
        assertEquals(value1, oldValue); // Expecting old value to be returned
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