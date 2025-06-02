package org.apache.commons.collections4;

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
import java.util.ArrayList;
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

public class CollectionUtils_collate_9_0_Test {

    @Test
    public void testCollateWithNonEmptyCollections() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithEmptyFirstCollection() {
        List<Integer> list1 = Collections.emptyList();
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(2, 4, 6);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithEmptySecondCollection() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(1, 3, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithBothEmptyCollections() {
        List<Integer> list1 = Collections.emptyList();
        List<Integer> list2 = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithDuplicates() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithNullComparator() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        // Expecting a NullPointerException to be thrown
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.collate(list1, list2, null);
        });
    }

    @Test
    public void testCollateWithSingleElementCollections() {
        List<Integer> list1 = Collections.singletonList(1);
        List<Integer> list2 = Collections.singletonList(2);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithReversedOrder() {
        List<Integer> list1 = Arrays.asList(5, 3, 1);
        List<Integer> list2 = Arrays.asList(6, 4, 2);
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> result = CollectionUtils.collate(list1, list2, comparator);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }
}
