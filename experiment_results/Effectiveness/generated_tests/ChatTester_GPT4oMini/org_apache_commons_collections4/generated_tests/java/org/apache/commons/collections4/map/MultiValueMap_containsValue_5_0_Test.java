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

class MultiValueMap_containsValue_5_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    // Test case when the collection for the key is null
    @Test
    void testContainsValue_KeyNotPresent() {
        assertFalse(multiValueMap.containsValue("nonexistentKey", "value"));
    }

    // Test case when the collection for the key is present but does not contain the value
    @Test
    void testContainsValue_KeyPresent_ValueNotFound() {
        multiValueMap.put("key", "value1");
        assertFalse(multiValueMap.containsValue("key", "value2"));
    }

    // Test case when the collection for the key contains the value
    @Test
    void testContainsValue_KeyPresent_ValueFound() {
        multiValueMap.put("key", "value1");
        multiValueMap.put("key", "value2");
        assertTrue(multiValueMap.containsValue("key", "value1"));
    }

    // Test case when the collection is empty for the key
    @Test
    void testContainsValue_KeyPresent_EmptyCollection() {
        multiValueMap.put("key", new ArrayList<>());
        assertFalse(multiValueMap.containsValue("key", "value"));
    }

    // Test case when the null value is checked
    @Test
    void testContainsValue_KeyPresent_NullValue() {
        multiValueMap.put("key", "value1");
        assertFalse(multiValueMap.containsValue("key", null));
    }

    // Test case when the key is null
    @Test
    void testContainsValue_NullKey() {
        assertFalse(multiValueMap.containsValue(null, "value"));
    }

    // Test case when the value is null
    @Test
    void testContainsValue_NullValue() {
        multiValueMap.put("key", null);
        assertTrue(multiValueMap.containsValue("key", null));
    }

    // Additional test case when the key has multiple values including null
    @Test
    void testContainsValue_KeyWithMultipleValuesIncludingNull() {
        multiValueMap.put("key", "value1");
        multiValueMap.put("key", null);
        assertTrue(multiValueMap.containsValue("key", null));
    }
}
