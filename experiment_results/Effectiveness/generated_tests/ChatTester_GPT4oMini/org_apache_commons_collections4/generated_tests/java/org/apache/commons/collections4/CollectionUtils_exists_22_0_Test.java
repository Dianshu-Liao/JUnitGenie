package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class CollectionUtils_exists_22_0_Test {

    @Test
    void testExists_WithNullInput_ReturnsFalse() {
        Predicate<Object> predicate = obj -> true;
        boolean result = CollectionUtils.exists(null, predicate);
        assertFalse(result);
    }

    @Test
    void testExists_WithEmptyCollection_ReturnsFalse() {
        Collection<String> input = Collections.emptyList();
        Predicate<CharSequence> predicate = obj -> true;
        boolean result = CollectionUtils.exists(input, predicate);
        assertFalse(result);
    }

    @Test
    void testExists_WithMatchingPredicate_ReturnsTrue() {
        Collection<String> input = Arrays.asList("apple", "banana", "cherry");
        Predicate<String> predicate = obj -> obj.startsWith("b");
        boolean result = CollectionUtils.exists(input, predicate);
        assertTrue(result);
    }

    @Test
    void testExists_WithNonMatchingPredicate_ReturnsFalse() {
        Collection<String> input = Arrays.asList("apple", "banana", "cherry");
        Predicate<String> predicate = obj -> obj.startsWith("d");
        boolean result = CollectionUtils.exists(input, predicate);
        assertFalse(result);
    }

    @Test
    void testExists_WithNullPredicate_ReturnsFalse() {
        Collection<String> input = Arrays.asList("apple", "banana", "cherry");
        boolean result = CollectionUtils.exists(input, null);
        assertFalse(result);
    }

    @Test
    void testExists_WithMultipleElementsAndMatchingPredicate_ReturnsTrue() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = num -> num > 3;
        boolean result = CollectionUtils.exists(input, predicate);
        assertTrue(result);
    }

    @Test
    void testExists_WithMultipleElementsAndNonMatchingPredicate_ReturnsFalse() {
        Collection<Integer> input = Arrays.asList(1, 2, 3);
        Predicate<Integer> predicate = num -> num > 5;
        boolean result = CollectionUtils.exists(input, predicate);
        assertFalse(result);
    }
}
