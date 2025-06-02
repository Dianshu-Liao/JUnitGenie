package org.apache.commons.collections4;

import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
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
import org.apache.commons.collections4.iterators.CollatingIterator;
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

class IteratorUtils_collatedIterator_24_2_Test {

    @Test
    void testCollatedIteratorWithNaturalComparator() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, iterator1, iterator2);
        assertTrue(result.hasNext());
        assertEquals(1, result.next());
        assertTrue(result.hasNext());
        assertEquals(2, result.next());
        assertTrue(result.hasNext());
        assertEquals(3, result.next());
        assertTrue(result.hasNext());
        assertEquals(4, result.next());
        assertTrue(result.hasNext());
        assertEquals(5, result.next());
        assertTrue(result.hasNext());
        assertEquals(6, result.next());
        assertFalse(result.hasNext());
    }

    @Test
    void testCollatedIteratorWithCustomComparator() {
        Iterator<String> iterator1 = Arrays.asList("apple", "orange").iterator();
        Iterator<String> iterator2 = Arrays.asList("banana", "grape").iterator();
        Comparator<String> comparator = Comparator.reverseOrder();
        Iterator<String> result = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);
        assertTrue(result.hasNext());
        assertEquals("orange", result.next());
        assertTrue(result.hasNext());
        assertEquals("grape", result.next());
        assertTrue(result.hasNext());
        assertEquals("banana", result.next());
        assertTrue(result.hasNext());
        assertEquals("apple", result.next());
        assertFalse(result.hasNext());
    }

    @Test
    void testCollatedIteratorWithEmptyIterators() {
        // Fixed Buggy Line
        Iterator<Object> iterator1 = Arrays.asList().iterator();
        Iterator<Object> iterator2 = Arrays.asList().iterator();
        Iterator<Object> result = IteratorUtils.collatedIterator(null, iterator1, iterator2);
        assertFalse(result.hasNext());
    }
}
