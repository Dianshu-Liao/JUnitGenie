package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

class CollectionUtils_select_58_1_Test {

    private List<Integer> inputCollection;

    private HashSet<Integer> outputCollection;

    private HashSet<Integer> rejectedCollection;

    private Predicate<Integer> predicate;

    @BeforeEach
    void setUp() {
        inputCollection = new ArrayList<>();
        outputCollection = new HashSet<>();
        rejectedCollection = new HashSet<>();
        // Predicate to select even numbers
        predicate = integer -> integer % 2 == 0;
    }

    @Test
    void testSelectWithNullInputCollection() {
        CollectionUtils.select(null, predicate, outputCollection, rejectedCollection);
        assertTrue(outputCollection.isEmpty());
        assertTrue(rejectedCollection.isEmpty());
    }

    @Test
    void testSelectWithNullPredicate() {
        CollectionUtils.select(inputCollection, null, outputCollection, rejectedCollection);
        assertTrue(outputCollection.isEmpty());
        assertTrue(rejectedCollection.isEmpty());
    }

    @Test
    void testSelectWithEmptyInputCollection() {
        CollectionUtils.select(inputCollection, predicate, outputCollection, rejectedCollection);
        assertTrue(outputCollection.isEmpty());
        assertTrue(rejectedCollection.isEmpty());
    }

    @Test
    void testSelectWithEvenNumbers() {
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        inputCollection.add(4);
        CollectionUtils.select(inputCollection, predicate, outputCollection, rejectedCollection);
        assertEquals(2, outputCollection.size());
        assertTrue(outputCollection.contains(2));
        assertTrue(outputCollection.contains(4));
        assertEquals(2, rejectedCollection.size());
        assertTrue(rejectedCollection.contains(1));
        assertTrue(rejectedCollection.contains(3));
    }

    @Test
    void testSelectWithAllEvenNumbers() {
        inputCollection.add(2);
        inputCollection.add(4);
        inputCollection.add(6);
        CollectionUtils.select(inputCollection, predicate, outputCollection, rejectedCollection);
        assertEquals(3, outputCollection.size());
        assertTrue(outputCollection.contains(2));
        assertTrue(outputCollection.contains(4));
        assertTrue(outputCollection.contains(6));
        assertTrue(rejectedCollection.isEmpty());
    }

    @Test
    void testSelectWithAllOddNumbers() {
        inputCollection.add(1);
        inputCollection.add(3);
        inputCollection.add(5);
        CollectionUtils.select(inputCollection, predicate, outputCollection, rejectedCollection);
        assertTrue(outputCollection.isEmpty());
        assertEquals(3, rejectedCollection.size());
        assertTrue(rejectedCollection.contains(1));
        assertTrue(rejectedCollection.contains(3));
        assertTrue(rejectedCollection.contains(5));
    }
}
