package org.apache.commons.collections4.trie;

import org.apache.commons.collections4.trie.AbstractPatriciaTrie;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

@ExtendWith(MockitoExtension.class)
class AbstractPatriciaTrie_values_47_0_Test {

    private AbstractPatriciaTrie<String, String> trie;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {

            @Override
            public String put(final String key, final String value) {
                return super.put(key, value);
            }

            @Override
            public String remove(final Object k) {
                return super.remove(k);
            }

            @Override
            public String get(final Object k) {
                return super.get(k);
            }

            @Override
            public int size() {
                return super.size();
            }

            @Override
            public Collection<String> values() {
                return super.values();
            }
        };
    }

    @Test
    void testValues() {
        Collection<String> values = trie.values();
        assertNotNull(values, "Values collection should not be null");
    }

    @Test
    void testValuesWhenEmpty() {
        Collection<String> values = trie.values();
        assertTrue(values.isEmpty(), "Values collection should be empty");
    }

    @Test
    void testValuesAfterAddingEntries() {
        trie.put("key1", "value1");
        trie.put("key2", "value2");
        Collection<String> values = trie.values();
        assertEquals(2, values.size(), "Values collection should contain 2 elements");
        assertTrue(values.contains("value1"), "Values should contain 'value1'");
        assertTrue(values.contains("value2"), "Values should contain 'value2'");
    }
}
