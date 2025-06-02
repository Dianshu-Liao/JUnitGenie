package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap_get_Object_cfg_path_2_Test {

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
        map.put("key1", "value1");
        
        // Test for null key, should return null
        String result = map.get(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKey() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        
        // Test for a non-existent key
        String result = map.get("nonExistentKey");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeyType() {
        AbstractHashedMap<Object, String> map = new AbstractHashedMap<>(10);
        map.put(1, "value1");
        
        // Test for a different key type
        String result = map.get("1");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithValidKeyAfterConversion() {
        AbstractHashedMap<String, String> map = new AbstractHashedMap<>(10);
        map.put("key1", "value1");
        
        // Test for a valid key that requires conversion
        String result = map.get("key1");
        assertEquals("value1", result);
    }

}