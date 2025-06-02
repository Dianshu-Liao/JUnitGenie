package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
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

class TransformedMap_transformMap_8_1_Test {

    private TransformedMap<String, Integer> transformedMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<Integer, Integer> valueTransformer;

    @BeforeEach
    void setUp() {
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    void testTransformMap_EmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        Map<String, Integer> result = transformedMap.transformMap(inputMap);
        assertSame(inputMap, result, "Transforming an empty map should return the same map.");
    }

    @Test
    void testTransformMap_NonEmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("key1", 1);
        inputMap.put("key2", 2);
        when(keyTransformer.apply("key1")).thenReturn("transformedKey1");
        when(keyTransformer.apply("key2")).thenReturn("transformedKey2");
        when(valueTransformer.apply(1)).thenReturn(10);
        when(valueTransformer.apply(2)).thenReturn(20);
        Map<String, Integer> result = transformedMap.transformMap(inputMap);
        assertEquals(2, result.size(), "The result map should have the same number of entries.");
        assertEquals(10, result.get("transformedKey1"), "The value for transformed key1 should be 10.");
        assertEquals(20, result.get("transformedKey2"), "The value for transformed key2 should be 20.");
    }

    @Test
    void testTransformMap_NullTransformers() {
        TransformedMap<String, Integer> mapWithNullTransformers = new TransformedMap<>(new HashMap<>(), null, null);
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("key1", 1);
        inputMap.put("key2", 2);
        Map<String, Integer> result = mapWithNullTransformers.transformMap(inputMap);
        assertEquals(2, result.size(), "The result map should have the same number of entries.");
        assertEquals(1, result.get("key1"), "The value for key1 should be 1.");
        assertEquals(2, result.get("key2"), "The value for key2 should be 2.");
    }
}
