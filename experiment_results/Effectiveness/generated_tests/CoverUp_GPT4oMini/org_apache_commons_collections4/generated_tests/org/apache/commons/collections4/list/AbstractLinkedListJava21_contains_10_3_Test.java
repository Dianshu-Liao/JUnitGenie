package org.apache.commons.collections4.list;

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

class AbstractLinkedListJava21_contains_10_3_Test {

    private AbstractLinkedListJava21<String> list;

    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        private class Node extends AbstractLinkedListJava21.Node<String> {

            Node(String value) {
                super(value);
            }
        }

        public TestLinkedList() {
            super();
        }

        public TestLinkedList(Collection<? extends String> coll) {
            super(coll);
        }

        @Override
        public int indexOf(final Object value) {
            int i = 0;
            for (Node node = (Node) header.next; node != header; node = (Node) node.next) {
                if (Objects.equals(node.getValue(), value)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        @Override
        public boolean add(String value) {
            Node newNode = new Node(value);
            if (header == null) {
                header = newNode;
                header.next = header;
                header.previous = header;
            } else {
                Node lastNode = (Node) header.previous;
                lastNode.next = newNode;
                newNode.previous = lastNode;
                newNode.next = header;
                header.previous = newNode;
            }
            size++;
            return true;
        }
    }

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testContainsWhenListIsEmpty() {
        assertFalse(list.contains("test"));
    }

    @Test
    void testContainsWhenElementIsPresent() {
        list.add("test");
        assertTrue(list.contains("test"));
    }

    @Test
    void testContainsWhenElementIsNotPresent() {
        list.add("test");
        assertFalse(list.contains("notPresent"));
    }

    @Test
    void testContainsWithMultipleElements() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertTrue(list.contains("two"));
        assertFalse(list.contains("four"));
    }

    @Test
    void testContainsWithNullElement() {
        list.add(null);
        assertTrue(list.contains(null));
        assertFalse(list.contains("nonNull"));
    }
}
