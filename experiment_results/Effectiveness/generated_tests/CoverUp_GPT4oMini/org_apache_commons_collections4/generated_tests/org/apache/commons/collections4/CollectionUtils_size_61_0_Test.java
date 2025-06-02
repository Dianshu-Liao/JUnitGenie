package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

class CollectionUtils_size_61_0_Test {

    @Test
    void testSizeWithNull() {
        assertEquals(0, CollectionUtils.size(null));
    }

    @Test
    void testSizeWithEmptyCollection() {
        Collection<Object> emptyCollection = new ArrayList<>();
        assertEquals(0, CollectionUtils.size(emptyCollection));
    }

    @Test
    void testSizeWithNonEmptyCollection() {
        Collection<Object> nonEmptyCollection = Arrays.asList(1, 2, 3);
        assertEquals(3, CollectionUtils.size(nonEmptyCollection));
    }

    @Test
    void testSizeWithEmptyMap() {
        Map<Object, Object> emptyMap = new HashMap<>();
        assertEquals(0, CollectionUtils.size(emptyMap));
    }

    @Test
    void testSizeWithNonEmptyMap() {
        Map<Object, Object> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put("key1", "value1");
        nonEmptyMap.put("key2", "value2");
        assertEquals(2, CollectionUtils.size(nonEmptyMap));
    }

    @Test
    void testSizeWithArray() {
        Object[] array = new Object[] { "a", "b", "c" };
        assertEquals(3, CollectionUtils.size(array));
    }

    @Test
    void testSizeWithEmptyArray() {
        Object[] emptyArray = new Object[0];
        assertEquals(0, CollectionUtils.size(emptyArray));
    }

    @Test
    void testSizeWithIterable() {
        Iterable<Object> iterable = Arrays.asList(1, 2, 3);
        assertEquals(3, CollectionUtils.size(iterable));
    }

    @Test
    void testSizeWithIterator() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        assertEquals(3, CollectionUtils.size(iterator));
    }

    @Test
    void testSizeWithEmptyIterator() {
        Iterator<Object> emptyIterator = Collections.emptyIterator();
        assertEquals(0, CollectionUtils.size(emptyIterator));
    }

    @Test
    void testSizeWithEnumeration() {
        Enumeration<Integer> enumeration = new Vector<>(Arrays.asList(1, 2, 3)).elements();
        assertEquals(3, CollectionUtils.size(enumeration));
    }

    @Test
    void testSizeWithEmptyEnumeration() {
        Enumeration<Object> emptyEnumeration = new Vector<>().elements();
        assertEquals(0, CollectionUtils.size(emptyEnumeration));
    }

    @Test
    void testSizeWithUnsupportedType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.size(new Object());
        });
        assertEquals("Unsupported object type: java.lang.Object", exception.getMessage());
    }
}
