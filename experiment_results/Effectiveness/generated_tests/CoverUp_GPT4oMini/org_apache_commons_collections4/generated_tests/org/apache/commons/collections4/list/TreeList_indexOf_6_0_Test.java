package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
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
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class // Additional tests can be added here to cover more edge cases
TreeList_indexOf_6_0_Test {

    private TreeList<String> treeList;

    @BeforeEach
    public void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    public void testIndexOfEmptyTree() {
        // Test when the tree is empty
        assertEquals(-1, treeList.indexOf("test"));
    }

    @Test
    public void testIndexOfElementNotPresent() {
        // Add elements to the tree
        treeList.add("A");
        treeList.add("B");
        treeList.add("C");
        // Test when the element is not present
        assertEquals(-1, treeList.indexOf("D"));
    }

    @Test
    public void testIndexOfElementPresent() {
        // Add elements to the tree
        treeList.add("A");
        treeList.add("B");
        treeList.add("C");
        // Test when the element is present
        assertEquals(1, treeList.indexOf("B"));
    }

    @Test
    public void testIndexOfNullElement() {
        // Add elements to the tree including null
        treeList.add("A");
        treeList.add(null);
        treeList.add("C");
        // Test when searching for null
        assertEquals(1, treeList.indexOf(null));
    }

    @Test
    public void testIndexOfWithConcurrentModification() {
        // Add elements to the tree
        treeList.add("A");
        treeList.add("B");
        // Simulate concurrent modification
        treeList.add("C");
        // Test indexOf after modification
        assertEquals(0, treeList.indexOf("A"));
        assertEquals(1, treeList.indexOf("B"));
        assertEquals(2, treeList.indexOf("C"));
    }
}
