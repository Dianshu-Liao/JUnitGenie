package org.apache.commons.collections4.multimap;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

public class TransformedMultiValuedMap_putAll_4_2_Test {

    private TransformedMultiValuedMap<String, String> transformedMultiValuedMap;

    @BeforeEach
    public void setUp() {
        MultiValuedMap<String, String> decoratedMap = mock(MultiValuedMap.class);
        transformedMultiValuedMap = new TransformedMultiValuedMap<>(decoratedMap, key -> key, value -> value);
    }

    @Test
    public void testPutAllWithNonEmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        // Mocking the behavior of the decorated map
        when(transformedMultiValuedMap.put("key1", "value1")).thenReturn(true);
        when(transformedMultiValuedMap.put("key2", "value2")).thenReturn(true);
        boolean changed = transformedMultiValuedMap.putAll(inputMap);
        assertTrue(changed);
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        boolean changed = transformedMultiValuedMap.putAll(inputMap);
        assertFalse(changed);
    }

    @Test
    public void testPutAllWithNullMap() {
        Map<String, String> inputMap = null;
        try {
            transformedMultiValuedMap.putAll(inputMap);
        } catch (NullPointerException e) {
            assertTrue(e.getMessage().contains("map"));
        }
    }

    @Test
    public void testPutAllWithMixedResults() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        // Mocking the behavior of the decorated map
        when(transformedMultiValuedMap.put("key1", "value1")).thenReturn(true);
        when(transformedMultiValuedMap.put("key2", "value2")).thenReturn(false);
        boolean changed = transformedMultiValuedMap.putAll(inputMap);
        assertTrue(changed);
    }
}
