package org.apache.commons.collections4.splitmap;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;
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

class TransformedSplitMap_transformMap_7_3_Test {

    private TransformedSplitMap<String, String, String, String> transformedSplitMap;

    @BeforeEach
    void setUp() {
        Transformer<String, String> keyTransformer = String::toUpperCase;
        Transformer<String, String> valueTransformer = String::toLowerCase;
        transformedSplitMap = new TransformedSplitMap<>(new LinkedMap<>(), keyTransformer, valueTransformer);
    }

    @Test
    void testTransformMap_EmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertTrue(result.isEmpty());
    }

    @Test
    void testTransformMap_NonEmptyMap() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key1", "VALUE1");
        inputMap.put("key2", "VALUE2");
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertEquals(2, result.size());
        assertEquals("VALUE1", result.get("KEY1"));
        assertEquals("VALUE2", result.get("KEY2"));
    }

    @Test
    void testTransformMap_SingleEntry() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("key", "value");
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertEquals(1, result.size());
        assertEquals("value", result.get("KEY"));
    }

    @Test
    void testTransformMap_NullKeyValue() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put(null, null);
        Map<String, String> result = transformedSplitMap.transformMap(inputMap);
        assertEquals(1, result.size());
        assertEquals(null, result.get(null));
    }
}
