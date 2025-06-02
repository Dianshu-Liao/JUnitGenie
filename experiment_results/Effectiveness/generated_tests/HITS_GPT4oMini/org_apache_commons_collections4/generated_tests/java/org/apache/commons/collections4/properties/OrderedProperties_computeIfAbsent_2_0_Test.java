package org.apache.commons.collections4.properties;

import java.util.function.Function;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class OrderedProperties_computeIfAbsent_2_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testComputeIfAbsent_NewKey() {
        String key = "newKey";
        String value = "value";
        // Function that returns a value
        Function<Object, Object> mappingFunction = k -> value;
        // Call computeIfAbsent
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Verify that the value is returned and stored
        assertEquals(value, result);
        assertEquals(value, orderedProperties.get(key));
    }

    @Test
    void testComputeIfAbsent_ExistingKey() {
        String key = "existingKey";
        String initialValue = "initialValue";
        // First, put an initial value
        orderedProperties.computeIfAbsent(key, k -> initialValue);
        // Function that would return a different value
        Function<Object, Object> mappingFunction = k -> "newValue";
        // Call computeIfAbsent with the existing key
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Verify that the initial value is returned and not overridden
        assertEquals(initialValue, result);
        assertEquals(initialValue, orderedProperties.get(key));
    }

    @Test
    void testComputeIfAbsent_NullValue() {
        String key = "keyWithNullValue";
        // Function that returns null
        Function<Object, Object> mappingFunction = k -> null;
        // Call computeIfAbsent
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Verify that the result is null and that the key does not exist
        assertNull(result);
        assertNull(orderedProperties.get(key));
    }

    @Test
    void testComputeIfAbsent_MultipleKeys() {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        // Function that returns values for both keys
        Function<Object, Object> mappingFunction1 = k -> value1;
        Function<Object, Object> mappingFunction2 = k -> value2;
        // Call computeIfAbsent for both keys
        orderedProperties.computeIfAbsent(key1, mappingFunction1);
        orderedProperties.computeIfAbsent(key2, mappingFunction2);
        // Verify that both keys return their respective values
        assertEquals(value1, orderedProperties.get(key1));
        assertEquals(value2, orderedProperties.get(key2));
    }
}
