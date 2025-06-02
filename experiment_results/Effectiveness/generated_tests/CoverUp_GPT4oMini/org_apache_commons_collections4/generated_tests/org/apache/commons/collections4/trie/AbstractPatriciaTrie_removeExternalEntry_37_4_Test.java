package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
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
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class AbstractPatriciaTrie_removeExternalEntry_37_4_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private TrieEntry<String, String> rootEntry;

    private TrieEntry<String, String> externalEntry;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {
        };
        rootEntry = new TrieEntry<>(null, null, -1);
        externalEntry = new TrieEntry<>("key", "value", 0);
        rootEntry.left = externalEntry;
        externalEntry.parent = rootEntry;
    }

    @Test
    void testRemoveExternalEntry_ValidEntry() throws Exception {
        invokeRemoveExternalEntry(externalEntry);
        assertNull(rootEntry.left);
    }

    @Test
    void testRemoveExternalEntry_RootEntry() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeRemoveExternalEntry(rootEntry);
        });
        assertEquals("Cannot delete root Entry!", thrown.getMessage());
    }

    @Test
    void testRemoveExternalEntry_NonExternalEntry() {
        TrieEntry<String, String> nonExternalEntry = new TrieEntry<>("nonExternal", "value", 1);
        rootEntry.left = nonExternalEntry;
        nonExternalEntry.parent = rootEntry;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeRemoveExternalEntry(nonExternalEntry);
        });
        assertEquals(nonExternalEntry + " is not an external Entry!", thrown.getMessage());
    }

    private void invokeRemoveExternalEntry(TrieEntry<String, String> entry) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("removeExternalEntry", TrieEntry.class);
        method.setAccessible(true);
        method.invoke(trie, entry);
    }

    // Mock TrieEntry class for testing purpose
    private static class TrieEntry<K, V> {

        K key;

        V value;

        TrieEntry<K, V> left;

        TrieEntry<K, V> right;

        TrieEntry<K, V> parent;

        TrieEntry<K, V> predecessor;

        int bitIndex;

        TrieEntry(K key, V value, int bitIndex) {
            this.key = key;
            this.value = value;
            this.bitIndex = bitIndex;
        }

        boolean isExternalNode() {
            return left == null && right == null;
        }
    }
}
