package org.apache.commons.collections4.properties;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderedProperties_remove_13_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    void setUp() {
        orderedProperties = new OrderedProperties();
    }

    @Test
    void testRemoveSuccessful() throws Exception {
        // Prepare the necessary state
        Method putMethod = LinkedHashMap.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(orderedProperties, "key1", "value1");
        // Invoke the focal method
        boolean result = invokeRemove(orderedProperties, "key1", "value1");
        // Verify the result
        assertTrue(result);
        // Assuming containsKey is implemented
        assertFalse(orderedProperties.containsKey("key1"));
        // Fixed Buggy Line
        assertFalse(orderedProperties.keySet().contains("key1"));
    }

    @Test
    void testRemoveNotFound() throws Exception {
        // Invoke the focal method
        boolean result = invokeRemove(orderedProperties, "nonexistentKey", "value");
        // Verify the result
        assertFalse(result);
    }

    @Test
    void testRemoveKeyExistsWithDifferentValue() throws Exception {
        // Prepare the necessary state
        Method putMethod = LinkedHashMap.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(orderedProperties, "key1", "value1");
        // Invoke the focal method with a different value
        boolean result = invokeRemove(orderedProperties, "key1", "differentValue");
        // Verify the result
        assertFalse(result);
        // The key should still exist
        assertTrue(orderedProperties.containsKey("key1"));
        // Fixed Buggy Line
        assertTrue(orderedProperties.keySet().contains("key1"));
    }

    private boolean invokeRemove(OrderedProperties orderedProperties, Object key, Object value) throws Exception {
        Method removeMethod = OrderedProperties.class.getDeclaredMethod("remove", Object.class);
        removeMethod.setAccessible(true);
        return (Boolean) removeMethod.invoke(orderedProperties, key);
    }
}
