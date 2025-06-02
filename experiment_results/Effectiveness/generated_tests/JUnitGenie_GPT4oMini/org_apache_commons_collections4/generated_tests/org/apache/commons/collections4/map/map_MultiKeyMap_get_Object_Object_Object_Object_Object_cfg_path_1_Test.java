package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        try {
            MultiKeyMap multiKeyMap = new MultiKeyMap();
            Object key1 = "key1";
            Object key2 = "key2";
            Object key3 = "key3";
            Object key4 = "key4";
            Object key5 = "key5";
            multiKeyMap.put(key1, key2, key3, key4, key5, "value");

            // This should lead to a successful execution of the CFG path
            Object result = multiKeyMap.get(key1, key2, key3, key4, key5);
            assertEquals("value", result);
        } catch (Exception e) {
            fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        try {
            MultiKeyMap multiKeyMap = new MultiKeyMap();
            Object key1 = null;
            Object key2 = "key2";
            Object key3 = "key3";
            Object key4 = "key4";
            Object key5 = "key5";
            multiKeyMap.put(key1, key2, key3, key4, key5, "value");

            // Testing with a null key
            Object result = multiKeyMap.get(key1, key2, key3, key4, key5);
            assertEquals("value", result);
        } catch (Exception e) {
            fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistingKeys() {
        try {
            MultiKeyMap multiKeyMap = new MultiKeyMap();
            Object key1 = "key1";
            Object key2 = "key2";
            Object key3 = "key3";
            Object key4 = "key4";
            Object key5 = "key5";

            // Testing with keys that do not exist
            Object result = multiKeyMap.get(key1, key2, key3, key4, key5);
            assertNull(result); // Should return null since there are no entries
        } catch (Exception e) {
            fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

}