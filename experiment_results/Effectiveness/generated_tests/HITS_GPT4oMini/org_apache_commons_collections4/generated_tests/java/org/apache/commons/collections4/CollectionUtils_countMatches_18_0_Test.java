package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.Predicate;
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
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_countMatches_18_0_Test {

    @Test
    public void testCountMatches_NullPredicate() {
        Iterable<Object> input = new ArrayList<>();
        Predicate<Object> predicate = null;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 when predicate is null");
    }

    @Test
    public void testCountMatches_EmptyIterable() {
        Iterable<String> input = new ArrayList<>();
        Predicate<String> predicate = TruePredicate.INSTANCE;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 for an empty iterable");
    }

    @Test
    public void testCountMatches_SingleElement_Matching() {
        List<String> input = new ArrayList<>();
        input.add("test");
        Predicate<String> predicate = new EqualPredicate<>("test");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(1, result, "Expected countMatches to return 1 for a matching element");
    }

    @Test
    public void testCountMatches_SingleElement_NonMatching() {
        List<String> input = new ArrayList<>();
        input.add("test");
        Predicate<String> predicate = new EqualPredicate<>("not_test");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 for a non-matching element");
    }

    @Test
    public void testCountMatches_MultipleElements_Matching() {
        List<String> input = new ArrayList<>();
        input.add("test");
        input.add("test");
        input.add("example");
        Predicate<String> predicate = new EqualPredicate<>("test");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result, "Expected countMatches to return 2 for multiple matching elements");
    }
}
