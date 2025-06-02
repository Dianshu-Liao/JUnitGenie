package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ComparatorUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collection;
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

public class CollectionUtils_collate_8_1_Test {

    @Test
    public void testCollateWithDuplicates() throws Exception {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        boolean includeDuplicates = true;
        List<Integer> result = invokeCollate(listA, listB, includeDuplicates);
        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithoutDuplicates() throws Exception {
        List<Integer> listA = Arrays.asList(1, 2, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        boolean includeDuplicates = false;
        List<Integer> result = invokeCollate(listA, listB, includeDuplicates);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    public void testCollateEmptyLists() throws Exception {
        List<Integer> listA = Collections.emptyList();
        List<Integer> listB = Collections.emptyList();
        boolean includeDuplicates = true;
        List<Integer> result = invokeCollate(listA, listB, includeDuplicates);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    public void testCollateWithNulls() throws Exception {
        List<Integer> listA = Arrays.asList(1, null, 3);
        List<Integer> listB = Arrays.asList(2, null);
        boolean includeDuplicates = true;
        List<Integer> result = invokeCollate(listA, listB, includeDuplicates);
        List<Integer> expected = Arrays.asList(1, null, 2, null, 3);
        assertEquals(expected, result);
    }

    private List<Integer> invokeCollate(Iterable<? extends Integer> a, Iterable<? extends Integer> b, boolean includeDuplicates) throws Exception {
        Method method = CollectionUtils.class.getDeclaredMethod("collate", Iterable.class, Iterable.class, boolean.class);
        method.setAccessible(true);
        return (List<Integer>) method.invoke(null, a, b, includeDuplicates);
    }
}
