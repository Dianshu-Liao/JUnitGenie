package org.apache.commons.collections4.properties;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.function.Function;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
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
    void testComputeIfAbsent_WhenKeyIsAbsent_ShouldInvokeMappingFunctionAndAddKey() {
        // Arrange
        Object key = "key1";
        Function<Object, Object> mappingFunction = k -> "value1";
        // Act
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Assert
        assertEquals("value1", result);
        assertTrue(getOrderedKeys().contains(key));
    }

    @Test
    void testComputeIfAbsent_WhenKeyIsPresent_ShouldNotInvokeMappingFunction() {
        // Arrange
        Object key = "key2";
        // Simulating the presence of the key
        orderedProperties.put(key, "value2");
        Function<Object, Object> mappingFunction = k -> "newValue";
        // Act
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Assert
        assertEquals("value2", result);
        assertFalse(getOrderedKeys().contains("newKey"));
    }

    @Test
    void testComputeIfAbsent_WhenMappingFunctionReturnsNull_ShouldNotAddKey() {
        // Arrange
        Object key = "key3";
        Function<Object, Object> mappingFunction = k -> null;
        // Act
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        // Assert
        assertNull(result);
        assertFalse(getOrderedKeys().contains(key));
    }

    @Test
    void testComputeIfAbsent_WhenMappingFunctionThrowsException_ShouldPropagateException() {
        // Arrange
        Object key = "key4";
        Function<Object, Object> mappingFunction = k -> {
            throw new RuntimeException("Mapping function error");
        };
        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            orderedProperties.computeIfAbsent(key, mappingFunction);
        });
        assertEquals("Mapping function error", exception.getMessage());
        assertFalse(getOrderedKeys().contains(key));
    }

    private Set<Object> getOrderedKeys() {
        try {
            Field field = OrderedProperties.class.getDeclaredField("orderedKeys");
            field.setAccessible(true);
            return (Set<Object>) field.get(orderedProperties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
