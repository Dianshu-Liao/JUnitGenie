package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Predicate;
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

public class PredicatedMap_putAll_4_2_Test {

    private PredicatedMap<String, String> predicatedMap;

    private Map<String, String> mockMap;

    @BeforeEach
    public void setUp() {
        // Using the correct Predicate type from org.apache.commons.collections4
        Predicate<String> keyPredicate = key -> key != null && !key.isEmpty();
        Predicate<String> valuePredicate = value -> value != null && !value.isEmpty();
        mockMap = mock(Map.class);
        predicatedMap = new PredicatedMap<>(mockMap, keyPredicate, valuePredicate);
    }

    @Test
    public void testPutAll_ValidEntries() {
        Map<String, String> mapToCopy = new HashMap<>();
        mapToCopy.put("key1", "value1");
        mapToCopy.put("key2", "value2");
        when(mockMap.entrySet()).thenReturn(mapToCopy.entrySet());
        predicatedMap.putAll(mapToCopy);
        verify(mockMap, times(1)).putAll(mapToCopy);
    }

    @Test
    public void testPutAll_InvalidKey() {
        Map<String, String> mapToCopy = new HashMap<>();
        // Invalid key
        mapToCopy.put(null, "value1");
        when(mockMap.entrySet()).thenReturn(mapToCopy.entrySet());
        assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(mapToCopy);
        });
        verify(mockMap, never()).putAll(any());
    }

    @Test
    public void testPutAll_InvalidValue() {
        Map<String, String> mapToCopy = new HashMap<>();
        // Invalid value
        mapToCopy.put("key1", null);
        when(mockMap.entrySet()).thenReturn(mapToCopy.entrySet());
        assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(mapToCopy);
        });
        verify(mockMap, never()).putAll(any());
    }

    @Test
    public void testPutAll_EmptyMap() {
        // Empty map
        Map<String, String> mapToCopy = new HashMap<>();
        when(mockMap.entrySet()).thenReturn(mapToCopy.entrySet());
        predicatedMap.putAll(mapToCopy);
        verify(mockMap, times(1)).putAll(mapToCopy);
    }

    @Test
    public void testPutAll_NonEmptyMapWithInvalidEntries() {
        Map<String, String> mapToCopy = new HashMap<>();
        mapToCopy.put("key1", "value1");
        // Invalid key
        mapToCopy.put(null, "value2");
        when(mockMap.entrySet()).thenReturn(mapToCopy.entrySet());
        assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(mapToCopy);
        });
        verify(mockMap, never()).putAll(any());
    }
}
