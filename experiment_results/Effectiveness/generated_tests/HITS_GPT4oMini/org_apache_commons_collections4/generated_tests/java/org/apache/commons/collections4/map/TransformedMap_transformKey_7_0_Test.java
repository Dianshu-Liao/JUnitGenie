package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
import java.util.HashMap;
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
import java.util.Map;

public class TransformedMap_transformKey_7_0_Test {

    private TransformedMap<String, String> transformedMap;

    @BeforeEach
    public void setUp() {
        // Setting up a Transformer that converts keys to upper case
        Transformer<String, String> keyTransformer = String::toUpperCase;
        transformedMap = new TransformedMap<>(new HashMap<>(), keyTransformer, null);
    }

    @Test
    public void testTransformKey_WithTransformer() {
        String inputKey = "testKey";
        String expectedOutputKey = "TESTKEY";
        String actualOutputKey = transformedMap.transformKey(inputKey);
        assertEquals(expectedOutputKey, actualOutputKey, "The transformed key should be in upper case.");
    }

    @Test
    public void testTransformKey_WithNullKeyTransformer() {
        // Testing with a null keyTransformer
        TransformedMap<String, String> noTransformerMap = new TransformedMap<>(new HashMap<>(), null, null);
        String inputKey = "testKey";
        String actualOutputKey = noTransformerMap.transformKey(inputKey);
        assertEquals(inputKey, actualOutputKey, "The key should remain unchanged when no transformer is applied.");
    }

    @Test
    public void testTransformKey_WithEmptyKey() {
        String inputKey = "";
        String expectedOutputKey = "";
        String actualOutputKey = transformedMap.transformKey(inputKey);
        assertEquals(expectedOutputKey, actualOutputKey, "The transformed key should remain empty.");
    }

    @Test
    public void testTransformKey_WithNullInput() {
        String actualOutputKey = transformedMap.transformKey(null);
        assertNull(actualOutputKey, "The transformed key should be null when input is null.");
    }
}
