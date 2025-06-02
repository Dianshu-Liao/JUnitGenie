package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
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
import org.apache.commons.collections4.list.UnmodifiableList;

class CompositeCollection_iterator_11_0_Test {

    private CompositeCollection<String> compositeCollection;

    @BeforeEach
    void setUp() {
        compositeCollection = new CompositeCollection<>();
    }

    @Test
    void testIteratorReturnsEmptyIteratorWhenCollectionIsEmpty() {
        Iterator<String> iterator = compositeCollection.iterator();
        assertTrue(iterator instanceof EmptyIterator);
    }

    @Test
    void testIteratorReturnsCombinedIteratorsWhenCollectionsArePresent() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B"));
        List<String> list2 = new ArrayList<>(Arrays.asList("C", "D"));
        compositeCollection = new CompositeCollection<>(list1, list2);
        Iterator<String> iterator = compositeCollection.iterator();
        List<String> result = new ArrayList<>();
        iterator.forEachRemaining(result::add);
        List<String> expected = Arrays.asList("A", "B", "C", "D");
        assertEquals(expected, result);
    }

    @Test
    void testIteratorWithSingleCollection() {
        List<String> list = new ArrayList<>(Collections.singletonList("X"));
        compositeCollection = new CompositeCollection<>(list);
        Iterator<String> iterator = compositeCollection.iterator();
        List<String> result = new ArrayList<>();
        iterator.forEachRemaining(result::add);
        List<String> expected = Collections.singletonList("X");
        assertEquals(expected, result);
    }

    @Test
    void testIteratorWithMultipleEmptyCollections() {
        List<String> emptyList1 = new ArrayList<>();
        List<String> emptyList2 = new ArrayList<>();
        compositeCollection = new CompositeCollection<>(emptyList1, emptyList2);
        Iterator<String> iterator = compositeCollection.iterator();
        assertTrue(iterator instanceof EmptyIterator);
    }
}
