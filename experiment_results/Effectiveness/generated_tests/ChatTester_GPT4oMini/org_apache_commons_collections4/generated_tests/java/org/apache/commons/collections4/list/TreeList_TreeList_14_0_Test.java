package org.apache.commons.collections4.list;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class TreeList_TreeList_14_0_Test {

    private TreeList<Object> treeList;

    @BeforeEach
    public void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    public void testTreeListConstructor() {
        // Verify that the treeList is initialized correctly
        assertNotNull(treeList, "TreeList instance should not be null");
        assertEquals(0, treeList.size(), "Size should be 0 for an empty TreeList");
        assertNull(getRoot(treeList), "Root should be null for an empty TreeList");
    }

    // Reflection method to access the private root field
    private Object getRoot(TreeList<?> treeList) {
        try {
            java.lang.reflect.Field rootField = TreeList.class.getDeclaredField("root");
            rootField.setAccessible(true);
            return rootField.get(treeList);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
            return null;
        }
    }
}
