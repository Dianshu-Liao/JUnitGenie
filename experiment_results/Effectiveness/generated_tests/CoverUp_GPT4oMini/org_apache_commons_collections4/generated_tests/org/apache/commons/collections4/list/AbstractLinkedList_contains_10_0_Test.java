package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbstractLinkedList_contains_10_0_Test {

    private TestLinkedList list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testContainsWhenElementIsPresent() {
        list.add("element1");
        assertTrue(list.contains("element1"));
    }

    @Test
    void testContainsWhenElementIsNotPresent() {
        list.add("element1");
        assertFalse(list.contains("element2"));
    }

    @Test
    void testContainsWhenListIsEmpty() {
        assertFalse(list.contains("element1"));
    }

    @Test
    void testContainsWithNull() {
        list.add(null);
        assertTrue(list.contains(null));
        assertFalse(list.contains("element1"));
    }

    @Test
    void testContainsWithMultipleElements() {
        list.add("element1");
        list.add("element2");
        list.add("element3");
        assertTrue(list.contains("element2"));
        assertFalse(list.contains("element4"));
    }

    @Test
    void testContainsWithConcurrentModification() throws Exception {
        list.add("element1");
        list.add("element2");
        incrementModCount(list);
        assertThrows(ConcurrentModificationException.class, () -> list.contains("element1"));
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

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

        private Node<String> header;

        private int size;

        public TestLinkedList() {
            header = new Node<>(null);
            header.next = header;
            header.previous = header;
            size = 0;
        }

        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.next = header;
            newNode.previous = header.previous;
            header.previous.next = newNode;
            header.previous = newNode;
            size++;
            modCount++;
            return true;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEqualValue(Object a, Object b) {
            return Objects.equals(a, b);
        }

        @Override
        public int indexOf(Object value) {
            Node<String> current = header.next;
            int index = 0;
            while (current != header) {
                if (isEqualValue(current.getValue(), value)) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    private void incrementModCount(TestLinkedList list) throws Exception {
        Field modCountField = AbstractLinkedList.class.getDeclaredField("modCount");
        modCountField.setAccessible(true);
        int currentModCount = (int) modCountField.get(list);
        modCountField.set(list, currentModCount + 1);
    }
}
