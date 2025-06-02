package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiValueMap_put_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPut_NewEntry() {
        MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
        Object key = "newKey"; // Key that does not exist in the map
        Object value = "value1";

        Object result = multiValueMap.put(key, value);
        
        // Expecting 'value' to be returned since it's a new entry
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPut_ExistingKey() {
        MultiValueMap<Object, Object> multiValueMap = new MultiValueMap<>();
        Object key = "existingKey"; // Key that does not exist in the map
        Object value1 = "value1";
        Object value2 = "value2";

        // Adding first value for the new key
        multiValueMap.put(key, value1);
        
        // Now, adding a second value for the same key
        Object result = multiValueMap.put(key, value2);
        
        // Expecting 'value2' to be returned as it is the value added
        assertEquals(value2, result);
    }

}