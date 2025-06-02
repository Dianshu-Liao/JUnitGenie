package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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

class CollectionUtils_isProperSubCollection_43_0_Test {

    @Test
    void testIsProperSubCollection() {
        // Test case where 'a' is a proper sub-collection of 'b'
        Collection<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        Collection<Integer> b = new HashSet<>();
        b.add(1);
        b.add(2);
        b.add(3);
        assertTrue(CollectionUtils.isProperSubCollection(a, b));
        // Test case where 'a' is not a proper sub-collection (same size)
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        Collection<Integer> d = new HashSet<>();
        d.add(1);
        d.add(2);
        assertFalse(CollectionUtils.isProperSubCollection(c, d));
        // Test case where 'a' is not a proper sub-collection (larger size)
        Collection<Integer> e = new ArrayList<>();
        e.add(1);
        e.add(2);
        e.add(3);
        Collection<Integer> f = new HashSet<>();
        f.add(1);
        f.add(2);
        assertFalse(CollectionUtils.isProperSubCollection(e, f));
        // Test case where 'a' is empty and 'b' is not
        Collection<Integer> g = new ArrayList<>();
        Collection<Integer> h = new HashSet<>();
        h.add(1);
        assertFalse(CollectionUtils.isProperSubCollection(g, h));
        // Test case where both 'a' and 'b' are empty
        Collection<Integer> i = new ArrayList<>();
        Collection<Integer> j = new HashSet<>();
        assertFalse(CollectionUtils.isProperSubCollection(i, j));
        // Test case where 'a' is null
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.isProperSubCollection(null, h);
        });
        // Test case where 'b' is null
        assertThrows(NullPointerException.class, () -> {
            CollectionUtils.isProperSubCollection(g, null);
        });
    }
}
