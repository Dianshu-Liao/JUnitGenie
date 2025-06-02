package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
import java.util.Properties;
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
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class OrderedProperties_put_9_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testPutNewKey() {
        Object key = "key1";
        Object value = "value1";
        // Test putting a new key
        Object result = orderedProperties.put(key, value);
        assertNull(result, "Expected null because the key was new");
        assertEquals(value, orderedProperties.get(key), "Value should be stored correctly");
    }

    @Test
    void testPutExistingKey() {
        Object key = "key1";
        Object value1 = "value1";
        Object value2 = "value2";
        // Put the key first
        orderedProperties.put(key, value1);
        // Test updating the existing key
        Object result = orderedProperties.put(key, value2);
        assertEquals(value1, result, "Expected old value to be returned");
        assertEquals(value2, orderedProperties.get(key), "Value should be updated correctly");
    }

    @Test
    void testPutNullKey() {
        Object value = "value1";
        // Test putting a null key
        Object result = orderedProperties.put(null, value);
        assertNull(result, "Expected null because the key was new");
        assertEquals(value, orderedProperties.get(null), "Value should be stored correctly for null key");
    }

    @Test
    void testPutNullValue() {
        Object key = "key1";
        // Test putting a null value
        Object result = orderedProperties.put(key, null);
        assertNull(result, "Expected null because the key was new");
        assertNull(orderedProperties.get(key), "Value should be null for the key");
    }

    @Test
    void testPutBothNull() {
        // Test putting both key and value as null
        Object result = orderedProperties.put(null, null);
        assertNull(result, "Expected null because the key was new");
        assertNull(orderedProperties.get(null), "Value should be null for null key");
    }

    @Test
    void testOrderedKeys() throws Exception {
        Object key1 = "key1";
        Object key2 = "key2";
        Object value1 = "value1";
        Object value2 = "value2";
        orderedProperties.put(key1, value1);
        orderedProperties.put(key2, value2);
        // Accessing private field orderedKeys using reflection
        Method method = OrderedProperties.class.getDeclaredMethod("getOrderedKeys");
        method.setAccessible(true);
        LinkedHashSet<Object> orderedKeys = (LinkedHashSet<Object>) method.invoke(orderedProperties);
        assertTrue(orderedKeys.contains(key1), "Ordered keys should contain key1");
        assertTrue(orderedKeys.contains(key2), "Ordered keys should contain key2");
        assertEquals(2, orderedKeys.size(), "Ordered keys size should be 2");
    }
}
