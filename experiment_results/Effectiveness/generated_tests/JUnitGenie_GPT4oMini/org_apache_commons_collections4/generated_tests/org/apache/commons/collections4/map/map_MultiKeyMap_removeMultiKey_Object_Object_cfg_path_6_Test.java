package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeMultiKey_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveMultiKey() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        multiKeyMap.put(new MultiKey("key1", "key2"), "value1");
        
        // Act
        Object result = multiKeyMap.remove(new MultiKey("key1", "key2"));
        
        // Assert
        assertEquals("value1", result);
        
        // Verify that the key is removed
        assertNull(multiKeyMap.remove(new MultiKey("key1", "key2")));
    }



}
