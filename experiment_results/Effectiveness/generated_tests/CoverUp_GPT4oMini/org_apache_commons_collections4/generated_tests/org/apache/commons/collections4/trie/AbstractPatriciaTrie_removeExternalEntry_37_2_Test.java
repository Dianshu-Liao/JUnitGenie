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

class AbstractPatriciaTrie_removeExternalEntry_37_2_Test {

    private AbstractPatriciaTrie<String, String> trie;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {
        };
    }

    @Test
    void removeExternalEntry_throwsIllegalArgumentException_whenRemovingRoot() {
        TrieEntry<String, String> rootEntry = new TrieEntry<>(null, null, -1);
        assertThrows(IllegalArgumentException.class, () -> {
            invokeRemoveExternalEntry(rootEntry);
        });
    }

    @Test
    void removeExternalEntry_throwsIllegalArgumentException_whenRemovingNonExternalEntry() {
        TrieEntry<String, String> nonExternalEntry = new TrieEntry<>(null, null, -1);
        // Simulating a non-external entry
        nonExternalEntry.external = false;
        assertThrows(IllegalArgumentException.class, () -> {
            invokeRemoveExternalEntry(nonExternalEntry);
        });
    }

    @Test
    void removeExternalEntry_successfullyRemovesExternalEntry() throws Exception {
        TrieEntry<String, String> parentEntry = new TrieEntry<>(null, null, -1);
        TrieEntry<String, String> externalEntry = new TrieEntry<>(parentEntry, null, -1);
        // Simulating an external entry
        externalEntry.external = true;
        parentEntry.left = externalEntry;
        setRoot(parentEntry);
        invokeRemoveExternalEntry(externalEntry);
        // Verify that the external entry has been removed
        assertNull(parentEntry.left);
    }

    private void invokeRemoveExternalEntry(TrieEntry<String, String> entry) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("removeExternalEntry", TrieEntry.class);
        method.setAccessible(true);
        method.invoke(trie, entry);
    }

    private void setRoot(TrieEntry<String, String> entry) throws Exception {
        Method method = AbstractPatriciaTrie.class.getDeclaredMethod("setRoot", TrieEntry.class);
        method.setAccessible(true);
        method.invoke(trie, entry);
    }

    // Mock class for TrieEntry to simulate behavior
    private static class TrieEntry<K, V> {

        TrieEntry<K, V> parent;

        TrieEntry<K, V> left;

        TrieEntry<K, V> right;

        TrieEntry<K, V> predecessor;

        int bitIndex;

        boolean external = true;

        TrieEntry(TrieEntry<K, V> parent, V value, int bitIndex) {
            this.parent = parent;
            this.bitIndex = bitIndex;
        }

        boolean isExternalNode() {
            return external;
        }
    }
}
