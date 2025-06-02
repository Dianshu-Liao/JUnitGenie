package org.apache.commons.collections4.properties;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.function.BiFunction;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderedProperties_compute_1_1_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testComputeWithExistingKey() throws Exception {
        // Prepare the key and value
        Object key = "key1";
        Object initialValue = "value1";
        // Use reflection to set the initial value in the superclass (Properties)
        Method putMethod = Properties.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(orderedProperties, key, initialValue);
        // Define a BiFunction for remapping
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> "newValue";
        // Invoke the compute method
        Object result = invokeCompute(key, remappingFunction);
        // Verify the result and state
        assertEquals("newValue", result);
        assertTrue(getOrderedKeys().contains(key));
    }

    @Test
    void testComputeWithNewKey() throws Exception {
        // Prepare the new key
        Object key = "key2";
        // Define a BiFunction for remapping
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> "newValue";
        // Invoke the compute method
        Object result = invokeCompute(key, remappingFunction);
        // Verify the result and state
        assertEquals("newValue", result);
        assertTrue(getOrderedKeys().contains(key));
    }

    @Test
    void testComputeWithNullResult() throws Exception {
        // Prepare the key
        Object key = "key3";
        // Define a BiFunction that returns null
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> null;
        // Invoke the compute method
        Object result = invokeCompute(key, remappingFunction);
        // Verify the result and state
        assertNull(result);
        assertFalse(getOrderedKeys().contains(key));
    }

    private Object invokeCompute(Object key, BiFunction<Object, Object, Object> remappingFunction) throws Exception {
        Method computeMethod = OrderedProperties.class.getDeclaredMethod("compute", Object.class, BiFunction.class);
        computeMethod.setAccessible(true);
        return computeMethod.invoke(orderedProperties, key, remappingFunction);
    }

    // For testing purposes, add a method to access the orderedKeys
    private LinkedHashSet<Object> getOrderedKeys() throws Exception {
        // Use reflection to access the private orderedKeys field
        Field orderedKeysField = OrderedProperties.class.getDeclaredField("orderedKeys");
        orderedKeysField.setAccessible(true);
        return (LinkedHashSet<Object>) orderedKeysField.get(orderedProperties);
    }
}
