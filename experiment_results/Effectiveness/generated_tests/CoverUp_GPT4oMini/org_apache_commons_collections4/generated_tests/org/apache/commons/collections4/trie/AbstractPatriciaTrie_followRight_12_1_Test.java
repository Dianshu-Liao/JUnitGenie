package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.NoSuchElementException;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

class AbstractPatriciaTrie_followRight_12_1_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private static class TrieEntry<K, V> {

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
        }

        boolean isEmpty() {
            return key == null;
        }
    }

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {

            @Override
            TrieEntry<String, String> followRight(TrieEntry<String, String> node) {
                if (node.right == null) {
                    return null;
                }
                while (node.right.bitIndex > node.bitIndex) {
                    node = node.right;
                }
                return node.right;
            }
        };
    }

    @Test
    void testFollowRight_NullRight() throws Exception {
        TrieEntry<String, String> entry = new TrieEntry<>(null, null, -1);
        entry.right = null;
        TrieEntry<String, String> result = invokeFollowRight(entry);
        assertNull(result, "Expected null when 'right' is null");
    }

    @Test
    void testFollowRight_ValidRight() throws Exception {
        TrieEntry<String, String> entry = new TrieEntry<>(null, null, -1);
        TrieEntry<String, String> rightEntry = new TrieEntry<>("rightKey", "rightValue", 1);
        entry.right = rightEntry;
        TrieEntry<String, String> result = invokeFollowRight(entry);
        assertEquals(rightEntry, result, "Expected to return the right entry");
    }

    @Test
    void testFollowRight_NavigatesRight() throws Exception {
        TrieEntry<String, String> entry = new TrieEntry<>(null, null, -1);
        TrieEntry<String, String> rightEntry = new TrieEntry<>("rightKey", "rightValue", 1);
        TrieEntry<String, String> furtherRightEntry = new TrieEntry<>("furtherRightKey", "furtherRightValue", 2);
        entry.right = rightEntry;
        rightEntry.right = furtherRightEntry;
        TrieEntry<String, String> result = invokeFollowRight(entry);
        assertEquals(furtherRightEntry, result, "Expected to navigate to the furthest right entry");
    }

    private TrieEntry<String, String> invokeFollowRight(TrieEntry<String, String> node) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followRight", TrieEntry.class);
        method.setAccessible(true);
        return (TrieEntry<String, String>) method.invoke(trie, node);
    }
}
