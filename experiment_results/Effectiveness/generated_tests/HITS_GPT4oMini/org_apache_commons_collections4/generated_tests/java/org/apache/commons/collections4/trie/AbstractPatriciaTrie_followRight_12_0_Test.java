package org.apache.commons.collections4.trie;

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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;

class AbstractPatriciaTrie_followRight_12_0_Test {

    private TestPatriciaTrie trie;

    private AbstractPatriciaTrie.TrieEntry<String, String> root;

    private AbstractPatriciaTrie.TrieEntry<String, String> child1;

    private AbstractPatriciaTrie.TrieEntry<String, String> child2;

    @BeforeEach
    void setUp() {
        trie = new TestPatriciaTrie();
        root = new AbstractPatriciaTrie.TrieEntry<>(null, null, -1);
        child1 = new AbstractPatriciaTrie.TrieEntry<>("key1", "value1", 0);
        child2 = new AbstractPatriciaTrie.TrieEntry<>("key2", "value2", 1);
        root.right = child1;
        child1.right = child2;
        trie.setRoot(root);
    }

    @Test
    void testFollowRight_NullRight() {
        root.right = null;
        assertNull(trie.followRight(root), "Expected null when there is no right child.");
    }

    @Test
    void testFollowRight_OneChild() {
        assertEquals(child1, trie.followRight(root), "Expected to follow right to child1.");
    }

    @Test
    void testFollowRight_MultipleChildren() {
        child1.right = null;
        assertNull(trie.followRight(child1), "Expected null when there are no further right children.");
    }

    @Test
    void testFollowRight_DeepHierarchy() {
        child2.right = new AbstractPatriciaTrie.TrieEntry<>("key3", "value3", 2);
        assertEquals(child2, trie.followRight(child1), "Expected to follow right to child2.");
    }

    @Test
    void testFollowRight_ComplexStructure() {
        AbstractPatriciaTrie.TrieEntry<String, String> child3 = new AbstractPatriciaTrie.TrieEntry<>("key3", "value3", 2);
        child1.right = child3;
        child3.right = new AbstractPatriciaTrie.TrieEntry<>("key4", "value4", 3);
        assertEquals(child3, trie.followRight(child1), "Expected to follow right to child3.");
    }

    private static class TestPatriciaTrie extends AbstractPatriciaTrie<String, String> {

        TestPatriciaTrie() {
            super(null);
        }

        void setRoot(TrieEntry<String, String> root) {
            // Use reflection to set the private root field
            try {
                java.lang.reflect.Field field = AbstractPatriciaTrie.class.getDeclaredField("root");
                field.setAccessible(true);
                field.set(this, root);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
