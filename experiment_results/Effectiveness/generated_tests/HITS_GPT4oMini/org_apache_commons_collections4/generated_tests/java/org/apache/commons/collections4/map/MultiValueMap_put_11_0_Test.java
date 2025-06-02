package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Supplier;
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
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_put_11_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        // Using a lambda expression to create a new ArrayList instance as the collection factory
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testPutNewKey() {
        String key = "key1";
        String value = "value1";
        Object result = multiValueMap.put(key, value);
        assertEquals(value, result);
        assertTrue(multiValueMap.getCollection(key).contains(value));
    }

    @Test
    void testPutExistingKey() {
        String key = "key2";
        String value1 = "value1";
        String value2 = "value2";
        multiValueMap.put(key, value1);
        Object result = multiValueMap.put(key, value2);
        assertEquals(value2, result);
        Collection<String> values = multiValueMap.getCollection(key);
        assertTrue(values.contains(value1));
        assertTrue(values.contains(value2));
        assertEquals(2, values.size());
    }

    @Test
    void testPutNullValue() {
        String key = "key3";
        Object result = multiValueMap.put(key, null);
        assertNull(result);
        assertTrue(multiValueMap.getCollection(key).isEmpty());
    }

    @Test
    void testPutNullKey() {
        String value = "value4";
        Object result = multiValueMap.put(null, value);
        assertEquals(value, result);
        assertTrue(multiValueMap.getCollection(null).contains(value));
    }

    @Test
    void testPutWithEmptyCollection() {
        String key = "key4";
        String value = "value5";
        Object result = multiValueMap.put(key, value);
        assertEquals(value, result);
        assertTrue(multiValueMap.getCollection(key).contains(value));
    }

    @Test
    void testPutWithExistingCollection() {
        String key = "key5";
        String value = "value6";
        multiValueMap.put(key, value);
        Object result = multiValueMap.put(key, "value7");
        assertEquals("value7", result);
        Collection<String> values = multiValueMap.getCollection(key);
        assertTrue(values.contains("value6"));
        assertTrue(values.contains("value7"));
        assertEquals(2, values.size());
    }
}
