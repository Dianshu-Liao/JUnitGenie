package org.apache.commons.collections4;

import org.apache.commons.collections4.functors.TruePredicate;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<String> input = Arrays.asList("a", "b", "c");
        int result = CollectionUtils.countMatches(input, null);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_EmptyCollection() {
        List<String> input = new ArrayList<>();
        int result = CollectionUtils.countMatches(input, TruePredicate.INSTANCE);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_NoMatches() {
        List<String> input = Arrays.asList("a", "b", "c");
        Predicate<String> predicate = s -> s.equals("d");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result);
    }

    @Test
    public void testCountMatches_SomeMatches() {
        List<String> input = Arrays.asList("a", "b", "a", "c");
        Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }

    @Test
    public void testCountMatches_AllMatches() {
        List<String> input = Arrays.asList("a", "a", "a", "a");
        Predicate<String> predicate = s -> s.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(4, result);
    }

    @Test
    public void testCountMatches_MixedTypes() {
        List<Object> input = Arrays.asList("a", 1, "b", 2, "a");
        Predicate<Object> predicate = obj -> obj.equals("a");
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }

    @Test
    public void testCountMatches_NonStringCollection() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        Predicate<Integer> predicate = num -> num > 2;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result);
    }

    // Reflection test to invoke private constructor
    @Test
    public void testPrivateConstructor() throws Exception {
        Constructor<CollectionUtils> constructor = CollectionUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
