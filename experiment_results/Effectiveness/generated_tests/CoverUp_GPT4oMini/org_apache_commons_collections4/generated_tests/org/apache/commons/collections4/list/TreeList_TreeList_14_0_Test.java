package org.apache.commons.collections4.list;

import java.util.Arrays;
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

class TreeList_TreeList_14_0_Test {

    private TreeList<String> treeList;

    @BeforeEach
    void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    void testTreeListDefaultConstructor() {
        assertNotNull(treeList);
        assertEquals(0, treeList.size());
    }

    @Test
    void testTreeListWithCollectionConstructor() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        TreeList<String> treeListWithCollection = new TreeList<>(collection);
        assertEquals(3, treeListWithCollection.size());
        assertTrue(treeListWithCollection.contains("A"));
        assertTrue(treeListWithCollection.contains("B"));
        assertTrue(treeListWithCollection.contains("C"));
    }

    @Test
    void testAddElement() {
        treeList.add(0, "A");
        assertEquals(1, treeList.size());
        assertTrue(treeList.contains("A"));
    }

    @Test
    void testAddAllElements() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        treeList.addAll(collection);
        assertEquals(3, treeList.size());
        assertTrue(treeList.contains("A"));
        assertTrue(treeList.contains("B"));
        assertTrue(treeList.contains("C"));
    }

    @Test
    void testClear() {
        treeList.add(0, "A");
        treeList.clear();
        assertEquals(0, treeList.size());
        assertFalse(treeList.contains("A"));
    }

    @Test
    void testGetElement() {
        treeList.add(0, "A");
        assertEquals("A", treeList.get(0));
    }

    @Test
    void testRemoveElement() {
        treeList.add(0, "A");
        treeList.add(1, "B");
        assertEquals("A", treeList.remove(0));
        assertEquals(1, treeList.size());
        assertFalse(treeList.contains("A"));
    }

    @Test
    void testSetElement() {
        treeList.add(0, "A");
        assertEquals("A", treeList.set(0, "B"));
        assertEquals("B", treeList.get(0));
    }

    @Test
    void testIndexOfElement() {
        treeList.add(0, "A");
        assertEquals(0, treeList.indexOf("A"));
        assertEquals(-1, treeList.indexOf("B"));
    }

    @Test
    void testSize() {
        assertEquals(0, treeList.size());
        treeList.add(0, "A");
        assertEquals(1, treeList.size());
    }

    @Test
    void testToArray() {
        treeList.add(0, "A");
        Object[] array = treeList.toArray();
        assertEquals(1, array.length);
        assertEquals("A", array[0]);
    }
}
