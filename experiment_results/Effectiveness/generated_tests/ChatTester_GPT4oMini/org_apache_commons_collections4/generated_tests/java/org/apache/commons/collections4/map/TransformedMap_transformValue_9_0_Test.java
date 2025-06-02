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
import org.apache.commons.collections4.Transformer;

class TransformedMap_transformValue_9_0_Test {

    private TransformedMap<String, Integer> transformedMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<Integer, Integer> valueTransformer;

    @BeforeEach
    void setUp() {
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
    }

    @Test
    void testTransformValueWithNullTransformer() {
        // Create a TransformedMap with a null valueTransformer
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, null);
        Integer originalValue = 5;
        Integer transformedValue = transformedMap.transformValue(originalValue);
        assertEquals(originalValue, transformedValue, "Should return the original value when valueTransformer is null");
    }

    @Test
    void testTransformValueWithValidTransformer() {
        // Create a TransformedMap with a valid valueTransformer
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, valueTransformer);
        Integer originalValue = 5;
        Integer transformedValue = 10;
        when(valueTransformer.apply(originalValue)).thenReturn(transformedValue);
        Integer result = transformedMap.transformValue(originalValue);
        assertEquals(transformedValue, result, "Should return the transformed value when valueTransformer is present");
        verify(valueTransformer).apply(originalValue);
    }
}
