package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testPutWithExistingKey() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "testKey";
        Object value = "testValue";

        // Pre-populate the map to satisfy the constraints
        map.put(key, "existingValue");

        // Now we can test the put method
        Object result = null;
        try {
            result = map.put(key, value);
        } catch (Exception e) {
            fail("Exception thrown during put: " + e.getMessage());
        }

        // Verify that the value was added
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutWithNewKey() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "newKey";
        Object value = "newValue";

        // Test the put method with a new key
        Object result = null;
        try {
            result = map.put(key, value);
        } catch (Exception e) {
            fail("Exception thrown during put: " + e.getMessage());
        }

        // Verify that the value was added
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutWithNullValue() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "nullValueKey";

        // Pre-populate the map to satisfy the constraints
        map.put(key, "existingValue");

        // Test the put method with a null value
        Object result = null;
        try {
            result = map.put(key, null);
        } catch (Exception e) {
            fail("Exception thrown during put: " + e.getMessage());
        }

        // Verify that the result is null since we are adding a null value
        assertNull(result);
    }

}