package org.apache.commons.collections4.properties;

import org.apache.commons.collections4.properties.OrderedProperties;
import java.lang.reflect.Method;
import java.util.Properties;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderedProperties_remove_13_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
    }

    @Test
    void testRemoveExistingKeyValue() {
        // Arrange
        String key = "key1";
        String value = "value1";
        // Act
        boolean result = orderedProperties.remove(key, value);
        // Assert
        assertTrue(result);
        // Check that the key is removed
        assertNull(orderedProperties.get(key));
    }

    @Test
    void testRemoveNonExistingKey() {
        // Arrange
        String key = "key3";
        String value = "value3";
        // Act
        boolean result = orderedProperties.remove(key, value);
        // Assert
        assertFalse(result);
    }

    @Test
    void testRemoveExistingKeyWithWrongValue() {
        // Arrange
        String key = "key1";
        String value = "wrongValue";
        // Act
        boolean result = orderedProperties.remove(key, value);
        // Assert
        assertFalse(result);
        // Check that the original value is still there
        assertEquals("value1", orderedProperties.get(key));
    }

    @Test
    void testRemoveKeyUpdatesOrderedKeys() throws Exception {
        // Arrange
        String key = "key2";
        String value = "value2";
        // Act
        orderedProperties.remove(key, value);
        // Assert
        // Check that the key is removed from the ordered keys using reflection
        Method method = OrderedProperties.class.getDeclaredMethod("getOrderedKeys");
        method.setAccessible(true);
        LinkedHashSet<Object> orderedKeys = (LinkedHashSet<Object>) method.invoke(orderedProperties);
        assertFalse(orderedKeys.contains(key));
    }

    @Test
    void testRemoveNullKey() {
        // Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            orderedProperties.remove(null, "value");
        });
        // Assert
        assertEquals("key cannot be null", exception.getMessage());
    }

    @Test
    void testRemoveNullValue() {
        // Act
        boolean result = orderedProperties.remove("key1", null);
        // Assert
        // Expect false, as null value doesn't match the existing value
        assertFalse(result);
    }

    // Reflection test for private method (if applicable)
    @Test
    void testPrivateMethodUsingReflection() throws Exception {
        Method method = OrderedProperties.class.getDeclaredMethod("yourPrivateMethodNameHere");
        method.setAccessible(true);
        // Invoke the private method here and assert if necessary
    }
}
