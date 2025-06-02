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

public class OrderedProperties_remove_13_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
        orderedProperties.put("key3", "value3");
    }

    @Test
    public void testRemoveExistingKeyValue() {
        // Test removing an existing key-value pair
        boolean result = orderedProperties.remove("key1", "value1");
        assertTrue(result, "Expected remove to return true for existing key-value pair");
        assertFalse(orderedProperties.containsKey("key1"), "Expected key1 to be removed");
    }

    @Test
    public void testRemoveNonExistingKey() {
        // Test removing a non-existing key-value pair
        boolean result = orderedProperties.remove("key4", "value4");
        assertFalse(result, "Expected remove to return false for non-existing key");
    }

    @Test
    public void testRemoveExistingKeyWithWrongValue() {
        // Test removing an existing key with a wrong value
        boolean result = orderedProperties.remove("key2", "wrongValue");
        assertFalse(result, "Expected remove to return false for existing key with wrong value");
        assertTrue(orderedProperties.containsKey("key2"), "Expected key2 to remain");
    }

    @Test
    public void testRemoveKeyWithNullValue() {
        // Test removing a key with a null value
        boolean result = orderedProperties.remove("key3", null);
        assertFalse(result, "Expected remove to return false for key with null value");
        assertTrue(orderedProperties.containsKey("key3"), "Expected key3 to remain");
    }

    @Test
    public void testRemoveKeyWithNullKey() {
        // Test removing with null key
        boolean result = orderedProperties.remove(null, "value1");
        assertFalse(result, "Expected remove to return false for null key");
    }

    @Test
    public void testRemoveKeyWithNullKeyAndValue() {
        // Test removing with null key and null value
        boolean result = orderedProperties.remove(null, null);
        assertFalse(result, "Expected remove to return false for null key and null value");
    }

    @Test
    public void testRemoveKeyWithEmptyStringValue() {
        // Test removing a key with an empty string value
        orderedProperties.put("key4", "");
        boolean result = orderedProperties.remove("key4", "");
        assertTrue(result, "Expected remove to return true for existing key with empty string value");
        assertFalse(orderedProperties.containsKey("key4"), "Expected key4 to be removed");
    }
}
