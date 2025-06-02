package org.apache.commons.collections4.list;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.NoSuchElementException;
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

class AbstractLinkedListJava21_isEmpty_26_2_Test {

    private AbstractLinkedListJava21<Integer> list;

    @BeforeEach
    void setUp() {
        list = new AbstractLinkedListJava21<Integer>() {

            {
                init();
            }

            @Override
            protected void init() {
                try {
                    Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
                    headerField.setAccessible(true);
                    headerField.set(this, new Node<>());
                    ((Node<Integer>) headerField.get(this)).next = (Node<Integer>) headerField.get(this);
                    ((Node<Integer>) headerField.get(this)).previous = (Node<Integer>) headerField.get(this);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                size = 0;
            }

            @Override
            public boolean add(Integer value) {
                Node<Integer> newNode = new Node<>(value);
                try {
                    Field headerField = AbstractLinkedListJava21.class.getDeclaredField("header");
                    headerField.setAccessible(true);
                    Node<Integer> header = (Node<Integer>) headerField.get(this);
                    newNode.next = header;
                    newNode.previous = header.previous;
                    header.previous.next = newNode;
                    header.previous = newNode;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                size++;
                return true;
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    @Test
    void testIsEmpty_WhenListIsEmpty() {
        assertTrue(list.isEmpty(), "The list should be empty.");
    }

    @Test
    void testIsEmpty_WhenListIsNotEmpty() {
        list.add(1);
        assertFalse(list.isEmpty(), "The list should not be empty.");
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
    }
}
