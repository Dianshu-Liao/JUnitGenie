package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_put_Object_Object_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutMethod() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object value = "value";

        // Act
        Object result = multiKeyMap.put(key1, key2, key3, value);

        // Assert
        assertNull(result); // Since it is the first insertion, the old value should be null

        // Act again to check for the old value
        Object newValue = "newValue";
        Object oldValue = multiKeyMap.put(key1, key2, key3, newValue);

        // Assert
        assertEquals(value, oldValue); // The old value should be the first inserted value
    }

    @Test(timeout = 4000)
    public void testPutMethodWithNullValues() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = null;
        Object key2 = null;
        Object key3 = null;
        Object value = "value";

        // Act
        Object result = multiKeyMap.put(key1, key2, key3, value);

        // Assert
        assertNull(result); // Since it is the first insertion, the old value should be null
    }

    @Test(timeout = 4000)
    public void testPutMethodWithMultipleEntries() {
        // Arrange
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object value1 = "value1";
        Object value2 = "value2";

        // Act
        multiKeyMap.put(key1, key2, key3, value1);
        multiKeyMap.put("key1", "key2", "key3", value2); // Same keys, different value

        // Assert
        Object oldValue = multiKeyMap.put(key1, key2, key3, value2);
        assertEquals(value1, oldValue); // The old value should be the first inserted value
    }

}