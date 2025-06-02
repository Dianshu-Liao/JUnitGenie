package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
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

class TransformedMap_transformKey_7_0_Test {

    private TransformedMap<String, String> transformedMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    void setUp() {
        keyTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                return input == null ? null : input.toUpperCase();
            }
        };
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, null);
    }

    @Test
    void testTransformKeyWithTransformer() throws Exception {
        String input = "test";
        String expected = "TEST";
        // Using reflection to access the private method
        Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedMap, input);
        assertEquals(expected, result);
    }

    @Test
    void testTransformKeyWithNull() throws Exception {
        String expected = null;
        // Using reflection to access the private method
        Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedMap, null);
        assertEquals(expected, result);
    }

    @Test
    void testTransformKeyWithoutTransformer() throws Exception {
        transformedMap = new TransformedMap<>(new HashMap<>(), null, null);
        String input = "test";
        // Using reflection to access the private method
        Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
        method.setAccessible(true);
        String result = (String) method.invoke(transformedMap, input);
        assertEquals(input, result);
    }
}
