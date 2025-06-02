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

class AbstractLinkedListJava21_getLast_21_0_Test extends AbstractLinkedListJava21 {

    @Override
    protected Node<Object> createHeaderNode() {
        Node<Object> headerNode = new Node<>(null);
        // Points to itself
        headerNode.previous = headerNode;
        // Points to itself
        headerNode.next = headerNode;
        return headerNode;
    }

    @BeforeEach
    void setUp() {
        // Initialize the linked list
        header = createHeaderNode();
        size = 0;
        modCount = 0;
    }

    @Test
    void testGetLast_WhenListIsEmpty_ShouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, this::getLast);
    }

    @Test
    void testGetLast_WhenListHasOneElement_ShouldReturnThatElement() {
        Node<Object> newNode = new Node<>("Element1");
        header.previous = newNode;
        newNode.next = header;
        newNode.previous = header;
        header.next = newNode;
        size++;
        assertEquals("Element1", getLast());
    }

    @Test
    void testGetLast_WhenListHasMultipleElements_ShouldReturnLastElement() {
        Node<Object> firstNode = new Node<>("Element1");
        Node<Object> secondNode = new Node<>("Element2");
        header.previous = secondNode;
        secondNode.next = header;
        secondNode.previous = firstNode;
        firstNode.next = secondNode;
        firstNode.previous = header;
        header.next = firstNode;
        size += 2;
        assertEquals("Element2", getLast());
    }

    @Test
    void testGetLast_WhenListHasOneElementAndRemoveIt_ShouldThrowNoSuchElementException() {
        Node<Object> newNode = new Node<>("Element1");
        header.previous = newNode;
        newNode.next = header;
        newNode.previous = header;
        header.next = newNode;
        size++;
        // Remove the only element
        header.previous = header;
        header.next = header;
        size--;
        assertThrows(NoSuchElementException.class, this::getLast);
    }

    @Test
    void testGetLast_WhenListIsModified_ShouldReflectChanges() {
        Node<Object> firstNode = new Node<>("Element1");
        Node<Object> secondNode = new Node<>("Element2");
        header.previous = secondNode;
        secondNode.next = header;
        secondNode.previous = firstNode;
        firstNode.next = secondNode;
        firstNode.previous = header;
        header.next = firstNode;
        size += 2;
        // Remove the last element
        header.previous = firstNode;
        firstNode.next = header;
        size--;
        assertEquals("Element1", getLast());
    }
}
