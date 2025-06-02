package org.apache.commons.collections4.list;

import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLinkedListJava21_lastIndexOf_29_0_Test {

    private AbstractLinkedListJava21<String> list;

    // Mock Node class for testing
    private static class Node<E> {

        E value;

        Node<E> previous;

        Node(E value) {
            this.value = value;
        }

        E getValue() {
            return value;
        }
    }

    // Concrete implementation for testing
    private static class ConcreteLinkedList extends AbstractLinkedListJava21<String> {

        public ConcreteLinkedList() {
            super();
            header = new Node<>(null);
            // Circular reference
            header.previous = header;
            size = 0;
        }

        @Override
        public boolean add(String value) {
            Node<String> newNode = new Node<>(value);
            newNode.previous = header.previous;
            header.previous = newNode;
            size++;
            // Return true to match List interface
            return true;
        }

        @Override
        protected boolean isEqualValue(Object a, Object b) {
            return a == null ? b == null : a.equals(b);
        }
    }

    @BeforeEach
    public void setUp() {
        list = new ConcreteLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
    }

    @Test
    public void testLastIndexOfFound() {
        int index = list.lastIndexOf("B");
        // Last index of "B" is 3
        assertEquals(3, index);
    }

    @Test
    public void testLastIndexOfNotFound() {
        int index = list.lastIndexOf("D");
        // "D" not found
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }

    @Test
    public void testLastIndexOfNullValue() {
        list.add(null);
        int index = list.lastIndexOf(null);
        // Last index of null is 4
        assertEquals(4, index);
    }

    @Test
    public void testLastIndexOfEmptyList() {
        AbstractLinkedListJava21<String> emptyList = new ConcreteLinkedList();
        int index = emptyList.lastIndexOf("A");
        // Empty list case
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }

    @Test
    public void testLastIndexOfMultipleSameValues() {
        list.add("B");
        int index = list.lastIndexOf("B");
        // Last index of "B" is now 4
        assertEquals(4, index);
    }
}
