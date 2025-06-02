package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import java.util.ArrayList;
import java.util.List;
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

public class TransformedMultiValuedMap_putAll_3_0_Test {

    private TransformedMultiValuedMap<String, String> transformedMultiValuedMap;

    @BeforeEach
    public void setUp() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        Transformer<String, String> keyTransformer = key -> "transformed_" + key;
        Transformer<String, String> valueTransformer = value -> "transformed_" + value;
        transformedMultiValuedMap = new TransformedMultiValuedMap<>(map, keyTransformer, valueTransformer);
    }

    @Test
    public void testPutAllWithNonEmptyIterable() {
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        boolean result = transformedMultiValuedMap.putAll("key", values);
        assertTrue(result);
        assertEquals(2, transformedMultiValuedMap.decorated().get("transformed_key").size());
        assertTrue(transformedMultiValuedMap.decorated().get("transformed_key").contains("transformed_value1"));
        assertTrue(transformedMultiValuedMap.decorated().get("transformed_key").contains("transformed_value2"));
    }

    @Test
    public void testPutAllWithEmptyIterable() {
        List<String> values = new ArrayList<>();
        boolean result = transformedMultiValuedMap.putAll("key", values);
        assertFalse(result);
        assertEquals(0, transformedMultiValuedMap.decorated().get("transformed_key").size());
    }

    @Test
    public void testPutAllWithNullIterable() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            transformedMultiValuedMap.putAll("key", null);
        });
        assertEquals("values", exception.getMessage());
    }

    @Test
    public void testPutAllWithSingleValue() {
        List<String> values = new ArrayList<>();
        values.add("singleValue");
        boolean result = transformedMultiValuedMap.putAll("singleKey", values);
        assertTrue(result);
        assertEquals(1, transformedMultiValuedMap.decorated().get("transformed_singleKey").size());
        assertTrue(transformedMultiValuedMap.decorated().get("transformed_singleKey").contains("transformed_singleValue"));
    }
}
