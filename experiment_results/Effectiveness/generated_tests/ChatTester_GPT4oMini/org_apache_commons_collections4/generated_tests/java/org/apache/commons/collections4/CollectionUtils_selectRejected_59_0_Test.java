package org.apache.commons.collections4;

import java.util.*;
import java.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Added import for PredicateUtils
import org.apache.commons.collections4.PredicateUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class CollectionUtils_selectRejected_59_0_Test {

    @Test
    public void testSelectRejected_WithNullInputCollection() {
        // Arrange
        Iterable<Object> inputCollection = null;
        // Always returns false
        // Changed to use commons collections Predicate
        org.apache.commons.collections4.Predicate<Object> predicate = obj -> false;
        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_WithEmptyInputCollection() {
        // Arrange
        Iterable<Object> inputCollection = Collections.emptyList();
        // Always returns false
        // Changed to use commons collections Predicate
        org.apache.commons.collections4.Predicate<Object> predicate = obj -> false;
        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_WithNoRejectedElements() {
        // Arrange
        Iterable<Integer> inputCollection = Arrays.asList(1, 2, 3);
        // Always returns false
        // Changed to use commons collections Predicate
        org.apache.commons.collections4.Predicate<Integer> predicate = num -> num > 3;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_WithSomeRejectedElements() {
        // Arrange
        Iterable<Integer> inputCollection = Arrays.asList(1, 2, 3);
        // Rejects 1
        // Changed to use commons collections Predicate
        org.apache.commons.collections4.Predicate<Integer> predicate = num -> num < 2;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(1));
        assertFalse(result.contains(2));
        assertFalse(result.contains(3));
    }

    @Test
    public void testSelectRejected_WithAllRejectedElements() {
        // Arrange
        Iterable<Integer> inputCollection = Arrays.asList(1, 2, 3);
        // Rejects all
        // Changed to use commons collections Predicate
        org.apache.commons.collections4.Predicate<Integer> predicate = num -> true;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }
}
