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

class TransformedMap_transformValue_9_0_Test {

    private TransformedMap<String, Integer> transformedMap;

    @BeforeEach
    void setUp() {
        // Setting up a Transformer for values
        Transformer<Integer, Integer> valueTransformer = new Transformer<Integer, Integer>() {

            @Override
            public Integer transform(Integer input) {
                // Simple transformation: double the value
                return input != null ? input * 2 : null;
            }
        };
        // Create an instance of TransformedMap with a keyTransformer and a valueTransformer
        transformedMap = new TransformedMap<>(new HashMap<>(), null, valueTransformer);
    }

    @Test
    void testTransformValueWithTransformer() throws Exception {
        // Test the transformValue method with a non-null value
        Integer input = 5;
        // Expected output after transformation
        Integer expectedOutput = 10;
        Integer actualOutput = invokeTransformValue(transformedMap, input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testTransformValueWithNull() throws Exception {
        // Test the transformValue method with a null value
        Integer input = null;
        Integer actualOutput = invokeTransformValue(transformedMap, input);
        assertNull(actualOutput);
    }

    @Test
    void testTransformValueWithoutTransformer() throws Exception {
        // Create a TransformedMap without a value transformer
        transformedMap = new TransformedMap<>(new HashMap<>(), null, null);
        Integer input = 5;
        Integer actualOutput = invokeTransformValue(transformedMap, input);
        // Should return the input directly
        assertEquals(input, actualOutput);
    }

    // Reflection method to invoke the private transformValue method
    private Integer invokeTransformValue(TransformedMap<String, Integer> map, Integer value) throws Exception {
        java.lang.reflect.Method method = TransformedMap.class.getDeclaredMethod("transformValue", Object.class);
        method.setAccessible(true);
        return (Integer) method.invoke(map, value);
    }
}
