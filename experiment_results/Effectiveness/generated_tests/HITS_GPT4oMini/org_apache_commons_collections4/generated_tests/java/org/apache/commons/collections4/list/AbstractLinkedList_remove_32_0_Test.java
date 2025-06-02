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

class AbstractLinkedList_remove_32_0_Test<E> extends AbstractLinkedList {

    private AbstractLinkedList<E> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedList<E>() {

            @Override
            public boolean add(E e) {
                // Simple implementation for testing
                Node<E> newNode = new Node<>(e);
                if (size == 0) {
                    header.next = newNode;
                    header.previous = newNode;
                    newNode.next = header;
                    newNode.previous = header;
                } else {
                    Node<E> lastNode = header.previous;
                    lastNode.next = newNode;
                    newNode.previous = lastNode;
                    newNode.next = header;
                    header.previous = newNode;
                }
                size++;
                modCount++;
                return true;
            }

            @Override
            public E get(int index) {
                return getNode(index, false).getValue();
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public void clear() {
                header.next = header;
                header.previous = header;
                size = 0;
                modCount++;
            }

            @Override
            public boolean remove(Object o) {
                // Placeholder implementation
                return false;
            }

            @Override
            public boolean contains(Object o) {
                // Placeholder implementation
                return false;
            }
        };
    }

    @Test
    void testRemove_ValidIndex() {
        list.add((E) "A");
        list.add((E) "B");
        list.add((E) "C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testRemove_FirstElement() {
        list.add((E) "A");
        list.add((E) "B");
        assertEquals("A", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    void testRemove_LastElement() {
        list.add((E) "A");
        list.add((E) "B");
        assertEquals("B", list.remove(1));
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    void testRemove_IndexOutOfBounds() {
        list.add((E) "A");
        list.add((E) "B");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testRemove_EmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.remove(0));
    }

    @Test
    void testRemove_ModificationCount() {
        list.add((E) "A");
        list.add((E) "B");
        int initialModCount = list.modCount;
        list.remove(0);
        assertNotEquals(initialModCount, list.modCount);
    }
}
