package org.apache.commons.collections4.map;

import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TransformedMap_transformKey_7_0_Test {

    private TransformedMap<String, String> transformedMap;

    private Transformer<String, String> mockKeyTransformer;

    @BeforeEach
    public void setUp() {
        mockKeyTransformer = mock(Transformer.class);
    }

    @Test
    public void testTransformKeyWithNullTransformer() {
        // Arrange
        transformedMap = new TransformedMap<>(null, null, null);
        // Act
        String result = invokeTransformKey(transformedMap, "originalKey");
        // Assert
        assertEquals("originalKey", result);
    }

    @Test
    public void testTransformKeyWithValidTransformer() {
        // Arrange
        when(mockKeyTransformer.apply("originalKey")).thenReturn("transformedKey");
        transformedMap = new TransformedMap<>(null, mockKeyTransformer, null);
        // Act
        String result = invokeTransformKey(transformedMap, "originalKey");
        // Assert
        assertEquals("transformedKey", result);
        verify(mockKeyTransformer).apply("originalKey");
    }

    @Test
    public void testTransformKeyWithDifferentKey() {
        // Arrange
        when(mockKeyTransformer.apply("anotherKey")).thenReturn("anotherTransformedKey");
        transformedMap = new TransformedMap<>(null, mockKeyTransformer, null);
        // Act
        String result = invokeTransformKey(transformedMap, "anotherKey");
        // Assert
        assertEquals("anotherTransformedKey", result);
        verify(mockKeyTransformer).apply("anotherKey");
    }

    private <K> K invokeTransformKey(TransformedMap<K, ?> transformedMap, K key) {
        try {
            // Repaired line
            java.lang.reflect.Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
            method.setAccessible(true);
            return (K) method.invoke(transformedMap, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
