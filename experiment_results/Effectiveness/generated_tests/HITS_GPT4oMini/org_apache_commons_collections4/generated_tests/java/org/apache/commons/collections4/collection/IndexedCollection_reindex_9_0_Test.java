package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import java.util.ArrayList;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class IndexedCollection_reindex_9_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> multiMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    public void setUp() {
        multiMap = new MultiValueMap<>();
        keyTransformer = String::toUpperCase;
        Collection<String> collection = new ArrayList<>();
        collection.add("apple");
        collection.add("banana");
        indexedCollection = new IndexedCollection<>(collection, keyTransformer, multiMap, true);
    }

    @Test
    public void testReindexWithExistingElements() {
        indexedCollection.reindex();
        assertEquals(2, multiMap.size());
        assertTrue(multiMap.containsKey("APPLE"));
        assertTrue(multiMap.containsKey("BANANA"));
    }

    @Test
    public void testReindexAfterAddingNewElement() {
        indexedCollection.reindex();
        indexedCollection = new IndexedCollection<>(addElement("cherry"), keyTransformer, multiMap, true);
        indexedCollection.reindex();
        assertEquals(3, multiMap.size());
        assertTrue(multiMap.containsKey("CHERRY"));
    }

    @Test
    public void testReindexWhenCollectionIsEmpty() {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, true);
        indexedCollection.reindex();
        assertTrue(multiMap.isEmpty());
    }

    @Test
    public void testReindexWithDuplicateKey() {
        indexedCollection.reindex();
        indexedCollection = new IndexedCollection<>(addElement("apple"), keyTransformer, multiMap, true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            indexedCollection.reindex();
        });
        assertEquals("Duplicate key in uniquely indexed collection.", exception.getMessage());
    }

    private Collection<String> addElement(String element) {
        Collection<String> collection = new ArrayList<>();
        collection.add(element);
        return collection;
    }
}
