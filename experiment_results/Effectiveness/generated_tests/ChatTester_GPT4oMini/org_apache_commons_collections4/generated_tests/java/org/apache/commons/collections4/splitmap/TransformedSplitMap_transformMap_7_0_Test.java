package org.apache.commons.collections4.splitmap;

import java.lang.reflect.Method;
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
import java.util.Objects;
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

class TransformedSplitMap_transformMap_7_0_Test {

    private TransformedSplitMap<Object, String, Object, Integer> transformedSplitMap;

    @BeforeEach
    void setUp() {
        // Assuming we have appropriate transformers for the test
        Transformer<Object, String> keyTransformer = Object::toString;
        // Simple transformer for testing
        Transformer<Object, Integer> valueTransformer = obj -> 1;
        transformedSplitMap = new TransformedSplitMap<>(new HashMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    void testTransformMap_EmptyMap() {
        Map<Object, Object> emptyMap = new HashMap<>();
        Map<String, Integer> result = invokeTransformMap(emptyMap);
        assertTrue(result.isEmpty(), "Result should be an empty map");
    }

    @Test
    void testTransformMap_NonEmptyMap() {
        Map<Object, Object> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        Map<String, Integer> result = invokeTransformMap(inputMap);
        assertEquals(2, result.size(), "Result map should contain 2 entries");
        assertEquals(1, result.get("key1"), "Value for key1 should be transformed to 1");
        assertEquals(1, result.get("key2"), "Value for key2 should be transformed to 1");
    }

    @SuppressWarnings("unchecked")
    private Map<String, Integer> invokeTransformMap(Map<Object, Object> map) {
        try {
            Method method = TransformedSplitMap.class.getDeclaredMethod("transformMap", Map.class);
            method.setAccessible(true);
            return (Map<String, Integer>) method.invoke(transformedSplitMap, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
