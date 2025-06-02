package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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
    void testCollate_WithNullIterableA_ShouldThrowNullPointerException() {
        Iterable<Integer> iterableB = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(null, iterableB, comparator, true);
        });
        assertEquals("iterableA", exception.getMessage());
    }

    @Test
    void testCollate_WithNullIterableB_ShouldThrowNullPointerException() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(iterableA, null, comparator, true);
        });
        assertEquals("iterableB", exception.getMessage());
    }

    @Test
    void testCollate_WithNullComparator_ShouldThrowNullPointerException() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(4, 5, 6);
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(iterableA, iterableB, null, true);
        });
        assertEquals("comparator", exception.getMessage());
    }

    @Test
    void testCollate_WithIncludeDuplicates_ShouldReturnListWithDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, true);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_WithoutIncludeDuplicates_ShouldReturnListWithoutDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, false);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_EmptyIterables_ShouldReturnEmptyList() {
        Iterable<Integer> iterableA = Collections.emptyList();
        Iterable<Integer> iterableB = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, false);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCollate_SingleElementIterables_ShouldReturnMergedList() {
        Iterable<Integer> iterableA = Collections.singletonList(1);
        Iterable<Integer> iterableB = Collections.singletonList(2);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, false);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_WithDuplicatesInBothIterables_ShouldReturnMergedListWithDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2);
        Iterable<Integer> iterableB = Arrays.asList(2, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, true);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 2, 3);
        assertEquals(expected, result);
    }

    @Test
    void testCollate_WithCustomComparator_ShouldReturnMergedList() {
        Iterable<String> iterableA = Arrays.asList("apple", "banana", "cherry");
        Iterable<String> iterableB = Arrays.asList("avocado", "blueberry", "citrus");
        Comparator<String> comparator = String::compareTo;
        List<String> result = CollectionUtils.collate(iterableA, iterableB, comparator, false);
        List<String> expected = Arrays.asList("apple", "avocado", "banana", "blueberry", "cherry", "citrus");
    }
}
