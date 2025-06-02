// Test method
package org.apache.commons.collections4.properties;

import java.util.LinkedHashSet;
import java.util.function.BiFunction;
import java.util.Set;
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
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderedProperties_compute_1_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    public void testComputeWithNonNullValue() {
        // Arrange
        Object key = "key1";
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> "value1";
        // Act
        Object result = orderedProperties.compute(key, remappingFunction);
        // Assert
        assertEquals("value1", result);
        assertTrue(orderedProperties.keySet().contains(key));
    }

    @Test
    public void testComputeWithNullValue() {
        // Arrange
        Object key = "key2";
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> null;
        // Act
        Object result = orderedProperties.compute(key, remappingFunction);
        // Assert
        assertNull(result);
        assertFalse(orderedProperties.keySet().contains(key));
    }

    @Test
    public void testComputeWithExistingKey() {
        // Arrange
        Object key = "key3";
        // First call to compute
        orderedProperties.compute(key, (k, v) -> "value3");
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> "newValue3";
        // Act
        Object result = orderedProperties.compute(key, remappingFunction);
        // Assert
        assertEquals("newValue3", result);
        assertTrue(orderedProperties.keySet().contains(key));
    }

    @Test
    public void testComputeWithNullKey() {
        // Arrange
        BiFunction<Object, Object, Object> remappingFunction = (k, v) -> "valueNullKey";
        // Act
        Object result = orderedProperties.compute(null, remappingFunction);
        // Assert
        assertEquals("valueNullKey", result);
        assertTrue(orderedProperties.keySet().contains(null));
    }

    @Test
    public void testComputeWithNullRemappingFunction() {
        // Arrange
        Object key = "key4";
        // Act
        Object result = orderedProperties.compute(key, null);
        // Assert
        assertNull(result);
        assertFalse(orderedProperties.keySet().contains(key));
    }
}
