package org.apache.commons.collections4.trie;

import org.apache.commons.collections4.Trie;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

public class UnmodifiableTrie_unmodifiableTrie_0_1_Test {

    @Test
    public void testUnmodifiableTrie() {
        // Arrange: Create a mock Trie
        Trie<String, String> mockTrie = mock(Trie.class);
        // Setup the mock behavior
        when(mockTrie.put("key1", "value1")).thenReturn(null);
        when(mockTrie.get("key1")).thenReturn("value1");
        // Act: Create an unmodifiable Trie
        Trie<String, String> unmodifiableTrie = UnmodifiableTrie.unmodifiableTrie(mockTrie);
        // Assert: Check that the unmodifiable Trie is not null and behaves correctly
        assertNotNull(unmodifiableTrie);
        assertNotNull(unmodifiableTrie.get("key1"));
    }

    @Test
    public void testUnmodifiableTrieAlreadyUnmodifiable() {
        // Arrange: Create an unmodifiable Trie
        Trie<String, String> originalTrie = mock(Trie.class);
        Trie<String, String> unmodifiableTrie = UnmodifiableTrie.unmodifiableTrie(originalTrie);
        // Act: Call unmodifiableTrie on the already unmodifiable Trie
        Trie<String, String> resultTrie = UnmodifiableTrie.unmodifiableTrie(unmodifiableTrie);
        // Assert: Ensure that the result is the same instance
        assertNotNull(resultTrie);
        assertSame(unmodifiableTrie, resultTrie);
    }
}
