package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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

class CollectionUtils_retainAll_53_0_Test {

    @Test
    void testRetainAll_withNonEmptyCollections() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collection<String> retain = new ArrayList<>(Arrays.asList("B", "D", "E"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList("B", "D"), result);
    }

    @Test
    void testRetainAll_withEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        Collection<String> retain = new ArrayList<>(Arrays.asList("B", "D", "E"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertTrue(result.isEmpty());
    }

    @Test
    void testRetainAll_withEmptyRetain() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collection<String> retain = new ArrayList<>();
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertTrue(result.isEmpty());
    }

    @Test
    void testRetainAll_withNullCollection() {
        Collection<String> retain = new ArrayList<>(Arrays.asList("B", "D", "E"));
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(null, retain);
        });
        assertEquals("collection", exception.getMessage());
    }

    @Test
    void testRetainAll_withNullRetain() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(collection, null);
        });
        assertEquals("retain", exception.getMessage());
    }

    @Test
    void testRetainAll_withIdenticalCollections() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> retain = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    void testRetainAll_withNoCommonElements() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collection<String> retain = new ArrayList<>(Arrays.asList("D", "E", "F"));
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        assertTrue(result.isEmpty());
    }
}
