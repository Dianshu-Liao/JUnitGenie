package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeMultiKey_Object_Object_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemoveMultiKey() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        Object value = new Object();
        
        // Adding a value to the map to ensure it can be removed
        multiKeyMap.put(key1, key2, key3, key4, value);

        // Act
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(key1, key2, key3, key4);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(removedValue);
        assertEquals(value, removedValue);
    }

    @Test(timeout = 4000)
    public void testRemoveMultiKeyWithNullKey() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        multiKeyMap.put(key1, key2, key3, key4, new Object());

        // Act
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(null, key2, key3, key4);
        } catch (Exception e) {
            // Expected behavior, as null key should not be allowed
        }

        // Assert
        assertNull(removedValue);
    }

    @Test(timeout = 4000)
    public void testRemoveMultiKeyWithNonExistentKey() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object key4 = new Object();
        multiKeyMap.put(key1, key2, key3, key4, new Object());

        // Act
        Object removedValue = null;
        try {
            removedValue = multiKeyMap.removeMultiKey(new Object(), new Object(), new Object(), new Object());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNull(removedValue);
    }

}