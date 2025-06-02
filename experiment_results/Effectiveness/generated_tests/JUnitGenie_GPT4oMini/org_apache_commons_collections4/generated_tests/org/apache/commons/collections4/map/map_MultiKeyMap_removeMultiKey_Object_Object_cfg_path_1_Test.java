package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeMultiKey_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveMultiKey() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        String value = "value";
        
        // Adding a MultiKey to the map
        multiKeyMap.put(key1, key2, value);
        
        // Act
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(key1, key2);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertEquals(value, removedValue);
        assertNull(multiKeyMap.removeMultiKey(key1, key2)); // Ensure the key is removed
    }

    @Test(timeout = 4000)
    public void testRemoveMultiKeyNotFound() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";

        // Act
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(key1, key2);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNull(removedValue); // Ensure that removing a non-existing key returns null
    }

}