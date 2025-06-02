package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.reflect.Field;
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

class AbstractLinkedList_remove_32_0_Test {

    private AbstractLinkedList<String> list;

    private class TestLinkedList extends AbstractLinkedList<String> {

        protected TestLinkedList() {
            super();
        }

        protected TestLinkedList(Collection<? extends String> coll) {
            super(coll);
        }

        @Override
        protected void removeNode(Node<String> node) {
            if (node == header)
                return;
            if (size > 0)
                size--;
        }

        @Override
        protected void updateNode(Node<String> node, String value) {
            node.setValue(value);
        }

        @Override
        protected void init() {
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
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

        public int getSize() {
            return size;
        }

        public Node<String> getHeader() {
            return header;
        }

        public String get(int index) {
            return getNode(index, false).getValue();
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testRemoveValidIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, getSizeUsingReflection(list));
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    void testRemoveFirstElement() {
        list.add("A");
        list.add("B");
        assertEquals("A", list.remove(0));
        assertEquals(1, getSizeUsingReflection(list));
        assertEquals("B", list.getFirst());
    }

    @Test
    void testRemoveLastElement() {
        list.add("A");
        list.add("B");
        assertEquals("B", list.remove(1));
        assertEquals(1, getSizeUsingReflection(list));
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

    private int getSizeUsingReflection(AbstractLinkedList<String> list) {
        try {
            Field field = AbstractLinkedList.class.getDeclaredField("size");
            field.setAccessible(true);
            return (int) field.get(list);
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

        void setValue(E value) {
            this.value = value;
        }
    }
}
