package org.apache.commons.collections4.list;

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

class AbstractLinkedList_remove_33_0_Test<E> extends AbstractLinkedList {

    private AbstractLinkedList<E> list;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setUp() {
        list = new AbstractLinkedList<E>() {

            {
                header = new Node<>();
                header.next = header;
                header.previous = header;
                size = 0;
            }

            @Override
            protected void removeNode(Node<E> node) {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
            }

            @Override
            public boolean add(E value) {
                Node<E> newNode = new Node<>();
                newNode.setValue(value);
                newNode.next = header;
                newNode.previous = header.previous;
                header.previous.next = newNode;
                header.previous = newNode;
                size++;
                return true;
            }

            @Override
            public boolean addAll(Collection<? extends E> coll) {
                boolean modified = false;
                for (E element : coll) {
                    if (add(element)) {
                        modified = true;
                    }
                }
                return modified;
            }
        };
    }

    @Test
    void testRemove_existingElement() {
        list.add((E) "Element1");
        list.add((E) "Element2");
        list.add((E) "Element3");
        assertTrue(list.remove("Element2"));
        assertEquals(2, list.size);
        assertEquals("Element1", list.getFirst());
    }

    @Test
    void testRemove_nonExistingElement() {
        list.add((E) "Element1");
        list.add((E) "Element2");
        assertFalse(list.remove("Element3"));
        assertEquals(2, list.size);
    }

    @Test
    void testRemove_firstElement() {
        list.add((E) "Element1");
        list.add((E) "Element2");
        list.add((E) "Element3");
        assertTrue(list.remove("Element1"));
        assertEquals(2, list.size);
        assertEquals("Element2", list.getFirst());
    }

    @Test
    void testRemove_lastElement() {
        list.add((E) "Element1");
        list.add((E) "Element2");
        list.add((E) "Element3");
        assertTrue(list.remove("Element3"));
        assertEquals(2, list.size);
        assertEquals("Element1", list.getFirst());
    }

    @Test
    void testRemove_emptyList() {
        assertFalse(list.remove("Element1"));
        assertEquals(0, list.size);
    }

    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> previous;

        void setValue(E value) {
            this.value = value;
        }
    }
}
