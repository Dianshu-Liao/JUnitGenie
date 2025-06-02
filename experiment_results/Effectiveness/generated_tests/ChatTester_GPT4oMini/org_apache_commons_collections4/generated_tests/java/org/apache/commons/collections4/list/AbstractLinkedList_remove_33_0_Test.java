package org.apache.commons.collections4.list;

import java.util.Objects;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLinkedList_remove_33_0_Test {

    private AbstractLinkedList<String> list;

    private class TestLinkedList extends AbstractLinkedList<String> {

        private class Node<E> {

            E value;

            Node<E> next;

            Node<E> previous;

            Node(E value) {
                this.value = value;
            }

            E getValue() {
                return value;
            }
        }

        private Node<String> header;

        public TestLinkedList() {
            super();
            header = new Node<>(null);
            header.next = header;
            header.previous = header;
            size = 0;
        }

        public boolean isEqualValue(Object a, Object b) {
            return (a == null) ? (b == null) : a.equals(b);
        }

        // Fixed the return type to boolean to match List's add method
        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            // Indicate that the element was added successfully
            return true;
        }

        public void removeNode(Node<String> node) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            size--;
        }
    }

    @BeforeEach
    public void setUp() {
        list = new TestLinkedList();
    }

    @Test
    public void testRemoveExistingElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        // Should return true
        assertTrue(list.remove("B"));
        // Ensure it's removed
        assertFalse(list.remove("B"));
        // First element should be A
        assertEquals("A", list.getFirst());
        // Last element should be C
        assertEquals("C", list.getLast());
    }

    @Test
    public void testRemoveNonExistingElement() {
        list.add("A");
        list.add("B");
        // Element does not exist
        assertFalse(list.remove("C"));
    }

    @Test
    public void testRemoveFromEmptyList() {
        // List is empty
        assertFalse(list.remove("A"));
    }

    @Test
    public void testRemoveNullValue() {
        list.add(null);
        // Remove null
        assertTrue(list.remove(null));
        // Ensure null is removed
        assertFalse(list.remove(null));
    }

    @Test
    public void testRemoveMultipleElements() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        // Remove first B
        assertTrue(list.remove("B"));
        // Remove second B
        assertTrue(list.remove("B"));
        // Ensure B is removed
        assertFalse(list.remove("B"));
    }
}
