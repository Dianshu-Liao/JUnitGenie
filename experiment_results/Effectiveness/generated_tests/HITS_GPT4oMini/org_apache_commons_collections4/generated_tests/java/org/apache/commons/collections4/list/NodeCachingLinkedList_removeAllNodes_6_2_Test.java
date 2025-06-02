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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NodeCachingLinkedList_removeAllNodes_6_2_Test {

    private NodeCachingLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new NodeCachingLinkedList<>();
    }

    @Test
    void testRemoveAllNodes_EmptyList() {
        list.removeAllNodes();
        assertEquals(0, list.size);
    }

    @Test
    void testRemoveAllNodes_SingleElement() {
        list.add("Node1");
        list.removeAllNodes();
        assertEquals(0, list.size);
    }

    @Test
    void testRemoveAllNodes_MultipleElements() {
        list.add("Node1");
        list.add("Node2");
        list.add("Node3");
        list.removeAllNodes();
        assertEquals(0, list.size);
    }

    @Test
    void testRemoveAllNodes_RespectsCacheSize() {
        list.setMaximumCacheSize(2);
        list.add("Node1");
        list.add("Node2");
        list.add("Node3");
        list.removeAllNodes();
        assertEquals(0, list.size);
        assertEquals(2, list.getMaximumCacheSize());
    }

    @Test
    void testRemoveAllNodes_NodesAddedToCache() {
        list.setMaximumCacheSize(3);
        list.add("Node1");
        list.add("Node2");
        list.add("Node3");
        list.removeAllNodes();
        assertEquals(0, list.size);
        assertEquals(3, list.getMaximumCacheSize());
    }

    @Test
    void testRemoveAllNodes_ThrowsExceptionWhenAccessingFirst() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
    }

    @Test
    void testRemoveAllNodes_ThrowsExceptionWhenAccessingLast() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getLast();
        });
    }
}
