package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class AbstractHashedMap_createEntrySetIterator_11_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<String, String>() {

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {
                for (Map.Entry<? extends String, ? extends String> entry : m.entrySet()) {
                    put(entry.getKey(), entry.getValue());
                }
            }

            @Override
            public int size() {
                return super.size();
            }

            @Override
            public boolean isEmpty() {
                return super.isEmpty();
            }

            @Override
            public String put(String key, String value) {
                // Mock implementation for testing
                return super.put(key, value);
            }
        };
    }

    @Test
    void testCreateEntrySetIteratorWhenEmpty() throws Exception {
        // Test case where the map is empty
        Method method = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
        method.setAccessible(true);
        Iterator<Map.Entry<String, String>> iterator = (Iterator<Map.Entry<String, String>>) method.invoke(map);
        assertNotNull(iterator);
        assertFalse(iterator.hasNext(), "Iterator should be empty when the map is empty.");
    }

    @Test
    void testCreateEntrySetIteratorWhenNotEmpty() throws Exception {
        // Test case where the map is not empty
        map.put("key1", "value1");
        Method method = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
        method.setAccessible(true);
        Iterator<Map.Entry<String, String>> iterator = (Iterator<Map.Entry<String, String>>) method.invoke(map);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext(), "Iterator should have entries when the map is not empty.");
    }
}
