package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutWhenCollectionIsNull() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "testKey";
        Object value = "testValue";

        // Expect that putting a value creates a new collection and returns the value
        Object result = null;
        try {
            result = map.put(key, value);
        } catch (Exception e) {
            fail("put method threw an exception: " + e.getMessage());
        }
        
        assertEquals(value, result);
        assertNotNull(map.getCollection(key));
    }

    @Test(timeout = 4000)
    public void testPutWhenCollectionExists() {
        MultiValueMap<Object, Object> map = new MultiValueMap<>();
        Object key = "existingKey";
        Object value1 = "value1";
        Object value2 = "value2";

        // Initially add a value to an existing collection
        map.put(key, value1);
        
        // Now when we add another value to the same key
        Object result = null;
        try {
            result = map.put(key, value2);
        } catch (Exception e) {
            fail("put method threw an exception: " + e.getMessage());
        }
        
        assertEquals(value2, result);
        assertEquals(2, map.getCollection(key).size()); // Verify that the collection size is 2
    }

}