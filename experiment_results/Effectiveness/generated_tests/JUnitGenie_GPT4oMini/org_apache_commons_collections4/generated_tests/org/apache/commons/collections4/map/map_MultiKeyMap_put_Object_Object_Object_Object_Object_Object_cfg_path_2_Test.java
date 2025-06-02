package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutWithValidParameters() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        Object value = "value";

        // Test putting a new entry
        Object oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, value);
        assertNull(oldValue); // Expecting null since it is a new entry

        // Test putting an entry with the same keys
        Object newValue = "newValue";
        oldValue = multiKeyMap.put(key1, key2, key3, key4, key5, newValue);
        assertEquals(value, oldValue); // Expecting the old value to be returned
    }

    @Test(timeout = 4000)
    public void testPutWithNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object value = "value";

        // Test putting an entry with null keys
        Object oldValue = multiKeyMap.put(null, null, null, null, null, value);
        assertNull(oldValue); // Expecting null since it is a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithMixedNullAndNonNullKeys() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object value = "value";

        // Test putting an entry with one null key
        Object oldValue = multiKeyMap.put(key1, null, "key3", "key4", "key5", value);
        assertNull(oldValue); // Expecting null since it is a new entry
    }

    @Test(timeout = 4000)
    public void testPutWithExistingEntry() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object value1 = "value1";
        Object value2 = "value2";

        // First put
        multiKeyMap.put(key1, key2, "key3", "key4", "key5", value1);
        // Now put with the same keys but different value
        Object oldValue = multiKeyMap.put(key1, key2, "key3", "key4", "key5", value2);
        assertEquals(value1, oldValue); // Expecting the old value to be returned
    }

}