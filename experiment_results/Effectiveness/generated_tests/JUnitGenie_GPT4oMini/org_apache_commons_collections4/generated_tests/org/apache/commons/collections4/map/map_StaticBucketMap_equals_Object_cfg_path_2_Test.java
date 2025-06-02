package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.StaticBucketMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class map_StaticBucketMap_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        StaticBucketMap map = new StaticBucketMap();
        Object differentObject = new Object(); // Not a Map
        try {
            assertFalse(map.equals(differentObject));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}