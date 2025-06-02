package org.apache.commons.collections4.list;

import java.util.Collection;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TreeList_indexOf_6_0_Test {

    private TreeList<String> treeList;

    // Adjusted to reference the inner class
    private TreeList.AVLNode<String> mockRoot;

    @BeforeEach
    void setUp() {
        treeList = new TreeList<>();
        // Adjusted to reference the inner class
        mockRoot = Mockito.mock(TreeList.AVLNode.class);
        try {
            java.lang.reflect.Field relativePositionField = TreeList.AVLNode.class.getDeclaredField("relativePosition");
            relativePositionField.setAccessible(true);
            relativePositionField.set(mockRoot, 0);
        } catch (Exception e) {
            fail("Failed to set the relativePosition field: " + e.getMessage());
        }
        // Use reflection to set the private root field
        try {
            java.lang.reflect.Field rootField = TreeList.class.getDeclaredField("root");
            rootField.setAccessible(true);
            rootField.set(treeList, mockRoot);
        } catch (Exception e) {
            fail("Failed to set the root field: " + e.getMessage());
        }
    }

    @Test
    void testIndexOfWhenRootIsNull() {
        // Set root to null to test empty tree
        try {
            java.lang.reflect.Field rootField = TreeList.class.getDeclaredField("root");
            rootField.setAccessible(true);
            rootField.set(treeList, null);
        } catch (Exception e) {
            fail("Failed to set the root field to null: " + e.getMessage());
        }
        assertEquals(-1, treeList.indexOf("test"));
    }

    @Test
    void testIndexOfWhenObjectIsFound() {
        String objectToFind = "test";
        Mockito.when(mockRoot.indexOf(objectToFind, 0)).thenReturn(2);
        assertEquals(2, treeList.indexOf(objectToFind));
    }

    @Test
    void testIndexOfWhenObjectIsNotFound() {
        String objectToFind = "test";
        Mockito.when(mockRoot.indexOf(objectToFind, 0)).thenReturn(-1);
        assertEquals(-1, treeList.indexOf(objectToFind));
    }

    @Test
    void testIndexOfWithDifferentObject() {
        String objectToFind = "anotherTest";
        Mockito.when(mockRoot.indexOf(objectToFind, 0)).thenReturn(3);
        assertEquals(3, treeList.indexOf(objectToFind));
    }

    @Test
    void testIndexOfWithMultipleCalls() {
        String objectToFind1 = "firstTest";
        String objectToFind2 = "secondTest";
        Mockito.when(mockRoot.indexOf(objectToFind1, 0)).thenReturn(1);
        Mockito.when(mockRoot.indexOf(objectToFind2, 0)).thenReturn(4);
        assertEquals(1, treeList.indexOf(objectToFind1));
        assertEquals(4, treeList.indexOf(objectToFind2));
    }
}
