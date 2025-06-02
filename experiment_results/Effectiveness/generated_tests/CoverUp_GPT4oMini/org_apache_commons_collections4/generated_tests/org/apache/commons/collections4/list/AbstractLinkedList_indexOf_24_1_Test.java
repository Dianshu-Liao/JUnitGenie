package org.apache.commons.collections4.list;

import org.apache.commons.collections4.CollectionUtils;
import java.util.Collection;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedList_indexOf_24_1_Test {

    private AbstractLinkedListTestImpl list;

    @BeforeEach
    public void setUp() {
        list = new AbstractLinkedListTestImpl();
        list.add("A");
        list.add("B");
        list.add("C");
    }

    @Test
    public void testIndexOfExistingElement() {
        assertEquals(0, list.indexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(2, list.indexOf("C"));
    }

    @Test
    public void testIndexOfNonExistingElement() {
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, list.indexOf("D"));
    }

    @Test
    public void testIndexOfNullElement() {
        list.add(null);
        assertEquals(3, list.indexOf(null));
    }

    @Test
    public void testIndexOfWithEmptyList() {
        AbstractLinkedListTestImpl emptyList = new AbstractLinkedListTestImpl();
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, emptyList.indexOf("A"));
    }

    private static class AbstractLinkedListTestImpl extends AbstractLinkedList<String> {

        private Node<String> header;

        public AbstractLinkedListTestImpl() {
            header = new Node<>();
            header.next = header;
            header.previous = header;
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
            // Return true to match List.add() contract
            return true;
        }

        // Mock Node class for testing
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
        }

        @Override
        protected boolean isEqualValue(final Object value1, final Object value2) {
            return super.isEqualValue(value1, value2);
        }
        // Other necessary methods can be implemented or mocked as needed
    }
}
