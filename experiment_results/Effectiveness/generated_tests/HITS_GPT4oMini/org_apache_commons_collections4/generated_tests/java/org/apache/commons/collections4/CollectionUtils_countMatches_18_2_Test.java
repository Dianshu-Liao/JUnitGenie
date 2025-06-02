package org.apache.commons.collections4;

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
import java.util.ArrayList;
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

public class CollectionUtils_countMatches_18_2_Test {

    @Test
    public void testCountMatches_NullInput() {
        Predicate<Object> predicate = o -> true;
        int result = CollectionUtils.countMatches(null, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 for null input.");
    }

    @Test
    public void testCountMatches_EmptyInput() {
        List<String> input = Arrays.asList();
        Predicate<String> predicate = s -> s.length() > 0;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 for empty input.");
    }

    @Test
    public void testCountMatches_NoMatches() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Predicate<Integer> predicate = n -> n > 3;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(0, result, "Expected countMatches to return 0 when there are no matches.");
    }

    @Test
    public void testCountMatches_SomeMatches() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        // even numbers
        Predicate<Integer> predicate = n -> n % 2 == 0;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(2, result, "Expected countMatches to return 2 for even numbers.");
    }

    @Test
    public void testCountMatches_AllMatches() {
        List<String> input = Arrays.asList("a", "b", "c");
        // all strings have length 1
        Predicate<String> predicate = s -> s.length() == 1;
        int result = CollectionUtils.countMatches(input, predicate);
        assertEquals(3, result, "Expected countMatches to return 3 when all elements match.");
    }

    @Test
    public void testCountMatches_NullPredicate() {
        List<String> input = Arrays.asList("a", "b", "c");
        int result = CollectionUtils.countMatches(input, null);
        assertEquals(0, result, "Expected countMatches to return 0 when predicate is null.");
    }
}
