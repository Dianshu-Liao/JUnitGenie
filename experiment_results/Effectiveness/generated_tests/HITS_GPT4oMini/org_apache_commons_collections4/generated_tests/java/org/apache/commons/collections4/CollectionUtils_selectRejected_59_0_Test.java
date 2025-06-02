package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import org.apache.commons.collections4.Predicate;
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

public class CollectionUtils_selectRejected_59_0_Test {

    @Test
    public void testSelectRejected_NullInputCollection() {
        // Replacing PredicateUtils.truePredicate()
        Predicate<Integer> predicate = x -> true;
        Collection<Integer> result = CollectionUtils.selectRejected(null, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_EmptyInputCollection() {
        List<Integer> inputCollection = new ArrayList<>();
        // Replacing PredicateUtils.truePredicate()
        Predicate<Integer> predicate = x -> true;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_AllRejected() {
        List<Integer> inputCollection = Arrays.asList(1, 2, 3);
        Predicate<Integer> predicate = x -> x > 5;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        Assertions.assertTrue(result.containsAll(inputCollection));
    }

    @Test
    public void testSelectRejected_SomeRejected() {
        List<Integer> inputCollection = Arrays.asList(1, 6, 3, 8);
        Predicate<Integer> predicate = x -> x > 5;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(1));
        Assertions.assertTrue(result.contains(3));
        Assertions.assertFalse(result.contains(6));
        Assertions.assertFalse(result.contains(8));
    }

    @Test
    public void testSelectRejected_AllAccepted() {
        List<Integer> inputCollection = Arrays.asList(6, 7, 8);
        Predicate<Integer> predicate = x -> x > 5;
        Collection<Integer> result = CollectionUtils.selectRejected(inputCollection, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSelectRejected_NonIntegerInput() {
        List<String> inputCollection = Arrays.asList("a", "b", "c");
        Predicate<String> predicate = x -> x.equals("a");
        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("b"));
        Assertions.assertTrue(result.contains("c"));
    }
}
