package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
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

class CollectionUtils_retainAll_54_0_Test {

    @Test
    void testRetainAll() {
        List<String> collection = new ArrayList<>();
        collection.add("apple");
        collection.add("banana");
        collection.add("cherry");
        List<String> retain = new ArrayList<>();
        retain.add("banana");
        retain.add("cherry");
        Collection<String> result = CollectionUtils.retainAll(collection, retain, new StringEquator());
        List<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("cherry");
        assertEquals(expected, result);
    }

    private static class StringEquator implements Equator<String> {

        @Override
        public boolean equate(String a, String b) {
            return Objects.equals(a, b);
        }

        @Override
        public int hash(String obj) {
            return obj != null ? obj.hashCode() : 0;
        }
    }
}
