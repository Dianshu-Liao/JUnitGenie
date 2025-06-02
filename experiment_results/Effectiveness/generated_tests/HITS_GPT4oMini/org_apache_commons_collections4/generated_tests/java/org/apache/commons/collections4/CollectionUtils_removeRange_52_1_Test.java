package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

public class CollectionUtils_removeRange_52_1_Test {

    @Test
    public void testRemoveRange_ValidRange() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        Collection<Integer> result = CollectionUtils.removeRange(input, 1, 3);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertFalse(result.contains(2));
        assertFalse(result.contains(3));
        assertTrue(result.contains(4));
        assertTrue(result.contains(5));
    }

    @Test
    public void testRemoveRange_EmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRemoveRange_SingleElementCollection() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 1);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRemoveRange_EndIndexLessThanStartIndex() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.removeRange(input, 2, 1);
        });
        assertEquals("The end index can't be less than the start index.", exception.getMessage());
    }

    @Test
    public void testRemoveRange_EndIndexGreaterThanSize() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            CollectionUtils.removeRange(input, 1, 5);
        });
        assertEquals("The end index can't be greater than the size of collection.", exception.getMessage());
    }

    @Test
    public void testRemoveRange_NegativeStartIndex() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            CollectionUtils.removeRange(input, -1, 2);
        });
        assertEquals("The end index can't be greater than the size of collection.", exception.getMessage());
    }
}
