package org.apache.commons.collections4.multimap;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransformedMultiValuedMap_putAll_5_0_Test {

    private TransformedMultiValuedMap<String, String> transformedMap;

    private MultiValuedMap<String, String> mockMap;

    @BeforeEach
    public void setUp() {
        mockMap = mock(MultiValuedMap.class);
        transformedMap = new TransformedMultiValuedMap<>(mockMap, key -> key.toUpperCase(), value -> value.toLowerCase());
    }

    @Test
    public void testPutAll_NullMap() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            transformedMap.putAll((MultiValuedMap<String, String>) null);
        });
        assertEquals("map", exception.getMessage());
    }

    @Test
    public void testPutAll_EmptyMap() {
        when(mockMap.entries()).thenReturn(new HashMap<String, String>().entrySet());
        boolean result = transformedMap.putAll(mockMap);
        assertFalse(result);
    }

    @Test
    public void testPutAll_NonEmptyMap() {
        Map<String, String> entryMap = new HashMap<>();
        entryMap.put("key1", "value1");
        entryMap.put("key2", "value2");
        when(mockMap.entries()).thenReturn(entryMap.entrySet());
        // Mock the put method to return true for the first call and false for the second
        when(transformedMap.put("KEY1", "value1")).thenReturn(true);
        when(transformedMap.put("KEY2", "value2")).thenReturn(false);
        boolean result = transformedMap.putAll(mockMap);
        assertTrue(result);
        verify(transformedMap, times(1)).put("KEY1", "value1");
        verify(transformedMap, times(1)).put("KEY2", "value2");
    }

    @Test
    public void testPutAll_SomeEntriesChanged() {
        Map<String, String> entryMap = new HashMap<>();
        entryMap.put("key1", "value1");
        entryMap.put("key2", "value2");
        when(mockMap.entries()).thenReturn(entryMap.entrySet());
        // Mock the put method to return true for the first call and false for the second
        when(transformedMap.put("KEY1", "value1")).thenReturn(true);
        when(transformedMap.put("KEY2", "value2")).thenReturn(false);
        boolean result = transformedMap.putAll(mockMap);
        assertTrue(result);
    }

    @Test
    public void testPutAll_AllEntriesChanged() {
        Map<String, String> entryMap = new HashMap<>();
        entryMap.put("key1", "value1");
        entryMap.put("key2", "value2");
        when(mockMap.entries()).thenReturn(entryMap.entrySet());
        // Mock the put method to return true for both calls
        when(transformedMap.put("KEY1", "value1")).thenReturn(true);
        when(transformedMap.put("KEY2", "value2")).thenReturn(true);
        boolean result = transformedMap.putAll(mockMap);
        assertTrue(result);
        verify(transformedMap, times(1)).put("KEY1", "value1");
        verify(transformedMap, times(1)).put("KEY2", "value2");
    }
}
