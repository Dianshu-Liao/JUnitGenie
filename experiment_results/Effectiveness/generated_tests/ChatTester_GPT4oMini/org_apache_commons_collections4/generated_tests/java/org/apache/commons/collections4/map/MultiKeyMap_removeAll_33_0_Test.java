package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_removeAll_33_0_Test {

    private MultiKeyMap multiKeyMap;

    @Mock
    private AbstractHashedMap<MultiKey<Object>, Object> mockMap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        multiKeyMap = new MultiKeyMap(mockMap);
    }

    @Test
    public void testRemoveAll_KeysFound() {
        // Setup
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "key1", "key2", "key3", "key4" });
        when(mockMap.containsKey(multiKey)).thenReturn(true);
        when(mockMap.get(multiKey)).thenReturn(new Object());
        // Invoke the method
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        // Verify
        assertTrue(result);
        verify(mockMap, times(1)).remove(multiKey);
    }

    @Test
    public void testRemoveAll_KeysNotFound() {
        // Setup
        when(mockMap.containsKey(any())).thenReturn(false);
        // Invoke the method
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        // Verify
        assertFalse(result);
        verify(mockMap, never()).remove(any());
    }

    @Test
    public void testRemoveAll_MultipleKeys() {
        // Setup
        MultiKey<Object> multiKey1 = new MultiKey<>(new Object[] { "key1", "key2", "key3", "key4" });
        MultiKey<Object> multiKey2 = new MultiKey<>(new Object[] { "key1", "key2", "key3", "key4" });
        when(mockMap.containsKey(multiKey1)).thenReturn(true);
        when(mockMap.get(multiKey1)).thenReturn(new Object());
        when(mockMap.containsKey(multiKey2)).thenReturn(true);
        when(mockMap.get(multiKey2)).thenReturn(new Object());
        // Invoke the method
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        // Verify
        assertTrue(result);
        verify(mockMap, times(1)).remove(multiKey1);
        verify(mockMap, times(1)).remove(multiKey2);
    }

    @Test
    public void testRemoveAll_EmptyMap() {
        // Setup
        when(mockMap.isEmpty()).thenReturn(true);
        // Invoke the method
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        // Verify
        assertFalse(result);
        verify(mockMap, never()).remove(any());
    }

    @Test
    public void testRemoveAll_NonMatchingKeys() {
        // Setup
        MultiKey<Object> multiKey = new MultiKey<>(new Object[] { "wrongKey1", "wrongKey2", "wrongKey3", "wrongKey4" });
        when(mockMap.containsKey(multiKey)).thenReturn(true);
        // Invoke the method
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        // Verify
        assertFalse(result);
        verify(mockMap, never()).remove(multiKey);
    }
}
