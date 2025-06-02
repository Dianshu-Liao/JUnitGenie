package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_get_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        map.put("key1", "value1");
        
        // Test for a valid key
        String result = map.get("key1");
        assertEquals("value1", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        map.put(null, "valueNull");
        
        // Test for a null key
        String result = map.get(null);
        assertEquals("valueNull", result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        
        // Test for a non-existent key
        String result = map.get("nonExistentKey");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithCollision() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        map.put("key1", "value1");
        map.put("key2", "value2"); // Assuming this causes a collision
        
        // Test for a key that causes a collision
        String result = map.get("key1");
        assertEquals("value1", result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentObjectType() {
        AbstractHashedMap<Object, String> map = new AbstractHashedMap<>(10);
        map.put(1, "value1");
        
        // Test for a different object type as key
        String result = map.get("1"); // String instead of Integer
        assertNull(result);
    }

}