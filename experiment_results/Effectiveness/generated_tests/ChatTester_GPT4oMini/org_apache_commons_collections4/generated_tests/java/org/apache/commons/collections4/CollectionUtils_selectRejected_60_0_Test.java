package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
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
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

class CollectionUtils_selectRejected_60_0_Test {

    private List<String> inputCollection;

    private org.apache.commons.collections4.Predicate<String> predicate;

    private Collection<String> outputCollection;

    @BeforeEach
    void setUp() {
        inputCollection = new ArrayList<>();
        // example predicate
        predicate = s -> s.startsWith("A");
        outputCollection = new ArrayList<>();
    }

    @Test
    void testSelectRejected_NullInputCollection() {
        Collection<String> result = CollectionUtils.selectRejected(null, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSelectRejected_NullPredicate() {
        Collection<String> result = CollectionUtils.selectRejected(inputCollection, null, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSelectRejected_EmptyInputCollection() {
        Collection<String> result = CollectionUtils.selectRejected(Collections.emptyList(), predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSelectRejected_NoItemsRejected() {
        inputCollection.add("Apple");
        inputCollection.add("Avocado");
        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSelectRejected_SomeItemsRejected() {
        inputCollection.add("Apple");
        inputCollection.add("Banana");
        inputCollection.add("Avocado");
        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.contains("Banana"));
        assertEquals(1, result.size());
    }

    @Test
    void testSelectRejected_AllItemsRejected() {
        inputCollection.add("Banana");
        inputCollection.add("Cherry");
        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(result.contains("Banana"));
        assertTrue(result.contains("Cherry"));
        assertEquals(2, result.size());
    }
}
