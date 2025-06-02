package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.MapIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
        
        // Act
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        
        // Assert
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test(timeout = 4000)
    public void testRemoveAll_NoMatch() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
        
        // Act
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        
        // Assert
        assertFalse(modified);
    }

    @Test(timeout = 4000)
    public void testRemoveAll_EmptyMap() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        
        // Act
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        
        // Assert
        assertFalse(modified);
    }

}