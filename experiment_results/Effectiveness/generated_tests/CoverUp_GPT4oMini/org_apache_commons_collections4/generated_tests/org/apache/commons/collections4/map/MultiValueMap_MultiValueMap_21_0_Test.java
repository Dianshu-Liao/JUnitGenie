package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.MultiMap;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_MultiValueMap_21_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    private Map<String, Collection<String>> map;

    private Factory<Collection<String>> collectionFactory;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        // Using ArrayList as the collection factory
        collectionFactory = ArrayList::new;
        multiValueMap = new MultiValueMap<>(map, collectionFactory);
    }

    @Test
    void testConstructorWithNullFactory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new MultiValueMap<>(map, null);
        });
        assertEquals("The factory must not be null", exception.getMessage());
    }

    @Test
    void testPutNewKey() {
        String key = "key1";
        String value = "value1";
        multiValueMap.put(key, value);
        assertEquals(1, multiValueMap.size(key));
        assertTrue(multiValueMap.getCollection(key).contains(value));
    }

    @Test
    void testPutExistingKey() {
        String key = "key1";
        String value1 = "value1";
        String value2 = "value2";
        multiValueMap.put(key, value1);
        multiValueMap.put(key, value2);
        assertEquals(2, multiValueMap.size(key));
        assertTrue(multiValueMap.getCollection(key).contains(value1));
        assertTrue(multiValueMap.getCollection(key).contains(value2));
    }

    @Test
    void testPutAllNewKey() {
        String key = "key2";
        Collection<String> values = Arrays.asList("value1", "value2");
        multiValueMap.putAll(key, values);
        assertEquals(2, multiValueMap.size(key));
        assertTrue(multiValueMap.getCollection(key).containsAll(values));
    }

    @Test
    void testPutAllExistingKey() {
        String key = "key1";
        multiValueMap.put(key, "value1");
        Collection<String> values = Arrays.asList("value2", "value3");
        multiValueMap.putAll(key, values);
        assertEquals(3, multiValueMap.size(key));
        assertTrue(multiValueMap.getCollection(key).contains("value1"));
        assertTrue(multiValueMap.getCollection(key).containsAll(values));
    }

    @Test
    void testContainsValue() {
        String key = "key1";
        String value = "value1";
        multiValueMap.put(key, value);
        assertTrue(multiValueMap.containsValue(key, value));
        assertFalse(multiValueMap.containsValue(key, "nonexistent"));
    }

    @Test
    void testRemoveMapping() {
        String key = "key1";
        String value = "value1";
        multiValueMap.put(key, value);
        assertTrue(multiValueMap.removeMapping(key, value));
        assertFalse(multiValueMap.getCollection(key).contains(value));
        assertEquals(0, multiValueMap.size(key));
    }

    @Test
    void testTotalSize() {
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        multiValueMap.put("key2", "value3");
        assertEquals(3, multiValueMap.totalSize());
    }

    @Test
    void testClear() {
        multiValueMap.put("key1", "value1");
        multiValueMap.clear();
        assertEquals(0, multiValueMap.totalSize());
    }

    @Test
    void testValues() {
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        Collection<Object> values = multiValueMap.values();
        assertEquals(2, values.size());
        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
    }
}
