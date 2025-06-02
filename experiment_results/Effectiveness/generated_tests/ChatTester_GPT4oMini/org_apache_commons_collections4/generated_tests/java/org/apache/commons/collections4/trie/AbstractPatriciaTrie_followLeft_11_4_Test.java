package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

class AbstractPatriciaTrie_followLeft_11_4_Test {

    private AbstractPatriciaTrie<Object, Object> trie;

    @BeforeEach
    void setUp() {
        // Fixed the generic type arguments for AbstractPatriciaTrie
        trie = new AbstractPatriciaTrie<Object, Object>(new KeyAnalyzer<Object>() {
        }) {
        };
    }

    @Test
    void testFollowLeftWithEmptyLeftNode() throws Exception {
        TrieEntry<Object, Object> rightChild = new TrieEntry<>(null, null, 0);
        TrieEntry<Object, Object> leftChild = new TrieEntry<>(null, null, -1);
        TrieEntry<Object, Object> root = new TrieEntry<>(leftChild, rightChild, 1);
        // Invoke the private method using reflection
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        TrieEntry<Object, Object> result = (TrieEntry<Object, Object>) method.invoke(trie, root);
        assertEquals(rightChild, result);
    }

    @Test
    void testFollowLeftWithValidLeftNode() throws Exception {
        TrieEntry<Object, Object> leftChild = new TrieEntry<>(null, null, 0);
        TrieEntry<Object, Object> root = new TrieEntry<>(leftChild, null, 1);
        // Invoke the private method using reflection
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        TrieEntry<Object, Object> result = (TrieEntry<Object, Object>) method.invoke(trie, root);
        assertEquals(leftChild, result);
    }

    @Test
    void testFollowLeftWithMultipleLevels() throws Exception {
        TrieEntry<Object, Object> childLevel1 = new TrieEntry<>(null, null, 2);
        TrieEntry<Object, Object> childLevel2 = new TrieEntry<>(childLevel1, null, 3);
        TrieEntry<Object, Object> root = new TrieEntry<>(null, childLevel2, 1);
        // Invoke the private method using reflection
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        TrieEntry<Object, Object> result = (TrieEntry<Object, Object>) method.invoke(trie, root);
        assertEquals(childLevel1, result);
    }

    @Test
    void testFollowLeftWithRootHavingNoChildren() throws Exception {
        TrieEntry<Object, Object> root = new TrieEntry<>(null, null, 1);
        // Invoke the private method using reflection
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        TrieEntry<Object, Object> result = (TrieEntry<Object, Object>) method.invoke(trie, root);
        assertNull(result);
    }

    @Test
    void testFollowLeftWithLeftNodeHavingNoChildren() throws Exception {
        TrieEntry<Object, Object> leftChild = new TrieEntry<>(null, null, 0);
        TrieEntry<Object, Object> rightChild = new TrieEntry<>(null, null, 1);
        TrieEntry<Object, Object> root = new TrieEntry<>(leftChild, rightChild, 2);
        // Invoke the private method using reflection
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        TrieEntry<Object, Object> result = (TrieEntry<Object, Object>) method.invoke(trie, root);
        assertEquals(rightChild, result);
    }
}

// Assuming TrieEntry is a class with the following structure
class TrieEntry<K, V> {

    TrieEntry<K, V> left;

    TrieEntry<K, V> right;

    int bitIndex;

    TrieEntry(TrieEntry<K, V> left, TrieEntry<K, V> right, int bitIndex) {
        this.left = left;
        this.right = right;
        this.bitIndex = bitIndex;
    }

    boolean isEmpty() {
        return left == null && right == null;
    }
}

// Assuming KeyAnalyzer is an interface with the following structure
interface KeyAnalyzer<K> {
    // Define necessary methods for KeyAnalyzer
}
