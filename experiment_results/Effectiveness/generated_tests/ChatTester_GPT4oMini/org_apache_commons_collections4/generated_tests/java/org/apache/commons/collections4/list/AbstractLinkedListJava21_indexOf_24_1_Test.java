package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractLinkedListJava21_indexOf_24_1_Test {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
        // Add test data to the list
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }

    @Test
    void testIndexOf_ExistingElement() {
        assertEquals(1, list.indexOf("B"));
        assertEquals(3, list.indexOf("D"));
    }

    @Test
    void testIndexOf_NonExistingElement() {
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.indexOf("E"));
    }

    @Test
    void testIndexOf_NullElement() {
        list.add(null);
        assertEquals(4, list.indexOf(null));
    }

    @Test
    void testIndexOf_EmptyList() {
        list.clear();
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.indexOf("A"));
    }

    // Inner class to implement abstract methods
    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        private Node<String> header;

        private int size;

        public TestLinkedList() {
            header = new Node<>(null);
            header.next = header;
            header.previous = header;
            size = 0;
        }

        // Fixed the return type to boolean
        @Override
        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            // Return true to indicate successful addition
            return true;
        }

        public void clear() {
            header.next = header;
            header.previous = header;
            size = 0;
        }

        protected boolean isEqualValue(String a, Object b) {
            return (b == null && a == null) || (a != null && a.equals(b));
        }

        @Override
        public int size() {
            return size;
        }

        private class Node<E> {

            E value;

            Node<E> next;

            Node<E> previous;

            Node(E value) {
                this.value = value;
            }

            public E getValue() {
                return value;
            }
        }
    }
}
