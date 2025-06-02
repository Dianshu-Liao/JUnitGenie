package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.LinkedList;
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
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_contains_10_1_Test {

    private TestLinkedList list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testContains_EmptyList() {
        assertFalse(list.contains("element"), "List should be empty, contains should return false.");
    }

    @Test
    void testContains_SingleElementPresent() {
        list.add("element");
        assertTrue(list.contains("element"), "List contains the element that was added.");
    }

    @Test
    void testContains_SingleElementAbsent() {
        list.add("element");
        assertFalse(list.contains("nonexistent"), "List does not contain the element that was not added.");
    }

    @Test
    void testContains_MultipleElements_Present() {
        list.addAll(Arrays.asList("first", "second", "third"));
        assertTrue(list.contains("second"), "List should contain the second element.");
    }

    @Test
    void testContains_MultipleElements_Absent() {
        list.addAll(Arrays.asList("first", "second", "third"));
        assertFalse(list.contains("fourth"), "List does not contain an element that was not added.");
    }

    @Test
    void testContains_NullElement() {
        list.add("element");
        assertFalse(list.contains(null), "List does not contain null if it was not added.");
        list.add(null);
        assertTrue(list.contains(null), "List should contain null after adding it.");
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        // Simple implementation of the abstract class for testing purposes
        private LinkedList<String> internalList = new LinkedList<>();

        public boolean add(String value) {
            internalList.add(value);
            return true;
        }

        public boolean addAll(java.util.Collection<? extends String> collection) {
            return internalList.addAll(collection);
        }

        public int indexOf(Object value) {
            return internalList.indexOf(value);
        }

        // Required method from AbstractLinkedList
        protected void init() {
            // Initialization logic if needed
        }
    }
}
