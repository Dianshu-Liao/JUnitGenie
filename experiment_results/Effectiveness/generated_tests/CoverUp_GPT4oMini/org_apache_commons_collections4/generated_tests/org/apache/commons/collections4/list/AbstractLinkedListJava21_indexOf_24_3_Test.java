package org.apache.commons.collections4.list;

import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.NoSuchElementException;
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

class AbstractLinkedListJava21_indexOf_24_3_Test {

    private AbstractLinkedListJava21<String> list;

    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        public TestLinkedList() {
            super();
            header = new Node<>();
            header.next = header;
            header.previous = header;
            size = 0;
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

        private class Node<E> extends AbstractLinkedListJava21.Node<E> {

            Node() {
                super();
            }

            Node(E value) {
                super(value);
            }

            @Override
            protected E getValue() {
                return value;
            }
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testIndexOfEmptyList() {
        assertEquals(-1, list.indexOf("test"));
    }

    @Test
    void testIndexOfElementNotInList() {
        list.add("first");
        list.add("second");
        assertEquals(-1, list.indexOf("third"));
    }

    @Test
    void testIndexOfFirstElement() {
        list.add("first");
        list.add("second");
        assertEquals(0, list.indexOf("first"));
    }

    @Test
    void testIndexOfSecondElement() {
        list.add("first");
        list.add("second");
        assertEquals(1, list.indexOf("second"));
    }

    @Test
    void testIndexOfDuplicateElement() {
        list.add("duplicate");
        list.add("duplicate");
        list.add("third");
        assertEquals(0, list.indexOf("duplicate"));
    }

    @Test
    void testIndexOfNullElement() {
        list.add(null);
        list.add("second");
        assertEquals(0, list.indexOf(null));
    }

    @Test
    void testIndexOfElementWithDifferentType() {
        list.add("first");
        assertEquals(-1, list.indexOf(1));
    }

    private void invokePrivateMethod(String methodName, Object... params) throws Exception {
        Method method = AbstractLinkedListJava21.class.getDeclaredMethod(methodName, Object.class);
        method.setAccessible(true);
        method.invoke(list, params);
    }
}
