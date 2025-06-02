package org.apache.commons.collections4.list;

import java.util.Arrays;
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
import java.util.Collection;

public class NodeCachingLinkedList_removeAllNodes_6_0_Test {

    private NodeCachingLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        // Set maximum cache size to 5 for testing
        list = new NodeCachingLinkedList<>(5);
    }

    @Test
    public void testRemoveAllNodesWhenListIsEmpty() {
        list.removeAllNodes();
        assertEquals(0, list.size);
        // Check if the cache is empty
        assertTrue(list.getNodeFromCache() == null);
    }

    @Test
    public void testRemoveAllNodesWhenListHasLessNodesThanCache() {
        // List size is 3
        list.addAll(Arrays.asList(1, 2, 3));
        list.removeAllNodes();
        assertEquals(0, list.size);
        // All nodes should be cached
        assertEquals(3, getCacheSize());
    }

    @Test
    public void testRemoveAllNodesWhenListHasMoreNodesThanCache() {
        // List size is 6
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        list.removeAllNodes();
        assertEquals(0, list.size);
        // Only 5 nodes should be cached
        assertEquals(5, getCacheSize());
    }

    @Test
    public void testRemoveAllNodesWhenCacheIsFull() {
        // List size is 5
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Cache should store all 5 nodes
        list.removeAllNodes();
        assertEquals(0, list.size);
        assertEquals(5, getCacheSize());
        // Remove again, cache should still be 5
        list.removeAllNodes();
        assertEquals(0, list.size);
        assertEquals(5, getCacheSize());
    }

    @Test
    public void testRemoveAllNodesWithDifferentCacheSizes() {
        NodeCachingLinkedList<Integer> smallCacheList = new NodeCachingLinkedList<>(2);
        // List size is 4
        smallCacheList.addAll(Arrays.asList(1, 2, 3, 4));
        smallCacheList.removeAllNodes();
        assertEquals(0, smallCacheList.size);
        // Only 2 nodes should be cached
        assertEquals(2, getCacheSize(smallCacheList));
        NodeCachingLinkedList<Integer> largeCacheList = new NodeCachingLinkedList<>(10);
        // List size is 3
        largeCacheList.addAll(Arrays.asList(1, 2, 3));
        largeCacheList.removeAllNodes();
        assertEquals(0, largeCacheList.size);
        // All nodes should be cached
        assertEquals(3, getCacheSize(largeCacheList));
    }

    private int getCacheSize() {
        // Use the method that indirectly checks the cache size
        int size = 0;
        while (list.getNodeFromCache() != null) {
            size++;
        }
        return size;
    }

    private int getCacheSize(NodeCachingLinkedList<?> list) {
        int size = 0;
        while (list.getNodeFromCache() != null) {
            size++;
        }
        return size;
    }
}
