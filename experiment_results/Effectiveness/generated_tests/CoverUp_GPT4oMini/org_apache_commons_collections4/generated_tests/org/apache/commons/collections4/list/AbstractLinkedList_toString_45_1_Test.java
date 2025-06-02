package org.apache.commons.collections4.list;

import org.apache.commons.collections4.list.AbstractLinkedList;
import java.util.Iterator;
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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_toString_45_1_Test {

    private TestLinkedList list;

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
        list.add(list.toString());
        assertEquals("[(this Collection)]", list.toString());
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        private final Node<String> header = new Node<>(null);

        private int size = 0;

        public TestLinkedList() {
            this.header.next = this.header;
            this.header.previous = this.header;
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
        public int size() {
            return size;
        }

        private static class Node<E> {

            E value;

            Node<E> next;

            Node<E> previous;

            Node(E value) {
                this.value = value;
            }

            E getValue() {
                return value;
            }
        }
    }
}
