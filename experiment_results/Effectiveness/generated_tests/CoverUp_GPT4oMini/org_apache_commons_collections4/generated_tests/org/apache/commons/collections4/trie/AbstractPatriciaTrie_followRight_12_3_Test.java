package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPatriciaTrie_followRight_12_3_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private TrieEntry<String, String> rootEntry;

    @BeforeEach
    void setUp() {
        trie = new ConcretePatriciaTrie();
        rootEntry = new TrieEntry<>(null, null, -1);
        setRoot(trie, rootEntry);
    }

    @Test
    void testFollowRight_NullRightChild() throws Exception {
        TrieEntry<String, String> result = invokeFollowRight(rootEntry);
        assertNull(result, "Expected null when right child is null");
    }

    @Test
    void testFollowRight_ValidRightChild() throws Exception {
        TrieEntry<String, String> rightChild = new TrieEntry<>("right", "value", 1);
        rootEntry.right = rightChild;
        TrieEntry<String, String> result = invokeFollowRight(rootEntry);
        assertEquals(rightChild, result, "Expected to follow to the right child");
    }

    @Test
    void testFollowRight_MultipleRightChildren() throws Exception {
        TrieEntry<String, String> rightChild = new TrieEntry<>("right", "value", 1);
        TrieEntry<String, String> rightChild2 = new TrieEntry<>("right2", "value2", 2);
        rootEntry.right = rightChild;
        rightChild.right = rightChild2;
        TrieEntry<String, String> result = invokeFollowRight(rootEntry);
        assertEquals(rightChild2, result, "Expected to follow to the second right child");
    }

    @Test
    void testFollowRight_NoUplinks() throws Exception {
        TrieEntry<String, String> rightChild = new TrieEntry<>("right", "value", 1);
        TrieEntry<String, String> rightChild2 = new TrieEntry<>("right2", "value2", 0);
        rootEntry.right = rightChild;
        rightChild.right = rightChild2;
        TrieEntry<String, String> result = invokeFollowRight(rootEntry);
        assertEquals(rightChild2, result, "Expected to follow to the second right child without uplink");
    }

    private TrieEntry<String, String> invokeFollowRight(TrieEntry<String, String> node) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followRight", TrieEntry.class);
        method.setAccessible(true);
        return (TrieEntry<String, String>) method.invoke(trie, node);
    }

    private void setRoot(AbstractPatriciaTrie<String, String> trie, TrieEntry<String, String> root) {
        try {
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("setRoot", TrieEntry.class);
            method.setAccessible(true);
            method.invoke(trie, root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// Concrete implementation for testing purposes
class ConcretePatriciaTrie extends AbstractPatriciaTrie<String, String> {

    public ConcretePatriciaTrie() {
        super(null);
    }

    void setRoot(TrieEntry<String, String> root) {
        try {
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("setRoot", TrieEntry.class);
            method.setAccessible(true);
            method.invoke(this, root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// Assuming TrieEntry is defined as follows
class TrieEntry<K, V> {

    K key;

    V value;

    int bitIndex;

    TrieEntry<K, V> left;

    TrieEntry<K, V> right;

    TrieEntry<K, V> parent;

    TrieEntry<K, V> predecessor;

    TrieEntry(K key, V value, int bitIndex) {
        this.key = key;
        this.value = value;
        this.bitIndex = bitIndex;
        this.left = this;
        this.right = null;
        this.parent = null;
        this.predecessor = null;
    }

    boolean isEmpty() {
        return key == null;
    }
}
