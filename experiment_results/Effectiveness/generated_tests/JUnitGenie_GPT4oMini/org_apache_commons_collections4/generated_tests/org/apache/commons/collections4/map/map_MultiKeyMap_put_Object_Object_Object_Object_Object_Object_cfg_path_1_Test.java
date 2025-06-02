package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutWithValidParameters() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        // Test putting a new entry
        String oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, value);
        assertNull(oldValue); // Expecting null since it is a new entry

        // Test putting an entry with the same keys
        String newValue = "newValue";
        oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, newValue);
        assertEquals(value, oldValue); // Expecting old value to be returned
    }

    @Test(timeout = 4000)
    public void testPutWithNullKey1() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        try {
            multiKeyMap.put(null, key2, key3, key4, key5, value);
            fail("Expected an exception to be thrown due to null key1");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPutWithNullKey2() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        try {
            multiKeyMap.put(key1, null, key3, key4, key5, value);
            fail("Expected an exception to be thrown due to null key2");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPutWithNullKey3() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";

        try {
            multiKeyMap.put(key1, key2, null, key4, key5, value);
            fail("Expected an exception to be thrown due to null key3");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPutWithNullKey4() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key5 = "key5";
        String value = "value";

        try {
            multiKeyMap.put(key1, key2, key3, null, key5, value);
            fail("Expected an exception to be thrown due to null key4");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPutWithNullKey5() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value = "value";

        try {
            multiKeyMap.put(key1, key2, key3, key4, null, value);
            fail("Expected an exception to be thrown due to null key5");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}