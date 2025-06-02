package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;

public class TransformedMultiValuedMap_transformValue_7_0_Test {

    @Test
    public void testTransformValueWithNullTransformer() {
        MultiValuedMap<String, String> multiValuedMap = new ArrayListValuedHashMap<>();
        Transformer<String, String> keyTransformer = null;
        Transformer<String, String> valueTransformer = null;
        TransformedMultiValuedMap<String, String> transformedMap = new TransformedMultiValuedMap<>(multiValuedMap, keyTransformer, valueTransformer);
        String result = transformedMap.transformValue("testValue");
        assertEquals("testValue", result, "Expected value should be unchanged when transformer is null");
    }

    @Test
    public void testTransformValueWithTransformer() {
        MultiValuedMap<String, String> multiValuedMap = new ArrayListValuedHashMap<>();
        Transformer<String, String> keyTransformer = input -> input.toUpperCase();
        Transformer<String, String> valueTransformer = input -> "Transformed: " + input;
        TransformedMultiValuedMap<String, String> transformedMap = new TransformedMultiValuedMap<>(multiValuedMap, keyTransformer, valueTransformer);
        String result = transformedMap.transformValue("testValue");
        assertEquals("Transformed: testValue", result, "Expected value should be transformed");
    }
}
