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

public class OrderedProperties_putIfAbsent_11_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    public void testPutIfAbsent_WhenKeyIsAbsent_ShouldAddKeyAndReturnNull() {
        Object key = "key1";
        Object value = "value1";
        Object result = orderedProperties.putIfAbsent(key, value);
        assertNull(result, "Expected putIfAbsent to return null when key is absent");
        assertEquals(value, orderedProperties.get(key), "Expected value to be added for the key");
    }

    @Test
    public void testPutIfAbsent_WhenKeyIsPresent_ShouldNotChangeValueAndReturnExistingValue() {
        Object key = "key2";
        Object initialValue = "value2";
        Object newValue = "value3";
        orderedProperties.putIfAbsent(key, initialValue);
        Object result = orderedProperties.putIfAbsent(key, newValue);
        assertEquals(initialValue, result, "Expected putIfAbsent to return existing value when key is present");
        assertEquals(initialValue, orderedProperties.get(key), "Expected value to remain unchanged for the key");
    }

    @Test
    public void testPutIfAbsent_WithNullKeyAndValue_ShouldAddNullKeyAndValue() {
        Object key = null;
        Object value = null;
        Object result = orderedProperties.putIfAbsent(key, value);
        assertNull(result, "Expected putIfAbsent to return null for null key and value");
        assertEquals(value, orderedProperties.get(key), "Expected null value to be added for null key");
    }

    @Test
    public void testPutIfAbsent_WithNullValue_ShouldAddKeyWithNullValue() {
        Object key = "key3";
        Object value = null;
        Object result = orderedProperties.putIfAbsent(key, value);
        assertNull(result, "Expected putIfAbsent to return null when key is absent");
        assertEquals(value, orderedProperties.get(key), "Expected null value to be added for the key");
    }

    @Test
    public void testPutIfAbsent_WithSameKeyDifferentValues_ShouldOnlyStoreFirstValue() {
        Object key = "key4";
        Object initialValue = "value4";
        Object newValue = "value5";
        orderedProperties.putIfAbsent(key, initialValue);
        Object result = orderedProperties.putIfAbsent(key, newValue);
        assertEquals(initialValue, result, "Expected putIfAbsent to return initial value when key is present");
        assertEquals(initialValue, orderedProperties.get(key), "Expected initial value to remain for the key");
    }
}
