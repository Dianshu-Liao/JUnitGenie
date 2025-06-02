package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

class TreeBidiMap_doRedBlackDelete_16_0_Test {

    private TreeBidiMap<String, String> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
        // Populate the TreeBidiMap with some initial values for testing
        treeBidiMap.put("key1", "value1");
        treeBidiMap.put("key2", "value2");
        treeBidiMap.put("key3", "value3");
    }

    @Test
    void testDoRedBlackDeleteWithLeftAndRightChildren() throws Exception {
        Node<String, String> nodeToDelete = getNode("key2");
        invokeDoRedBlackDelete(nodeToDelete);
        assertNull(treeBidiMap.get("key2"), "Node should be deleted");
        assertEquals(2, treeBidiMap.size(), "Size should decrease by one");
    }

    @Test
    void testDoRedBlackDeleteWithOnlyLeftChild() throws Exception {
        Node<String, String> nodeToDelete = getNode("key1");
        invokeDoRedBlackDelete(nodeToDelete);
        assertNull(treeBidiMap.get("key1"), "Node should be deleted");
        assertEquals(2, treeBidiMap.size(), "Size should decrease by one");
    }

    @Test
    void testDoRedBlackDeleteWithOnlyRightChild() throws Exception {
        Node<String, String> nodeToDelete = getNode("key3");
        invokeDoRedBlackDelete(nodeToDelete);
        assertNull(treeBidiMap.get("key3"), "Node should be deleted");
        assertEquals(2, treeBidiMap.size(), "Size should decrease by one");
    }

    @Test
    void testDoRedBlackDeleteWithNoChildren() throws Exception {
        Node<String, String> nodeToDelete = getNode("key1");
        invokeDoRedBlackDelete(nodeToDelete);
        assertNull(treeBidiMap.get("key1"), "Node should be deleted");
        assertEquals(2, treeBidiMap.size(), "Size should decrease by one");
    }

    private Node<String, String> getNode(String key) throws Exception {
        Method method = TreeBidiMap.class.getDeclaredMethod("getNode", Object.class);
        method.setAccessible(true);
        return (Node<String, String>) method.invoke(treeBidiMap, key);
    }

    private void invokeDoRedBlackDelete(Node<String, String> node) throws Exception {
        Method method = TreeBidiMap.class.getDeclaredMethod("doRedBlackDelete", Node.class);
        method.setAccessible(true);
        method.invoke(treeBidiMap, node);
    }

    // Node class needs to be defined or imported here
    private static class Node<K, V> {

        private Node<K, V> left;

        private Node<K, V> right;

        private Node<K, V> parent;

        public Node<K, V> getLeft(TreeBidiMap.DataElement dataElement) {
            return left;
        }

        public Node<K, V> getRight(TreeBidiMap.DataElement dataElement) {
            return right;
        }

        public Node<K, V> getParent(TreeBidiMap.DataElement dataElement) {
            return parent;
        }

        public void setLeft(Node<K, V> left, TreeBidiMap.DataElement dataElement) {
            this.left = left;
        }

        public void setRight(Node<K, V> right, TreeBidiMap.DataElement dataElement) {
            this.right = right;
        }

        public void setParent(Node<K, V> parent, TreeBidiMap.DataElement dataElement) {
            this.parent = parent;
        }
    }
}
