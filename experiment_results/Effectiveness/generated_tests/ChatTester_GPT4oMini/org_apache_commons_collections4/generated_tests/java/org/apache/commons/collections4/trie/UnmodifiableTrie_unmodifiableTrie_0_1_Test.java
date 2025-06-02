package org.apache.commons.collections4.trie;

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
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

public class UnmodifiableTrie_unmodifiableTrie_0_1_Test {

    @Test
    public void testUnmodifiableTrie_WhenTrieIsUnmodifiable_ReturnsSameInstance() {
        // Arrange
        Trie<String, Integer> unmodifiableTrie = Mockito.mock(Trie.class);
        when(unmodifiableTrie instanceof Unmodifiable).thenReturn(true);
        // Act
        Trie<String, Integer> result = UnmodifiableTrie.unmodifiableTrie(unmodifiableTrie);
        // Assert
        assertSame(unmodifiableTrie, result);
    }

    @Test
    public void testUnmodifiableTrie_WhenTrieIsModifiable_ReturnsNewUnmodifiableTrieInstance() {
        // Arrange
        Trie<String, Integer> modifiableTrie = Mockito.mock(Trie.class);
        when(modifiableTrie instanceof Unmodifiable).thenReturn(false);
        // Act
        Trie<String, Integer> result = UnmodifiableTrie.unmodifiableTrie(modifiableTrie);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableTrie);
    }
}
