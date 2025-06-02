package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.Collection;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedListJava21_contains_10_1_Test {

    private AbstractLinkedListJava21<String> linkedList;

    // A concrete implementation of AbstractLinkedListJava21 for testing purposes
    private static class TestLinkedList extends AbstractLinkedListJava21<String> {

        public TestLinkedList() {
            super();
        }

        public TestLinkedList(Collection<? extends String> coll) {
            super(coll);
        }

        // Implement required methods for the abstract class
        @Override
        public int size() {
            return super.size;
        }
        // Add other necessary methods if required for the test
    }

    @BeforeEach
    void setUp() {
        linkedList = new TestLinkedList();
    }

    @Test
    void testContains_whenElementIsPresent() {
        linkedList.add("Test");
        assertTrue(linkedList.contains("Test"), "List should contain the added element.");
    }

    @Test
    void testContains_whenElementIsNotPresent() {
        linkedList.add("Test");
        assertFalse(linkedList.contains("NotInList"), "List should not contain an element that was not added.");
    }

    @Test
    void testContains_whenListIsEmpty() {
        assertFalse(linkedList.contains("Test"), "Empty list should not contain any element.");
    }

    @Test
    void testContains_multipleElements() {
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        assertTrue(linkedList.contains("Second"), "List should contain the element 'Second'.");
        assertFalse(linkedList.contains("Fourth"), "List should not contain an element 'Fourth'.");
    }

    @Test
    void testContains_withNullElement() {
        linkedList.add(null);
        assertTrue(linkedList.contains(null), "List should contain null when it is added.");
        assertFalse(linkedList.contains("NotNull"), "List should not contain an element that was not added.");
    }
}
