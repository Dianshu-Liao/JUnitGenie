package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class map_CompositeMap_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithMap() {
        CompositeMap compositeMap = new CompositeMap();
        java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put("key", "value");

        // Testing equals with a Map
        assertTrue(compositeMap.equals(map));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMapObject() {
        CompositeMap compositeMap = new CompositeMap();
        String nonMapObject = "Not a Map";

        // Testing equals with a non-Map object
        assertFalse(compositeMap.equals(nonMapObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CompositeMap compositeMap = new CompositeMap();

        // Testing equals with null
        assertFalse(compositeMap.equals(null));
    }

}