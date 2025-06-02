package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.StaticBucketMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class map_StaticBucketMap_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        StaticBucketMap map = new StaticBucketMap();
        assertTrue(map.equals(map));
    }

    @Test(timeout = 4000)
    public void testEquals_NonMapObject() {
        StaticBucketMap map = new StaticBucketMap();
        String nonMapObject = "Not a Map";
        assertFalse(map.equals(nonMapObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualMaps() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        
        // Assuming entrySet() returns a properly initialized and comparable set
        // Here we would need to add entries to both maps to ensure they are equal
        // This is a placeholder for actual entries
        map1.put("key1", "value1");
        map2.put("key1", "value1");

        assertTrue(map1.equals(map2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualMaps() {
        StaticBucketMap map1 = new StaticBucketMap();
        StaticBucketMap map2 = new StaticBucketMap();
        
        // Assuming entrySet() returns a properly initialized and comparable set
        // Here we would need to add different entries to both maps
        map1.put("key1", "value1");
        map2.put("key2", "value2");

        assertFalse(map1.equals(map2));
    }

}