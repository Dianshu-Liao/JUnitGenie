package org.apache.commons.collections4.trie;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

class AbstractPatriciaTrie_entrySet_7_0_Test {

    private AbstractPatriciaTrie<String, String> trie;

    // A simple implementation of AbstractPatriciaTrie for testing purposes
    private class TestPatriciaTrie extends AbstractPatriciaTrie<String, String> {

        private final Map<String, String> map = new HashMap<>();

        public TestPatriciaTrie() {
            super(null);
        }

        public String put(String key, String value) {
            // Return previous value associated with the key
            return map.put(key, value);
        }

        public int size() {
            // Return size of the map
            return map.size();
        }

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            // Provide the entry set from the underlying map
            return map.entrySet();
        }
    }

    @BeforeEach
    void setUp() {
        trie = new TestPatriciaTrie();
    }

    @Test
    void testEntrySetNotNull() {
        Set<Map.Entry<String, String>> entries = trie.entrySet();
        assertNotNull(entries, "Entry set should not be null");
    }

    @Test
    void testEntrySetInitialSize() {
        Set<Map.Entry<String, String>> entries = trie.entrySet();
        assertEquals(0, entries.size(), "Initial entry set size should be 0");
    }

    @Test
    void testEntrySetAfterAddingEntries() {
        trie.put("key1", "value1");
        trie.put("key2", "value2");
        Set<Map.Entry<String, String>> entries = trie.entrySet();
        assertEquals(2, entries.size(), "Entry set size should be 2 after adding two entries");
        // Check if the entries are present
        boolean foundKey1 = entries.contains(new AbstractMap.SimpleEntry<>("key1", "value1"));
        boolean foundKey2 = entries.contains(new AbstractMap.SimpleEntry<>("key2", "value2"));
        assertTrue(foundKey1, "Entry for key1 should be present in the entry set");
        assertTrue(foundKey2, "Entry for key2 should be present in the entry set");
    }
}
