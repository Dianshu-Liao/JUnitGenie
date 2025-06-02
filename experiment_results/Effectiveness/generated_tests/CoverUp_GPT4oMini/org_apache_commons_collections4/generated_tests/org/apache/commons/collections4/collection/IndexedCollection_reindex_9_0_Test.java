package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

class IndexedCollection_reindex_9_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> indexMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    void setUp() {
        indexMap = new MultiValueMap<>();
        // Simple transformer for testing
        keyTransformer = String::toUpperCase;
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        indexedCollection = new IndexedCollection<>(collection, keyTransformer, indexMap, true);
    }

    @Test
    void testReindex() {
        // Initial indexing
        indexedCollection.reindex();
        assertEquals(2, indexMap.size());
        assertTrue(indexMap.containsKey("ONE"));
        assertTrue(indexMap.containsKey("TWO"));
        assertTrue(((Collection<String>) indexMap.get("ONE")).contains("one"));
        assertTrue(((Collection<String>) indexMap.get("TWO")).contains("two"));
        // Modify the collection and reindex
        Collection<String> newCollection = new ArrayList<>();
        newCollection.add("three");
        newCollection.add("four");
        setCollection(newCollection);
        // Reindex after changing the collection
        indexedCollection.reindex();
        assertEquals(2, indexMap.size());
        assertTrue(indexMap.containsKey("THREE"));
        assertTrue(indexMap.containsKey("FOUR"));
        assertTrue(((Collection<String>) indexMap.get("THREE")).contains("three"));
        assertTrue(((Collection<String>) indexMap.get("FOUR")).contains("four"));
    }

    private void setCollection(Collection<String> collection) {
        try {
            Method setCollectionMethod = IndexedCollection.class.getDeclaredMethod("setCollection", Collection.class);
            setCollectionMethod.setAccessible(true);
            setCollectionMethod.invoke(indexedCollection, collection);
        } catch (Exception e) {
            fail("Failed to set collection: " + e.getMessage());
        }
    }
}
