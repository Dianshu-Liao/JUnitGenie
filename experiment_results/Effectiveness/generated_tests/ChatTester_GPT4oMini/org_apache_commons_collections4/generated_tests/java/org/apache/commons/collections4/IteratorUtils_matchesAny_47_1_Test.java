package org.apache.commons.collections4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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

public class IteratorUtils_matchesAny_47_1_Test {

    private Iterator<String> iterator;

    // Changed to use the correct Predicate type
    private org.apache.commons.collections4.Predicate<String> predicate;

    @BeforeEach
    public void setUp() {
        iterator = mock(Iterator.class);
        // Changed to use the correct Predicate type
        predicate = mock(org.apache.commons.collections4.Predicate.class);
    }

    @Test
    public void testMatchesAny_WithMatchingElement() {
        when(iterator.hasNext()).thenReturn(true, true, false);
        when(iterator.next()).thenReturn("test1", "test2");
        // Changed to use the correct method
        when(predicate.evaluate("test1")).thenReturn(false);
        // Changed to use the correct method
        when(predicate.evaluate("test2")).thenReturn(true);
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertTrue(result);
    }

    @Test
    public void testMatchesAny_WithNoMatchingElement() {
        when(iterator.hasNext()).thenReturn(true, true, false);
        when(iterator.next()).thenReturn("test1", "test2");
        // Changed to use the correct method
        when(predicate.evaluate("test1")).thenReturn(false);
        // Changed to use the correct method
        when(predicate.evaluate("test2")).thenReturn(false);
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result);
    }

    @Test
    public void testMatchesAny_WithEmptyIterator() {
        when(iterator.hasNext()).thenReturn(false);
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result);
    }

    @Test
    public void testMatchesAny_WithNullPredicate() {
        when(iterator.hasNext()).thenReturn(true);
        when(iterator.next()).thenReturn("test1");
        boolean result = IteratorUtils.matchesAny(iterator, null);
        assertFalse(result);
    }

    @Test
    public void testMatchesAny_WithExceptionOnNext() {
        when(iterator.hasNext()).thenReturn(true);
        when(iterator.next()).thenThrow(new NoSuchElementException());
        boolean result = IteratorUtils.matchesAny(iterator, predicate);
        assertFalse(result);
    }
}
