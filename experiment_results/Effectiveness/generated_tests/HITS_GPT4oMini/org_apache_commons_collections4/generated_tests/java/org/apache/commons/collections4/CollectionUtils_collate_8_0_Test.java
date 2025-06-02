package org.apache.commons.collections4;

import java.util.Arrays;
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

public class CollectionUtils_collate_8_0_Test {

    @Test
    public void testCollateWithEmptyIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(), Arrays.asList(), false);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testCollateWithNoDuplicates() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), false);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    public void testCollateWithDuplicates() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), true);
        assertEquals(Arrays.asList(1, 2, 3, 2, 3, 4), result);
    }

    @Test
    public void testCollateWithAllDuplicates() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 1, 1), Arrays.asList(1, 1), true);
        assertEquals(Arrays.asList(1, 1, 1, 1, 1), result);
    }

    @Test
    public void testCollateWithNullIterable() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1, 2, 3), null, false);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testCollateWithBothNullIterables() {
        List<Integer> result = CollectionUtils.collate(null, null, false);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testCollateWithMixedNulls() {
        List<Integer> result = CollectionUtils.collate(null, Arrays.asList(4, 5, 6), false);
        assertEquals(Arrays.asList(4, 5, 6), result);
    }

    @Test
    public void testCollateWithSingleElementIterables() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1), Arrays.asList(2), false);
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testCollateWithSingleElementDuplicates() {
        List<Integer> result = CollectionUtils.collate(Arrays.asList(1), Arrays.asList(1), true);
        assertEquals(Arrays.asList(1, 1), result);
    }
}
