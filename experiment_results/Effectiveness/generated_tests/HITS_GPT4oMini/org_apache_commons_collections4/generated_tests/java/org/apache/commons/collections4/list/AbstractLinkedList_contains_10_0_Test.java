package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.List;
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
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_contains_10_0_Test {

    private TestLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new TestLinkedList();
    }

    @Test
    void testContains_WhenElementIsPresent() {
        linkedList.add("Element1");
        linkedList.add("Element2");
        linkedList.add("Element3");
        assertTrue(linkedList.contains("Element2"), "List should contain Element2");
    }

    @Test
    void testContains_WhenElementIsNotPresent() {
        linkedList.add("Element1");
        linkedList.add("Element2");
        linkedList.add("Element3");
        assertFalse(linkedList.contains("Element4"), "List should not contain Element4");
    }

    @Test
    void testContains_WhenListIsEmpty() {
        assertFalse(linkedList.contains("Element1"), "List should not contain any elements");
    }

    @Test
    void testContains_WhenNullElementIsPresent() {
        linkedList.add(null);
        assertTrue(linkedList.contains(null), "List should contain null");
    }

    @Test
    void testContains_WhenNullElementIsNotPresent() {
        linkedList.add("Element1");
        linkedList.add("Element2");
        assertFalse(linkedList.contains(null), "List should not contain null");
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        // Implement abstract methods if needed for testing
        @Override
        public boolean add(String value) {
            // Simplified add method for test purposes
            Node<String> newNode = new Node<>(value);
            if (header == null) {
                header = newNode;
                header.next = header;
                header.previous = header;
            } else {
                Node<String> lastNode = header.previous;
                lastNode.next = newNode;
                newNode.previous = lastNode;
                newNode.next = header;
                header.previous = newNode;
            }
            size++;
            modCount++;
            return true;
        }
        // Additional methods can be implemented as needed
    }
}
