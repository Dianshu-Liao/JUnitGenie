package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.util.Collection;
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
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_remove_32_3_Test {

    private AbstractLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedList<String>() {

            {
                header = new Node<>();
                header.next = header;
                header.previous = header;
                size = 0;
            }

            @Override
            protected void removeNode(Node<String> node) {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
            }

            @Override
            protected void updateNode(Node<String> node, String value) {
                node.value = value;
            }

            @Override
            protected Node<String> getNode(int index, boolean endMarkerAllowed) {
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException();
                }
                Node<String> current = header.next;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current;
            }

            @Override
            public boolean add(String value) {
                Node<String> newNode = new Node<>(value);
                newNode.previous = header.previous;
                newNode.next = header;
                header.previous.next = newNode;
                header.previous = newNode;
                size++;
                return true;
            }

            public String getFirst() {
                return header.next.getValue();
            }
        };
    }

    @Test
    void testRemoveValidIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, invokeSize());
        assertThrows(IndexOutOfBoundsException.class, () -> list.getNode(2, false));
    }

    @Test
    void testRemoveFirstElement() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.remove(0));
        assertEquals(1, invokeSize());
        assertEquals("B", list.getFirst());
    }

    @Test
    void testRemoveLastElement() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.remove(1));
        assertEquals(1, invokeSize());
        assertEquals("A", list.getFirst());
    }

    @Test
    void testRemoveInvalidIndex() {
        list.add("A");
        list.add("B");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testRemoveFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    private int invokeSize() {
        try {
            Method method = AbstractLinkedList.class.getDeclaredField("size").getDeclaringClass().getDeclaredMethod("getSize");
            method.setAccessible(true);
            return (int) method.invoke(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> previous;

        Node() {
        }

        Node(E value) {
            this.value = value;
        }

        E getValue() {
            return value;
        }
    }
}
