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
    public void testCollate_EmptyIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(), Arrays.asList());
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testCollate_OneEmptyIterable() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 3), Arrays.asList());
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testCollate_BothIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testCollate_SortedInput() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testCollate_DuplicateElements() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 2, 3), Arrays.asList(2, 4, 4, 5));
        assertEquals(Arrays.asList(1, 2, 2, 2, 3, 4, 4, 5), result);
    }

    @Test
    public void testCollate_NegativeAndPositiveNumbers() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(-3, -1, 0), Arrays.asList(-2, 1, 2));
        assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2), result);
    }

    @Test
    public void testCollate_SingleElementIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1), Arrays.asList(2));
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testCollate_SameElements() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 1, 1), Arrays.asList(1, 1));
        assertEquals(Arrays.asList(1, 1, 1, 1, 1), result);
    }
}
