package org.apache.commons.collections4.splitmap;

import org.apache.commons.collections4.Transformer;
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
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.map.LinkedMap;

public class TransformedSplitMap_transformMap_7_0_Test {

    private TransformedSplitMap transformedSplitMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<Integer, String> valueTransformer;

    @BeforeEach
    public void setUp() {
        keyTransformer = Mockito.mock(Transformer.class);
        valueTransformer = Mockito.mock(Transformer.class);
        transformedSplitMap = new TransformedSplitMap(new HashMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    public void testTransformMap_EmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertTrue(result.isEmpty(), "The result should be an empty map for an empty input map.");
    }

    @Test
    public void testTransformMap_NonEmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("one", 1);
        inputMap.put("two", 2);
        Mockito.when(keyTransformer.apply("one")).thenReturn("ONE");
        Mockito.when(keyTransformer.apply("two")).thenReturn("TWO");
        Mockito.when(valueTransformer.apply(1)).thenReturn("One");
        Mockito.when(valueTransformer.apply(2)).thenReturn("Two");
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertEquals(2, result.size(), "The result should contain two entries.");
        assertEquals("One", result.get("ONE"), "The value for key 'ONE' should be 'One'.");
        assertEquals("Two", result.get("TWO"), "The value for key 'TWO' should be 'Two'.");
    }

    @Test
    public void testTransformMap_SingleEntryMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("single", 1);
        Mockito.when(keyTransformer.apply("single")).thenReturn("SINGLE");
        Mockito.when(valueTransformer.apply(1)).thenReturn("Single");
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertEquals(1, result.size(), "The result should contain one entry.");
        assertEquals("Single", result.get("SINGLE"), "The value for key 'SINGLE' should be 'Single'.");
    }

    @Test
    public void testTransformMap_NullKeyTransformer() {
        Exception exception = null;
        try {
            transformedSplitMap = new TransformedSplitMap(new HashMap<>(), null, valueTransformer);
        } catch (NullPointerException e) {
            exception = e;
        }
        assertEquals("keyTransformer", exception.getMessage());
    }

    @Test
    public void testTransformMap_NullValueTransformer() {
        Exception exception = null;
        try {
            transformedSplitMap = new TransformedSplitMap(new HashMap<>(), keyTransformer, null);
        } catch (NullPointerException e) {
            exception = e;
        }
        assertEquals("valueTransformer", exception.getMessage());
    }
}
