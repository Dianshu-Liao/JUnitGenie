package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Collection;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

@ExtendWith(MockitoExtension.class)
class AbstractPatriciaTrie_followLeft_11_1_Test {

    private AbstractPatriciaTrie<String, String> trie;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {
        };
    }

    @Test
    void testFollowLeft() throws Exception {
        // Create a mock TrieEntry
        TrieEntry<String, String> leftChild = new TrieEntry<>(null, null, -1);
        TrieEntry<String, String> rightChild = new TrieEntry<>(null, null, 0);
        // Set up the left and right children
        leftChild.left = new TrieEntry<>(null, null, -1);
        leftChild.right = rightChild;
        // Set up the node with bitIndex
        TrieEntry<String, String> node = new TrieEntry<>(null, null, 1);
        node.left = leftChild;
        // Invoke the private method using reflection
        Method followLeftMethod = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        followLeftMethod.setAccessible(true);
        // Call the method
        TrieEntry<String, String> result = (TrieEntry<String, String>) followLeftMethod.invoke(trie, node);
        // Verify the result
        assertNotNull(result);
        assertEquals(rightChild, result);
    }

    // Mock TrieEntry class for testing
    private static class TrieEntry<K, V> {

        K key;

        V value;

        int bitIndex;

        TrieEntry<K, V> left;

        TrieEntry<K, V> right;

        TrieEntry(K key, V value, int bitIndex) {
            this.key = key;
            this.value = value;
            this.bitIndex = bitIndex;
            this.left = new TrieEntry<>(null, null, -1);
            this.right = new TrieEntry<>(null, null, -1);
        }

        boolean isEmpty() {
            return key == null && value == null;
        }
    }
}
