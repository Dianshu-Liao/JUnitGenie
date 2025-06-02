package org.apache.commons.collections4.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class // Additional tests can be added for edge cases and other scenarios
ListOrderedSet_add_3_0_Test {

    private ListOrderedSet<String> listOrderedSet;

    private Set<String> mockSet;

    @BeforeEach
    public void setUp() {
        mockSet = new HashSet<>();
        listOrderedSet = new ListOrderedSet<>(mockSet);
    }

    @Test
    public void testAddNewElement() {
        boolean result = listOrderedSet.add("element1");
        assertTrue(result);
        assertTrue(mockSet.contains("element1"));
    }

    @Test
    public void testAddDuplicateElement() {
        listOrderedSet.add("element1");
        boolean result = listOrderedSet.add("element1");
        assertFalse(result);
        assertEquals(1, mockSet.size());
    }

    @Test
    public void testAddNullElement() {
        boolean result = listOrderedSet.add(null);
        assertTrue(result);
        assertTrue(mockSet.contains(null));
    }

    @Test
    public void testAddMultipleElements() {
        boolean result1 = listOrderedSet.add("element1");
        boolean result2 = listOrderedSet.add("element2");
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(mockSet.contains("element1"));
        assertTrue(mockSet.contains("element2"));
        assertEquals(2, mockSet.size());
    }

    @Test
    public void testAddElementAfterDuplicate() {
        listOrderedSet.add("element1");
        // Adding duplicate
        listOrderedSet.add("element1");
        // Adding a new element
        boolean result = listOrderedSet.add("element2");
        assertTrue(result);
        assertTrue(mockSet.contains("element2"));
        assertEquals(2, mockSet.size());
    }
}
