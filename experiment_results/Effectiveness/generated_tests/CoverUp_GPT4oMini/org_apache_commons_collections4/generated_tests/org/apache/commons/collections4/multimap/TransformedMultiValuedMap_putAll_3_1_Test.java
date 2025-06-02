package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;

class TransformedMultiValuedMap_putAll_3_1_Test {

    private TransformedMultiValuedMap<String, String> transformedMultiValuedMap;

    private MultiValuedMap<String, String> multiValuedMapMock;

    private Transformer<String, String> keyTransformer;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    void setUp() {
        multiValuedMapMock = mock(MultiValuedMap.class);
        keyTransformer = (key) -> "transformed_" + key;
        valueTransformer = (value) -> "transformed_" + value;
        transformedMultiValuedMap = new TransformedMultiValuedMap<>(multiValuedMapMock, keyTransformer, valueTransformer);
    }

    @Test
    void testPutAllWithNonEmptyIterable() {
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        when(multiValuedMapMock.get("transformed_key")).thenReturn(new ArrayList<>());
        boolean result = transformedMultiValuedMap.putAll("key", values);
        assertTrue(result);
        verify(multiValuedMapMock).get("transformed_key");
        verify(multiValuedMapMock, times(2)).put("transformed_key", "transformed_value1");
        verify(multiValuedMapMock, times(2)).put("transformed_key", "transformed_value2");
    }

    @Test
    void testPutAllWithEmptyIterable() {
        List<String> values = new ArrayList<>();
        boolean result = transformedMultiValuedMap.putAll("key", values);
        assertFalse(result);
        verify(multiValuedMapMock, never()).get(anyString());
    }

    @Test
    void testPutAllWithNullValues() {
        assertThrows(NullPointerException.class, () -> transformedMultiValuedMap.putAll("key", null));
    }

    @Test
    void testPutAllWithSingleValue() {
        List<String> values = new ArrayList<>();
        values.add("value1");
        when(multiValuedMapMock.get("transformed_key")).thenReturn(new ArrayList<>());
        boolean result = transformedMultiValuedMap.putAll("key", values);
        assertTrue(result);
        verify(multiValuedMapMock).get("transformed_key");
        verify(multiValuedMapMock, times(1)).put("transformed_key", "transformed_value1");
    }

    @Test
    void testPutAllWithKeyTransformerNull() {
        // Create a TransformedMultiValuedMap with a null key transformer
        TransformedMultiValuedMap<String, String> mapWithNullKeyTransformer = new TransformedMultiValuedMap<>(multiValuedMapMock, null, valueTransformer);
        List<String> values = new ArrayList<>();
        values.add("value1");
        boolean result = mapWithNullKeyTransformer.putAll("key", values);
        assertTrue(result);
        verify(multiValuedMapMock).get("key");
        verify(multiValuedMapMock, times(1)).put("key", "transformed_value1");
    }
}
