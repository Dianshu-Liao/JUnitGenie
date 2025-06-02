package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.ArrayList;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLinkedList_contains_10_1_Test {

    private AbstractLinkedList list;

    // A concrete implementation of AbstractLinkedList for testing purposes
    private class TestLinkedList extends AbstractLinkedList {

        private final ArrayList<Object> elements = new ArrayList<>();

        public TestLinkedList() {
            super();
        }

        public TestLinkedList(Collection<? extends Object> coll) {
            super(coll);
            elements.addAll(coll);
            size = elements.size();
        }

        @Override
        public int indexOf(Object value) {
            return elements.indexOf(value);
        }

        @Override
        public boolean add(Object value) {
            // Fixed the return type to boolean
            elements.add(value);
            size++;
            // Added return statement
            return true;
        }

        public int size() {
            return size;
        }
    }

    @BeforeEach
    public void setUp() {
        list = new TestLinkedList();
    }

    @Test
    public void testContains_ExistingElement() {
        list.add("test");
        assertTrue(list.contains("test"), "The list should contain the element 'test'.");
    }

    @Test
    public void testContains_NonExistingElement() {
        list.add("test");
        assertFalse(list.contains("other"), "The list should not contain the element 'other'.");
    }

    @Test
    public void testContains_EmptyList() {
        assertFalse(list.contains("test"), "The list should not contain any elements.");
    }

    @Test
    public void testContains_NullElement() {
        list.add(null);
        assertTrue(list.contains(null), "The list should contain a null element.");
    }

    @Test
    public void testContains_MultipleElements() {
        list.add("first");
        list.add("second");
        list.add("third");
        assertTrue(list.contains("second"), "The list should contain the element 'second'.");
        assertFalse(list.contains("fourth"), "The list should not contain the element 'fourth'.");
    }
}
