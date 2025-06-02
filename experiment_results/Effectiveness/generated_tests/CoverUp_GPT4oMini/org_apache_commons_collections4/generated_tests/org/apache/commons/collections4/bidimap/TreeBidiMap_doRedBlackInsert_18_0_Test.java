package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement;
import org.apache.commons.collections4.bidimap.TreeBidiMap.Node;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
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

@ExtendWith(MockitoExtension.class)
class TreeBidiMap_doRedBlackInsert_18_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>(new HashMap<>());
    }

    @Test
    void testDoRedBlackInsert() throws Exception {
        // Create a mock node
        TreeBidiMap.Node<String, Integer> node = new TreeBidiMap.Node<>("key1", 1);
        // Use reflection to access the private method
        Method method = TreeBidiMap.class.getDeclaredMethod("doRedBlackInsert", TreeBidiMap.Node.class, DataElement.class);
        method.setAccessible(true);
        // Test inserting a node with KEY data element
        method.invoke(treeBidiMap, node, DataElement.KEY);
        // Assertions to verify the state of the tree after insertion
        assertNotNull(getRootNode(treeBidiMap, DataElement.KEY));
        assertEquals("key1", getRootNode(treeBidiMap, DataElement.KEY).getKey());
        assertEquals(1, getRootNode(treeBidiMap, DataElement.KEY).getValue());
        // Test inserting a node with VALUE data element
        TreeBidiMap.Node<String, Integer> node2 = new TreeBidiMap.Node<>("key2", 2);
        method.invoke(treeBidiMap, node2, DataElement.VALUE);
        // Assertions to verify the state of the tree after second insertion
        assertNotNull(getRootNode(treeBidiMap, DataElement.VALUE));
        assertEquals("key2", getRootNode(treeBidiMap, DataElement.VALUE).getKey());
        assertEquals(2, getRootNode(treeBidiMap, DataElement.VALUE).getValue());
    }

    @Test
    void testDoRedBlackInsertWithRedParent() throws Exception {
        // Create a mock node with a red parent
        TreeBidiMap.Node<String, Integer> parentNode = new TreeBidiMap.Node<>("parentKey", 10);
        TreeBidiMap.Node<String, Integer> childNode = new TreeBidiMap.Node<>("childKey", 20);
        // Insert parent node first
        Method method = TreeBidiMap.class.getDeclaredMethod("doRedBlackInsert", TreeBidiMap.Node.class, DataElement.class);
        method.setAccessible(true);
        method.invoke(treeBidiMap, parentNode, DataElement.KEY);
        // Insert child node
        method.invoke(treeBidiMap, childNode, DataElement.KEY);
        // Assertions for tree properties after insertion
        assertEquals("parentKey", getRootNode(treeBidiMap, DataElement.KEY).getKey());
        assertEquals("childKey", getLeftChild(treeBidiMap, DataElement.KEY, parentNode).getKey());
    }

    private TreeBidiMap.Node<String, Integer> getRootNode(TreeBidiMap<String, Integer> map, DataElement element) throws Exception {
        Method getRootNodeMethod = TreeBidiMap.class.getDeclaredMethod("getRootNode", DataElement.class);
        getRootNodeMethod.setAccessible(true);
        return (TreeBidiMap.Node<String, Integer>) getRootNodeMethod.invoke(map, element);
    }

    private TreeBidiMap.Node<String, Integer> getLeftChild(TreeBidiMap<String, Integer> map, DataElement element, TreeBidiMap.Node<String, Integer> parent) throws Exception {
        Method getLeftChildMethod = TreeBidiMap.class.getDeclaredMethod("getLeftChild", TreeBidiMap.Node.class, DataElement.class);
        getLeftChildMethod.setAccessible(true);
        return (TreeBidiMap.Node<String, Integer>) getLeftChildMethod.invoke(map, parent, element);
    }
}
