package org.apache.commons.collections4.list;

import java.lang.reflect.Field;
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

class AbstractLinkedListJava21_getLast_21_0_Test {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedListJava21<String>() {

            @Override
            protected Node<String> createHeaderNode() {
                Node<String> node = new Node<>();
                node.setValue(null);
                node.next = node;
                node.previous = node;
                return node;
            }

            @Override
            public boolean add(String value) {
                Node<String> newNode = new Node<>();
                newNode.setValue(value);
                Node<String> last = header.previous;
                last.next = newNode;
                newNode.previous = last;
                newNode.next = header;
                header.previous = newNode;
                size++;
                modCount++;
                return true;
            }
        };
        setHeaderNode();
    }

    private void setHeaderNode() {
        try {
            Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
            headerField.setAccessible(true);
            headerField.set(list, list.createHeaderNode());
        } catch (Exception e) {
            fail("Failed to set header node: " + e.getMessage());
        }
    }

    @Test
    void testGetLast_EmptyList_ThrowsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    @Test
    void testGetLast_NonEmptyList_ReturnsLastElement() {
        list.add("First");
        list.add("Second");
        String lastElement = list.getLast();
        assertEquals("Second", lastElement);
    }

    @Test
    void testGetLast_SingleElementList_ReturnsLastElement() {
        list.add("OnlyElement");
        String lastElement = list.getLast();
        assertEquals("OnlyElement", lastElement);
    }

    @Test
    void testGetLast_AfterAddingMultipleElements_ReturnsCorrectLastElement() {
        list.add("One");
        list.add("Two");
        list.add("Three");
        String lastElement = list.getLast();
        assertEquals("Three", lastElement);
    }

    private static class Node<E> {

        private E value;

        private Node<E> next;

        private Node<E> previous;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
