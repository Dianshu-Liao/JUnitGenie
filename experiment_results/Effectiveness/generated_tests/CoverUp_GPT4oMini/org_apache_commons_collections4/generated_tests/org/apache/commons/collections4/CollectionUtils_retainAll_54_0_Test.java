package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Objects;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
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

class CollectionUtils_retainAll_54_0_Test {

    private static class DummyEquator implements Equator<String> {

        @Override
        public boolean equate(String a, String b) {
            return a.equals(b);
        }

        @Override
        public int hash(String obj) {
            return obj.hashCode();
        }
    }

    @Test
    void testRetainAll_withCommonElements() {
        List<String> collection = Arrays.asList("a", "b", "c", "d");
        List<String> retain = Arrays.asList("b", "c");
        Collection<String> result = CollectionUtils.retainAll(collection, retain, new DummyEquator());
        assertEquals(new HashSet<>(retain), new HashSet<>(result));
    }

    @Test
    void testRetainAll_withNoCommonElements() {
        List<String> collection = Arrays.asList("a", "b", "c");
        List<String> retain = Arrays.asList("d", "e");
        Collection<String> result = CollectionUtils.retainAll(collection, retain, new DummyEquator());
        assertTrue(result.isEmpty());
    }

    @Test
    void testRetainAll_withEmptyCollection() {
        List<String> collection = new ArrayList<>();
        List<String> retain = Arrays.asList("b", "c");
        Collection<String> result = CollectionUtils.retainAll(collection, retain, new DummyEquator());
        assertTrue(result.isEmpty());
    }

    @Test
    void testRetainAll_withEmptyRetain() {
        List<String> collection = Arrays.asList("a", "b", "c");
        List<String> retain = new ArrayList<>();
        Collection<String> result = CollectionUtils.retainAll(collection, retain, new DummyEquator());
        assertTrue(result.isEmpty());
    }

    @Test
    void testRetainAll_withNullCollection() {
        List<String> retain = Arrays.asList("b", "c");
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(null, retain, new DummyEquator());
        });
    }

    @Test
    void testRetainAll_withNullRetain() {
        List<String> collection = Arrays.asList("a", "b", "c");
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(collection, null, new DummyEquator());
        });
    }

    @Test
    void testRetainAll_withNullEquator() {
        List<String> collection = Arrays.asList("a", "b", "c");
        List<String> retain = Arrays.asList("b", "c");
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(collection, retain, null);
        });
    }
}
