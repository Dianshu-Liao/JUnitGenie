package org.apache.commons.collections4.multimap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;

@ExtendWith(MockitoExtension.class)
class TransformedMultiValuedMap_putAll_4_4_Test {

    private TransformedMultiValuedMap<String, String> transformedMap;

    private MultiValuedMap<String, String> multiValuedMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    void setUp() {
        multiValuedMap = mock(MultiValuedMap.class);
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
        transformedMap = new TransformedMultiValuedMap<>(multiValuedMap, keyTransformer, valueTransformer);
    }

    @Test
    void testPutAll_NonEmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        when(multiValuedMap.put(anyString(), anyString())).thenReturn(false).thenReturn(true);
        boolean result = invokePutAll(inputMap);
        assertTrue(result);
        verify(multiValuedMap, times(2)).put(anyString(), anyString());
    }

    @Test
    void testPutAll_EmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        boolean result = invokePutAll(inputMap);
        assertFalse(result);
        verify(multiValuedMap, never()).put(anyString(), anyString());
    }

    @Test
    void testPutAll_NullMap() {
        assertThrows(NullPointerException.class, () -> {
            invokePutAll(null);
        });
    }

    @Test
    void testPutAll_SingleElementMap() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        when(multiValuedMap.put(anyString(), anyString())).thenReturn(false);
        boolean result = invokePutAll(inputMap);
        assertFalse(result);
        verify(multiValuedMap, times(1)).put(anyString(), anyString());
    }

    @SuppressWarnings("unchecked")
    private boolean invokePutAll(Map<String, String> map) {
        try {
            return (boolean) TransformedMultiValuedMap.class.getDeclaredMethod("putAll", Map.class).invoke(transformedMap, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
