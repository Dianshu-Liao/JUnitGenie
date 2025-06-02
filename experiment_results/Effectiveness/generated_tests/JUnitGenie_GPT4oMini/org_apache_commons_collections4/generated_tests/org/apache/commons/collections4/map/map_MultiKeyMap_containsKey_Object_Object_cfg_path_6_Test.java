package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class map_MultiKeyMap_containsKey_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testContainsKeyWithNullEntry() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        
        // Since the map is empty, it should return false
        try {
            boolean result = multiKeyMap.containsKey(key1, key2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}