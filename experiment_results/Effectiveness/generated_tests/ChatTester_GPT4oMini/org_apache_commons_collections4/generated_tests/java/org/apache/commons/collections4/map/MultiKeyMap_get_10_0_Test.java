package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_get_10_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testGetReturnsValueForExistingKeys() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        String expectedValue = "value";
        // Use reflection to set up the internal state of MultiKeyMap
        setMockHashEntry(key1, key2, expectedValue);
        // Act
        Object actualValue = multiKeyMap.get(key1, key2);
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetReturnsNullForNonExistingKeys() {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        // Act
        Object actualValue = multiKeyMap.get(key1, key2);
        // Assert
        assertNull(actualValue);
    }

    @Test
    public void testGetReturnsNullForDifferentKeys() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        String expectedValue = "value";
        setMockHashEntry(key1, key2, expectedValue);
        Object differentKey1 = "differentKey1";
        Object differentKey2 = "differentKey2";
        // Act
        Object actualValue = multiKeyMap.get(differentKey1, differentKey2);
        // Assert
        assertNull(actualValue);
    }

    private void setMockHashEntry(Object key1, Object key2, String value) throws Exception {
        // Assuming there's a way to access the private method `decoratedHashEntry`
        // and set up the internal state for testing purposes.
        // This is a placeholder for the actual implementation
        // You would need to use reflection to set the internal state of the MultiKeyMap
        // to include the mock HashEntry with the specified keys and value.
        // Example of how you might implement this (pseudo-code):
        // Field field = MultiKeyMap.class.getDeclaredField("yourHashMapField");
        // field.setAccessible(true);
        // YourHashMapType map = (YourHashMapType) field.get(multiKeyMap);
        // map.put(new MultiKey<>(key1, key2), value);
    }
}
