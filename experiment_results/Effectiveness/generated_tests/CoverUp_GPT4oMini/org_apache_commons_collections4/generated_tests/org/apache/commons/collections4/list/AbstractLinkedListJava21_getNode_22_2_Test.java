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

public class AbstractLinkedListJava21_getNode_22_2_Test {

    private AbstractLinkedListJava21<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new AbstractLinkedListJava21<Integer>() {

            @Override
            protected Node<Integer> createNode(Integer value) {
                return new Node<>(value);
            }

            @Override
            protected Node<Integer> createHeaderNode() {
                Node<Integer> headerNode = new Node<>(null);
                headerNode.next = headerNode;
                headerNode.previous = headerNode;
                return headerNode;
            }
        };
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
    }

    @Test
    public void testGetNode_ValidIndex() {
        assertEquals(1, list.getNode(0, false).getValue());
        assertEquals(2, list.getNode(1, false).getValue());
        assertEquals(3, list.getNode(2, false).getValue());
    }

    @Test
    public void testGetNode_IndexOutOfBounds_Negative() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getNode(-1, false);
        });
        assertEquals("Couldn't get the node: index (-1) less than zero.", exception.getMessage());
    }

    @Test
    public void testGetNode_IndexOutOfBounds_EqualToSize() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getNode(3, false);
        });
        assertEquals("Couldn't get the node: index (3) is the size of the list.", exception.getMessage());
    }

    @Test
    public void testGetNode_IndexOutOfBounds_GreaterThanSize() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getNode(4, false);
        });
        assertEquals("Couldn't get the node: index (4) greater than the size of the list (3).", exception.getMessage());
    }

    @Test
    public void testGetNode_EndMarkerAllowed() {
        assertEquals(3, list.getNode(3, true).getValue());
    }

    @Test
    public void testGetNode_EndMarkerAllowed_ThrowsException() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getNode(4, true);
        });
        assertEquals("Couldn't get the node: index (4) greater than the size of the list (3).", exception.getMessage());
    }

    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> previous;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
