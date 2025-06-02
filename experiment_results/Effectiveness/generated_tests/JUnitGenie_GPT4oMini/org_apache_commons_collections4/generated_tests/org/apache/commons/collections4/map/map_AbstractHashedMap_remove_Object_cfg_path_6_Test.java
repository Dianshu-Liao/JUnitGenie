package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_remove_Object_cfg_path_6_Test {

    // Create a concrete implementation of AbstractHashedMap for testing
    private static class TestHashedMap<K, V> extends AbstractHashedMap<K, V> {
        @Override
        protected K convertKey(Object key) {
            return (K) key; // Return the key as-is
        }
    }

    @Test(timeout = 4000)
    public void testRemove_WithNullKey() {
        AbstractHashedMap<Object, Object> map = new TestHashedMap<>();

        // Trying to remove a null key
        Object result = null;
        try {
            result = map.remove(null);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertNull(result); // Expecting null as the result
    }

    @Test(timeout = 4000)
    public void testRemove_WithExistingKey() {
        AbstractHashedMap<Object, String> map = new TestHashedMap<>();
        
        // Adding a key-value pair for testing
        map.put("testKey", "testValue");

        // Trying to remove the key
        Object result = null;
        try {
            result = map.remove("testKey");
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertEquals("testValue", result); // Expecting to retrieve the old value
    }

    @Test(timeout = 4000)
    public void testRemove_WithNonExistingKey() {
        AbstractHashedMap<Object, Object> map = new TestHashedMap<>();

        // Trying to remove a non-existing key
        Object result = null;
        try {
            result = map.remove("nonExistingKey");
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertNull(result); // Expecting null as the result
    }


}