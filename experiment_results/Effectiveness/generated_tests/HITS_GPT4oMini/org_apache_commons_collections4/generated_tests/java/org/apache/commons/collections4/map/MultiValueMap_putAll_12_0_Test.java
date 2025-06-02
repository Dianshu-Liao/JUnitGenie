package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.Factory;
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
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testPutAllWithNullValues() {
        boolean result = multiValueMap.putAll("key1", null);
        assertFalse(result, "putAll should return false when values are null");
    }

    @Test
    void testPutAllWithEmptyCollection() {
        Collection<String> emptyCollection = new ArrayList<>();
        boolean result = multiValueMap.putAll("key1", emptyCollection);
        assertFalse(result, "putAll should return false when values are empty");
    }

    @Test
    void testPutAllWithNewKey() {
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        boolean result = multiValueMap.putAll("key1", values);
        assertTrue(result, "putAll should return true when adding a new key with values");
        assertEquals(2, multiValueMap.getCollection("key1").size(), "The size of the collection for key1 should be 2");
    }

    @Test
    void testPutAllWithExistingKey() {
        Collection<String> initialValues = new ArrayList<>();
        initialValues.add("value1");
        multiValueMap.putAll("key1", initialValues);
        Collection<String> newValues = new ArrayList<>();
        newValues.add("value2");
        newValues.add("value3");
        boolean result = multiValueMap.putAll("key1", newValues);
        assertTrue(result, "putAll should return true when adding values to an existing key");
        assertEquals(3, multiValueMap.getCollection("key1").size(), "The size of the collection for key1 should be 3");
    }

    @Test
    void testPutAllWithDuplicateValues() {
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        // duplicate value
        values.add("value1");
        boolean result = multiValueMap.putAll("key1", values);
        assertTrue(result, "putAll should return true when adding duplicate values");
        assertEquals(2, multiValueMap.getCollection("key1").size(), "The size of the collection for key1 should be 2 due to duplicates");
    }
}
