// Adjust package name as necessary
package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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

public class CollectionUtils_removeRange_52_0_Test {

    @Test
    public void testRemoveRange_EndIndexGreaterThanCollectionSize() {
        Collection<Integer> input = new ArrayList<>(Collections.singletonList(1));
        int startIndex = 0;
        // Greater than the size of the collection (1)
        int endIndex = 2;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            CollectionUtils.removeRange(input, startIndex, endIndex);
        }, "The end index can't be greater than the size of collection.");
    }

    @Test
    public void testRemoveRange_EndIndexEqualsCollectionSize() {
        Collection<Integer> input = new ArrayList<>(Collections.singletonList(1));
        int startIndex = 0;
        // Equal to the size of the collection
        int endIndex = 1;
        Collection<Integer> result = CollectionUtils.removeRange(input, startIndex, endIndex);
        // Verify that the result is empty since we removed the only element
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRemoveRange_EndIndexLessThanStartIndex() {
        Collection<Integer> input = new ArrayList<>(Collections.singletonList(1));
        int startIndex = 1;
        // Less than the start index
        int endIndex = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.removeRange(input, startIndex, endIndex);
        }, "The end index can't be less than the start index.");
    }

    @Test
    public void testRemoveRange_ValidRange() {
        Collection<Integer> input = new ArrayList<>();
        Collections.addAll(input, 1, 2, 3, 4, 5);
        int startIndex = 1;
        // Should remove elements at index 1 and 2 (2 and 3)
        int endIndex = 3;
        Collection<Integer> result = CollectionUtils.removeRange(input, startIndex, endIndex);
        // Verify remaining elements
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(4));
        assertTrue(result.contains(5));
        assertFalse(result.contains(2));
        assertFalse(result.contains(3));
    }

    @Test
    public void testRemoveRange_EmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        int startIndex = 0;
        // Trying to remove from an empty collection
        int endIndex = 1;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            CollectionUtils.removeRange(input, startIndex, endIndex);
        }, "The end index can't be greater than the size of collection.");
    }
}
