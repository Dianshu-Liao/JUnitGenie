package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
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

class IndexedCollection_containsAll_7_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> indexMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    void setUp() {
        indexMap = new MultiValueMap<String, String>();
        keyTransformer = String::toLowerCase;
        // Initialize the IndexedCollection with some test data
        indexedCollection = new IndexedCollection<>(Arrays.asList("Apple", "Banana", "Cherry"), keyTransformer, indexMap, true);
        // Populate the index
        indexMap.put(keyTransformer.transform("Apple"), "Apple");
        indexMap.put(keyTransformer.transform("Banana"), "Banana");
        indexMap.put(keyTransformer.transform("Cherry"), "Cherry");
    }

    @Test
    void testContainsAll_WithAllElementsPresent() {
        Collection<String> collectionToTest = new HashSet<>(Arrays.asList("Apple", "Banana"));
        assertTrue(indexedCollection.containsAll(collectionToTest));
    }

    @Test
    void testContainsAll_WithMissingElement() {
        Collection<String> collectionToTest = new HashSet<>(Arrays.asList("Apple", "Grapes"));
        assertFalse(indexedCollection.containsAll(collectionToTest));
    }

    @Test
    void testContainsAll_WithEmptyCollection() {
        Collection<String> collectionToTest = new HashSet<>();
        assertTrue(indexedCollection.containsAll(collectionToTest));
    }

    @Test
    void testContainsAll_WithNullElement() {
        Collection<String> collectionToTest = new HashSet<>(Arrays.asList("Apple", null));
        assertFalse(indexedCollection.containsAll(collectionToTest));
    }

    @Test
    void testContainsAll_WithNonExistentElement() {
        Collection<String> collectionToTest = new HashSet<>(Arrays.asList("Unknown", "Banana"));
        assertFalse(indexedCollection.containsAll(collectionToTest));
    }

    // Reflection test for private method contains
    @Test
    void testContains_PrivateMethod() throws Exception {
        Method containsMethod = IndexedCollection.class.getDeclaredMethod("contains", Object.class);
        containsMethod.setAccessible(true);
        // Test with an existing element
        boolean result1 = (boolean) containsMethod.invoke(indexedCollection, "Apple");
        assertTrue(result1);
        // Test with a non-existing element
        boolean result2 = (boolean) containsMethod.invoke(indexedCollection, "Grapes");
        assertFalse(result2);
    }
}
