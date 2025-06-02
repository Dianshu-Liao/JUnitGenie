package org.apache.commons.collections4.list;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

class NodeCachingLinkedList_removeAllNodes_6_0_Test {

    private NodeCachingLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        // Set maximum cache size to 5
        list = new NodeCachingLinkedList<>(5);
    }

    @Test
    void testRemoveAllNodesWithNoNodes() throws Exception {
        invokeRemoveAllNodes();
        assertEquals(0, getCacheSize());
        assertEquals(0, getListSize());
    }

    @Test
    void testRemoveAllNodesWithLessThanMaximumCacheSize() throws Exception {
        list.addAll(Arrays.asList(1, 2, 3));
        invokeRemoveAllNodes();
        assertEquals(3, getCacheSize());
        assertEquals(0, getListSize());
    }

    @Test
    void testRemoveAllNodesWithMoreThanMaximumCacheSize() throws Exception {
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        invokeRemoveAllNodes();
        assertEquals(5, getCacheSize());
        assertEquals(0, getListSize());
    }

    @Test
    void testRemoveAllNodesWithExactMaximumCacheSize() throws Exception {
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        invokeRemoveAllNodes();
        assertEquals(5, getCacheSize());
        assertEquals(0, getListSize());
    }

    private void invokeRemoveAllNodes() throws Exception {
        Method method = NodeCachingLinkedList.class.getDeclaredMethod("removeAllNodes");
        method.setAccessible(true);
        method.invoke(list);
    }

    private int getCacheSize() throws Exception {
        return (int) getFieldValue("cacheSize");
    }

    private int getListSize() throws Exception {
        return (int) getFieldValue("size");
    }

    private Object getFieldValue(String fieldName) throws Exception {
        Field field = NodeCachingLinkedList.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(list);
    }
}
