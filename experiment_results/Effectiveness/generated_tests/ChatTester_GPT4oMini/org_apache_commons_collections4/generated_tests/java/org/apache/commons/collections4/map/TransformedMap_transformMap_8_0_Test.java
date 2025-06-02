package org.apache.commons.collections4.map;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TransformedMap_transformMap_8_0_Test {

    private TransformedMap<String, String> transformedMap;

    @BeforeEach
    void setUp() {
        // Mocking the Transformer behavior
        Transformer<String, String> keyTransformer = mock(Transformer.class);
        Transformer<String, String> valueTransformer = mock(Transformer.class);
        when(keyTransformer.transform(anyString())).thenAnswer(invocation -> "key_" + invocation.getArgument(0));
        when(valueTransformer.transform(anyString())).thenAnswer(invocation -> "value_" + invocation.getArgument(0));
        transformedMap = new TransformedMap<>(new LinkedHashMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    void testTransformMap_EmptyMap() {
        Map<String, String> inputMap = new LinkedHashMap<>();
        Map<String, String> result = invokeTransformMap(inputMap);
        assertSame(inputMap, result);
    }

    @Test
    void testTransformMap_NonEmptyMap() {
        Map<String, String> inputMap = new LinkedHashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");
        Map<String, String> result = invokeTransformMap(inputMap);
        assertEquals(2, result.size());
        assertEquals("key_key1", result.keySet().toArray()[0]);
        assertEquals("value_value1", result.values().toArray()[0]);
        assertEquals("key_key2", result.keySet().toArray()[1]);
        assertEquals("value_value2", result.values().toArray()[1]);
    }

    @Test
    void testTransformMap_SingleEntry() {
        Map<String, String> inputMap = new LinkedHashMap<>();
        inputMap.put("key3", "value3");
        Map<String, String> result = invokeTransformMap(inputMap);
        assertEquals(1, result.size());
        assertEquals("key_key3", result.keySet().iterator().next());
        assertEquals("value_value3", result.values().iterator().next());
    }

    @Test
    void testTransformMap_MultipleEntries() {
        Map<String, String> inputMap = new LinkedHashMap<>();
        inputMap.put("key4", "value4");
        inputMap.put("key5", "value5");
        inputMap.put("key6", "value6");
        Map<String, String> result = invokeTransformMap(inputMap);
        assertEquals(3, result.size());
        assertEquals("key_key4", result.keySet().toArray()[0]);
        assertEquals("value_value4", result.values().toArray()[0]);
        assertEquals("key_key5", result.keySet().toArray()[1]);
        assertEquals("value_value5", result.values().toArray()[1]);
        assertEquals("key_key6", result.keySet().toArray()[2]);
        assertEquals("value_value6", result.values().toArray()[2]);
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> invokeTransformMap(Map<String, String> map) {
        try {
            // Repaired the buggy line by replacing 'var' with 'java.lang.reflect.Method'
            java.lang.reflect.Method method = TransformedMap.class.getDeclaredMethod("transformMap", Map.class);
            method.setAccessible(true);
            return (Map<String, String>) method.invoke(transformedMap, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
