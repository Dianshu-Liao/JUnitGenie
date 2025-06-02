package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPut() {
        MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
        Object key = "key1";
        Object value = "value1";

        // Case when collection is null and a new collection is created
        Object result = multiValueMap.put(key, value);
        assertEquals(value, result);

        // To ensure the `getCollection(key)` returns a non-null value
        // We'll manually mimic this since the original method does not expose it.
        Object keyExists = "key1";
        // we simulate the map's internal state
        multiValueMap.put(keyExists, new java.util.ArrayList<Object>());
        
        // Case when collection already exists
        Object result2 = multiValueMap.put(keyExists, value);
        assertEquals(value, result2);
    }

    @Test(timeout = 4000)
    public void testPut_throwsException() {
        MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
        Object nullKey = null;
        Object value = "value1";
        
        try {
            multiValueMap.put(nullKey, value); // This should not throw.
        } catch (Exception e) {
            fail("Expected no exception for null key but got: " + e.getMessage());
        }
    }

}