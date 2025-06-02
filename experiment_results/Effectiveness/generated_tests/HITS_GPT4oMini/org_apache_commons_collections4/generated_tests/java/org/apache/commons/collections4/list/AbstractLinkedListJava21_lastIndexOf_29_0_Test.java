package org.apache.commons.collections4.list;

import java.util.Collection;
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
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_lastIndexOf_29_0_Test {

    private TestLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList<>();
    }

    @Test
    void testLastIndexOfEmptyList() {
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.lastIndexOf(1));
    }

    @Test
    void testLastIndexOfSingleElementPresent() {
        list.addElement(1);
        assertEquals(0, list.lastIndexOf(1));
    }

    @Test
    void testLastIndexOfSingleElementNotPresent() {
        list.addElement(1);
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.lastIndexOf(2));
    }

    @Test
    void testLastIndexOfMultipleElements() {
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(2);
        assertEquals(3, list.lastIndexOf(2));
    }

    @Test
    void testLastIndexOfElementNotInList() {
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.lastIndexOf(4));
    }

    @Test
    void testLastIndexOfNullElement() {
        list.addElement(null);
        list.addElement(2);
        list.addElement(null);
        assertEquals(2, list.lastIndexOf(null));
    }

    @Test
    void testLastIndexOfWithMultipleNulls() {
        list.addElement(null);
        list.addElement(2);
        list.addElement(null);
        list.addElement(3);
        assertEquals(2, list.lastIndexOf(null));
    }

    private static class TestLinkedList<E> extends AbstractLinkedListJava21 {

        private Node<E> header;

        public TestLinkedList() {
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
        }

        public void addElement(E value) {
            Node<E> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
        }

        private class Node<E> {

            E value;

            Node<E> next;

            Node<E> previous;

            Node() {
            }

            Node(E value) {
                this.value = value;
            }

            public E getValue() {
                return value;
            }
        }
    }
}
