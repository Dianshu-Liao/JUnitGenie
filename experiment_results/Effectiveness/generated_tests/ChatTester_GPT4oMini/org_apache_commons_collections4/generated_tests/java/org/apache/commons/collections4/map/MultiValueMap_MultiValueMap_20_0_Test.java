package org.apache.commons.collections4.map;

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

class MultiValueMap_MultiValueMap_20_0_Test {

    private MultiValueMap multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap();
    }

    @Test
    void testMultiValueMapConstructor() {
        assertNotNull(multiValueMap, "MultiValueMap instance should be created");
    }

    @Test
    void testMultiValueMapEmptyMap() {
        // Assuming we can access the internal map for testing purposes
        Map<?, ?> internalMap = getInternalMap(multiValueMap);
        assertTrue(internalMap.isEmpty(), "Internal map should be empty upon initialization");
    }

    @Test
    void testMultiValueMapDefaultCollectionFactory() {
        // Assuming we can access the collectionFactory for testing purposes
        Factory<? extends Collection<?>> factory = getCollectionFactory(multiValueMap);
        assertNotNull(factory, "Collection factory should not be null");
        assertEquals(ArrayList.class, factory.create().getClass(), "Default collection should be an ArrayList");
    }

    @Test
    void testMultiValueMapContainsValue() {
        multiValueMap.put("key1", "value1");
        assertTrue(multiValueMap.containsValue("value1"), "MultiValueMap should contain 'value1'");
    }

    @Test
    void testMultiValueMapPutAll() {
        Collection<String> values = new ArrayList<>();
        values.add("value2");
        values.add("value3");
        multiValueMap.putAll("key2", values);
        assertTrue(multiValueMap.containsValue("key2", "value2"), "MultiValueMap should contain 'value2' for 'key2'");
        assertTrue(multiValueMap.containsValue("key2", "value3"), "MultiValueMap should contain 'value3' for 'key2'");
    }

    // Reflection methods to access private fields
    private Map<?, ?> getInternalMap(MultiValueMap multiValueMap) {
        try {
            java.lang.reflect.Field field = MultiValueMap.class.getDeclaredField("map");
            field.setAccessible(true);
            return (Map<?, ?>) field.get(multiValueMap);
        } catch (Exception e) {
            fail("Failed to access internal map: " + e.getMessage());
            return null;
        }
    }

    private Factory<? extends Collection<?>> getCollectionFactory(MultiValueMap multiValueMap) {
        try {
            java.lang.reflect.Field field = MultiValueMap.class.getDeclaredField("collectionFactory");
            field.setAccessible(true);
            return (Factory<? extends Collection<?>>) field.get(multiValueMap);
        } catch (Exception e) {
            fail("Failed to access collection factory: " + e.getMessage());
            return null;
        }
    }
}
