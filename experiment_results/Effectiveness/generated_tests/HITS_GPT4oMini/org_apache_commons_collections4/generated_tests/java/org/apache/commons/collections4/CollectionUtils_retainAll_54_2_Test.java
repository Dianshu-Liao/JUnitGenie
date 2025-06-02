package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
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

public class CollectionUtils_retainAll_54_2_Test {

    // A simple Equator implementation for testing purposes
    static class SimpleEquator<T> implements Equator<T> {

        @Override
        public boolean equate(T first, T second) {
            return first.equals(second);
        }

        @Override
        public int hash(T object) {
            return Objects.hashCode(object);
        }
    }

    @Test
    public void testRetainAllWithCommonElements() {
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        List<Integer> retain = new ArrayList<>();
        retain.add(2);
        retain.add(3);
        Collection<Integer> result = CollectionUtils.retainAll(collection, retain, new SimpleEquator<>());
        assertEquals(2, result.size());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    @Test
    public void testRetainAllWithNoCommonElements() {
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        List<Integer> retain = new ArrayList<>();
        retain.add(4);
        retain.add(5);
        Collection<Integer> result = CollectionUtils.retainAll(collection, retain, new SimpleEquator<>());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRetainAllWithEmptyCollection() {
        List<Integer> collection = new ArrayList<>();
        List<Integer> retain = new ArrayList<>();
        retain.add(1);
        Collection<Integer> result = CollectionUtils.retainAll(collection, retain, new SimpleEquator<>());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRetainAllWithEmptyRetain() {
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        List<Integer> retain = new ArrayList<>();
        Collection<Integer> result = CollectionUtils.retainAll(collection, retain, new SimpleEquator<>());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRetainAllWithNullCollection() {
        List<Integer> retain = new ArrayList<>();
        retain.add(1);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(null, retain, new SimpleEquator<>());
        });
        assertEquals("collection", exception.getMessage());
    }
}
