package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_containsValue_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsValue_ValidKeyAndValue() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        map.put("key1", "value1");
        map.put("key1", "value2");

        // Valid key and value
        boolean result = map.containsValue("key1", "value1");
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsValue_ValidKeyInvalidValue() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        map.put("key1", "value1");

        // Valid key but invalid value
        boolean result = map.containsValue("key1", "value2");
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsValue_InvalidKey() {
        MultiValueMap<String, String> map = new MultiValueMap<>();

        // Invalid key
        boolean result = map.containsValue("key2", "value1");
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsValue_NullCollection() {
        MultiValueMap<String, String> map = new MultiValueMap<>();

        // Null collection scenario
        boolean result = map.containsValue("key1", "value1");
        assertFalse(result);
    }

}