package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class map_MultiKeyMap_get_Object_Object_Object_Object_cfg_path_6_Test {
    
    @Test(timeout = 4000)
    public void testGetWithUniqueKeys() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // Note: The keys must be unique such that their combination does not exist in the map
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        
        // Act
        Object result = multiKeyMap.get(key1, key2, key3, key4);
        
        // Assert
        assertNull(result); // Since the map is empty, we expect a null return
    }

}