package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_remove_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemove() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Test removing an existing key
        String removedValue = map.remove("key1");
        assertEquals("value1", removedValue);
        assertNull(map.remove("key1")); // Ensure the key is no longer present

        // Test removing a non-existing key
        removedValue = map.remove("key3");
        assertNull(removedValue);
    }

    @Test(timeout = 4000)
    public void testRemoveWithNullKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        map.put("key1", "value1");

        try {
            map.remove(null); // This should not throw an exception, but we need to handle it
        } catch (Exception e) {
            fail("Removing with null key should not throw an exception");
        }
    }

    @Test(timeout = 4000)
    public void testRemoveWithEqualKeys() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Test removing with a key that is equal to an existing key
        String removedValue = map.remove("key2");
        assertEquals("value2", removedValue);
        assertNull(map.remove("key2")); // Ensure the key is no longer present
    }

}