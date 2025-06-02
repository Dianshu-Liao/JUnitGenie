package org.apache.commons.collections4.set;

import java.util.HashSet;
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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedSet_removeIf_15_1_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    public void setUp() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        listOrderedSet = new ListOrderedSet(set);
    }

    @Test
    public void testRemoveIf_TrueCondition() {
        Predicate<String> predicate = s -> s.equals("B");
        boolean result = listOrderedSet.removeIf(predicate);
        assertTrue(result);
        // Assuming contains method exists
        assertFalse(listOrderedSet.contains("B"));
    }

    @Test
    public void testRemoveIf_FalseCondition() {
        Predicate<String> predicate = s -> s.equals("D");
        boolean result = listOrderedSet.removeIf(predicate);
        assertFalse(result);
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("A"));
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("B"));
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("C"));
    }

    @Test
    public void testRemoveIf_NullPredicate() {
        Predicate<String> predicate = null;
        boolean result = listOrderedSet.removeIf(predicate);
        assertFalse(result);
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("A"));
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("B"));
        // Assuming contains method exists
        assertTrue(listOrderedSet.contains("C"));
    }

    @Test
    public void testRemoveIf_EmptySet() {
        listOrderedSet = new ListOrderedSet(new HashSet<>());
        Predicate<String> predicate = s -> s.equals("A");
        boolean result = listOrderedSet.removeIf(predicate);
        assertFalse(result);
    }
}
