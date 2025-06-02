package org.apache.commons.collections4.list;

import java.util.ArrayList;
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
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_isEmpty_26_1_Test extends AbstractLinkedListJava21 {

    // Constructor for the test class
    protected AbstractLinkedListJava21_isEmpty_26_1_Test() {
        super(new ArrayList<>());
    }

    @BeforeEach
    void setUp() {
        // Initialize the linked list before each test
        // We can control the size directly for testing
        this.size = 0;
    }

    @Test
    void testIsEmptyWhenListIsEmpty() {
        // Test isEmpty() when the list is empty
        assertTrue(isEmpty(), "The list should be empty.");
    }

    @Test
    void testIsEmptyWhenListIsNotEmpty() {
        // Test isEmpty() when the list has elements
        // Simulate adding one element
        this.size = 1;
        assertFalse(isEmpty(), "The list should not be empty.");
    }

    @Test
    void testIsEmptyAfterRemovingAllElements() {
        // Test isEmpty() after removing all elements
        // Simulate adding three elements
        this.size = 3;
        // Simulate removing all elements
        this.size = 0;
        assertTrue(isEmpty(), "The list should be empty after removal of all elements.");
    }
}
