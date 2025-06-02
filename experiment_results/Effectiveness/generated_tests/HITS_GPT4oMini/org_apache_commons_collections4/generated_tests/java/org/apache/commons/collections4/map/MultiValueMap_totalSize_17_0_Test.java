package org.apache.commons.collections4.map;

import org.apache.commons.collections4.CollectionUtils;
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
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

public class MultiValueMap_totalSize_17_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    public void setUp() {
        multiValueMap = new MultiValueMap<>();
    }

    @Test
    public void testTotalSize_EmptyMap() {
        assertEquals(0, multiValueMap.totalSize(), "Total size should be 0 for an empty map.");
    }

    @Test
    public void testTotalSize_SingleEmptyCollection() {
        multiValueMap.put("key1", new ArrayList<>());
        assertEquals(0, multiValueMap.totalSize(), "Total size should be 0 for a map with an empty collection.");
    }

    @Test
    public void testTotalSize_SingleCollectionWithElements() {
        multiValueMap.put("key1", Arrays.asList("value1", "value2"));
        assertEquals(2, multiValueMap.totalSize(), "Total size should be 2 for a map with a collection of two elements.");
    }

    @Test
    public void testTotalSize_MultipleCollections() {
        multiValueMap.put("key1", Arrays.asList("value1", "value2"));
        multiValueMap.put("key2", Arrays.asList("value3"));
        assertEquals(3, multiValueMap.totalSize(), "Total size should be 3 for a map with multiple collections.");
    }

    @Test
    public void testTotalSize_MixedEmptyAndNonEmptyCollections() {
        multiValueMap.put("key1", Arrays.asList("value1"));
        multiValueMap.put("key2", new ArrayList<>());
        multiValueMap.put("key3", Arrays.asList("value2", "value3"));
        assertEquals(3, multiValueMap.totalSize(), "Total size should be 3 for a map with mixed empty and non-empty collections.");
    }

    @Test
    public void testTotalSize_NestedCollections() {
        multiValueMap.put("key1", Arrays.asList(Arrays.asList("value1", "value2"), Arrays.asList("value3")));
        assertEquals(0, multiValueMap.totalSize(), "Total size should be 0 for a map with nested collections, as they are not counted.");
    }

    @Test
    public void testTotalSize_CollectionOfCollections() {
        Collection<Collection<String>> collectionOfCollections = new ArrayList<>();
        collectionOfCollections.add(Arrays.asList("value1", "value2"));
        collectionOfCollections.add(Arrays.asList("value3", "value4"));
        multiValueMap.put("key1", collectionOfCollections);
        assertEquals(4, multiValueMap.totalSize(), "Total size should be 4 for a map with a collection of collections.");
    }
}
