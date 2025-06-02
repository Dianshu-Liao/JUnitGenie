package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection_iterator_11_0_Test {

    private CompositeCollection<String> compositeCollection;

    @BeforeEach
    public void setUp() {
        compositeCollection = new CompositeCollection<>();
    }

    @Test
    public void testIterator_EmptyCollection_ReturnsEmptyIterator() {
        Iterator<String> iterator = compositeCollection.iterator();
        assertFalse(iterator.hasNext(), "Iterator should be empty for an empty CompositeCollection");
    }

    @Test
    public void testIterator_SingleNonEmptyCollection_ReturnsElements() {
        List<String> collection1 = Arrays.asList("one", "two", "three");
        compositeCollection.addComposited(collection1);
        Iterator<String> iterator = compositeCollection.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have elements");
        assertEquals("one", iterator.next());
        assertEquals("two", iterator.next());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext(), "Iterator should be empty after iterating through all elements");
    }

    @Test
    public void testIterator_MultipleCollections_ReturnsAllElements() {
        List<String> collection1 = Arrays.asList("one", "two");
        List<String> collection2 = Arrays.asList("three", "four");
        compositeCollection.addComposited(collection1);
        compositeCollection.addComposited(collection2);
        Iterator<String> iterator = compositeCollection.iterator();
        List<String> results = new ArrayList<>();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }
        List<String> expectedResults = Arrays.asList("one", "two", "three", "four");
        assertIterableEquals(expectedResults, results, "Iterator should return all elements from all collections");
    }

    @Test
    public void testIterator_NoCollections_ReturnsEmptyIterator() {
        compositeCollection = new CompositeCollection<>();
        Iterator<String> iterator = compositeCollection.iterator();
        assertFalse(iterator.hasNext(), "Iterator should be empty when no collections are added");
    }

    @Test
    public void testIterator_OneEmptyCollection_ReturnsEmptyIterator() {
        List<String> emptyCollection = Collections.emptyList();
        compositeCollection.addComposited(emptyCollection);
        Iterator<String> iterator = compositeCollection.iterator();
        assertFalse(iterator.hasNext(), "Iterator should be empty when only an empty collection is added");
    }

    @Test
    public void testIterator_MultipleCollectionsWithEmpty_ReturnsOnlyNonEmptyElements() {
        List<String> collection1 = Arrays.asList("one", "two");
        List<String> emptyCollection = Collections.emptyList();
        List<String> collection2 = Arrays.asList("three", "four");
        compositeCollection.addComposited(collection1);
        compositeCollection.addComposited(emptyCollection);
        compositeCollection.addComposited(collection2);
        Iterator<String> iterator = compositeCollection.iterator();
        List<String> results = new ArrayList<>();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }
        List<String> expectedResults = Arrays.asList("one", "two", "three", "four");
        assertIterableEquals(expectedResults, results, "Iterator should return all non-empty elements from all collections");
    }
}
