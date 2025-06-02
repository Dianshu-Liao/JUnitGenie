package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

@ExtendWith(MockitoExtension.class)
public class AbstractLinkedListJava21_removeLast_37_1_Test {

    private AbstractLinkedListJava21<String> list;

    @BeforeEach
    public void setUp() {
        list = mock(AbstractLinkedListJava21.class, withSettings().useConstructor().defaultAnswer(CALLS_REAL_METHODS));
        // Initialize the linked list with some values
        try {
            Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
            headerField.setAccessible(true);
            Node<String> headerNode = new Node<>();
            headerField.set(list, headerNode);
            headerNode.next = headerNode;
            headerNode.previous = headerNode;
            Field sizeField = AbstractLinkedListJava21.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(list, 0);
            Field modCountField = AbstractLinkedListJava21.class.getDeclaredField("modCount");
            modCountField.setAccessible(true);
            modCountField.setInt(list, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Setup failed due to reflection issue: " + e.getMessage());
        }
    }

    @Test
    public void removeLast_ShouldThrowNoSuchElementException_WhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    public void removeLast_ShouldReturnLastElement_WhenListHasElements() {
        Node<String> node = new Node<>("Last Element");
        try {
            Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
            headerField.setAccessible(true);
            Node<String> headerNode = (Node<String>) headerField.get(list);
            headerNode.previous = node;
            node.next = headerNode;
            node.previous = headerNode;
            Field sizeField = AbstractLinkedListJava21.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(list, 1);
            String removedElement = list.removeLast();
            assertEquals("Last Element", removedElement);
            assertEquals(headerNode, node.previous);
            assertEquals(headerNode, node.next);
            assertEquals(0, sizeField.getInt(list));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Test failed due to reflection issue: " + e.getMessage());
        }
    }

    @Test
    public void removeLast_ShouldUpdateModCount_WhenElementIsRemoved() {
        Node<String> node = new Node<>("Last Element");
        try {
            Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
            headerField.setAccessible(true);
            Node<String> headerNode = (Node<String>) headerField.get(list);
            headerNode.previous = node;
            node.next = headerNode;
            node.previous = headerNode;
            Field sizeField = AbstractLinkedListJava21.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setInt(list, 1);
            Field modCountField = AbstractLinkedListJava21.class.getDeclaredField("modCount");
            modCountField.setAccessible(true);
            modCountField.setInt(list, 0);
            int initialModCount = modCountField.getInt(list);
            list.removeLast();
            assertEquals(initialModCount + 1, modCountField.getInt(list));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Test failed due to reflection issue: " + e.getMessage());
        }
    }

    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> previous;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
    }
}
