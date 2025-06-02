package org.apache.commons.collections4.trie;

import org.apache.commons.collections4.trie.AbstractPatriciaTrie;
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
import java.util.AbstractMap;
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

    private TestPatriciaTrie<String, String> trie;

    @BeforeEach
    void setUp() {
        trie = new TestPatriciaTrie<>(null);
    }

    @Test
    void testEntrySetInitiallyNull() {
        Set<Map.Entry<String, String>> entrySet = trie.entrySet();
        assertNotNull(entrySet);
        assertTrue(entrySet.isEmpty());
    }

    @Test
    void testEntrySetAfterAddingEntries() {
        trie.put("key1", "value1");
        trie.put("key2", "value2");
        Set<Map.Entry<String, String>> entrySet = trie.entrySet();
        assertEquals(2, entrySet.size());
        boolean containsKey1 = entrySet.stream().anyMatch(entry -> "key1".equals(entry.getKey()) && "value1".equals(entry.getValue()));
        boolean containsKey2 = entrySet.stream().anyMatch(entry -> "key2".equals(entry.getKey()) && "value2".equals(entry.getValue()));
        assertTrue(containsKey1);
        assertTrue(containsKey2);
    }

    @Test
    void testEntrySetDoesNotModifyOriginalSet() {
        trie.put("key1", "value1");
        Set<Map.Entry<String, String>> entrySet = trie.entrySet();
        entrySet.clear();
        assertEquals(1, trie.size());
    }

    private static class TestPatriciaTrie<K, V> extends AbstractPatriciaTrie<K, V> {

        private final Map<K, V> map = new HashMap<>();

        public TestPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer) {
            super(keyAnalyzer);
        }

        @Override
        public V put(K key, V value) {
            return map.put(key, value);
        }

        @Override
        public V get(Object key) {
            return map.get(key);
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            return map.entrySet();
        }
    }
}
