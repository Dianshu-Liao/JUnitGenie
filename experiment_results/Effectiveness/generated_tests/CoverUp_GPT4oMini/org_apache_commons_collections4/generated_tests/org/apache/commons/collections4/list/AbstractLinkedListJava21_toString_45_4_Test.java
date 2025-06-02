package org.apache.commons.collections4.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.lang.reflect.Field;
import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;
import java.lang.reflect.Method;
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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_toString_45_4_Test {

    private AbstractLinkedListJava21<String> list;

    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        protected TestLinkedList() {
            super();
            try {
                Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
                headerField.setAccessible(true);
                header = new Node<>();
                header.next = header;
                header.previous = header;
                headerField.set(this, header);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            size = 0;
            modCount = 0;
        }

        @Override
        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.previous = header.previous;
            newNode.next = header;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            modCount++;
            return true;
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {

                private Node<String> current = header.next;

                @Override
                public boolean hasNext() {
                    return current != header;
                }

                @Override
                public String next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    String value = current.value;
                    current = current.next;
                    return value;
                }
            };
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }
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

        E getValue() {
            return value;
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testToString_EmptyList() {
        assertEquals("[]", list.toString());
    }

    @Test
    void testToString_SingleElement() {
        list.add("Element1");
        assertEquals("[Element1]", list.toString());
    }

    @Test
    void testToString_MultipleElements() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("[Element1, Element2, Element3]", list.toString());
    }

    @Test
    void testToString_SelfReference() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        // Adding self-reference
        list.add("Element1");
        assertEquals("[Element1, Element2, Element3, (this Collection)]", list.toString());
    }

    @Test
    void testToString_ConcurrentModification() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        Iterator<String> iterator = list.iterator();
        // Modify the list during iteration
        list.add("Element4");
        assertThrows(ConcurrentModificationException.class, () -> {
            iterator.next();
        });
    }
}
