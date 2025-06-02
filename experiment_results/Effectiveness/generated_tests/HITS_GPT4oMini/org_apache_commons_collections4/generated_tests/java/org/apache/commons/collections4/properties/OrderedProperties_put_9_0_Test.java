package org.apache.commons.collections4.properties;

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
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderedProperties_put_9_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    public void testPutNewKeyValue() {
        // Arrange
        String key = "key1";
        String value = "value1";
        // Act
        Object result = orderedProperties.put(key, value);
        // Assert
        assertNull(result, "Expected result to be null for a new key");
        assertEquals(value, orderedProperties.get(key), "The value for the key should be the one added");
    }

    @Test
    public void testPutExistingKey() {
        // Arrange
        String key = "key2";
        String initialValue = "value2";
        String newValue = "newValue2";
        orderedProperties.put(key, initialValue);
        // Act
        Object result = orderedProperties.put(key, newValue);
        // Assert
        assertEquals(initialValue, result, "Expected result to be the old value for an existing key");
        assertEquals(newValue, orderedProperties.get(key), "The value for the key should be updated to the new value");
    }

    @Test
    public void testPutNullKey() {
        // Arrange
        String key = null;
        String value = "value3";
        // Act
        Object result = orderedProperties.put(key, value);
        // Assert
        assertNull(result, "Expected result to be null when adding a null key");
        assertEquals(value, orderedProperties.get(key), "The value for the null key should be the one added");
    }

    @Test
    public void testPutNullValue() {
        // Arrange
        String key = "key4";
        String value = null;
        // Act
        Object result = orderedProperties.put(key, value);
        // Assert
        assertNull(result, "Expected result to be null when adding a value of null");
        assertNull(orderedProperties.get(key), "The value for the key should be null");
    }

    @Test
    public void testPutBothNull() {
        // Arrange
        Object key = null;
        Object value = null;
        // Act
        Object result = orderedProperties.put(key, value);
        // Assert
        assertNull(result, "Expected result to be null when both key and value are null");
        assertNull(orderedProperties.get(key), "The value for the null key should be null");
    }

    @Test
    public void testPutSameKeyDifferentValues() {
        // Arrange
        String key = "key5";
        String firstValue = "firstValue";
        String secondValue = "secondValue";
        // Act
        orderedProperties.put(key, firstValue);
        Object result = orderedProperties.put(key, secondValue);
        // Assert
        assertEquals(firstValue, result, "Expected result to be the first value when updating with a new value");
        assertEquals(secondValue, orderedProperties.get(key), "The value for the key should be updated to the second value");
    }
}
