package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.reflect.Field;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLinkedListJava21_contains_10_2_Test {

    private AbstractLinkedListJava21<String> list;

    // Mock Node class for testing
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

    // Concrete implementation of the abstract class for testing
    private static class ConcreteLinkedList extends AbstractLinkedListJava21<String> {

        public ConcreteLinkedList() {
            super();
            try {
                Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
                headerField.setAccessible(true);
                header = new Node<>(null);
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
        public int size() {
            return size;
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
        public int indexOf(Object value) {
            Node<String> current = header.next;
            int index = 0;
            while (current != header) {
                if (Objects.equals(current.getValue(), value)) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    @BeforeEach
    public void setUp() {
        list = new ConcreteLinkedList();
    }

    @Test
    public void testContains_WhenElementExists() {
        list.add("test");
        assertTrue(list.contains("test"));
    }

    @Test
    public void testContains_WhenElementDoesNotExist() {
        list.add("test");
        assertFalse(list.contains("nonexistent"));
    }

    @Test
    public void testContains_WhenListIsEmpty() {
        assertFalse(list.contains("nonexistent"));
    }

    @Test
    public void testContains_WhenNullElementExists() {
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    public void testContains_WhenNullElementDoesNotExist() {
        list.add("test");
        assertFalse(list.contains(null));
    }
}
