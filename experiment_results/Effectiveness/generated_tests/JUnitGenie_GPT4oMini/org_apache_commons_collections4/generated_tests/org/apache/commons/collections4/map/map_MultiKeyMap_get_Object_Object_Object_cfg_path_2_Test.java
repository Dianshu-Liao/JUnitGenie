package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithValidKeys() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object value = new Object();
        
        // Simulating the insertion of a value into the MultiKeyMap
        // This is a hypothetical method to add an entry, as the original code does not provide it.
        multiKeyMap.put(key1, key2, key3, value); // Assuming a put method exists

        // Act
        Object result = multiKeyMap.get(key1, key2, key3);

        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNullKeys() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object value = new Object();
        
        // Simulating the insertion of a value with null keys
        multiKeyMap.put(null, null, null, value); // Assuming a put method exists

        // Act
        Object result = multiKeyMap.get(null, null, null);

        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();

        // Act
        Object result = multiKeyMap.get(key1, key2, key3);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithDifferentKeys() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = new Object();
        Object key2 = new Object();
        Object key3 = new Object();
        Object value = new Object();
        
        // Simulating the insertion of a value into the MultiKeyMap
        multiKeyMap.put(key1, key2, key3, value); // Assuming a put method exists

        // Act
        Object result = multiKeyMap.get(new Object(), new Object(), new Object());

        // Assert
        assertNull(result);
    }

}