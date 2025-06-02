package org.apache.commons.collections4.list;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class AbstractLinkedList_doWriteObject_17_0_Test extends AbstractLinkedList<Object> {

    private AbstractLinkedList<Object> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new AbstractLinkedList<Object>() {

            // Implementing necessary methods for the test
            @Override
            public boolean add(Object e) {
                // Custom add logic for testing
                Node<Object> newNode = new Node<>(e);
                if (size == 0) {
                    header.next = newNode;
                    header.previous = newNode;
                    newNode.next = header;
                    newNode.previous = header;
                } else {
                    Node<Object> lastNode = header.previous;
                    lastNode.next = newNode;
                    newNode.previous = lastNode;
                    newNode.next = header;
                    header.previous = newNode;
                }
                size++;
                modCount++;
                return true;
            }

            @Override
            public Iterator<Object> iterator() {
                return new Iterator<Object>() {

                    Node<Object> current = header.next;

                    @Override
                    public boolean hasNext() {
                        return current != header;
                    }

                    @Override
                    public Object next() {
                        if (!hasNext())
                            throw new NoSuchElementException();
                        Object value = current.getValue();
                        current = current.next;
                        return value;
                    }
                };
            }
        };
    }

    @Test
    void testDoWriteObject_EmptyList() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        linkedList.doWriteObject(objectOutputStream);
        objectOutputStream.flush();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
            int size = objectInputStream.readInt();
            assertEquals(0, size);
        }
    }

    @Test
    void testDoWriteObject_NonEmptyList() throws IOException {
        linkedList.add("Element 1");
        linkedList.add("Element 2");
        linkedList.add("Element 3");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        linkedList.doWriteObject(objectOutputStream);
        objectOutputStream.flush();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
            int size = objectInputStream.readInt();
            assertEquals(3, size);
            // Read elements back
            assertEquals("Element 1", objectInputStream.readObject());
            assertEquals("Element 2", objectInputStream.readObject());
            assertEquals("Element 3", objectInputStream.readObject());
        } catch (ClassNotFoundException e) {
            fail("Class not found during deserialization", e);
        }
    }

    // Node class for testing purposes
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
}
