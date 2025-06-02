package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.ListOrderedSet;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedSet_add_4_0_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    void setUp() {
        listOrderedSet = new ListOrderedSet<>(new HashSet<>(), new ArrayList<>());
    }

    @Test
    void testAdd_NewElement() throws Exception {
        String element = "Element1";
        listOrderedSet.add(0, element);
        // Validate that the element was added
        assertTrue(listOrderedSet.contains(element));
    }

    @Test
    void testAdd_ExistingElement() throws Exception {
        String element = "Element1";
        // First add
        listOrderedSet.add(0, element);
        // Attempt to add again
        listOrderedSet.add(1, element);
        // Validate that the element is still only added once
        assertEquals(1, listOrderedSet.size());
    }

    @Test
    void testAdd_IndexOutOfBounds() throws Exception {
        String element = "Element1";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Index 1 is out of bounds for an empty list
            listOrderedSet.add(1, element);
        });
    }

    @Test
    void testAdd_NegativeIndex() throws Exception {
        String element = "Element1";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Negative index should throw exception
            listOrderedSet.add(-1, element);
        });
    }

    @Test
    void testAdd_ValidIndex() throws Exception {
        String element1 = "Element1";
        String element2 = "Element2";
        // Add first element
        listOrderedSet.add(0, element1);
        // Add second element at valid index
        listOrderedSet.add(1, element2);
        // Validate the order of elements
        assertEquals(2, listOrderedSet.size());
        assertTrue(listOrderedSet.contains(element1));
        assertTrue(listOrderedSet.contains(element2));
    }

    private void invokePrivateAdd(int index, String element) throws Exception {
        Method method = ListOrderedSet.class.getDeclaredMethod("add", int.class, Object.class);
        method.setAccessible(true);
        method.invoke(listOrderedSet, index, element);
    }
}
