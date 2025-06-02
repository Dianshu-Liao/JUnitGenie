package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
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
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderedProperties_put_9_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    public void testPutNewKey() throws Exception {
        // Arrange
        Object key = "key1";
        Object value = "value1";
        // Act
        Object result = orderedProperties.put(key, value);
        // Assert
        assertNull(result, "Expected null return for new key");
        assertTrue(containsKey(orderedProperties, key), "Key should be present after put");
        assertEquals(value, orderedProperties.get(key), "Value should match the inserted value");
    }

    @Test
    public void testPutExistingKey() throws Exception {
        // Arrange
        Object key = "key1";
        Object value1 = "value1";
        Object value2 = "value2";
        orderedProperties.put(key, value1);
        // Act
        Object result = orderedProperties.put(key, value2);
        // Assert
        assertEquals(value1, result, "Expected previous value to be returned");
        assertEquals(value1, orderedProperties.get(key), "Value should remain unchanged for existing key");
    }

    @Test
    public void testPutNullKey() throws Exception {
        // Arrange
        Object value = "value1";
        // Act
        Object result = orderedProperties.put(null, value);
        // Assert
        assertNull(result, "Expected null return for new null key");
        assertTrue(containsKey(orderedProperties, null), "Null key should be present after put");
        assertEquals(value, orderedProperties.get(null), "Value should match the inserted value for null key");
    }

    @Test
    public void testPutNullValue() throws Exception {
        // Arrange
        Object key = "key1";
        // Act
        Object result = orderedProperties.put(key, null);
        // Assert
        assertNull(result, "Expected null return for new key with null value");
        assertTrue(containsKey(orderedProperties, key), "Key should be present after put");
        assertNull(orderedProperties.get(key), "Value should be null for the key");
    }

    @Test
    public void testPutBothNull() throws Exception {
        // Act
        Object result = orderedProperties.put(null, null);
        // Assert
        assertNull(result, "Expected null return for new null key with null value");
        assertTrue(containsKey(orderedProperties, null), "Null key should be present after put");
        assertNull(orderedProperties.get(null), "Value should be null for the null key");
    }

    private boolean containsKey(OrderedProperties properties, Object key) throws Exception {
        // Use reflection to access the private orderedKeys field
        Method method = OrderedProperties.class.getDeclaredMethod("getOrderedKeys");
        method.setAccessible(true);
        LinkedHashSet<Object> keys = (LinkedHashSet<Object>) method.invoke(properties);
        return keys.contains(key);
    }
}
