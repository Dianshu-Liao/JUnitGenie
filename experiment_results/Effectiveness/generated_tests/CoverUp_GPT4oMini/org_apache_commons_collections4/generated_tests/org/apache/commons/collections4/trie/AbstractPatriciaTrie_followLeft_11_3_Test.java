package org.apache.commons.collections4.trie;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

class AbstractPatriciaTrie_followLeft_11_3_Test {

    @Mock
    private TrieEntry<String, String> mockLeftEntry;

    @Mock
    private TrieEntry<String, String> mockRightEntry;

    private TestablePatriciaTrie trie;

    private class TestablePatriciaTrie extends AbstractPatriciaTrie<String, String> {

        protected TestablePatriciaTrie() {
            super(null);
        }
    }

    private static class TrieEntry<K, V> {

        TrieEntry<K, V> left;

        TrieEntry<K, V> right;

        int bitIndex;

        TrieEntry(TrieEntry<K, V> left, TrieEntry<K, V> right, int bitIndex) {
            this.left = left;
            this.right = right;
            this.bitIndex = bitIndex;
        }

        boolean isEmpty() {
            // Adjust based on actual implementation
            return left == null && right == null;
        }
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        trie = new TestablePatriciaTrie();
    }

    @Test
    void testFollowLeftWithLeftChildNotEmpty() {
        // Arrange
        TrieEntry<String, String> node = new TrieEntry<>(null, null, 0);
        node.left = mockLeftEntry;
        node.right = mockRightEntry;
        when(mockLeftEntry.isEmpty()).thenReturn(false);
        when(mockLeftEntry.bitIndex).thenReturn(1);
        when(mockRightEntry.bitIndex).thenReturn(2);
        // Act
        TrieEntry<String, String> result = invokeFollowLeft(node);
        // Assert
        assertEquals(mockLeftEntry, result);
    }

    @Test
    void testFollowLeftWithLeftChildEmpty() {
        // Arrange
        TrieEntry<String, String> node = new TrieEntry<>(null, null, 0);
        node.left = mockLeftEntry;
        node.right = mockRightEntry;
        when(mockLeftEntry.isEmpty()).thenReturn(true);
        when(mockRightEntry.bitIndex).thenReturn(2);
        // Act
        TrieEntry<String, String> result = invokeFollowLeft(node);
        // Assert
        assertEquals(mockRightEntry, result);
    }

    @Test
    void testFollowLeftWithChildBitIndexGreater() {
        // Arrange
        TrieEntry<String, String> node = new TrieEntry<>(null, null, 0);
        node.left = mockLeftEntry;
        node.right = mockRightEntry;
        when(mockLeftEntry.isEmpty()).thenReturn(false);
        when(mockLeftEntry.bitIndex).thenReturn(2);
        when(mockRightEntry.bitIndex).thenReturn(1);
        // Act
        TrieEntry<String, String> result = invokeFollowLeft(node);
        // Assert
        assertEquals(mockLeftEntry, result);
    }

    private TrieEntry<String, String> invokeFollowLeft(TrieEntry<String, String> node) {
        try {
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
            method.setAccessible(true);
            return (TrieEntry<String, String>) method.invoke(trie, node);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
