package org.apache.commons.collections4;

import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_size_61_0_Test {

    @Test
    public void testSize_NullObject() {
        assertEquals(0, CollectionUtils.size(null));
    }

    @Test
    public void testSize_EmptyCollection() {
        Collection<?> emptyCollection = Collections.emptyList();
        assertEquals(0, CollectionUtils.size(emptyCollection));
    }

    @Test
    public void testSize_NonEmptyCollection() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        assertEquals(3, CollectionUtils.size(collection));
    }

    @Test
    public void testSize_EmptyMap() {
        Map<?, ?> emptyMap = Collections.emptyMap();
        assertEquals(0, CollectionUtils.size(emptyMap));
    }

    @Test
    public void testSize_NonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, CollectionUtils.size(map));
    }

    @Test
    public void testSize_Array() {
        Object[] array = new Object[] { 1, 2, 3 };
        assertEquals(3, CollectionUtils.size(array));
    }

    @Test
    public void testSize_EmptyArray() {
        Object[] emptyArray = new Object[] {};
        assertEquals(0, CollectionUtils.size(emptyArray));
    }

    @Test
    public void testSize_Iterable() {
        Iterable<Integer> iterable = Arrays.asList(1, 2, 3);
        assertEquals(3, CollectionUtils.size(iterable));
    }

    @Test
    public void testSize_Iterator() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        assertEquals(3, CollectionUtils.size(iterator));
    }

    @Test
    public void testSize_Enumeration() {
        Vector<Integer> vector = new Vector<>(Arrays.asList(1, 2, 3));
        Enumeration<Integer> enumeration = vector.elements();
        assertEquals(3, CollectionUtils.size(enumeration));
    }

    @Test
    public void testSize_UnsupportedType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.size(new Object());
        });
        assertTrue(exception.getMessage().contains("Unsupported object type: java.lang.Object"));
    }
}
