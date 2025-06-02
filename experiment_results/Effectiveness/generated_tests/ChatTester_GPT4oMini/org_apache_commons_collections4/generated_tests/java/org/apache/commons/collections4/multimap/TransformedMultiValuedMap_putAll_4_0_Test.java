package org.apache.commons.collections4.multimap;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

public class TransformedMultiValuedMap_putAll_4_0_Test {

    private TransformedMultiValuedMap<String, String> transformedMap;

    private MultiValuedMap<String, String> mockMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    public void setUp() {
        mockMap = mock(MultiValuedMap.class);
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
        transformedMap = new TransformedMultiValuedMap<>(mockMap, keyTransformer, valueTransformer);
    }

    @Test
    public void testPutAll_WithNullMap_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> transformedMap.putAll((Map<String, String>) null));
    }

    @Test
    public void testPutAll_WithEmptyMap_ShouldReturnFalse() {
        Map<String, String> emptyMap = new HashMap<>();
        boolean result = transformedMap.putAll(emptyMap);
        assertFalse(result);
    }

    @Test
    public void testPutAll_WithNonEmptyMap_ShouldReturnTrue_WhenEntriesChanged() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        when(mockMap.put("key1", "value1")).thenReturn(false);
        when(mockMap.put("key2", "value2")).thenReturn(false);
        boolean result = transformedMap.putAll(inputMap);
        assertTrue(result);
    }

    @Test
    public void testPutAll_WithNonEmptyMap_ShouldReturnFalse_WhenNoEntriesChanged() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        when(mockMap.put("key1", "value1")).thenReturn(false);
        when(mockMap.put("key2", "value2")).thenReturn(false);
        boolean result = transformedMap.putAll(inputMap);
        assertFalse(result);
    }

    @Test
    public void testPutAll_WithMixedResults_ShouldReturnTrue() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        when(mockMap.put("key1", "value1")).thenReturn(false);
        when(mockMap.put("key2", "value2")).thenReturn(true);
        boolean result = transformedMap.putAll(inputMap);
        assertTrue(result);
    }
}
