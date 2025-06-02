package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class TreeList_TreeList_15_0_Test {

    private TreeList<String> treeList;

    @BeforeEach
    void setUp() {
        // Initialize TreeList with an empty collection
        treeList = new TreeList<>(new ArrayList<>());
    }

    @Test
    void testConstructorWithNonEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        treeList = new TreeList<>(collection);
        // Check that the size is correct
        assertEquals(3, treeList.size());
    }

    @Test
    void testConstructorWithEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        treeList = new TreeList<>(collection);
        // Check that the size is 0
        assertEquals(0, treeList.size());
    }

    @Test
    void testConstructorWithNullCollection() {
        assertThrows(NullPointerException.class, () -> {
            new TreeList<>(null);
        });
    }

    @Test
    void testConstructorWithSingleElementCollection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("Single Element");
        treeList = new TreeList<>(collection);
        // Check that the size is 1
        assertEquals(1, treeList.size());
    }

    // Add more tests to ensure full branch and line coverage
    @Test
    void testSetMethod() {
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        treeList = new TreeList<>(collection);
        // Set the value at index 1
        String oldValue = treeList.set(1, "New Value");
        // Verify the old value and new value
        assertEquals("B", oldValue);
        assertEquals("New Value", treeList.get(1));
    }

    @Test
    void testSetMethodWithInvalidIndex() {
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        treeList = new TreeList<>(collection);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            treeList.set(1, "Invalid Index");
        });
    }
}
