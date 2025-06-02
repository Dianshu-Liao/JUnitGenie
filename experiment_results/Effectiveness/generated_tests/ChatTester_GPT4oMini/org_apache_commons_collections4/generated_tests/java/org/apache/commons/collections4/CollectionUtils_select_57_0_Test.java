package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.Collections;
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
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_select_57_0_Test {

    private List<Integer> inputCollection;

    private Collection<Integer> outputCollection;

    private org.apache.commons.collections4.Predicate<Integer> predicate;

    @BeforeEach
    public void setUp() {
        inputCollection = new ArrayList<>();
        outputCollection = new ArrayList<>();
        predicate = mock(org.apache.commons.collections4.Predicate.class);
    }

    @Test
    public void testSelect_NullInputCollection() {
        Collection<Integer> result = CollectionUtils.select(null, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(outputCollection.isEmpty());
    }

    @Test
    public void testSelect_NullPredicate() {
        Collection<Integer> result = CollectionUtils.select(inputCollection, null, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(outputCollection.isEmpty());
    }

    @Test
    public void testSelect_EmptyInputCollection() {
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(outputCollection.isEmpty());
    }

    @Test
    public void testSelect_SingleItemMatchingPredicate() {
        inputCollection.add(1);
        when(predicate.evaluate(1)).thenReturn(true);
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertEquals(1, outputCollection.size());
        assertTrue(outputCollection.contains(1));
    }

    @Test
    public void testSelect_SingleItemNotMatchingPredicate() {
        inputCollection.add(1);
        when(predicate.evaluate(1)).thenReturn(false);
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertTrue(outputCollection.isEmpty());
    }

    @Test
    public void testSelect_MultipleItemsWithSomeMatching() {
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        when(predicate.evaluate(1)).thenReturn(true);
        when(predicate.evaluate(2)).thenReturn(false);
        when(predicate.evaluate(3)).thenReturn(true);
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertEquals(2, outputCollection.size());
        assertTrue(outputCollection.contains(1));
        assertTrue(outputCollection.contains(3));
    }

    @Test
    public void testSelect_AllItemsMatching() {
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        when(predicate.evaluate(1)).thenReturn(true);
        when(predicate.evaluate(2)).thenReturn(true);
        when(predicate.evaluate(3)).thenReturn(true);
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        assertEquals(outputCollection, result);
        assertEquals(3, outputCollection.size());
        assertTrue(outputCollection.contains(1));
        assertTrue(outputCollection.contains(2));
        assertTrue(outputCollection.contains(3));
    }
}
