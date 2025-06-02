// Adjust the package as necessary
package org.apache.commons.collections4;

import org.apache.commons.collections4.IteratorUtils;
import java.util.Arrays;
import java.util.Collections;
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

public class IteratorUtils_collatedIterator_23_1_Test {

    @Test
    public void testCollatedIterator_NullComparator_UsesNaturalComparator() {
        // Arrange
        List<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(3, 1, 2).iterator(), Arrays.asList(6, 5, 4).iterator());
        // Act
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, Collections.unmodifiableCollection(iterators));
        // Collect results
        List<Integer> resultList = collectIterator(result);
        // Assert
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, resultList);
    }

    @Test
    public void testCollatedIterator_ProvidedComparator_UsesGivenComparator() {
        // Arrange
        Comparator<Integer> descendingComparator = Comparator.reverseOrder();
        List<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(3, 1, 2).iterator(), Arrays.asList(6, 5, 4).iterator());
        // Act
        Iterator<Integer> result = IteratorUtils.collatedIterator(descendingComparator, Collections.unmodifiableCollection(iterators));
        // Collect results
        List<Integer> resultList = collectIterator(result);
        // Assert
        List<Integer> expected = Arrays.asList(6, 5, 4, 3, 2, 1);
        assertEquals(expected, resultList);
    }

    @Test
    public void testCollatedIterator_EmptyCollection_ReturnsEmptyIterator() {
        // Arrange
        List<Iterator<Integer>> iterators = Collections.emptyList();
        // Act
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, Collections.unmodifiableCollection(iterators));
        // Collect results
        List<Integer> resultList = collectIterator(result);
        // Assert
        assertTrue(resultList.isEmpty());
    }

    @Test
    public void testCollatedIterator_SingleIterator_ReturnsSameElements() {
        // Arrange
        List<Iterator<Integer>> iterators = Arrays.asList(Arrays.asList(1, 2, 3).iterator());
        // Act
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, Collections.unmodifiableCollection(iterators));
        // Collect results
        List<Integer> resultList = collectIterator(result);
        // Assert
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, resultList);
    }

    private List<Integer> collectIterator(Iterator<Integer> iterator) {
        List<Integer> resultList = new ArrayList<>();
        iterator.forEachRemaining(resultList::add);
        return resultList;
    }
}
