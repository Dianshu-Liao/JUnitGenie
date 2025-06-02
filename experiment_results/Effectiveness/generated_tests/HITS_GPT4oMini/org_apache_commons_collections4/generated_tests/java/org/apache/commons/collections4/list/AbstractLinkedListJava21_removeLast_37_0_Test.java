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

class AbstractLinkedListJava21_removeLast_37_0_Test {

    private TestLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new TestLinkedList<>();
    }

    @Test
    void testRemoveLastFromEmptyList() {
        assertThrows(NoSuchElementException.class, linkedList::removeLast);
    }

    @Test
    void testRemoveLastFromSingleElementList() {
        linkedList.addLastElement(1);
        Integer removedValue = linkedList.removeLast();
        assertEquals(Integer.valueOf(1), removedValue);
        assertEquals(0, linkedList.size());
    }

    @Test
    void testRemoveLastFromMultipleElementList() {
        linkedList.addLastElement(1);
        linkedList.addLastElement(2);
        linkedList.addLastElement(3);
        Integer removedValue = linkedList.removeLast();
        assertEquals(Integer.valueOf(3), removedValue);
        assertEquals(2, linkedList.size());
        assertEquals(Integer.valueOf(2), linkedList.getLast());
    }

    @Test
    void testRemoveLastUpdatesModCount() {
        linkedList.addLastElement(1);
        linkedList.addLastElement(2);
        int initialModCount = linkedList.modCount;
        linkedList.removeLast();
        assertNotEquals(initialModCount, linkedList.modCount);
    }

    private static class TestLinkedList<E> extends AbstractLinkedListJava21 {

        public TestLinkedList() {
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
            modCount = 0;
        }

        public void addLastElement(E value) {
            Node<E> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            modCount++;
        }

        public int size() {
            return size;
        }

        public Integer getLast() {
            return (Integer) super.getLast();
        }

        public Integer removeLast() {
            return (Integer) super.removeLast();
        }

        private class Node<T> extends AbstractLinkedListJava21.Node<T> {

            T value;

            Node() {
                this.value = null;
            }

            Node(T value) {
                this.value = value;
            }

            public T getValue() {
                return value;
            }
        }
    }
}
