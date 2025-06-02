package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_doWriteObject_17_1_Test {

    private AbstractLinkedList<String> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new AbstractLinkedList<String>() {

            {
                header = new Node<>();
                header.next = header;
                header.previous = header;
                size = 0;
                modCount = 0;
            }

            @Override
            public boolean add(String value) {
                Node<String> newNode = new Node<>(value);
                newNode.next = header;
                newNode.previous = header.previous;
                header.previous.next = newNode;
                header.previous = newNode;
                size++;
                modCount++;
                return true;
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public String get(int index) {
                return getNode(index).getValue();
            }

            private Node<String> getNode(int index) {
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException();
                }
                Node<String> current = header.next;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current;
            }
        };
    }

    @Test
    void testDoWriteObjectWithNoElements() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        invokeDoWriteObject(linkedList, outputStream);
        assertEquals(4, byteArrayOutputStream.size());
    }

    @Test
    void testDoWriteObjectWithMultipleElements() throws Exception {
        linkedList.add("element1");
        linkedList.add("element2");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        invokeDoWriteObject(linkedList, outputStream);
        // 4 bytes for size + 6 bytes for each string
        assertEquals(4 + 6 + 6, byteArrayOutputStream.size());
    }

    private void invokeDoWriteObject(AbstractLinkedList<?> list, ObjectOutputStream outputStream) throws Exception {
        Method method = AbstractLinkedList.class.getDeclaredMethod("doWriteObject", ObjectOutputStream.class);
        method.setAccessible(true);
        method.invoke(list, outputStream);
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
