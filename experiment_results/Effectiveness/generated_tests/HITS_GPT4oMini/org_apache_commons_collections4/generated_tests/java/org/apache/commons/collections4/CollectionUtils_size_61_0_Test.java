package org.apache.commons.collections4;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

@ExtendWith(MockitoExtension.class)
public class CollectionUtils_size_61_0_Test {

    @Test
    public void testSize_Iterator() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        assertEquals(3, CollectionUtils.size(iterator));
    }

    @Test
    public void testSize_Null() {
        assertEquals(0, CollectionUtils.size(null));
    }

    @Test
    public void testSize_EmptyCollection() {
        assertEquals(0, CollectionUtils.size(Collections.emptyList()));
    }

    @Test
    public void testSize_NonEmptyCollection() {
        assertEquals(3, CollectionUtils.size(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testSize_EmptyArray() {
        assertEquals(0, CollectionUtils.size(new Object[0]));
    }

    @Test
    public void testSize_NonEmptyArray() {
        assertEquals(3, CollectionUtils.size(new Object[] { 1, 2, 3 }));
    }

    @Test
    public void testSize_EmptyMap() {
        assertEquals(0, CollectionUtils.size(Collections.emptyMap()));
    }

    @Test
    public void testSize_NonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, CollectionUtils.size(map));
    }
}
