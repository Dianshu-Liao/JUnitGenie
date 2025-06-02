package org.apache.commons.collections4.trie;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Map;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPatriciaTrie_removeExternalEntry_37_1_Test {

    private AbstractPatriciaTrie<String, String> trie;

    private TrieEntry<String, String> rootEntry;

    private TrieEntry<String, String> externalEntry;

    @BeforeEach
    void setUp() {
        trie = new AbstractPatriciaTrie<String, String>(null) {
        };
        rootEntry = new TrieEntry<>(null, null, -1);
        externalEntry = new TrieEntry<>("key", "value", 1);
        setField(trie, "root", rootEntry);
        setField(rootEntry, "left", externalEntry);
        setField(externalEntry, "parent", rootEntry);
        setField(externalEntry, "left", externalEntry);
        setField(externalEntry, "right", externalEntry);
    }

    @Test
    void testRemoveExternalEntry_RemovesExternalEntrySuccessfully() {
        assertDoesNotThrow(() -> invokeRemoveExternalEntry(trie, externalEntry));
        assertNull(getField(externalEntry, "parent"));
        assertEquals(getField(rootEntry, "left"), externalEntry);
    }

    @Test
    void testRemoveExternalEntry_ThrowsExceptionForRootEntry() {
        assertThrows(IllegalArgumentException.class, () -> invokeRemoveExternalEntry(trie, rootEntry));
    }

    @Test
    void testRemoveExternalEntry_ThrowsExceptionForNonExternalEntry() {
        TrieEntry<String, String> internalEntry = new TrieEntry<>("internalKey", "internalValue", 2);
        setField(internalEntry, "parent", rootEntry);
        setField(rootEntry, "left", internalEntry);
        assertThrows(IllegalArgumentException.class, () -> invokeRemoveExternalEntry(trie, internalEntry));
    }

    private void invokeRemoveExternalEntry(AbstractPatriciaTrie<String, String> trie, TrieEntry<String, String> entry) {
        try {
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("removeExternalEntry", TrieEntry.class);
            method.setAccessible(true);
            method.invoke(trie, entry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object getField(Object target, String fieldName) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class TrieEntry<K, V> {

    K key;

    V value;

    int bitIndex;

    TrieEntry<K, V> parent;

    TrieEntry<K, V> left;

    TrieEntry<K, V> right;

    TrieEntry(K key, V value, int bitIndex) {
        this.key = key;
        this.value = value;
        this.bitIndex = bitIndex;
    }

    boolean isExternalNode() {
        return left == this && right == this;
    }
}
