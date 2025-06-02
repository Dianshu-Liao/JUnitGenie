package org.apache.commons.collections4.trie;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPatriciaTrie_values_47_2_Test {

    private AbstractPatriciaTrie<String, Integer> trie;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, Integer>(null) {

            @Override
            public Integer put(final String key, final Integer value) {
                return super.put(key, value);
            }

            @Override
            public int size() {
                return super.size();
            }

            @Override
            public void clear() {
                super.clear();
            }

            @Override
            public Collection<Integer> values() {
                return super.values();
            }
        };
    }

    @Test
    void testValuesReturnsCollection() {
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertTrue(valuesCollection.isEmpty());
    }

    @Test
    void testValuesCaching() {
        trie.put("key1", 1);
        trie.put("key2", 2);
        Collection<Integer> valuesFirstCall = trie.values();
        Collection<Integer> valuesSecondCall = trie.values();
        assertSame(valuesFirstCall, valuesSecondCall);
        assertEquals(2, valuesFirstCall.size());
    }

    @Test
    void testValuesAfterClear() {
        trie.put("key1", 1);
        trie.put("key2", 2);
        trie.clear();
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertTrue(valuesCollection.isEmpty());
    }

    @Test
    void testValuesWithMultipleEntries() {
        trie.put("key1", 1);
        trie.put("key2", 2);
        trie.put("key3", 3);
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertEquals(3, valuesCollection.size());
        assertTrue(valuesCollection.contains(1));
        assertTrue(valuesCollection.contains(2));
        assertTrue(valuesCollection.contains(3));
    }

    @Test
    void testValuesWithNoEntries() {
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertTrue(valuesCollection.isEmpty());
    }

    @Test
    void testValuesWithOneEntry() {
        trie.put("key1", 1);
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertEquals(1, valuesCollection.size());
        assertTrue(valuesCollection.contains(1));
    }

    @Test
    void testValuesWithNullKey() {
        Integer value = trie.put(null, 1);
        assertNull(value);
        Collection<Integer> valuesCollection = trie.values();
        assertNotNull(valuesCollection);
        assertTrue(valuesCollection.isEmpty());
    }
}
