package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.reflect.Method;
import java.util.Objects;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbstractLinkedListJava21_getNode_22_1_Test {

    private AbstractLinkedListJava21<String> linkedList;

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

    @BeforeEach
    void setUp() {
        linkedList = new AbstractLinkedListJava21<String>() {

            {
                addLast("A");
                addLast("B");
                addLast("C");
            }

            @Override
            protected Node<String> createNode(String value) {
                return new Node<>(value);
            }

            @Override
            protected Node<String> createHeaderNode() {
                return new Node<>();
            }
        };
    }

    @Test
    void testGetNode_ValidIndex() {
        assertNotNull(invokeGetNode(0, false));
        assertEquals("A", invokeGetNode(0, false).getValue());
        assertEquals("B", invokeGetNode(1, false).getValue());
        assertEquals("C", invokeGetNode(2, false).getValue());
    }

    @Test
    void testGetNode_IndexLessThanZero() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(-1, false);
        });
        assertEquals("Couldn't get the node: index (-1) less than zero.", exception.getMessage());
    }

    @Test
    void testGetNode_IndexEqualToSizeWithoutEndMarker() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(3, false);
        });
        assertEquals("Couldn't get the node: index (3) is the size of the list.", exception.getMessage());
    }

    @Test
    void testGetNode_IndexGreaterThanSize() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(4, false);
        });
        assertEquals("Couldn't get the node: index (4) greater than the size of the list (3).", exception.getMessage());
    }

    @Test
    void testGetNode_IndexEqualToSizeWithEndMarker() {
        assertNotNull(invokeGetNode(3, true));
    }

    @Test
    void testGetNode_NegativeIndexWithEndMarker() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(-1, true);
        });
        assertEquals("Couldn't get the node: index (-1) less than zero.", exception.getMessage());
    }

    @Test
    void testGetNode_HalfwayTraversal() {
        assertEquals("B", invokeGetNode(1, false).getValue());
    }

    @Test
    void testGetNode_BackwardTraversal() {
        assertEquals("B", invokeGetNode(1, false).getValue());
        assertEquals("C", invokeGetNode(2, false).getValue());
        assertEquals("A", invokeGetNode(0, false).getValue());
    }

    private Node<String> invokeGetNode(int index, boolean endMarkerAllowed) {
        try {
            Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);
            return (Node<String>) method.invoke(linkedList, index, endMarkerAllowed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
