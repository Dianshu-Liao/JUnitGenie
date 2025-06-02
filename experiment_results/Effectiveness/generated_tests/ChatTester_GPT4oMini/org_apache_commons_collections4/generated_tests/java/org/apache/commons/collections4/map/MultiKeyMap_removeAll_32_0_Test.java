package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
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
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_removeAll_32_0_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<Object>, Object> mockMap;

    @BeforeEach
    public void setUp() {
        mockMap = mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockMap);
    }

    @Test
    public void testRemoveAll_KeysPresent() {
        // Setup
        MultiKey<Object> multiKey1 = new MultiKey<>(new Object[] { "key1", "key2", "key3" });
        MultiKey<Object> multiKey2 = new MultiKey<>(new Object[] { "key4", "key5", "key6" });
        when(mockMap.containsKey(multiKey1)).thenReturn(true);
        when(mockMap.containsKey(multiKey2)).thenReturn(true);
        // Mock the iterator behavior
        MapIterator<MultiKey<Object>, Object> iterator = mock(MapIterator.class);
        when(iterator.hasNext()).thenReturn(true, false);
        when(iterator.next()).thenReturn(multiKey1);
        when(mockMap.mapIterator()).thenReturn(iterator);
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        // Assert
        assertTrue(result);
        verify(iterator).remove();
    }

    @Test
    public void testRemoveAll_KeysNotPresent() {
        // Setup
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key4", "key5", "key6" });
        when(mockMap.containsKey(multiKey)).thenReturn(false);
        // Mock the iterator behavior
        MapIterator<MultiKey<Object>, Object> iterator = mock(MapIterator.class);
        when(iterator.hasNext()).thenReturn(true, false);
        when(iterator.next()).thenReturn(multiKey);
        when(mockMap.mapIterator()).thenReturn(iterator);
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        // Assert
        assertFalse(result);
        verify(iterator, never()).remove();
    }

    @Test
    public void testRemoveAll_EmptyMap() {
        // Mock the iterator behavior
        MapIterator<MultiKey<Object>, Object> iterator = mock(MapIterator.class);
        when(iterator.hasNext()).thenReturn(false);
        when(mockMap.mapIterator()).thenReturn(iterator);
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_MultipleKeys() {
        // Setup
        MultiKey<Object> multiKey1 = new MultiKey<>(new Object[] { "key1", "key2", "key3" });
        MultiKey<Object> multiKey2 = new MultiKey<>(new Object[] { "key1", "key2", "key3" });
        // Mock the iterator behavior
        MapIterator<MultiKey<Object>, Object> iterator = mock(MapIterator.class);
        when(iterator.hasNext()).thenReturn(true, true, false);
        when(iterator.next()).thenReturn(multiKey1, multiKey2);
        when(mockMap.mapIterator()).thenReturn(iterator);
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3");
        // Assert
        assertTrue(result);
        verify(iterator, times(2)).remove();
    }
}
