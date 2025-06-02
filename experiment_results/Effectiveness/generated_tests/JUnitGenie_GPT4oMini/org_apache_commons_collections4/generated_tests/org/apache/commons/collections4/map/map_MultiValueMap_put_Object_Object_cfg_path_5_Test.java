package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingKey() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        String key = "testKey";
        String value = "testValue";

        // Pre-populate the map to ensure the key exists
        map.put(key, "existingValue");

        // Now test the put method
        Object result = map.put(key, value);
        
        // Verify that the result is the new value added
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutWithNewKey() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        String key = "newKey";
        String value = "newValue";

        // Test the put method with a new key
        Object result = map.put(key, value);
        
        // Verify that the result is the new value added
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        String key = "nullValueKey";

        // Test the put method with a null value
        Object result = map.put(key, null);
        
        // Verify that the result is null since we are adding a null value
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testPutWithExistingKeyAndNullValue() {
        MultiValueMap<String, String> map = new MultiValueMap<>();
        String key = "existingKey";
        String value = "valueToRemove";

        // Pre-populate the map to ensure the key exists
        map.put(key, value);

        // Now test the put method with a null value
        Object result = map.put(key, null);
        
        // Verify that the result is null since we are adding a null value
        assertNull(result);
    }

}