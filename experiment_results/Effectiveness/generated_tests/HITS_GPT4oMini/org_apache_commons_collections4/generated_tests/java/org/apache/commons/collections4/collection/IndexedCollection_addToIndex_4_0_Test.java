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

class IndexedCollection_addToIndex_4_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> multiMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    void setUp() {
        multiMap = new MultiValueMap<>();
        keyTransformer = String::toUpperCase;
        Collection<String> initialCollection = new ArrayList<>();
        indexedCollection = new IndexedCollection<>(initialCollection, keyTransformer, multiMap, true);
    }

    @Test
    void testAddToIndexWithUniqueKey() {
        String object = "test";
        // Use the public method
        indexedCollection.add(object);
        assertTrue(multiMap.containsKey("TEST"));
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains(object));
    }

    @Test
    void testAddToIndexThrowsExceptionOnDuplicateKey() {
        String object1 = "test";
        String object2 = "TEST";
        // Use the public method
        indexedCollection.add(object1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Use the public method
            indexedCollection.add(object2);
        });
        assertEquals("Duplicate key in uniquely indexed collection.", exception.getMessage());
    }

    @Test
    void testAddToIndexMultipleObjectsWithSameKey() {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, false);
        String object1 = "test";
        String object2 = "TEST";
        // Use the public method
        indexedCollection.add(object1);
        // Use the public method
        indexedCollection.add(object2);
        assertTrue(multiMap.containsKey("TEST"));
        assertEquals(2, ((Collection<String>) multiMap.get("TEST")).size());
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains(object1));
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains(object2));
    }

    @Test
    void testAddToIndexWithDifferentKeys() {
        String object1 = "test";
        String object2 = "example";
        // Use the public method
        indexedCollection.add(object1);
        // Use the public method
        indexedCollection.add(object2);
        assertTrue(multiMap.containsKey("TEST"));
        assertTrue(multiMap.containsKey("EXAMPLE"));
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains(object1));
        assertTrue(((Collection<String>) multiMap.get("EXAMPLE")).contains(object2));
    }
}
