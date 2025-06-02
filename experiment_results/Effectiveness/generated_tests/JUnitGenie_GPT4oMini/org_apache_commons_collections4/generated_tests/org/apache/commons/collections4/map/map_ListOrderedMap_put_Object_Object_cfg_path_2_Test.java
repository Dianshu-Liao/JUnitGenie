package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_ListOrderedMap_put_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPut_NewKey() {
        ListOrderedMap<Object, Object> map = new ListOrderedMap<>();
        Object key = "key1";
        Object value = "value1";

        // Execute the focal method
        Object result = map.put(key, value);

        // Verify the result
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPut_ExistingKey() {
        ListOrderedMap<Object, Object> map = new ListOrderedMap<>();
        Object key = "key1";
        Object value1 = "value1";
        Object value2 = "value2";

        // First put
        map.put(key, value1);
        // Second put with the same key
        Object result = map.put(key, value2);

        // Verify the result
        assertEquals(value1, result); // Should return the old value
    }

}