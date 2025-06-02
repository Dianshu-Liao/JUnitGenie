package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.MultiValueMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_putAll_12_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        // Initialize MultiValueMap with a HashMap and a Factory for ArrayList
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testPutAllWithNullValues() {
        // Test putAll with null collection
        assertFalse(multiValueMap.putAll("key1", null));
    }

    @Test
    void testPutAllWithEmptyCollection() {
        // Test putAll with empty collection
        Collection<String> emptyCollection = new ArrayList<>();
        assertFalse(multiValueMap.putAll("key1", emptyCollection));
    }

    @Test
    void testPutAllWithNewKey() {
        // Test putAll with a new key and a non-empty collection
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        assertTrue(multiValueMap.putAll("key1", values));
        assertEquals(2, multiValueMap.getCollection("key1").size());
    }

    @Test
    void testPutAllWithExistingKey() {
        // Test putAll with an existing key
        Collection<String> initialValues = new ArrayList<>();
        initialValues.add("value1");
        multiValueMap.putAll("key1", initialValues);
        Collection<String> newValues = new ArrayList<>();
        newValues.add("value2");
        newValues.add("value3");
        assertTrue(multiValueMap.putAll("key1", newValues));
        assertEquals(3, multiValueMap.getCollection("key1").size());
    }

    @Test
    void testPutAllWithDuplicateValues() {
        // Test putAll with duplicate values
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        // Duplicate
        values.add("value1");
        assertTrue(multiValueMap.putAll("key1", values));
        assertEquals(2, multiValueMap.getCollection("key1").size());
    }

    @Test
    void testPutAllWithNonEmptyExistingCollection() {
        // Test putAll with a non-empty existing collection
        Collection<String> initialValues = new ArrayList<>();
        initialValues.add("value1");
        multiValueMap.putAll("key1", initialValues);
        Collection<String> newValues = new ArrayList<>();
        newValues.add("value2");
        assertTrue(multiValueMap.putAll("key1", newValues));
        assertEquals(2, multiValueMap.getCollection("key1").size());
    }
}
