package org.apache.commons.collections4.map;

import java.util.Arrays;
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
import java.util.ArrayList;
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

public class MultiValueMap_putAll_13_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    public void setUp() {
        multiValueMap = new MultiValueMap<>();
    }

    @Test
    public void testPutAllWithMultiMap() {
        MultiValueMap<String, String> sourceMap = new MultiValueMap<>();
        sourceMap.put("key1", "value1");
        sourceMap.put("key1", "value2");
        sourceMap.put("key2", "value3");
        multiValueMap.putAll(sourceMap);
        assertEquals(2, multiValueMap.getCollection("key1").size());
        assertTrue(multiValueMap.getCollection("key1").contains("value1"));
        assertTrue(multiValueMap.getCollection("key1").contains("value2"));
        assertEquals(1, multiValueMap.getCollection("key2").size());
        assertTrue(multiValueMap.getCollection("key2").contains("value3"));
    }

    @Test
    public void testPutAllWithRegularMap() {
        Map<String, Collection<String>> sourceMap = new HashMap<>();
        sourceMap.put("key1", Arrays.asList("value1", "value2"));
        sourceMap.put("key2", Arrays.asList("value3"));
        multiValueMap.putAll(sourceMap);
        assertEquals(2, multiValueMap.getCollection("key1").size());
        assertTrue(multiValueMap.getCollection("key1").contains("value1"));
        assertTrue(multiValueMap.getCollection("key1").contains("value2"));
        assertEquals(1, multiValueMap.getCollection("key2").size());
        assertTrue(multiValueMap.getCollection("key2").contains("value3"));
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Collection<String>> sourceMap = new HashMap<>();
        multiValueMap.putAll(sourceMap);
        assertTrue(multiValueMap.isEmpty());
    }

    @Test
    public void testPutAllWithNullMap() {
        assertThrows(NullPointerException.class, () -> {
            multiValueMap.putAll(null);
        });
    }

    @Test
    public void testPutAllWithMixedMap() {
        Map<String, Object> sourceMap = new HashMap<>();
        sourceMap.put("key1", "value1");
        sourceMap.put("key2", Arrays.asList("value2", "value3"));
        multiValueMap.putAll(sourceMap);
        assertEquals(1, multiValueMap.getCollection("key1").size());
        assertTrue(multiValueMap.getCollection("key1").contains("value1"));
        assertEquals(2, multiValueMap.getCollection("key2").size());
        assertTrue(multiValueMap.getCollection("key2").contains("value2"));
        assertTrue(multiValueMap.getCollection("key2").contains("value3"));
    }
}
