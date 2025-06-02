package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
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

public class CollectionUtils_collate_7_0_Test {

    @Test
    public void testCollate_NonEmptyIterables() {
        Iterable<Integer> a = Arrays.asList(1, 3, 5);
        Iterable<Integer> b = Arrays.asList(2, 4, 6);
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testCollate_EmptyFirstIterable() {
        Iterable<Integer> a = Arrays.asList();
        Iterable<Integer> b = Arrays.asList(2, 4, 6);
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(2, 4, 6), result);
    }

    @Test
    public void testCollate_EmptySecondIterable() {
        Iterable<Integer> a = Arrays.asList(1, 3, 5);
        Iterable<Integer> b = Arrays.asList();
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(1, 3, 5), result);
    }

    @Test
    public void testCollate_BothEmptyIterables() {
        Iterable<Integer> a = Arrays.asList();
        Iterable<Integer> b = Arrays.asList();
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testCollate_SingleElementIterables() {
        Iterable<Integer> a = Arrays.asList(1);
        Iterable<Integer> b = Arrays.asList(2);
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testCollate_SameElements() {
        Iterable<Integer> a = Arrays.asList(1, 2, 3);
        Iterable<Integer> b = Arrays.asList(1, 2, 3);
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(1, 1, 2, 2, 3, 3), result);
    }

    @Test
    public void testCollate_NegativeAndPositiveNumbers() {
        Iterable<Integer> a = Arrays.asList(-3, -1, 2);
        Iterable<Integer> b = Arrays.asList(-2, 1, 3);
        List<Integer> result = CollectionUtils.collate(a, b);
        assertEquals(Arrays.asList(-3, -2, -1, 1, 2, 3), result);
    }
}
