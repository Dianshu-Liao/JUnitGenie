package org.apache.commons.collections4.properties;

import org.apache.commons.collections4.properties.OrderedProperties;
import java.lang.reflect.Field;
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

public class OrderedProperties_remove_12_0_Test {

    private OrderedProperties orderedProperties;

    @BeforeEach
    public void setUp() {
        orderedProperties = new OrderedProperties();
        orderedProperties.put("key1", "value1");
        orderedProperties.put("key2", "value2");
    }

    @Test
    public void testRemoveExistingKey() throws Exception {
        Object removedValue = orderedProperties.remove("key1");
        assertEquals("value1", removedValue);
        assertNull(orderedProperties.get("key1"));
        assertOrderedKeysContains("key2");
    }

    @Test
    public void testRemoveNonExistingKey() throws Exception {
        Object removedValue = orderedProperties.remove("nonExistingKey");
        assertNull(removedValue);
        assertOrderedKeysContains("key1");
        assertOrderedKeysContains("key2");
    }

    private void assertOrderedKeysContains(Object key) throws Exception {
        Field field = OrderedProperties.class.getDeclaredField("orderedKeys");
        field.setAccessible(true);
        LinkedHashSet<Object> orderedKeys = (LinkedHashSet<Object>) field.get(orderedProperties);
        assertEquals(orderedKeys.contains(key), orderedProperties.containsKey(key));
    }
}
