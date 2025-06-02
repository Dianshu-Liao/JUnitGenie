package org.apache.commons.collections4;

import org.apache.commons.collections4.Closure;
import java.util.Arrays;
import java.util.Iterator;
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

class CollectionUtils_forAllDo_30_4_Test {

    @Test
    void testForAllDo_withValidIteratorAndClosure() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        final StringBuilder result = new StringBuilder();
        Closure<Integer> closure = new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(",");
            }
        };
        CollectionUtils.forAllDo(iterator, closure);
        assertEquals("1,2,3,4,5,", result.toString());
    }

    @Test
    void testForAllDo_withNullClosure() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        Closure<Integer> closure = null;
        Closure<Integer> result = CollectionUtils.forAllDo(iterator, closure);
        assertNull(result);
    }

    @Test
    void testForAllDo_withEmptyIterator() {
        List<Integer> list = Arrays.asList();
        Iterator<Integer> iterator = list.iterator();
        final StringBuilder result = new StringBuilder();
        Closure<Integer> closure = new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(",");
            }
        };
        CollectionUtils.forAllDo(iterator, closure);
        assertEquals("", result.toString());
    }

    @Test
    void testForAllDo_withSingleElementIterator() {
        List<Integer> list = Arrays.asList(42);
        Iterator<Integer> iterator = list.iterator();
        final StringBuilder result = new StringBuilder();
        Closure<Integer> closure = new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(",");
            }
        };
        CollectionUtils.forAllDo(iterator, closure);
        assertEquals("42,", result.toString());
    }
}
