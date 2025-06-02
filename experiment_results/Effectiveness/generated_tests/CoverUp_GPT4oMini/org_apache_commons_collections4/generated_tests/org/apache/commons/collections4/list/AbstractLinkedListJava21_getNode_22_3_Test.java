package org.apache.commons.collections4.list;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.NoSuchElementException;
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
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_getNode_22_3_Test {

    private AbstractLinkedListJava21<Integer> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedListJava21<Integer>() {

            @Override
            protected Node<Integer> createNode(Integer value) {
                return new Node<>(value);
            }

            @Override
            protected Node<Integer> createHeaderNode() {
                return new Node<>();
            }
        };
        list.add(1);
        list.add(2);
        list.add(3);
        // Initialize header and size for the test
        try {
            Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
            headerField.setAccessible(true);
            headerField.set(list, list.createHeaderNode());
            Field sizeField = AbstractLinkedListJava21.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(list, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetNode_ValidIndex() {
        assertEquals(1, invokeGetNode(0, false).getValue());
        assertEquals(2, invokeGetNode(1, false).getValue());
        assertEquals(3, invokeGetNode(2, false).getValue());
    }

    @Test
    void testGetNode_IndexOutOfBounds_Negative() {
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(-1, false);
        });
        assertEquals("Couldn't get the node: index (-1) less than zero.", thrown.getMessage());
    }

    @Test
    void testGetNode_IndexOutOfBounds_EqualToSize() {
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(3, false);
        });
        assertEquals("Couldn't get the node: index (3) is the size of the list.", thrown.getMessage());
    }

    @Test
    void testGetNode_IndexOutOfBounds_GreaterThanSize() {
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(4, false);
        });
        assertEquals("Couldn't get the node: index (4) greater than the size of the list (3).", thrown.getMessage());
    }

    @Test
    void testGetNode_ValidIndex_EndMarkerAllowed() {
        // Should allow getting the end marker
        assertEquals(3, invokeGetNode(3, true).getValue());
    }

    @Test
    void testGetNode_EndMarkerAllowed_IndexOutOfBounds() {
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeGetNode(4, true);
        });
        assertEquals("Couldn't get the node: index (4) greater than the size of the list (3).", thrown.getMessage());
    }

    private Node<Integer> invokeGetNode(int index, boolean endMarkerAllowed) {
        try {
            Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);
            return (Node<Integer>) method.invoke(list, index, endMarkerAllowed);
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
