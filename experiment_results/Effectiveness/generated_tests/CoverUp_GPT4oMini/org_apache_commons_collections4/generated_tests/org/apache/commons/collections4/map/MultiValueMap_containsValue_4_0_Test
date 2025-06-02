package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
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

class // Reflection test case to invoke private methods if needed
// This is just an example, as there are no private methods in the provided code.
/*
    @Test
    void testPrivateMethod() throws Exception {
        Method method = MultiValueMap.class.getDeclaredMethod("yourPrivateMethodName");
        method.setAccessible(true);
        Object result = method.invoke(multiValueMap);
        // Assertions based on the expected result
    }
    */
MultiValueMap_containsValue_4_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        // Using a simple HashMap and a Factory for testing purposes.
        Map<String, Collection<String>> map = new HashMap<>();
        Factory<Collection<String>> factory = ArrayList::new;
        multiValueMap = new MultiValueMap<>(map, factory);
    }

    @Test
    void testContainsValueWhenValueExists() {
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        multiValueMap.put("key2", "value3");
        assertTrue(multiValueMap.containsValue("value1"));
        assertTrue(multiValueMap.containsValue("value2"));
        assertTrue(multiValueMap.containsValue("value3"));
    }

    @Test
    void testContainsValueWhenValueDoesNotExist() {
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key2", "value2");
        assertFalse(multiValueMap.containsValue("value3"));
        assertFalse(multiValueMap.containsValue("value4"));
    }

    @Test
    void testContainsValueWithEmptyMap() {
        assertFalse(multiValueMap.containsValue("value1"));
    }

    @Test
    void testContainsValueWithNullValue() {
        multiValueMap.put("key1", null);
        assertTrue(multiValueMap.containsValue(null));
        assertFalse(multiValueMap.containsValue("value1"));
    }

    @Test
    void testContainsValueWithNullKey() {
        multiValueMap.put(null, "value1");
        assertTrue(multiValueMap.containsValue("value1"));
    }

    @Test
    void testContainsValueWithMixedValues() {
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", null);
        multiValueMap.put("key2", "value2");
        assertTrue(multiValueMap.containsValue("value1"));
        assertTrue(multiValueMap.containsValue(null));
        assertFalse(multiValueMap.containsValue("value3"));
    }
}
