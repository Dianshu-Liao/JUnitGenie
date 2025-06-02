package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.StaticBucketMap;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class map_StaticBucketMap_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        StaticBucketMap map = new StaticBucketMap();
        assertTrue(map.equals(map)); // Testing the case where obj is the same instance
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        StaticBucketMap map = new StaticBucketMap();
        String notAMap = "Not a Map";
        assertFalse(map.equals(notAMap)); // Testing the case where obj is not an instance of Map
    }

    @Test(timeout = 4000)
    public void testEquals_EqualMaps() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        // Assuming both maps are empty and thus equal
        assertTrue(map1.equals(map2)); // Testing the case where both maps are equal
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        StaticBucketMap map = new StaticBucketMap();
        assertFalse(map.equals(null)); // Testing the case where obj is null
    }

}