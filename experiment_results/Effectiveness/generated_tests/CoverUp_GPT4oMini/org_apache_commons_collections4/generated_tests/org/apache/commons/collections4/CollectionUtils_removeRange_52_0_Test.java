package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import java.util.List;
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

class CollectionUtils_removeRange_52_0_Test {

    @Test
    void testRemoveRange_ValidRange() {
        Collection<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collection<Integer> result = CollectionUtils.removeRange(input, 1, 4);
        assertEquals(Arrays.asList(1, 5), result);
    }

    @Test
    void testRemoveRange_EmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void testRemoveRange_SingleElement() {
        Collection<Integer> input = new ArrayList<>(Arrays.asList(1));
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 1);
        assertTrue(result.isEmpty());
    }

    @Test
    void testRemoveRange_EndIndexLessThanStartIndex() {
        Collection<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.removeRange(input, 2, 1);
        });
        assertEquals("The end index can't be less than the start index.", exception.getMessage());
    }

    @Test
    void testRemoveRange_EndIndexGreaterThanSize() {
        Collection<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            CollectionUtils.removeRange(input, 0, 5);
        });
        assertEquals("The end index can't be greater than the size of collection.", exception.getMessage());
    }
}
