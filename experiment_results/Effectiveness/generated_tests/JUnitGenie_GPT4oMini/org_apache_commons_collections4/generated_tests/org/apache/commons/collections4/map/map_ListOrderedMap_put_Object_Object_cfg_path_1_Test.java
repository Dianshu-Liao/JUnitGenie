package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_ListOrderedMap_put_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPut_NewKey() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        String key = "key1";
        String value = "value1";

        // Act
        String result = null;
        try {
            result = map.put(key, value);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPut_ExistingKey() {
        ListOrderedMap<String, String> map = new ListOrderedMap<>();
        String key = "key1";
        String value1 = "value1";
        String value2 = "value2";

        // First put
        try {
            map.put(key, value1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        String result = null;
        try {
            result = map.put(key, value2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(value2, result);
    }

}