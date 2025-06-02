package org.apache.commons.collections4.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
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

class MultiValueMap_putAll_12_1_Test {

    private MultiValueMap<String, String> multiValueMap;

    private Map<String, Collection<String>> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        multiValueMap = Mockito.spy(new MultiValueMap<>(mockMap, ArrayList::new));
    }

    @Test
    void testPutAllWithNullValues() {
        boolean result = multiValueMap.putAll("key1", null);
        assertFalse(result);
        assertFalse(mockMap.containsKey("key1"));
    }

    @Test
    void testPutAllWithEmptyValues() {
        Collection<String> emptyCollection = new ArrayList<>();
        boolean result = multiValueMap.putAll("key1", emptyCollection);
        assertFalse(result);
        assertFalse(mockMap.containsKey("key1"));
    }

    @Test
    void testPutAllWithNewKey() {
        Collection<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        boolean result = multiValueMap.putAll("key1", values);
        assertTrue(result);
        assertTrue(mockMap.containsKey("key1"));
        assertEquals(2, mockMap.get("key1").size());
    }

    @Test
    void testPutAllWithExistingKey() {
        Collection<String> existingValues = new ArrayList<>();
        existingValues.add("existingValue");
        mockMap.put("key1", existingValues);
        Collection<String> newValues = new ArrayList<>();
        newValues.add("value1");
        boolean result = multiValueMap.putAll("key1", newValues);
        assertTrue(result);
        assertEquals(2, mockMap.get("key1").size());
    }

    @Test
    void testPutAllWithDuplicateValues() {
        Collection<String> existingValues = new ArrayList<>();
        existingValues.add("value1");
        mockMap.put("key1", existingValues);
        Collection<String> newValues = new ArrayList<>();
        newValues.add("value1");
        newValues.add("value2");
        boolean result = multiValueMap.putAll("key1", newValues);
        assertTrue(result);
        assertEquals(2, mockMap.get("key1").size());
    }

    @Test
    void testPutAllWithAllNullValues() {
        Collection<String> values = new ArrayList<>();
        values.add(null);
        boolean result = multiValueMap.putAll("key1", values);
        assertTrue(result);
        assertTrue(mockMap.containsKey("key1"));
        assertEquals(1, mockMap.get("key1").size());
    }
}
