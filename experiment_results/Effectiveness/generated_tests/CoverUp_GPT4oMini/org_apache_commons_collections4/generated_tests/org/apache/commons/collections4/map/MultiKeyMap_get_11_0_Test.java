package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Field;
import java.util.HashMap;
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

public class MultiKeyMap_get_11_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testGetReturnsValueForExistingKeys() throws Exception {
        // Arrange
        MultiKey<String> multiKey = new MultiKey<>("key1", "key2", "key3");
        setField(multiKeyMap, "map", new HashMap<>());
        multiKeyMap.put(multiKey, "value");
        // Act
        String result = multiKeyMap.get("key1", "key2", "key3");
        // Assert
        assertEquals("value", result);
    }

    @Test
    public void testGetReturnsNullForNonExistingKeys() throws Exception {
        // Act
        String result = multiKeyMap.get("nonExistingKey1", "nonExistingKey2", "nonExistingKey3");
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetReturnsNullForNullKeys() throws Exception {
        // Arrange
        MultiKey<String> multiKey = new MultiKey<>("key1", "key2", "key3");
        setField(multiKeyMap, "map", new HashMap<>());
        multiKeyMap.put(multiKey, "value");
        // Act
        String result = multiKeyMap.get(null, null, null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetReturnsNullForPartialKeyMatch() throws Exception {
        // Arrange
        MultiKey<String> multiKey = new MultiKey<>("key1", "key2", "key3");
        setField(multiKeyMap, "map", new HashMap<>());
        multiKeyMap.put(multiKey, "value");
        // Act
        String result = multiKeyMap.get("key1", "key2", "differentKey");
        // Assert
        assertNull(result);
    }

    private void setField(MultiKeyMap<String, String> map, String fieldName, Object value) throws Exception {
        Field field = MultiKeyMap.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(map, value);
    }
}
