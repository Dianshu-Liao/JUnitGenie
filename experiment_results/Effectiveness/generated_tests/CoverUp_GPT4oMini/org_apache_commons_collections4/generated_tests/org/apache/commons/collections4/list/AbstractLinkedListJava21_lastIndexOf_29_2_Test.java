package org.apache.commons.collections4.list;

import org.apache.commons.collections4.CollectionUtils;
import java.util.Collection;
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
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractLinkedListJava21_lastIndexOf_29_2_Test {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedListJava21<String>() {

            {
                header = new Node<>();
                header.next = header;
                header.previous = header;
                size = 0;
            }

            @Override
            protected void init() {
                // Initialization logic if needed
            }

            @Override
            public boolean add(String value) {
                Node<String> newNode = new Node<>(value);
                newNode.next = header;
                newNode.previous = header.previous;
                header.previous.next = newNode;
                header.previous = newNode;
                size++;
                return true;
            }

            @Override
            protected Node<String> getNode(int index, boolean create) {
                Node<String> current = header.next;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current;
            }

            @Override
            protected void updateNode(Node<String> node, String value) {
                node.value = value;
            }

            @Override
            public int lastIndexOf(final Object value) {
                int i = size - 1;
                for (Node<String> node = header.previous; node != header; node = node.previous) {
                    if (isEqualValue(node.getValue(), value)) {
                        return i;
                    }
                    i--;
                }
                return CollectionUtils.INDEX_NOT_FOUND;
            }

            protected boolean isEqualValue(Object a, Object b) {
                return (a == null ? b == null : a.equals(b));
            }
        };
    }

    @Test
    void testLastIndexOf_ExistingElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(1, list.lastIndexOf("B"));
    }

    @Test
    void testLastIndexOf_NonExistingElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.lastIndexOf("D"));
    }

    @Test
    void testLastIndexOf_MultipleOccurrences() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(2, list.lastIndexOf("A"));
    }

    @Test
    void testLastIndexOf_EmptyList() {
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.lastIndexOf("A"));
    }

    @Test
    void testLastIndexOf_NullValue() {
        list.add(null);
        list.add("B");
        assertEquals(0, list.lastIndexOf(null));
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
