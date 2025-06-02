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

public class AbstractLinkedListJava21_getLast_21_1_Test {

    private AbstractLinkedListJava21<String> linkedList;

    // Node class for the linked list
    private static class Node<E> {

        E value;

        Node<E> previous;

        Node<E> next;

        Node(E value) {
            this.value = value;
        }

        E getValue() {
            return value;
        }
    }

    // Concrete implementation of the abstract class for testing
    private static class // Fixed the generic type
    // Fixed the generic type
    ConcreteLinkedList extends AbstractLinkedListJava21<String> {

        public ConcreteLinkedList() {
            super();
            header = new Node<>(null);
            // Initialize as empty list
            header.previous = header;
            header.next = header;
        }

        public void addLast(String value) {
            // Fixed the method signature
            Node<String> newNode = new Node<>(value);
            newNode.previous = header.previous;
            // Fixing the linkage
            header.previous.next = newNode;
            header.previous = newNode;
            // Fixing the linkage
            newNode.next = header;
            size++;
            modCount++;
        }
    }

    @BeforeEach
    public void setUp() {
        linkedList = new ConcreteLinkedList();
    }

    @Test
    public void testGetLastThrowsNoSuchElementExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.getLast();
        });
    }

    @Test
    public void testGetLastReturnsLastElement() {
        linkedList.addLast("first");
        linkedList.addLast("second");
        String lastElement = linkedList.getLast();
        assertEquals("second", lastElement);
    }

    @Test
    public void testGetLastReturnsCorrectElementAfterMultipleAdds() {
        linkedList.addLast("first");
        linkedList.addLast("second");
        linkedList.addLast("third");
        String lastElement = linkedList.getLast();
        assertEquals("third", lastElement);
    }

    @Test
    public void testGetLastHandlesSingleElement() {
        linkedList.addLast("onlyElement");
        String lastElement = linkedList.getLast();
        assertEquals("onlyElement", lastElement);
    }
}
