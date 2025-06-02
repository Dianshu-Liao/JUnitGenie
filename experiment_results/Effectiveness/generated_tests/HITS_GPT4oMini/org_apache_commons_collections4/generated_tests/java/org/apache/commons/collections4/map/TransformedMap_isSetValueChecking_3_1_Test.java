package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Transformer;
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

public class TransformedMap_isSetValueChecking_3_1_Test {

    private TransformedMap<String, String> transformedMapWithTransformer;

    private TransformedMap<String, String> transformedMapWithoutTransformer;

    @BeforeEach
    public void setUp() {
        // Setting up a transformer
        Transformer<String, String> keyTransformer = input -> input.toUpperCase();
        Transformer<String, String> valueTransformer = input -> input.toLowerCase();
        // Initialize TransformedMap with a valueTransformer
        Map<String, String> mapWithTransformer = new HashMap<>();
        transformedMapWithTransformer = new TransformedMap<>(mapWithTransformer, keyTransformer, valueTransformer);
        // Initialize TransformedMap without a valueTransformer
        Map<String, String> mapWithoutTransformer = new HashMap<>();
        transformedMapWithoutTransformer = new TransformedMap<>(mapWithoutTransformer, keyTransformer, null);
    }

    @Test
    public void testIsSetValueChecking_WhenValueTransformerIsNotNull() {
        // Test when valueTransformer is initialized
        assertTrue(transformedMapWithTransformer.isSetValueChecking(), "Expected valueTransformer to be initialized.");
    }

    @Test
    public void testIsSetValueChecking_WhenValueTransformerIsNull() {
        // Test when valueTransformer is not initialized
        assertFalse(transformedMapWithoutTransformer.isSetValueChecking(), "Expected valueTransformer to be null.");
    }
}
