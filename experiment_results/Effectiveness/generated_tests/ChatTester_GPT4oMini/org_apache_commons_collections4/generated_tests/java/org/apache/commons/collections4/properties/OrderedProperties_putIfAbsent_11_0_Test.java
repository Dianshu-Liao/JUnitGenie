package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
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
    public void testPutIfAbsent_NewKey() throws Exception {
        Object key = "key1";
        Object value = "value1";
        // Call the focal method
        Object result = invokePutIfAbsent(key, value);
        // Verify that the method returns null (indicating the key was absent)
        assertNull(result);
        // Verify that the key was added
        assertEquals(value, orderedProperties.get(key));
    }

    @Test
    public void testPutIfAbsent_ExistingKey() throws Exception {
        Object key = "key2";
        Object value1 = "value1";
        Object value2 = "value2";
        // First, add the key
        orderedProperties.putIfAbsent(key, value1);
        // Call the focal method with the same key but a different value
        Object result = invokePutIfAbsent(key, value2);
        // Verify that the method returns the existing value (indicating the key was present)
        assertEquals(value1, result);
        // Verify that the value associated with the key remains the same
        assertEquals(value1, orderedProperties.get(key));
    }

    @Test
    public void testPutIfAbsent_NullKeyAndValue() throws Exception {
        // Call the focal method with null key and value
        Object result = invokePutIfAbsent(null, null);
        // Verify that the method returns null (indicating the key was absent)
        assertNull(result);
        // Verify that the key-value pair is stored
        assertNull(orderedProperties.get(null));
    }

    @Test
    public void testPutIfAbsent_EmptyKey() throws Exception {
        Object key = "";
        Object value = "valueEmptyKey";
        // Call the focal method with an empty string as key
        Object result = invokePutIfAbsent(key, value);
        // Verify that the method returns null (indicating the key was absent)
        assertNull(result);
        // Verify that the key was added
        assertEquals(value, orderedProperties.get(key));
    }

    private Object invokePutIfAbsent(Object key, Object value) throws Exception {
        Method method = OrderedProperties.class.getDeclaredMethod("putIfAbsent", Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(orderedProperties, key, value);
    }
}
