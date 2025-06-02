package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
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
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class OrderedProperties_putIfAbsent_11_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testPutIfAbsent_NewKey() throws Exception {
        Object key = "key1";
        Object value = "value1";
        Object result = orderedProperties.putIfAbsent(key, value);
        assertNull(result);
        assertEquals(value, orderedProperties.get(key));
        assertTrue(getOrderedKeys().contains(key));
    }

    @Test
    void testPutIfAbsent_ExistingKey() throws Exception {
        Object key = "key1";
        Object value1 = "value1";
        Object value2 = "value2";
        orderedProperties.putIfAbsent(key, value1);
        Object result = orderedProperties.putIfAbsent(key, value2);
        assertEquals(value1, result);
        assertEquals(value1, orderedProperties.get(key));
        assertEquals(1, getOrderedKeys().size());
    }

    @Test
    void testPutIfAbsent_NullKey() throws Exception {
        Object value = "value1";
        Object result = orderedProperties.putIfAbsent(null, value);
        assertNull(result);
        assertEquals(value, orderedProperties.get(null));
        assertTrue(getOrderedKeys().contains(null));
    }

    @Test
    void testPutIfAbsent_NullValue() throws Exception {
        Object key = "key1";
        Object result = orderedProperties.putIfAbsent(key, null);
        assertNull(result);
        assertNull(orderedProperties.get(key));
        assertTrue(getOrderedKeys().contains(key));
    }

    @Test
    void testPutIfAbsent_NullKeyAndValue() throws Exception {
        Object result = orderedProperties.putIfAbsent(null, null);
        assertNull(result);
        assertNull(orderedProperties.get(null));
        assertTrue(getOrderedKeys().contains(null));
    }

    private LinkedHashSet<Object> getOrderedKeys() throws Exception {
        Method method = OrderedProperties.class.getDeclaredMethod("getOrderedKeys");
        method.setAccessible(true);
        return (LinkedHashSet<Object>) method.invoke(orderedProperties);
    }
}
