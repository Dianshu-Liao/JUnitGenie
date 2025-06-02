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

public class TransformedMap_transformMap_8_0_Test {

    private TransformedMap<String, Integer> transformedMap;

    @BeforeEach
    public void setUp() {
        // Initialize the TransformedMap with identity transformers for testing
        Transformer<String, String> keyTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                // Identity transformation
                return input;
            }
        };
        Transformer<Integer, Integer> valueTransformer = new Transformer<Integer, Integer>() {

            @Override
            public Integer transform(Integer input) {
                // Identity transformation
                return input;
            }
        };
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    public void testTransformMap_EmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        Map<String, Integer> resultMap = transformedMap.transformMap(inputMap);
        assertTrue(resultMap.isEmpty(), "Expected empty map when input is empty");
    }

    @Test
    public void testTransformMap_NonEmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("One", 1);
        inputMap.put("Two", 2);
        inputMap.put("Three", 3);
        Map<String, Integer> resultMap = transformedMap.transformMap(inputMap);
        assertEquals(3, resultMap.size(), "Expected size of the transformed map to be the same as input map");
        assertEquals(Integer.valueOf(1), resultMap.get("One"), "Expected value for key 'One' to be 1");
        assertEquals(Integer.valueOf(2), resultMap.get("Two"), "Expected value for key 'Two' to be 2");
        assertEquals(Integer.valueOf(3), resultMap.get("Three"), "Expected value for key 'Three' to be 3");
    }

    @Test
    public void testTransformMap_WithKeyTransformer() {
        Transformer<String, String> keyTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                // Transform keys to uppercase
                return input.toUpperCase();
            }
        };
        Transformer<Integer, Integer> valueTransformer = new Transformer<Integer, Integer>() {

            @Override
            public Integer transform(Integer input) {
                // Identity transformation for values
                return input;
            }
        };
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, valueTransformer);
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("one", 1);
        inputMap.put("two", 2);
        Map<String, Integer> resultMap = transformedMap.transformMap(inputMap);
        assertEquals(2, resultMap.size(), "Expected size of the transformed map to be the same as input map");
        assertEquals(Integer.valueOf(1), resultMap.get("ONE"), "Expected value for key 'ONE' to be 1");
        assertEquals(Integer.valueOf(2), resultMap.get("TWO"), "Expected value for key 'TWO' to be 2");
    }

    @Test
    public void testTransformMap_WithValueTransformer() {
        Transformer<String, String> keyTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                // Identity transformation for keys
                return input;
            }
        };
        Transformer<Integer, Integer> valueTransformer = new Transformer<Integer, Integer>() {

            @Override
            public Integer transform(Integer input) {
                // Transform values by doubling them
                return input * 2;
            }
        };
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, valueTransformer);
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("one", 1);
        inputMap.put("two", 2);
        Map<String, Integer> resultMap = transformedMap.transformMap(inputMap);
        assertEquals(2, resultMap.size(), "Expected size of the transformed map to be the same as input map");
        assertEquals(Integer.valueOf(2), resultMap.get("one"), "Expected value for key 'one' to be 2");
        assertEquals(Integer.valueOf(4), resultMap.get("two"), "Expected value for key 'two' to be 4");
    }
}
