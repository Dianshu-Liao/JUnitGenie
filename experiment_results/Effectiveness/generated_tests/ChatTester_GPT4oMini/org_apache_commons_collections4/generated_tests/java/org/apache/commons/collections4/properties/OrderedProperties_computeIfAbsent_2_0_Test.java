package org.apache.commons.collections4.properties;

import java.util.LinkedHashSet;
import java.util.function.Function;
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
import java.util.stream.Collectors;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedProperties_computeIfAbsent_2_0_Test {

    private OrderedProperties orderedProperties;

    private Function<Object, Object> mappingFunction;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
        mappingFunction = mock(Function.class);
    }

    @Test
    public void testComputeIfAbsent_NewKey() {
        Object key = "newKey";
        Object value = "value";
        when(mappingFunction.apply(key)).thenReturn(value);
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        assertEquals(value, result);
        try {
            assertTrue(getOrderedKeys().contains(key));
        } catch (Exception e) {
            fail("Exception occurred while accessing ordered keys: " + e.getMessage());
        }
    }

    @Test
    public void testComputeIfAbsent_ExistingKey() {
        Object key = "existingKey";
        Object existingValue = "existingValue";
        when(mappingFunction.apply(key)).thenReturn(existingValue);
        // First call to add the key
        orderedProperties.computeIfAbsent(key, mappingFunction);
        // Now call again to simulate existing key
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        assertEquals(existingValue, result);
        try {
            assertTrue(getOrderedKeys().contains(key));
        } catch (Exception e) {
            fail("Exception occurred while accessing ordered keys: " + e.getMessage());
        }
    }

    @Test
    public void testComputeIfAbsent_NullMappingFunction() {
        Object key = "keyWithNullMappingFunction";
        Object result = orderedProperties.computeIfAbsent(key, null);
        assertNull(result);
        try {
            assertFalse(getOrderedKeys().contains(key));
        } catch (Exception e) {
            fail("Exception occurred while accessing ordered keys: " + e.getMessage());
        }
    }

    @Test
    public void testComputeIfAbsent_NullValue() {
        Object key = "keyWithNullValue";
        when(mappingFunction.apply(key)).thenReturn(null);
        Object result = orderedProperties.computeIfAbsent(key, mappingFunction);
        assertNull(result);
        try {
            assertFalse(getOrderedKeys().contains(key));
        } catch (Exception e) {
            fail("Exception occurred while accessing ordered keys: " + e.getMessage());
        }
    }

    // Reflection to access private field for testing
    private LinkedHashSet<Object> getOrderedKeys() throws Exception {
        java.lang.reflect.Field field = OrderedProperties.class.getDeclaredField("orderedKeys");
        field.setAccessible(true);
        return (LinkedHashSet<Object>) field.get(orderedProperties);
    }
}
