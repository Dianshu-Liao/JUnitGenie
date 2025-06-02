package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class map_MultiKeyMap_get_Object_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetReturnsNullWhenEntryIsNull() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        
        // Given keys
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        
        // When calling get with the keys
        Object result = multiKeyMap.get(key1, key2, key3);
        
        // Then the result should be null
        assertNull(result);
    }

}