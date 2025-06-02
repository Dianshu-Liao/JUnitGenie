package org.apache.commons.collections4.trie;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UnmodifiableTrie_unmodifiableTrie_0_1_Test {

    private Trie<String, String> mockTrie;

    @BeforeEach
    void setUp() {
        mockTrie = mock(Trie.class);
    }

    @Test
    void testUnmodifiableTrie_WithUnmodifiableInstance() {
        UnmodifiableTrie unmodifiableTrie = new UnmodifiableTrie(mockTrie);
        when(mockTrie instanceof Unmodifiable).thenReturn(true);
        Trie<String, String> result = UnmodifiableTrie.unmodifiableTrie(unmodifiableTrie);
        assertSame(unmodifiableTrie, result);
    }

    @Test
    void testUnmodifiableTrie_WithRegularTrie() {
        when(mockTrie.size()).thenReturn(1);
        when(mockTrie.containsKey("key")).thenReturn(true);
        when(mockTrie.get("key")).thenReturn("value");
        Trie<String, String> result = UnmodifiableTrie.unmodifiableTrie(mockTrie);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("key"));
        assertEquals("value", result.get("key"));
    }

    @Test
    void testUnmodifiableTrie_ThrowsUnsupportedOperationException() throws Exception {
        UnmodifiableTrie unmodifiableTrie = new UnmodifiableTrie(mockTrie);
        Method putMethod = UnmodifiableTrie.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        assertThrows(UnsupportedOperationException.class, () -> putMethod.invoke(unmodifiableTrie, "key", "value"));
        Method putAllMethod = UnmodifiableTrie.class.getDeclaredMethod("putAll", Map.class);
        putAllMethod.setAccessible(true);
        assertThrows(UnsupportedOperationException.class, () -> putAllMethod.invoke(unmodifiableTrie, new HashMap<>()));
        Method removeMethod = UnmodifiableTrie.class.getDeclaredMethod("remove", Object.class);
        removeMethod.setAccessible(true);
        assertThrows(UnsupportedOperationException.class, () -> removeMethod.invoke(unmodifiableTrie, "key"));
        Method clearMethod = UnmodifiableTrie.class.getDeclaredMethod("clear");
        clearMethod.setAccessible(true);
        assertThrows(UnsupportedOperationException.class, () -> clearMethod.invoke(unmodifiableTrie));
    }
}
