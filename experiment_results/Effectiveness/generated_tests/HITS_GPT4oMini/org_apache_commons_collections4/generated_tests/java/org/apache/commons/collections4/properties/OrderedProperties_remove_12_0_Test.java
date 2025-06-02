package org.apache.commons.collections4.properties;

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

class OrderedProperties_remove_12_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testRemoveExistingKey() {
        // Arrange
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
        // Act
        Object removedValue = orderedProperties.remove("key1");
        // Assert
        assertEquals("value1", removedValue);
        assertNull(orderedProperties.get("key1"));
    }

    @Test
    void testRemoveNonExistingKey() {
        // Arrange
        orderedProperties.put("key1", "value1");
        // Act
        Object removedValue = orderedProperties.remove("key2");
        // Assert
        assertNull(removedValue);
        assertEquals("value1", orderedProperties.get("key1"));
    }

    @Test
    void testRemoveNullKey() {
        // Arrange
        orderedProperties.put("key1", "value1");
        // Act
        Object removedValue = orderedProperties.remove(null);
        // Assert
        assertNull(removedValue);
        assertEquals("value1", orderedProperties.get("key1"));
    }

    @Test
    void testRemoveKeyFromEmptyProperties() {
        // Act
        Object removedValue = orderedProperties.remove("key1");
        // Assert
        assertNull(removedValue);
    }

    @Test
    void testRemoveKeyUpdatesOrderedKeys() {
        // Arrange
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
        // Act
        orderedProperties.remove("key1");
        // Assert
        assertNull(orderedProperties.get("key1"));
        // Ensure only one key remains
        assertEquals(1, orderedProperties.size());
    }
}
