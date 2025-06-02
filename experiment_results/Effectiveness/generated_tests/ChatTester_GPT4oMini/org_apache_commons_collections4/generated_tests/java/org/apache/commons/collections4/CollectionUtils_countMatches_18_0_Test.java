package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionUtils_countMatches_18_0_Test {

    @Test
    public void testCountMatches_WithNullPredicate_ReturnsZero() {
        Iterable<String> input = Arrays.asList("a", "b", "c");
        int result = CollectionUtils.countMatches(input, null);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_WithEmptyIterable_ReturnsZero() {
        Iterable<String> input = Collections.emptyList();
        org.apache.commons.collections4.Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_WithNoMatches_ReturnsZero() {
        Iterable<String> input = Arrays.asList("b", "c", "d");
        org.apache.commons.collections4.Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_WithSomeMatches_ReturnsCorrectCount() {
        Iterable<String> input = Arrays.asList("a", "b", "a", "c");
        org.apache.commons.collections4.Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }

    @Test
    public void testCountMatches_WithAllMatches_ReturnsTotalCount() {
        Iterable<String> input = Arrays.asList("a", "a", "a");
        org.apache.commons.collections4.Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(3, result);
    }

    @Test
    public void testCountMatches_WithDifferentTypes_ReturnsCorrectCount() {
        Iterable<Integer> input = Arrays.asList(1, 2, 3, 1, 4);
        org.apache.commons.collections4.Predicate<Integer> predicate = i -> i.equals(1);
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }

    @Test
    public void testCountMatches_WithMixedTypes_ReturnsCorrectCount() {
        Iterable<Object> input = Arrays.asList("a", 1, "b", 1, "c");
        org.apache.commons.collections4.Predicate<Object> predicate = obj -> obj.equals(1);
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }
}
