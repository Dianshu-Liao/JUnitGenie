package org.apache.commons.collections4.set;

import java.util.ArrayList;
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
import java.util.Collection;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedSet_removeIf_15_0_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    public void setUp() {
        listOrderedSet = new ListOrderedSet<>(new HashSet<>(), new ArrayList<>());
    }

    @Test
    public void testRemoveIf_NullFilter() {
        boolean result = listOrderedSet.removeIf(null);
        assertFalse(result, "Expected false when filter is null.");
    }

    @Test
    public void testRemoveIf_FilterRemovesElements() {
        listOrderedSet.add("A");
        listOrderedSet.add("B");
        listOrderedSet.add("C");
        Predicate<String> filter = s -> s.equals("B");
        boolean result = listOrderedSet.removeIf(filter);
        assertTrue(result, "Expected true when elements are removed.");
        assertFalse(listOrderedSet.contains("B"), "Expected 'B' to be removed.");
    }

    @Test
    public void testRemoveIf_NoElementsRemoved() {
        listOrderedSet.add("A");
        listOrderedSet.add("B");
        listOrderedSet.add("C");
        Predicate<String> filter = s -> s.equals("D");
        boolean result = listOrderedSet.removeIf(filter);
        assertFalse(result, "Expected false when no elements are removed.");
        assertTrue(listOrderedSet.contains("A"), "Expected 'A' to remain.");
        assertTrue(listOrderedSet.contains("B"), "Expected 'B' to remain.");
        assertTrue(listOrderedSet.contains("C"), "Expected 'C' to remain.");
    }

    @Test
    public void testRemoveIf_MultipleElementsRemoved() {
        listOrderedSet.add("A");
        listOrderedSet.add("B");
        listOrderedSet.add("C");
        listOrderedSet.add("B");
        Predicate<String> filter = s -> s.equals("B");
        boolean result = listOrderedSet.removeIf(filter);
        assertTrue(result, "Expected true when multiple elements are removed.");
        assertFalse(listOrderedSet.contains("B"), "Expected 'B' to be removed.");
        assertTrue(listOrderedSet.contains("A"), "Expected 'A' to remain.");
        assertTrue(listOrderedSet.contains("C"), "Expected 'C' to remain.");
    }

    @Test
    public void testRemoveIf_EmptySet() {
        Predicate<String> filter = s -> s.equals("B");
        boolean result = listOrderedSet.removeIf(filter);
        assertFalse(result, "Expected false when removing from an empty set.");
    }
}
