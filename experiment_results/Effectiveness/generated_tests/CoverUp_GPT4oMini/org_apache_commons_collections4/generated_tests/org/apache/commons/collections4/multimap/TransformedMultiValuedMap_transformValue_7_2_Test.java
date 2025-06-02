package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;

class TransformedMultiValuedMap_transformValue_7_2_Test {

    private TransformedMultiValuedMap<String, Integer> transformedMap;

    @BeforeEach
    void setUp() {
        // Setup a MultiValuedMap and transformers for testing
        MultiValuedMap<String, Integer> map = new ArrayListValuedHashMap<>();
        Transformer<String, String> keyTransformer = key -> "transformed_" + key;
        Transformer<Integer, Integer> valueTransformer = value -> value * 2;
        transformedMap = new TransformedMultiValuedMap<>(map, keyTransformer, valueTransformer);
    }

    @Test
    void testTransformValue_WithTransformer() throws Exception {
        // Test case where valueTransformer is not null
        Integer input = 5;
        // 5 * 2
        Integer expectedOutput = 10;
        Integer actualOutput = invokeTransformValue(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testTransformValue_WithoutTransformer() throws Exception {
        // Create a TransformedMultiValuedMap with a null valueTransformer
        TransformedMultiValuedMap<String, Integer> mapWithoutTransformer = new TransformedMultiValuedMap<>(new ArrayListValuedHashMap<>(), key -> key, null);
        Integer input = 5;
        Integer actualOutput = invokeTransformValue(mapWithoutTransformer, input);
        assertEquals(input, actualOutput);
    }

    @Test
    void testTransformValue_NullInput() throws Exception {
        // Test case where input is null
        Integer actualOutput = invokeTransformValue(null);
        assertNull(actualOutput);
    }

    private Integer invokeTransformValue(Integer value) throws Exception {
        Method method = TransformedMultiValuedMap.class.getDeclaredMethod("transformValue", Object.class);
        method.setAccessible(true);
        return (Integer) method.invoke(transformedMap, value);
    }

    private Integer invokeTransformValue(TransformedMultiValuedMap<String, Integer> map, Integer value) throws Exception {
        Method method = TransformedMultiValuedMap.class.getDeclaredMethod("transformValue", Object.class);
        method.setAccessible(true);
        return (Integer) method.invoke(map, value);
    }
}
