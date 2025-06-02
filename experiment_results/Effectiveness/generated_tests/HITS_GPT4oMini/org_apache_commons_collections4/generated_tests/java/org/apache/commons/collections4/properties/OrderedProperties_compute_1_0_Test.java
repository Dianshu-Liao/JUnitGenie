package org.apache.commons.collections4.properties;

import java.util.function.BiFunction;
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
import java.util.function.Function;
import java.util.stream.Collectors;

class OrderedProperties_compute_1_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testComputeWithNewKey() {
        BiFunction<Object, Object, Object> remappingFunction = (key, value) -> "newValue";
        Object result = orderedProperties.compute("key1", remappingFunction);
        assertEquals("newValue", result);
        // Assuming there is a way to verify that the key was added to orderedKeys;
        // this part is pseudo-code as orderedKeys is private.
        // assertTrue(orderedProperties.orderedKeys.contains("key1"));
    }

    @Test
    void testComputeWithExistingKey() {
        orderedProperties.compute("key1", (key, value) -> "initialValue");
        BiFunction<Object, Object, Object> remappingFunction = (key, value) -> "updatedValue";
        Object result = orderedProperties.compute("key1", remappingFunction);
        assertEquals("updatedValue", result);
        // Again, check if the key was added to orderedKeys
        // assertTrue(orderedProperties.orderedKeys.contains("key1"));
    }

    @Test
    void testComputeWithNullValue() {
        BiFunction<Object, Object, Object> remappingFunction = (key, value) -> null;
        Object result = orderedProperties.compute("key2", remappingFunction);
        assertNull(result);
        // Check if the key was still added to orderedKeys
        // assertTrue(orderedProperties.orderedKeys.contains("key2"));
    }

    @Test
    void testComputeWithNullKey() {
        BiFunction<Object, Object, Object> remappingFunction = (key, value) -> "valueForNullKey";
        Object result = orderedProperties.compute(null, remappingFunction);
        assertEquals("valueForNullKey", result);
        // Check if the key was added to orderedKeys
        // assertTrue(orderedProperties.orderedKeys.contains(null));
    }

    @Test
    void testComputeWithNullRemappingFunction() {
        Object result = orderedProperties.compute("key3", null);
        assertNull(result);
        // Check if the key was added to orderedKeys
        // assertTrue(orderedProperties.orderedKeys.contains("key3"));
    }
}
