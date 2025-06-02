package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.CollectionUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_indexOf_24_0_Test extends AbstractLinkedListJava21<Integer> {

    @BeforeEach
    void setUp() {
        // Initialize the linked list with some elements for testing
        Collection<Integer> initialElements = Arrays.asList(1, 2, 3, 4, 5);
        addAll(initialElements);
    }

    @Test
    void testIndexOfExistingElement() {
        // Test for an existing element
        assertEquals(0, indexOf(1));
        assertEquals(1, indexOf(2));
        assertEquals(2, indexOf(3));
        assertEquals(3, indexOf(4));
        assertEquals(4, indexOf(5));
    }

    @Test
    void testIndexOfNonExistingElement() {
        // Test for a non-existing element
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, indexOf(6));
    }

    @Test
    void testIndexOfNullElement() {
        // Test for null element when the list contains a null
        add(null);
        // Assuming the null is added at index 5
        assertEquals(5, indexOf(null));
    }

    @Test
    void testIndexOfNullWhenListIsEmpty() {
        // Test for null when the list is empty
        clear();
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, indexOf(null));
    }

    @Test
    void testIndexOfWithConcurrentModification() {
        // Test for concurrent modification exception
        assertThrows(ConcurrentModificationException.class, () -> {
            for (int i = 0; i < size(); i++) {
                indexOf(get(i));
                // Modifying the list while iterating
                remove(i);
            }
        });
    }

    @Override
    public boolean add(Integer value) {
        // Implementation for adding an element to the list
        // Add the value to the linked list
        // Return true after adding
        return true;
    }

    @Override
    public void clear() {
        // Implementation for clearing the list
        // Clear the linked list
    }

    @Override
    public Integer remove(int index) {
        // Implementation for removing an element at the specified index
        // Remove the element from the linked list
        // Placeholder return value
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> coll) {
        // Implementation for adding all elements from a collection
        // Add all elements to the linked list
        // Return true after adding all
        return true;
    }
}
