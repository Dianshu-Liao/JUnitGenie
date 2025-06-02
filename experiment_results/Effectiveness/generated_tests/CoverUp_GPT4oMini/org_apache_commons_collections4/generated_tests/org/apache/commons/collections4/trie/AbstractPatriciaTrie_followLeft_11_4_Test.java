package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Map;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class AbstractPatriciaTrie_followLeft_11_4_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private TrieEntry<String, String> rootEntry;

    private TrieEntry<String, String> leftChild;

    private TrieEntry<String, String> rightChild;

    @BeforeEach
    void setUp() {
        trie = Mockito.mock(AbstractPatriciaTrie.class, Mockito.CALLS_REAL_METHODS);
        rootEntry = new TrieEntry<>(null, null, -1);
        leftChild = new TrieEntry<>("left", "valueLeft", 0);
        rightChild = new TrieEntry<>("right", "valueRight", 1);
        // Setting up the mock behavior
        Mockito.when(trie.followLeft(any())).thenCallRealMethod();
        rootEntry.left = leftChild;
        rootEntry.right = rightChild;
    }

    @Test
    void testFollowLeft_WithLeftChild() throws Exception {
        // Test when the left child is present
        TrieEntry<String, String> result = invokeFollowLeft(rootEntry);
        assertNotNull(result);
        assertEquals(leftChild, result);
    }

    @Test
    void testFollowLeft_WithEmptyLeftChild() throws Exception {
        // Test when the left child is empty and should go to the right
        leftChild.setEmpty(true);
        TrieEntry<String, String> result = invokeFollowLeft(rootEntry);
        assertNotNull(result);
        assertEquals(rightChild, result);
    }

    @Test
    void testFollowLeft_WithBitIndexCondition() throws Exception {
        // Test when child bitIndex is greater than node bitIndex
        leftChild.setEmpty(true);
        TrieEntry<String, String> childWithHigherBitIndex = new TrieEntry<>("higher", "valueHigher", 2);
        rootEntry.right = childWithHigherBitIndex;
        TrieEntry<String, String> result = invokeFollowLeft(rootEntry);
        assertNotNull(result);
        assertEquals(childWithHigherBitIndex, result);
    }

    private TrieEntry<String, String> invokeFollowLeft(TrieEntry<String, String> node) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        method.setAccessible(true);
        return (TrieEntry<String, String>) method.invoke(trie, node);
    }

    // Mocking TrieEntry class for testing purposes
    static class TrieEntry<K, V> {

        K key;

        V value;

        int bitIndex;

        TrieEntry<K, V> left;

        TrieEntry<K, V> right;

        TrieEntry(K key, V value, int bitIndex) {
            this.key = key;
            this.value = value;
            this.bitIndex = bitIndex;
        }

        boolean isEmpty() {
            return key == null && value == null;
        }

        void setEmpty(boolean empty) {
            if (empty) {
                this.key = null;
                this.value = null;
            }
        }
    }
}
