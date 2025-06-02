package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.MapIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        
        // Assert
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test(timeout = 4000)
    public void testRemoveAll_NoMatch() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        
        // Assert
        assertFalse(result);
        assertTrue(multiKeyMap.containsKey(new MultiKey<>("key3", "key4")));
    }

    @Test(timeout = 4000)
    public void testRemoveAll_MultipleKeys() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value2");
        
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        
        // Assert
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

}