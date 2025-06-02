package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

public class MultiValueMap_containsValue_4_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    public void setUp() {
        multiValueMap = new MultiValueMap<>();
        // Setting up a simple map with some collections
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        multiValueMap.put("key2", "value3");
    }

    @Test
    public void testContainsValue_ExistingValue() {
        assertTrue(multiValueMap.containsValue("value1"), "Should contain value1");
        assertTrue(multiValueMap.containsValue("value2"), "Should contain value2");
        assertTrue(multiValueMap.containsValue("value3"), "Should contain value3");
    }

    @Test
    public void testContainsValue_NonExistingValue() {
        assertFalse(multiValueMap.containsValue("value4"), "Should not contain value4");
        assertFalse(multiValueMap.containsValue("value5"), "Should not contain value5");
    }

    @Test
    public void testContainsValue_EmptyMap() {
        MultiValueMap<String, String> emptyMap = new MultiValueMap<>();
        assertFalse(emptyMap.containsValue("value1"), "Should not contain any value in an empty map");
    }

    @Test
    public void testContainsValue_NullValue() {
        multiValueMap.put("key3", null);
        assertTrue(multiValueMap.containsValue(null), "Should contain null value");
    }

    @Test
    public void testContainsValue_WithMultipleValues() {
        multiValueMap.put("key4", "value1");
        multiValueMap.put("key4", "value4");
        assertTrue(multiValueMap.containsValue("value4"), "Should contain value4");
        assertTrue(multiValueMap.containsValue("value1"), "Should contain value1");
    }
}
