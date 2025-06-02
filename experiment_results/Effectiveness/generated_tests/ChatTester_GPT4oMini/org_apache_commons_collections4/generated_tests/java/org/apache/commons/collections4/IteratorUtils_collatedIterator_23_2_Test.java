package org.apache.commons.collections4;

import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IteratorUtils_collatedIterator_23_2_Test {

    @Test
    void testCollatedIteratorWithNullComparator() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 3, 5).iterator(), Arrays.asList(2, 4, 6).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection) iterators);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithCustomComparator() {
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        Collection<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 3, 5).iterator(), Arrays.asList(2, 4, 6).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(reverseComparator, (Collection) iterators);
        List<Integer> expected = Arrays.asList(6, 5, 4, 3, 2, 1);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithEmptyCollection() {
        Collection<Iterator<Integer>> iterators = Collections.emptyList();
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection) iterators);
        assertFalse(result.hasNext());
    }

    @Test
    void testCollatedIteratorWithSingleIterator() {
        Collection<Iterator<Integer>> iterators = Collections.singletonList(Arrays.asList(1, 2, 3).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection) iterators);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithIteratorsReturningNoElements() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Collections.emptyIterator(), Collections.emptyIterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection) iterators);
        assertFalse(result.hasNext());
    }

    @Test
    void testCollatedIteratorWithMixedEmptyAndNonEmptyIterators() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 3).iterator(), Collections.emptyIterator(), Arrays.asList(2, 4).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection) iterators);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }
}
