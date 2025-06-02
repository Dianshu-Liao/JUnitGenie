package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedProperties_remove_12_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
        // Adding some entries to the ordered properties for testing
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
    }

    @Test
    public void testRemoveExistingKey() throws Exception {
        // Arrange
        String keyToRemove = "key1";
        // Act
        Object removedValue = invokeRemoveMethod(orderedProperties, keyToRemove);
        // Assert
        assertEquals("value1", removedValue);
        assertNull(orderedProperties.get(keyToRemove));
        // Fixed line
        assertFalse(orderedProperties.keySet().contains(keyToRemove));
    }

    @Test
    public void testRemoveNonExistingKey() throws Exception {
        // Arrange
        String keyToRemove = "key3";
        // Act
        Object removedValue = invokeRemoveMethod(orderedProperties, keyToRemove);
        // Assert
        assertNull(removedValue);
    }

    @Test
    public void testRemoveNullKey() throws Exception {
        // Act
        Object removedValue = invokeRemoveMethod(orderedProperties, null);
        // Assert
        assertNull(removedValue);
    }

    private Object invokeRemoveMethod(OrderedProperties orderedProperties, Object key) throws Exception {
        Method removeMethod = OrderedProperties.class.getDeclaredMethod("remove", Object.class);
        removeMethod.setAccessible(true);
        return removeMethod.invoke(orderedProperties, key);
    }
}
