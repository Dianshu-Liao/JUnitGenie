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

class TransformedMap_isSetValueChecking_3_0_Test {

    private TransformedMap<String, String> transformedMapWithTransformer;

    private TransformedMap<String, String> transformedMapWithoutTransformer;

    private static class DummyTransformer<T> implements Transformer<T, T> {

        @Override
        public T transform(T input) {
            // No-op transformer for testing
            return input;
        }
    }

    @BeforeEach
    void setUp() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        // Create TransformedMap with a value transformer
        transformedMapWithTransformer = new TransformedMap<>(map, new DummyTransformer<>(), new DummyTransformer<>());
        // Create TransformedMap without a value transformer
        transformedMapWithoutTransformer = new TransformedMap<>(map, new DummyTransformer<>(), null);
    }

    @Test
    void testIsSetValueChecking_WithTransformer() {
        // Test when valueTransformer is not null
        boolean result = invokeIsSetValueChecking(transformedMapWithTransformer);
        assertTrue(result, "Expected isSetValueChecking to return true when valueTransformer is set.");
    }

    @Test
    void testIsSetValueChecking_WithoutTransformer() {
        // Test when valueTransformer is null
        boolean result = invokeIsSetValueChecking(transformedMapWithoutTransformer);
        assertFalse(result, "Expected isSetValueChecking to return false when valueTransformer is not set.");
    }

    private boolean invokeIsSetValueChecking(TransformedMap<String, String> transformedMap) {
        try {
            java.lang.reflect.Method method = TransformedMap.class.getDeclaredMethod("isSetValueChecking");
            method.setAccessible(true);
            return (boolean) method.invoke(transformedMap);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke isSetValueChecking method", e);
        }
    }
}
