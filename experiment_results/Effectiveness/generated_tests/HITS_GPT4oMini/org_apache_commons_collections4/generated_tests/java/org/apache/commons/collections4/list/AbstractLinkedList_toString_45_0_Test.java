package org.apache.commons.collections4.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedList_toString_45_0_Test {

    private TestLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new TestLinkedList();
    }

    @Test
    public void testToString_EmptyList() {
        assertEquals("[]", list.toString());
    }

    @Test
    public void testToString_SingleElement() {
        list.add("Element1");
        assertEquals("[Element1]", list.toString());
    }

    @Test
    public void testToString_MultipleElements() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("[Element1, Element2, Element3]", list.toString());
    }

    @Test
    public void testToString_SelfReference() {
        list.add("this Collection");
        assertEquals("[this Collection]", list.toString());
    }

    @Test
    public void testToString_NullElement() {
        list.add(null);
        assertEquals("[null]", list.toString());
    }

    @Test
    public void testToString_ConcurrentModification() {
        list.add("Element1");
        list.add("Element2");
        // Simulate concurrent modification
        assertThrows(ConcurrentModificationException.class, () -> {
            Iterator<String> iterator = list.iterator();
            iterator.next();
            list.add("Element3");
            list.toString();
        });
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        private Node<String> header;

        private int size;

        private int modCount;

        public TestLinkedList() {
            header = new Node<>(null);
            header.next = header;
            header.previous = header;
            size = 0;
            modCount = 0;
        }

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

                private final int expectedModCount = modCount;

                @Override
                public boolean hasNext() {
                    return current != header;
                }

                @Override
                public String next() {
                    if (modCount != expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
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

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        private static class Node<E> {

            E value;

            Node<E> next;

            Node<E> previous;

            Node(E value) {
                this.value = value;
            }
        }
    }
}
