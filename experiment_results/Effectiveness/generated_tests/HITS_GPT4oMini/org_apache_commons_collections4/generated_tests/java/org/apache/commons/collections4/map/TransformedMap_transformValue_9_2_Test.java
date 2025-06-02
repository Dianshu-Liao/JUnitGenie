package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
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

public class TransformedMap_transformValue_9_2_Test {

    private TransformedMap<String, String> transformedMap;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    public void setUp() {
        valueTransformer = Mockito.mock(Transformer.class);
        transformedMap = new TransformedMap<>(new HashMap<>(), null, valueTransformer);
    }

    @Test
    public void testTransformValue_WithTransformer() {
        String input = "test";
        String expectedOutput = "TEST";
        Mockito.when(valueTransformer.apply(input)).thenReturn(expectedOutput);
        String result = transformedMap.transformValue(input);
        assertEquals(expectedOutput, result);
        verify(valueTransformer).apply(input);
    }

    @Test
    public void testTransformValue_WithoutTransformer() {
        transformedMap = new TransformedMap<>(new HashMap<>(), null, null);
        String input = "test";
        String result = transformedMap.transformValue(input);
        assertEquals(input, result);
    }

    @Test
    public void testTransformValue_NullInput_WithTransformer() {
        String expectedOutput = null;
        Mockito.when(valueTransformer.apply(null)).thenReturn(expectedOutput);
        String result = transformedMap.transformValue(null);
        assertEquals(expectedOutput, result);
        verify(valueTransformer).apply(null);
    }

    @Test
    public void testTransformValue_NullInput_WithoutTransformer() {
        transformedMap = new TransformedMap<>(new HashMap<>(), null, null);
        String result = transformedMap.transformValue(null);
        assertNull(result);
    }
}
