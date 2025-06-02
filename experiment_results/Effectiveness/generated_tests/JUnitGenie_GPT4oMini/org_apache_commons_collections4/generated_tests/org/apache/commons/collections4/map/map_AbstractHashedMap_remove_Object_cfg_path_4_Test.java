package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_remove_Object_cfg_path_4_Test {

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
        map.put(null, "valueNull");

        // Test removing a key that is null
        String removedValue = map.remove(null);
        assertEquals("valueNull", removedValue);
        assertNull(map.remove(null)); // Ensure the key is no longer present
    }

    @Test(timeout = 4000)
    public void testRemoveWithCollision() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10); // Using reflection to access protected constructor
        map.put("key1", "value1");
        map.put("key2", "value2");
        // Simulate a collision by adding a key that hashes to the same index as "key1"
        map.put("key1_collision", "valueCollision");

        // Test removing the original key
        String removedValue = map.remove("key1");
        assertEquals("value1", removedValue);
        // Ensure the collision key is still present
        assertEquals("valueCollision", map.get("key1_collision"));
    }

}