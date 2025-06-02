package org.apache.commons.collections4.list;

import org.apache.commons.collections4.list.NodeCachingLinkedList;
import java.lang.reflect.Method;
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
import java.io.Serializable;

class NodeCachingLinkedList_removeAllNodes_6_2_Test {

    private NodeCachingLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        // Set a maximum cache size of 5
        list = new NodeCachingLinkedList<>(5);
    }

    @Test
    void testRemoveAllNodesWithLessThanMaximumCacheSize() throws Exception {
        // Add some nodes to the list
        list.add(1);
        list.add(2);
        list.add(3);
        // Invoke the removeAllNodes method using reflection
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
        // Verify that the list is empty
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAllNodesWithExactlyMaximumCacheSize() throws Exception {
        // Fill the list to its maximum cache size
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        // Invoke the removeAllNodes method using reflection
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
        // Verify that the list is empty
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAllNodesWithMoreThanMaximumCacheSize() throws Exception {
        // Fill the list to exceed the maximum cache size
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        // Invoke the removeAllNodes method using reflection
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
        // Verify that the list is empty
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAllNodesWithEmptyList() throws Exception {
        // Invoke the removeAllNodes method using reflection
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
        // Verify that the list is still empty
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAllNodesWithPartialCache() throws Exception {
        // Fill the list to have some nodes
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // Adding more than cache size
        list.add(6);
        // Invoke the removeAllNodes method using reflection
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
        // Verify that the list is empty
        assertEquals(0, list.size());
    }
}
