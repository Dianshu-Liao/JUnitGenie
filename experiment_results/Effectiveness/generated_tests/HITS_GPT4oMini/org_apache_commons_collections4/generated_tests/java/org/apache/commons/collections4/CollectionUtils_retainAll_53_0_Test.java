package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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

public class CollectionUtils_retainAll_53_0_Test {

    @Test
    public void testRetainAll_withCommonElements() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collection<String> retain = new HashSet<>(Arrays.asList("B", "C", "E"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList("B", "C"), result);
    }

    @Test
    public void testRetainAll_withNoCommonElements() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> retain = new HashSet<>(Arrays.asList("D", "E"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testRetainAll_withEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        Collection<String> retain = new HashSet<>(Arrays.asList("A", "B"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testRetainAll_withEmptyRetain() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> retain = new HashSet<>();
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testRetainAll_withNullCollection() {
        Collection<String> retain = new HashSet<>(Arrays.asList("A", "B"));
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(null, retain);
        });
    }

    @Test
    public void testRetainAll_withNullRetain() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B"));
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(collection, null);
        });
    }
}
