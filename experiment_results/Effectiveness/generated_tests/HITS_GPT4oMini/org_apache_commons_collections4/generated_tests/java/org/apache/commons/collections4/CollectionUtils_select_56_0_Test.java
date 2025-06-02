package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
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

public class CollectionUtils_select_56_0_Test {

    @Test
    public void testSelect_WithNullInputCollection() {
        Collection<Object> result = CollectionUtils.select(null, o -> true);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Expected empty collection when input is null");
    }

    @Test
    public void testSelect_WithEmptyInputCollection() {
        Collection<Object> input = new ArrayList<>();
        Collection<Object> result = CollectionUtils.select(input, o -> true);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Expected empty collection when input is empty");
    }

    @Test
    public void testSelect_WithPredicateThatAlwaysReturnsTrue() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> result = CollectionUtils.select(input, o -> true);
        assertNotNull(result);
        assertEquals(input.size(), result.size(), "Expected the same size as input when predicate is always true");
        assertTrue(result.containsAll(input), "Expected result to contain all elements from input");
    }

    @Test
    public void testSelect_WithPredicateThatAlwaysReturnsFalse() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> result = CollectionUtils.select(input, o -> false);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Expected empty collection when predicate is always false");
    }

    @Test
    public void testSelect_WithPredicateThatFiltersEvenNumbers() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> result = CollectionUtils.select(input, o -> o % 2 == 0);
        assertNotNull(result);
        assertEquals(2, result.size(), "Expected two even numbers in the result");
        assertTrue(result.contains(2) && result.contains(4), "Expected result to contain only even numbers");
    }

    @Test
    public void testSelect_WithPredicateThatFiltersOddNumbers() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> result = CollectionUtils.select(input, o -> o % 2 != 0);
        assertNotNull(result);
        assertEquals(3, result.size(), "Expected three odd numbers in the result");
        assertTrue(result.contains(1) && result.contains(3) && result.contains(5), "Expected result to contain only odd numbers");
    }

    @Test
    public void testSelect_WithPredicateThatFiltersBasedOnCondition() {
        Collection<String> input = Arrays.asList("apple", "banana", "cherry", "date");
        Collection<String> result = CollectionUtils.select(input, s -> s.startsWith("b"));
        assertNotNull(result);
        assertEquals(1, result.size(), "Expected one fruit starting with 'b'");
        assertTrue(result.contains("banana"), "Expected result to contain 'banana'");
    }
}
