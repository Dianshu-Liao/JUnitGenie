package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutWithNewCollection() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "testKey";
        Object value = "testValue";

        // Simulate the condition where getCollection returns null
        // This requires that the decorated() method returns a map that does not contain the key
        try {
            Object result = map.put(key, value);
            assertEquals(value, result);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPutWithExistingCollection() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "existingKey";
        Object value = "newValue";

        // Pre-populate the map to ensure getCollection returns a non-null value
        map.put(key, "oldValue");

        try {
            Object result = map.put(key, value);
            assertEquals(value, result);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}