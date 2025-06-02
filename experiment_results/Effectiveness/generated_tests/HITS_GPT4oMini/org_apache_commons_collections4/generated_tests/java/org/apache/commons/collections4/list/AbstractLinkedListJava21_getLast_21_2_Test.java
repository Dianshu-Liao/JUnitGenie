package org.apache.commons.collections4.list;

import java.util.NoSuchElementException;
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
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_getLast_21_2_Test extends AbstractLinkedListJava21 {

    private Node<Integer> node1;

    private Node<Integer> node2;

    private Node<Integer> node3;

    @BeforeEach
    void setUp() {
        // Initialize the linked list with a header and nodes for testing
        init();
        node1 = new Node<>(1);
        node2 = new Node<>(2);
        node3 = new Node<>(3);
        // Set up the circular links
        header.next = node1;
        node1.previous = header;
        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = header;
        header.previous = node3;
        // Update size for the list
        size = 3;
    }

    @Test
    void testGetLast_ReturnsLastElement() {
        assertEquals(3, getLast());
    }

    @Test
    void testGetLast_ThrowsNoSuchElementException_WhenListIsEmpty() {
        // Clear the list
        header.next = header;
        header.previous = header;
        size = 0;
        assertThrows(NoSuchElementException.class, this::getLast);
    }

    @Test
    void testGetLast_ReturnsCorrectElementAfterAddingMoreNodes() {
        Node<Integer> node4 = new Node<>(4);
        node3.next = node4;
        node4.previous = node3;
        node4.next = header;
        header.previous = node4;
        size++;
        assertEquals(4, getLast());
    }

    @Test
    void testGetLast_ThrowsNoSuchElementException_AfterRemovingLastElement() {
        // Remove the last element (node3)
        node2.next = header;
        header.previous = node2;
        size--;
        // Should return the new last element
        assertEquals(2, getLast());
        // Now make it empty
        node2.next = header;
        header.previous = header;
        size--;
        assertThrows(NoSuchElementException.class, this::getLast);
    }
}
