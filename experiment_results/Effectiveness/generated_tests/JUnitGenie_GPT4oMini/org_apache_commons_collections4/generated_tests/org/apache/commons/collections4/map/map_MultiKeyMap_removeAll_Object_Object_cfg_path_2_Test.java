package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.MapIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeAll_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        
        // Act
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test(timeout = 4000)
    public void testRemoveAll_NoMatch() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");

        // Act
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertFalse(modified);
    }

    @Test(timeout = 4000)
    public void testRemoveAll_EmptyMap() {
        // Arrange
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();

        // Act
        boolean modified = false;
        try {
            modified = multiKeyMap.removeAll("key1", "key2");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertFalse(modified);
    }

}