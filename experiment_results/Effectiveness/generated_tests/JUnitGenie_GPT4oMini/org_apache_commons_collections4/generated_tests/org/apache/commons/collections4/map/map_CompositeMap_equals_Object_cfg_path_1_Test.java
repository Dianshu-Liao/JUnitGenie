package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class map_CompositeMap_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithMap() {
        CompositeMap compositeMap = new CompositeMap();
        java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        // Adding the map to the composite map
        compositeMap.putAll(map);

        // Creating another map with the same entries
        java.util.Map<String, String> anotherMap = new java.util.HashMap<>();
        anotherMap.put("key1", "value1");
        anotherMap.put("key2", "value2");

        // Testing equals method
        try {
            assertTrue(compositeMap.equals(anotherMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        CompositeMap compositeMap = new CompositeMap();
        String notAMap = "I am not a map";

        // Testing equals method with a non-map object
        try {
            assertFalse(compositeMap.equals(notAMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CompositeMap compositeMap = new CompositeMap();

        // Testing equals method with null
        try {
            assertFalse(compositeMap.equals(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}