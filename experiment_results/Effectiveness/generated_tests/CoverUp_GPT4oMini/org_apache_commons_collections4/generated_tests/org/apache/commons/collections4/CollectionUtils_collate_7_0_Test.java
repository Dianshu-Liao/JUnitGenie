package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ComparatorUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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
    public void testCollateWithEmptyCollections() throws Exception {
        Iterable<Integer> a = new ArrayList<>();
        Iterable<Integer> b = new ArrayList<>();
        List<Integer> result = invokeCollate(a, b);
        assertEquals(0, result.size());
    }

    @Test
    public void testCollateWithNonEmptyCollections() throws Exception {
        Iterable<Integer> a = Arrays.asList(1, 3, 5);
        Iterable<Integer> b = Arrays.asList(2, 4, 6);
        List<Integer> result = invokeCollate(a, b);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testCollateWithDuplicates() throws Exception {
        Iterable<Integer> a = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> b = Arrays.asList(2, 4, 5);
        List<Integer> result = invokeCollate(a, b);
        assertEquals(Arrays.asList(1, 2, 2, 2, 3, 4, 5), result);
    }

    @Test
    public void testCollateWithSingleCollection() throws Exception {
        Iterable<Integer> a = Arrays.asList(1, 2, 3);
        Iterable<Integer> b = new ArrayList<>();
        List<Integer> result = invokeCollate(a, b);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    private List<Integer> invokeCollate(Iterable<Integer> a, Iterable<Integer> b) throws Exception {
        Method method = CollectionUtils.class.getDeclaredMethod("collate", Iterable.class, Iterable.class);
        method.setAccessible(true);
        return (List<Integer>) method.invoke(null, a, b);
    }
}
