package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

public class IndexedCollection_containsAll_7_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    @BeforeEach
    public void setUp() {
        Transformer<String, String> keyTransformer = String::toLowerCase;
        MultiMap<String, String> multiMap = new MultiValueMap<>();
        indexedCollection = new IndexedCollection<>(Arrays.asList("Apple", "Banana", "Cherry"), keyTransformer, multiMap, true);
    }

    @Test
    public void testContainsAll_WithAllElementsPresent() {
        Collection<String> elementsToCheck = Arrays.asList("Apple", "Banana");
        assertTrue(indexedCollection.containsAll(elementsToCheck), "Should return true when all elements are present");
    }

    @Test
    public void testContainsAll_WithSomeElementsMissing() {
        Collection<String> elementsToCheck = Arrays.asList("Apple", "Banana", "Date");
        assertFalse(indexedCollection.containsAll(elementsToCheck), "Should return false when some elements are missing");
    }

    @Test
    public void testContainsAll_WithNoElements() {
        Collection<String> elementsToCheck = Collections.emptyList();
        assertTrue(indexedCollection.containsAll(elementsToCheck), "Should return true when checking against an empty collection");
    }

    @Test
    public void testContainsAll_WithSingleElementPresent() {
        Collection<String> elementsToCheck = Collections.singletonList("Cherry");
        assertTrue(indexedCollection.containsAll(elementsToCheck), "Should return true when the single element is present");
    }

    @Test
    public void testContainsAll_WithSingleElementMissing() {
        Collection<String> elementsToCheck = Collections.singletonList("Date");
        assertFalse(indexedCollection.containsAll(elementsToCheck), "Should return false when the single element is missing");
    }
}
