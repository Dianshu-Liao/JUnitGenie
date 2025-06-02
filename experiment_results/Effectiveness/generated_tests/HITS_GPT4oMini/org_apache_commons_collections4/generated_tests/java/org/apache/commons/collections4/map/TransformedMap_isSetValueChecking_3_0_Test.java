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

public class TransformedMap_isSetValueChecking_3_0_Test {

    private TransformedMap<String, String> transformedMapWithTransformer;

    private TransformedMap<String, String> transformedMapWithoutTransformer;

    @BeforeEach
    public void setUp() {
        // Create a transformer that simply returns the input value (identity transformer)
        Transformer<String, String> identityTransformer = input -> input;
        // Initialize the TransformedMap with a value transformer
        Map<String, String> mapWithTransformer = new HashMap<>();
        transformedMapWithTransformer = new TransformedMap<>(mapWithTransformer, null, identityTransformer);
        // Initialize the TransformedMap without a value transformer
        Map<String, String> mapWithoutTransformer = new HashMap<>();
        transformedMapWithoutTransformer = new TransformedMap<>(mapWithoutTransformer, null, null);
    }

    @Test
    public void testIsSetValueChecking_WithTransformer() {
        // Test the method when valueTransformer is not null
        assertTrue(transformedMapWithTransformer.isSetValueChecking(), "Expected isSetValueChecking() to return true when valueTransformer is not null");
    }

    @Test
    public void testIsSetValueChecking_WithoutTransformer() {
        // Test the method when valueTransformer is null
        assertFalse(transformedMapWithoutTransformer.isSetValueChecking(), "Expected isSetValueChecking() to return false when valueTransformer is null");
    }
}
