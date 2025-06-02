package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.ListOrderedSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedSet_removeIf_15_0_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    void setUp() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
        List<String> list = Arrays.asList("A", "B", "C");
        listOrderedSet = new ListOrderedSet<>(set, list);
    }

    @Test
    void testRemoveIf_WithNonNullPredicate_RemovesMatchingElements() {
        Predicate<String> predicate = s -> s.equals("B");
        boolean result = listOrderedSet.removeIf(predicate);
        assertTrue(result);
        assertFalse(listOrderedSet.contains("B"));
    }

    @Test
    void testRemoveIf_WithPredicateThatRemovesNothing_ReturnsFalse() {
        Predicate<String> predicate = s -> s.equals("D");
        boolean result = listOrderedSet.removeIf(predicate);
        assertFalse(result);
        assertTrue(listOrderedSet.contains("A"));
        assertTrue(listOrderedSet.contains("B"));
        assertTrue(listOrderedSet.contains("C"));
    }

    @Test
    void testRemoveIf_WithNullPredicate_ReturnsFalse() {
        boolean result = listOrderedSet.removeIf(null);
        assertFalse(result);
        assertTrue(listOrderedSet.contains("A"));
        assertTrue(listOrderedSet.contains("B"));
        assertTrue(listOrderedSet.contains("C"));
    }

    @Test
    void testRemoveIf_WithPredicateThatRemovesAllElements() {
        Predicate<String> predicate = s -> true;
        boolean result = listOrderedSet.removeIf(predicate);
        assertTrue(result);
        assertTrue(listOrderedSet.isEmpty());
    }

    @Test
    void testRemoveIf_WithPredicateThatRemovesSomeElements() {
        Predicate<String> predicate = s -> s.equals("A") || s.equals("C");
        boolean result = listOrderedSet.removeIf(predicate);
        assertTrue(result);
        assertFalse(listOrderedSet.contains("A"));
        assertFalse(listOrderedSet.contains("C"));
        assertTrue(listOrderedSet.contains("B"));
    }
}
