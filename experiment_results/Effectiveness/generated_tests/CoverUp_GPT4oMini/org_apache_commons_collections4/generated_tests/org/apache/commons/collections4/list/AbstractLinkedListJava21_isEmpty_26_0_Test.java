package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
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

class AbstractLinkedListJava21_isEmpty_26_0_Test {

    private AbstractLinkedListJava21<String> linkedList;

    // A concrete implementation of AbstractLinkedListJava21 for testing purposes
    private class TestLinkedList extends AbstractLinkedListJava21<String> {

        protected TestLinkedList() {
            super();
        }

        protected TestLinkedList(Collection<? extends String> coll) {
            super(coll);
        }

        @Override
        public int size() {
            // Expose size for testing
            return size;
        }
        // Additional methods for testing can be added here
    }

    @BeforeEach
    void setUp() {
        linkedList = new TestLinkedList();
    }

    @Test
    void testIsEmpty_WhenListIsEmpty() {
        assertTrue(linkedList.isEmpty(), "List should be empty");
    }

    @Test
    void testIsEmpty_WhenListIsNotEmpty() {
        linkedList.add("Element 1");
        assertFalse(linkedList.isEmpty(), "List should not be empty");
    }

    @Test
    void testIsEmpty_AfterRemovingElement() {
        linkedList.add("Element 1");
        linkedList.remove("Element 1");
        assertTrue(linkedList.isEmpty(), "List should be empty after removing the only element");
    }
}
