package org.apache.commons.collections4.map;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap_remove_37_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(16);
        invokePutMethod(map, "key1", "value1");
        invokePutMethod(map, "key2", "value2");
        invokePutMethod(map, "key3", "value3");
    }

    @Test
    public void testRemoveExistingKey() {
        String removedValue = map.remove("key2");
        assertEquals("value2", removedValue);
        // Ensure it's removed
        assertNull(map.remove("key2"));
    }

    @Test
    public void testRemoveNonExistingKey() {
        String removedValue = map.remove("key4");
        assertNull(removedValue);
    }

    @Test
    public void testRemoveNullKey() {
        String removedValue = map.remove(null);
        assertNull(removedValue);
    }

    @Test
    public void testRemoveAfterMultipleRemovals() {
        map.remove("key1");
        map.remove("key3");
        String removedValue = map.remove("key2");
        assertEquals("value2", removedValue);
        // Ensure it's removed
        assertNull(map.remove("key1"));
        // Ensure it's removed
        assertNull(map.remove("key3"));
    }

    private void invokePutMethod(AbstractHashedMap<String, String> map, String key, String value) {
        try {
            Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(map, key, value);
        } catch (Exception e) {
            fail("Failed to invoke put method: " + e.getMessage());
        }
    }
}
