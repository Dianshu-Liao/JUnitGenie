package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;
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
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_remove_33_1_Test {

    private TestLinkedList list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList();
    }

    @Test
    void testRemoveExistingElement() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertTrue(list.remove("Element2"));
        assertEquals(2, list.size());
        assertThrows(NoSuchElementException.class, list::getFirst);
    }

    @Test
    void testRemoveNonExistingElement() {
        list.add("Element1");
        list.add("Element2");
        assertFalse(list.remove("Element3"));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFromEmptyList() {
        assertFalse(list.remove("Element1"));
    }

    @Test
    void testRemoveFirstElement() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertTrue(list.remove("Element1"));
        assertEquals(2, list.size());
        assertEquals("Element2", list.getFirst());
    }

    @Test
    void testRemoveLastElement() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertTrue(list.remove("Element3"));
        assertEquals(2, list.size());
        assertEquals("Element1", list.getFirst());
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        private final List<String> elements = new ArrayList<>();

        @Override
        public boolean add(String value) {
            elements.add(value);
            return true;
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        protected void removeNode(Node<String> node) {
            elements.remove(node.getValue());
        }

        @Override
        protected Node<String> getNode(int index, boolean create) {
            // Assuming Node has a constructor that takes a value
            return new Node<>(elements.get(index));
        }

        @Override
        protected void updateNode(Node<String> node, String value) {
            int index = elements.indexOf(node.getValue());
            elements.set(index, value);
        }
    }
}
