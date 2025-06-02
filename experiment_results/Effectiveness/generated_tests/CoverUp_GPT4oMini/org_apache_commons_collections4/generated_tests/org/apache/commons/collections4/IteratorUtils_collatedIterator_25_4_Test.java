package org.apache.commons.collections4;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
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

class IteratorUtils_collatedIterator_25_4_Test {

    @Test
    void testCollatedIteratorWithNonEmptyIterators() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> collatedIterator = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithEmptyIterator() {
        List<Integer> list1 = Arrays.asList();
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> collatedIterator = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        List<Integer> expected = Arrays.asList(2, 4, 6);
        List<Integer> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithBothEmptyIterators() {
        List<Integer> list1 = Arrays.asList();
        List<Integer> list2 = Arrays.asList();
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> collatedIterator = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithNullComparator() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        // Using null comparator, should use natural ordering
        Iterator<Integer> collatedIterator = IteratorUtils.collatedIterator(null, iterator1, iterator2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithDifferentOrderings() {
        List<String> list1 = Arrays.asList("apple", "banana");
        List<String> list2 = Arrays.asList("apricot", "blueberry");
        Iterator<String> iterator1 = list1.iterator();
        Iterator<String> iterator2 = list2.iterator();
        Comparator<String> comparator = String::compareTo;
        Iterator<String> collatedIterator = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        List<String> expected = Arrays.asList("apple", "apricot", "banana", "blueberry");
        List<String> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }

    @Test
    void testCollatedIteratorWithNullIterator() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        Iterator<Integer> iterator1 = list1.iterator();
        // Null iterator
        Iterator<Integer> iterator2 = null;
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> collatedIterator = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        List<Integer> expected = Arrays.asList(1, 3, 5);
        List<Integer> actual = IteratorUtils.toList(collatedIterator);
        assertEquals(expected, actual);
    }
}
