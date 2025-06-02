package org.apache.commons.collections4.map;

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

public class TransformedMap_isSetValueChecking_3_1_Test {

    private static class DummyTransformer<T> implements Transformer<T, T> {

        @Override
        public T transform(T input) {
            // Identity transformation for testing
            return input;
        }
    }

    @Test
    public void testIsSetValueCheckingWithNullValueTransformer() throws Exception {
        // Arrange
        Map<String, String> map = new HashMap<>();
        TransformedMap<String, String> transformedMap = new TransformedMap<>(map, new DummyTransformer<>(), null);
        // Act
        boolean result = invokeIsSetValueChecking(transformedMap);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsSetValueCheckingWithNonNullValueTransformer() throws Exception {
        // Arrange
        Map<String, String> map = new HashMap<>();
        TransformedMap<String, String> transformedMap = new TransformedMap<>(map, new DummyTransformer<>(), new DummyTransformer<>());
        // Act
        boolean result = invokeIsSetValueChecking(transformedMap);
        // Assert
        assertTrue(result);
    }

    // Reflection method to invoke the private isSetValueChecking method
    private boolean invokeIsSetValueChecking(TransformedMap<?, ?> transformedMap) throws Exception {
        java.lang.reflect.Method method = TransformedMap.class.getDeclaredMethod("isSetValueChecking");
        method.setAccessible(true);
        return (Boolean) method.invoke(transformedMap);
    }
}
