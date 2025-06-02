package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
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

public class CollectionUtils_collate_9_0_Test {

    @Test
    public void testCollate_EmptyIterables() {
        List<Integer> result = CollectionUtils.collate(Collections.emptyList(), Collections.emptyList(), Integer::compare);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testCollate_FirstIterableEmpty() {
        List<Integer> result = CollectionUtils.collate(Collections.emptyList(), Arrays.asList(3, 1, 2), Integer::compare);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testCollate_SecondIterableEmpty() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(3, 1, 2), Collections.emptyList(), Integer::compare);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testCollate_NonEmptyIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(3, 1, 4), Arrays.asList(2, 5), Integer::compare);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    @Test
    public void testCollate_SameElements() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 1, 1), Arrays.asList(1, 1), Integer::compare);
        assertEquals(Arrays.asList(1, 1, 1, 1, 1), result);
    }

    @Test
    public void testCollate_ComparatorReversed() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 3, 2), Arrays.asList(4, 5), Collections.reverseOrder());
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), result);
    }

    @Test
    public void testCollate_Strings() {
        List<String> result = CollectionUtils.collate(Arrays.asList("banana", "apple"), Arrays.asList("cherry", "date"), String::compareTo);
        assertEquals(Arrays.asList("apple", "banana", "cherry", "date"), result);
    }

    @Test
    public void testCollate_NullElements() {
        List<String> result = CollectionUtils.collate(Arrays.asList("apple", null), Arrays.asList("banana", null), String::compareTo);
        assertEquals(Arrays.asList(null, null, "apple", "banana"), result);
    }
}
