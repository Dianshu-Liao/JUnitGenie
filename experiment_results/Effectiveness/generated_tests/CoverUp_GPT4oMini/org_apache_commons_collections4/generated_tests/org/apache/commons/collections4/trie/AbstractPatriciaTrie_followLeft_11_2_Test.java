package org.apache.commons.collections4.trie;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
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

class AbstractPatriciaTrie_followLeft_11_2_Test {

    private AbstractPatriciaTrie<String, String> trie;

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
            return this.left == null && this.right == null;
        }
    }

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {

            @Override
            protected TrieEntry<String, String> followLeft(TrieEntry<String, String> node) {
                return super.followLeft(node);
            }
        };
    }

    @Test
    void testFollowLeft() throws Exception {
        TrieEntry<String, String> leftChild = new TrieEntry<>(null, null, 0);
        TrieEntry<String, String> rightChild = new TrieEntry<>(null, null, 1);
        TrieEntry<String, String> rootEntry = new TrieEntry<>(leftChild, rightChild, 2);
        leftChild.bitIndex = 0;
        rightChild.bitIndex = -1;
        Method followLeftMethod = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        followLeftMethod.setAccessible(true);
        TrieEntry<String, String> result = (TrieEntry<String, String>) followLeftMethod.invoke(trie, rootEntry);
        assertEquals(leftChild, result);
    }

    @Test
    void testFollowLeftWithEmptyLeftChild() throws Exception {
        TrieEntry<String, String> leftChild = new TrieEntry<>(null, null, -1);
        TrieEntry<String, String> rightChild = new TrieEntry<>(null, null, 1);
        TrieEntry<String, String> rootEntry = new TrieEntry<>(leftChild, rightChild, 2);
        leftChild.bitIndex = -1;
        rightChild.bitIndex = 1;
        Method followLeftMethod = AbstractPatriciaTrie.class.getDeclaredMethod("followLeft", TrieEntry.class);
        followLeftMethod.setAccessible(true);
        TrieEntry<String, String> result = (TrieEntry<String, String>) followLeftMethod.invoke(trie, rootEntry);
        assertEquals(rightChild, result);
    }
}
