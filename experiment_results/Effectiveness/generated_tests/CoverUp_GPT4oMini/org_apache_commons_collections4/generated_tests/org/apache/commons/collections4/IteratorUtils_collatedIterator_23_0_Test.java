package org.apache.commons.collections4;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Array;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyListIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.iterators.EnumerationIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.FilterListIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.apache.commons.collections4.iterators.NodeListIterator;
import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.apache.commons.collections4.iterators.PushbackIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.iterators.ZippingIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IteratorUtils_collatedIterator_23_0_Test {

    @Test
    void testCollatedIteratorWithNullComparator() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 3, 5).iterator(), Arrays.asList(2, 4, 6).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection<Iterator<? extends Integer>>) (Collection<?>) iterators);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithCustomComparator() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(5, 3, 1).iterator(), Arrays.asList(6, 4, 2).iterator());
        Comparator<Integer> comparator = Comparator.reverseOrder();
        Iterator<Integer> result = IteratorUtils.collatedIterator(comparator, (Collection<Iterator<? extends Integer>>) (Collection<?>) iterators);
        List<Integer> expected = Arrays.asList(6, 5, 4, 3, 2, 1);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithEmptyIterators() {
        Collection<Iterator<Integer>> iterators = Arrays.asList(Collections.emptyIterator(), Collections.emptyIterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection<Iterator<? extends Integer>>) (Collection<?>) iterators);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testCollatedIteratorWithSingleIterator() {
        Collection<Iterator<Integer>> iterators = Collections.singletonList(Arrays.asList(1, 2, 3).iterator());
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, (Collection<Iterator<? extends Integer>>) (Collection<?>) iterators);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = new ArrayList<>();
        result.forEachRemaining(actual::add);
        assertEquals(expected, actual);
    }
}
