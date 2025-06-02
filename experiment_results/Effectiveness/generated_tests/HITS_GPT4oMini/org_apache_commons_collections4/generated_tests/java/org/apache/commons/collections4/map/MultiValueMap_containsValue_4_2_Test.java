package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_containsValue_4_2_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        // Create a HashMap for the MultiValueMap
        HashMap<String, Collection<String>> map = new HashMap<>();
        // Use ArrayList as the collection type
        Factory<Collection<String>> factory = ArrayList::new;
        multiValueMap = new MultiValueMap<>(map, factory);
        // Add some values for testing
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        multiValueMap.put("key2", "value3");
    }

    @Test
    void testContainsValue_True() {
        // Test that containsValue returns true for an existing value
        assertTrue(multiValueMap.containsValue("value1"));
    }

    @Test
    void testContainsValue_False() {
        // Test that containsValue returns false for a non-existing value
        assertFalse(multiValueMap.containsValue("value4"));
    }

    @Test
    void testContainsValue_Empty() {
        // Test containsValue on an empty MultiValueMap
        MultiValueMap<String, String> emptyMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
        assertFalse(emptyMap.containsValue("value1"));
    }
}
