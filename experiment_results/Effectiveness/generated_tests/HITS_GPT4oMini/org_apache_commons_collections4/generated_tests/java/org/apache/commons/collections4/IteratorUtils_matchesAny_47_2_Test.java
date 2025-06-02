package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;
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
import java.util.Comparator;
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

public class IteratorUtils_matchesAny_47_2_Test {

    @Test
    public void testMatchesAny_WithMatchingElement() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        // Custom Predicate
        Predicate<Integer> predicate = number -> number == 3;
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(result, "Expected to find a matching element (3) in the iterator.");
    }

    @Test
    public void testMatchesAny_WithNoMatchingElement() {
        List<Integer> list = Arrays.asList(1, 2, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        // Custom Predicate
        Predicate<Integer> predicate = number -> number == 3;
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result, "Expected not to find a matching element (3) in the iterator.");
    }

    @Test
    public void testMatchesAny_WithEmptyIterator() {
        List<Integer> list = Arrays.asList();
        Iterator<Integer> iterator = list.iterator();
        // Custom Predicate
        Predicate<Integer> predicate = number -> number == 3;
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result, "Expected not to find a matching element (3) in the empty iterator.");
    }

    @Test
    public void testMatchesAny_WithNullPredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        // This will need to be handled in the method under test
        Predicate<Integer> predicate = null;
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result, "Expected not to find a matching element with a null predicate.");
    }

    @Test
    public void testMatchesAny_WithAllMatchingElements() {
        List<Integer> list = Arrays.asList(3, 3, 3);
        Iterator<Integer> iterator = list.iterator();
        // Custom Predicate
        Predicate<Integer> predicate = number -> number == 3;
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(result, "Expected to find matching elements (all are 3) in the iterator.");
    }

    @Test
    public void testMatchesAny_WithComplexPredicate() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Iterator<String> iterator = list.iterator();
        // Custom Predicate
        Predicate<String> predicate = fruit -> fruit.startsWith("b");
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(result, "Expected to find a matching element (banana) in the iterator.");
    }
}
