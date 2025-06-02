package org.apache.commons.collections4;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collection;
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

class CollectionUtils_collate_10_0_Test {

    @Test
    void testCollate_WithDuplicates() {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(listA, listB, comparator, true);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_WithoutDuplicates() {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(listA, listB, comparator, false);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_EmptyCollections() {
        List<Integer> listA = Collections.emptyList();
        List<Integer> listB = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(listA, listB, comparator, true);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    void testCollate_NullIterableA() {
        List<Integer> listB = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(null, listB, comparator, true);
        });
        assertEquals("iterableA", exception.getMessage());
    }

    @Test
    void testCollate_NullIterableB() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(listA, null, comparator, true);
        });
        assertEquals("iterableB", exception.getMessage());
    }

    @Test
    void testCollate_NullComparator() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(3, 4, 5);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(listA, listB, null, true);
        });
        assertEquals("comparator", exception.getMessage());
    }
}
