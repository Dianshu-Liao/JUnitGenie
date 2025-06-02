package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.util.Collection;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class AbstractLinkedListJava21_getNode_22_1_Test {

    private AbstractLinkedListJava21<String> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new AbstractLinkedListJava21<String>() {

            {
                header = new Node<>();
                size = 0;
            }

            @Override
            public boolean add(String e) {
                Node<String> newNode = new Node<>(e);
                if (size == 0) {
                    header.next = newNode;
                    newNode.previous = header;
                } else {
                    Node<String> lastNode = getNode(size - 1, false);
                    lastNode.next = newNode;
                    newNode.previous = lastNode;
                }
                // Circular reference for header
                newNode.next = header;
                // Circular reference for header
                header.previous = newNode;
                size++;
                return true;
            }
        };
    }

    @Test
    public void testGetNode_ValidIndex() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Node<String> node = invokeGetNode(1, false);
        assertEquals("B", node.value);
    }

    @Test
    public void testGetNode_IndexAtSize() {
        linkedList.add("A");
        linkedList.add("B");
        assertThrows(IndexOutOfBoundsException.class, () -> invokeGetNode(2, false));
    }

    @Test
    public void testGetNode_NegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> invokeGetNode(-1, false));
    }

    @Test
    public void testGetNode_IndexGreaterThanSize() {
        linkedList.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> invokeGetNode(2, false));
    }

    @Test
    public void testGetNode_EndMarkerAllowed() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        Node<String> node = invokeGetNode(2, true);
        // Assuming endMarkerAllowed returns null for index equal to size
        assertNull(node);
    }

    private Node<String> invokeGetNode(int index, boolean endMarkerAllowed) throws Exception {
        Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
        method.setAccessible(true);
        return (Node<String>) method.invoke(linkedList, index, endMarkerAllowed);
    }

    // Node class for testing purposes
    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> previous;

        Node() {
        }

        Node(E value) {
            this.value = value;
        }
    }
}
