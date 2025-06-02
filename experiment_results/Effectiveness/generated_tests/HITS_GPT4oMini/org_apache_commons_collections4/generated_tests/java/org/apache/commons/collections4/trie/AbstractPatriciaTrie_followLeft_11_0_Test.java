package org.apache.commons.collections4.trie;

import java.util.HashMap;
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

class AbstractPatriciaTrie_followLeft_11_0_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private class TestPatriciaTrie extends AbstractPatriciaTrie<String, String> {

        TestPatriciaTrie() {
            super(null, new HashMap<>());
        }
    }

    @BeforeEach
    void setUp() {
        trie = new TestPatriciaTrie();
    }

    @Test
    void testFollowLeftWithLeftChild() {
        AbstractPatriciaTrie.TrieEntry<String, String> leftChild = new AbstractPatriciaTrie.TrieEntry<>("leftKey", "leftValue", 0);
        AbstractPatriciaTrie.TrieEntry<String, String> parentNode = new AbstractPatriciaTrie.TrieEntry<>("parentKey", "parentValue", 1);
        parentNode.left = leftChild;
        AbstractPatriciaTrie.TrieEntry<String, String> result = trie.followLeft(parentNode);
        assertNotNull(result);
        assertEquals("leftValue", result.getValue());
    }

    @Test
    void testFollowLeftWithEmptyLeftChild() {
        AbstractPatriciaTrie.TrieEntry<String, String> rightChild = new AbstractPatriciaTrie.TrieEntry<>("rightKey", "rightValue", 0);
        AbstractPatriciaTrie.TrieEntry<String, String> parentNode = new AbstractPatriciaTrie.TrieEntry<>("parentKey", "parentValue", 1);
        parentNode.left = new AbstractPatriciaTrie.TrieEntry<>(null, null, -1);
        parentNode.right = rightChild;
        AbstractPatriciaTrie.TrieEntry<String, String> result = trie.followLeft(parentNode);
        assertNotNull(result);
        assertEquals("rightValue", result.getValue());
    }

    @Test
    void testFollowLeftWithNoChildren() {
        AbstractPatriciaTrie.TrieEntry<String, String> parentNode = new AbstractPatriciaTrie.TrieEntry<>("parentKey", "parentValue", 1);
        parentNode.left = new AbstractPatriciaTrie.TrieEntry<>(null, null, -1);
        parentNode.right = new AbstractPatriciaTrie.TrieEntry<>(null, null, -1);
        AbstractPatriciaTrie.TrieEntry<String, String> result = trie.followLeft(parentNode);
        assertNotNull(result);
        assertEquals(-1, result.bitIndex);
    }
}
