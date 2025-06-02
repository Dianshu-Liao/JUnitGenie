package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_containsKey_3_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WithExistingKeys_ReturnsTrue() throws Exception {
        // Arrange
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key1", "key2" });
        multiKeyMap.put(multiKey, "value");
        // Act
        boolean result = multiKeyMap.containsKey("key1", "key2");
        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsKey_WithNonExistingKeys_ReturnsFalse() throws Exception {
        // Act
        boolean result = multiKeyMap.containsKey("key1", "key2");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsKey_WithNullKeys_ReturnsFalse() throws Exception {
        // Act
        boolean result = multiKeyMap.containsKey(null, null);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsKey_WithOneNullKey_ReturnsFalse() throws Exception {
        // Arrange
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key1", "key2" });
        multiKeyMap.put(multiKey, "value");
        // Act
        boolean resultWithNullKey1 = multiKeyMap.containsKey(null, "key2");
        boolean resultWithNullKey2 = multiKeyMap.containsKey("key1", null);
        // Assert
        assertFalse(resultWithNullKey1);
        assertFalse(resultWithNullKey2);
    }

    @Test
    public void testContainsKey_WithDifferentKeys_ReturnsFalse() throws Exception {
        // Arrange
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key1", "key2" });
        multiKeyMap.put(multiKey, "value");
        // Act
        boolean result = multiKeyMap.containsKey("key1", "key3");
        // Assert
        assertFalse(result);
    }

    // Reflection test to access private method
    @Test
    public void testContainsKey_ReflectionAccess() throws Exception {
        // Arrange
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key1", "key2" });
        multiKeyMap.put(multiKey, "value");
        // Act
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (boolean) containsKeyMethod.invoke(multiKeyMap, "key1", "key2");
        // Assert
        assertTrue(result);
    }
}
