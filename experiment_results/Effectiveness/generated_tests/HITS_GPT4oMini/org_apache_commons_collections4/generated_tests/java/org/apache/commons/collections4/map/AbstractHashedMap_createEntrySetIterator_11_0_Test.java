package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Map;
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
            public String put(String key, String value) {
                // Mock implementation for testing purpose
                // Return null as no previous value is associated
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {
                // Mock implementation for testing purpose
                for (Map.Entry<? extends String, ? extends String> entry : m.entrySet()) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        };
    }

    @Test
    void testCreateEntrySetIteratorWhenMapIsEmpty() {
        Iterator<Map.Entry<String, String>> iterator = map.createEntrySetIterator();
        assertNotNull(iterator, "Iterator should not be null");
        assertFalse(iterator.hasNext(), "Iterator should be empty");
    }

    @Test
    void testCreateEntrySetIteratorWhenMapIsNotEmpty() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        Iterator<Map.Entry<String, String>> iterator = map.createEntrySetIterator();
        assertNotNull(iterator, "Iterator should not be null");
        assertTrue(iterator.hasNext(), "Iterator should have elements");
    }
}
