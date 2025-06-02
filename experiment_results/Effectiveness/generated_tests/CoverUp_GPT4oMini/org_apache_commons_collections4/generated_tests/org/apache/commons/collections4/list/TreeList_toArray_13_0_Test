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
    void testToArray_EmptyList() {
        Object[] expected = new Object[0];
        Object[] actual = treeList.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testToArray_SingleElement() {
        treeList.set(0, "A");
        Object[] expected = new Object[] { "A" };
        Object[] actual = treeList.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testToArray_MultipleElements() {
        treeList.set(0, "A");
        treeList.set(1, "B");
        treeList.set(2, "C");
        Object[] expected = new Object[] { "A", "B", "C" };
        Object[] actual = treeList.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testToArray_NonEmptyTreeList() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        treeList = new TreeList<>(collection);
        Object[] expected = new Object[] { "A", "B", "C" };
        Object[] actual = treeList.toArray();
        assertArrayEquals(expected, actual);
    }
}
