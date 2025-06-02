// Test method
package org.apache.commons.collections4.list;

import java.util.Arrays;
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

public class TreeList_toArray_13_0_Test {

    private TreeList<String> treeList;

    @BeforeEach
    public void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    public void testToArray_EmptyTree() {
        // Test when the tree is empty
        Object[] result = treeList.toArray();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testToArray_NonEmptyTree() throws Exception {
        // Assuming we have a method to add elements to the TreeList
        addElementsToTreeList(treeList, Arrays.asList("A", "B", "C"));
        Object[] result = treeList.toArray();
        assertNotNull(result);
        assertEquals(3, result.length);
        assertArrayEquals(new Object[] { "A", "B", "C" }, result);
    }

    @Test
    public void testToArray_SingleElement() throws Exception {
        // Assuming we have a method to add a single element to the TreeList
        addElementToTreeList(treeList, "A");
        Object[] result = treeList.toArray();
        assertNotNull(result);
        assertEquals(1, result.length);
        assertArrayEquals(new Object[] { "A" }, result);
    }

    // Helper methods to add elements for testing
    private void addElementsToTreeList(TreeList<String> treeList, Collection<String> elements) throws Exception {
        for (String element : elements) {
            addElementToTreeList(treeList, element);
        }
    }

    private void addElementToTreeList(TreeList<String> treeList, String element) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'Method'
        java.lang.reflect.Method method = TreeList.class.getDeclaredMethod("add", Object.class);
        method.setAccessible(true);
        method.invoke(treeList, element);
    }
}
