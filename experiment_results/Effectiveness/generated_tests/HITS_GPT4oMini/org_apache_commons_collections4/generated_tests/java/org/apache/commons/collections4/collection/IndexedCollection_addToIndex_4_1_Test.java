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

public class IndexedCollection_addToIndex_4_1_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> multiMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    public void setUp() {
        multiMap = new MultiValueMap<>();
        keyTransformer = String::toUpperCase;
        Collection<String> collection = new ArrayList<>();
        indexedCollection = new IndexedCollection<>(collection, keyTransformer, multiMap, false);
    }

    @Test
    public void testAddToIndex() {
        indexedCollection.add("test");
        assertTrue(multiMap.containsKey("TEST"));
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains("test"));
    }

    @Test
    public void testAddToIndexUnique() {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, true);
        indexedCollection.add("test");
        assertThrows(IllegalArgumentException.class, () -> indexedCollection.add("TEST"));
    }

    @Test
    public void testAddToIndexWithDifferentCase() {
        indexedCollection.add("test");
        indexedCollection.add("TEST");
        assertEquals(2, ((Collection<String>) multiMap.get("TEST")).size());
    }

    @Test
    public void testAddToIndexWithNull() {
        assertThrows(NullPointerException.class, () -> indexedCollection.add(null));
    }

    @Test
    public void testAddToIndexWhenEmpty() {
        indexedCollection.add("example");
        assertTrue(multiMap.containsKey("EXAMPLE"));
    }
}
