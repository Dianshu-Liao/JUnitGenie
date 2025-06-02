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

class TreeList_toArray_13_0_Test {

    private TreeList<String> treeList;

    @BeforeEach
    void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    void testToArrayEmptyList() {
        Object[] result = treeList.toArray();
        assertArrayEquals(new Object[0], result, "The array should be empty for an empty TreeList.");
    }

    @Test
    void testToArraySingleElement() {
        treeList = new TreeList<>(Arrays.asList("Element1"));
        Object[] result = treeList.toArray();
        assertArrayEquals(new Object[] { "Element1" }, result, "The array should contain the single element.");
    }

    @Test
    void testToArrayMultipleElements() {
        treeList = new TreeList<>(Arrays.asList("Element1", "Element2", "Element3"));
        Object[] result = treeList.toArray();
        assertArrayEquals(new Object[] { "Element1", "Element2", "Element3" }, result, "The array should contain all elements in order.");
    }

    @Test
    void testToArrayWithNullElements() {
        treeList = new TreeList<>(Arrays.asList("Element1", null, "Element3"));
        Object[] result = treeList.toArray();
        assertArrayEquals(new Object[] { "Element1", null, "Element3" }, result, "The array should correctly handle null elements.");
    }

    @Test
    void testToArrayAfterModification() {
        treeList = new TreeList<>(Arrays.asList("Element1", "Element2"));
        treeList.set(1, "ModifiedElement");
        Object[] result = treeList.toArray();
        assertArrayEquals(new Object[] { "Element1", "ModifiedElement" }, result, "The array should reflect changes after modification.");
    }
}
