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

public class CollectionUtils_collate_8_0_Test {

    @Test
    public void testCollate_WithDuplicates() {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        List<Integer> result = CollectionUtils.collate(listA, listB, true);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_WithoutDuplicates() {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        List<Integer> result = CollectionUtils.collate(listA, listB, false);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_EmptyCollections() {
        List<Integer> listA = Arrays.asList();
        List<Integer> listB = Arrays.asList();
        List<Integer> result = CollectionUtils.collate(listA, listB, true);
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_OneEmptyCollection() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList();
        List<Integer> result = CollectionUtils.collate(listA, listB, true);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_BothCollectionsEmpty() {
        List<Integer> listA = Arrays.asList();
        List<Integer> listB = Arrays.asList();
        List<Integer> result = CollectionUtils.collate(listA, listB, false);
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_SingleElementCollections_WithDuplicates() {
        List<Integer> listA = Arrays.asList(1);
        List<Integer> listB = Arrays.asList(1);
        List<Integer> result = CollectionUtils.collate(listA, listB, true);
        List<Integer> expected = Arrays.asList(1, 1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCollate_SingleElementCollections_WithoutDuplicates() {
        List<Integer> listA = Arrays.asList(1);
        List<Integer> listB = Arrays.asList(1);
        List<Integer> result = CollectionUtils.collate(listA, listB, false);
        List<Integer> expected = Arrays.asList(1);
        Assertions.assertEquals(expected, result);
    }
}
