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

class MultiValueMap_containsValue_5_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testContainsValue_WhenKeyDoesNotExist_ShouldReturnFalse() {
        assertFalse(multiValueMap.containsValue("nonexistentKey", "value"));
    }

    @Test
    void testContainsValue_WhenKeyExistsButValueDoesNot_ShouldReturnFalse() {
        multiValueMap.getCollection("existingKey").add("value1");
        assertFalse(multiValueMap.containsValue("existingKey", "value2"));
    }

    @Test
    void testContainsValue_WhenKeyAndValueExist_ShouldReturnTrue() {
        multiValueMap.getCollection("existingKey").add("value1");
        multiValueMap.getCollection("existingKey").add("value2");
        assertTrue(multiValueMap.containsValue("existingKey", "value1"));
    }

    @Test
    void testContainsValue_WhenKeyIsNull_ShouldReturnFalse() {
        assertFalse(multiValueMap.containsValue(null, "value"));
    }

    @Test
    void testContainsValue_WhenValueIsNull_ShouldReturnFalse() {
        multiValueMap.getCollection("existingKey").add("value1");
        assertFalse(multiValueMap.containsValue("existingKey", null));
    }

    @Test
    void testContainsValue_WhenBothKeyAndValueAreNull_ShouldReturnFalse() {
        assertFalse(multiValueMap.containsValue(null, null));
    }

    @Test
    void testContainsValue_WithMultipleValuesForKey_ShouldReturnTrueForExistingValue() {
        multiValueMap.getCollection("key").add("value1");
        multiValueMap.getCollection("key").add("value2");
        assertTrue(multiValueMap.containsValue("key", "value2"));
    }

    @Test
    void testContainsValue_WithMultipleValuesForKey_ShouldReturnFalseForNonExistingValue() {
        multiValueMap.getCollection("key").add("value1");
        assertFalse(multiValueMap.containsValue("key", "value3"));
    }
}
