package org.apache.commons.collections4.map;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransformedMap_transformValue_9_0_Test {

    @Test
    public void testTransformValue_WhenValueTransformerIsNull_ShouldReturnOriginalObject() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        TransformedMap<String, String> transformedMap = new TransformedMap<>(map, null, null);
        String originalValue = "testValue";
        // Act
        String result = transformedMap.transformValue(originalValue);
        // Assert
        assertEquals(originalValue, result, "Expected the original value to be returned when valueTransformer is null");
    }

    @Test
    public void testTransformValue_WhenValueTransformerIsNotNull_ShouldApplyTransformation() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        Transformer<String, String> valueTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                return input.toUpperCase();
            }
        };
        TransformedMap<String, String> transformedMap = new TransformedMap<>(map, null, valueTransformer);
        String originalValue = "testValue";
        // Act
        String result = transformedMap.transformValue(originalValue);
        // Assert
        assertEquals("TESTVALUE", result, "Expected the transformed value to be returned when valueTransformer is applied");
    }
}
