package org.apache.commons.collections4.map;

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

public class AbstractHashedMap_get_24_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR);
    }

    @Test
    public void testGetReturnsValueForExistingKey() {
        invokePut(map, "key1", "value1");
        String result = map.get("key1");
        assertEquals("value1", result);
    }

    @Test
    public void testGetReturnsNullForNonExistingKey() {
        String result = map.get("nonExistingKey");
        assertNull(result);
    }

    @Test
    public void testGetReturnsNullForNullKey() {
        String result = map.get(null);
        assertNull(result);
    }

    @Test
    public void testGetHandlesCollisions() {
        invokePut(map, "key1", "value1");
        // This should collide with key1 based on hash
        invokePut(map, "key1_collision", "value2");
        String result = map.get("key1_collision");
        assertEquals("value2", result);
    }

    private void invokePut(AbstractHashedMap<String, String> map, String key, String value) {
        try {
            Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(map, key, value);
        } catch (Exception e) {
            fail("Failed to invoke put method: " + e.getMessage());
        }
    }
}
