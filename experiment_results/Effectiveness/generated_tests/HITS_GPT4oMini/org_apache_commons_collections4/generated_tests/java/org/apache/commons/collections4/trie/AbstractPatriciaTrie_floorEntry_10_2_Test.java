package org.apache.commons.collections4.trie;

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

public class AbstractPatriciaTrie_floorEntry_10_2_Test {

    private AbstractPatriciaTrie<String, String> trie;

    @BeforeEach
    public void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(new KeyAnalyzer<String>() {

            @Override
            public int bitIndex(String key, int offset, int lengthInBits, String other, int otherOffset, int otherLengthInBits) {
                return key.length() > 0 ? 0 : -1;
            }

            @Override
            public int lengthInBits(String key) {
                return key != null ? key.length() : 0;
            }

            @Override
            public int compare(String key1, String key2) {
                return key1.compareTo(key2);
            }

            @Override
            public boolean isPrefix(String key, int offset, int lengthInBits, String other) {
                return key.startsWith(other);
            }

            @Override
            public boolean isBitSet(String key, int bitIndex, int lengthInBits) {
                return bitIndex < lengthInBits && (key.charAt(bitIndex) == '1');
            }

            @Override
            public int bitsPerElement() {
                // Assuming each element is represented by one bit
                return 1;
            }
        }) {

            @Override
            TrieEntry<String, String> getNearestEntryForKey(final String key, final int lengthInBits) {
                return super.getNearestEntryForKey(key, lengthInBits);
            }
        };
    }

    @Test
    public void testFloorEntryWhenKeyIsNull() {
        assertNull(trie.floorEntry(null), "Floor entry for null key should be null.");
    }

    @Test
    public void testFloorEntryWhenRootIsEmpty() {
        assertNull(trie.floorEntry("test"), "Floor entry when root is empty should be null.");
    }

    @Test
    public void testFloorEntryWhenKeyExists() {
        trie.put("test", "value");
        assertNotNull(trie.floorEntry("test"), "Floor entry for existing key should not be null.");
        assertEquals("test", trie.floorEntry("test").key, "Floor entry should match the key.");
    }

    @Test
    public void testFloorEntryWhenKeyDoesNotExist() {
        trie.put("test", "value");
        assertNotNull(trie.floorEntry("test1"), "Floor entry for a non-existing key should not be null.");
        assertEquals("test", trie.floorEntry("test1").key, "Floor entry should match the closest key.");
    }
}
