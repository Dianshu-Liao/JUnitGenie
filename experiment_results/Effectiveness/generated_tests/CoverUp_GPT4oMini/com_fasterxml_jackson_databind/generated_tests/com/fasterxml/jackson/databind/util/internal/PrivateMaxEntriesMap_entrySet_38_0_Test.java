package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.IDLE;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.PROCESSING;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.REQUIRED;

class PrivateMaxEntriesMap_entrySet_38_0_Test {

    private PrivateMaxEntriesMap<String, String> map;

    @BeforeEach
    void setUp() {
        PrivateMaxEntriesMap.Builder<String, String> builder = new PrivateMaxEntriesMap.Builder<>();
        map = builder.build();
    }

    @Test
    void testEntrySetReturnsNonNull() {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertNotNull(entrySet, "Entry set should not be null");
    }

    @Test
    void testEntrySetLazyInitialization() {
        assertNull(map.entrySet, "Entry set should be null before access");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertNotNull(entrySet, "Entry set should be initialized after access");
        assertSame(entrySet, map.entrySet, "Entry set should be cached after first access");
    }

    @Test
    void testEntrySetIsEmptyInitially() {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertTrue(entrySet.isEmpty(), "Entry set should be empty initially");
    }

    @Test
    void testEntrySetAfterAddingEntries() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertEquals(2, entrySet.size(), "Entry set should contain 2 entries");
        for (Map.Entry<String, String> entry : entrySet) {
            assertTrue(entry.getKey().equals("key1") || entry.getKey().equals("key2"), "Entry key should be either key1 or key2");
            assertTrue(entry.getValue().equals("value1") || entry.getValue().equals("value2"), "Entry value should be either value1 or value2");
        }
    }

    @Test
    void testEntrySetAfterRemovingAnEntry() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.remove("key1");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertEquals(1, entrySet.size(), "Entry set should contain 1 entry after removal");
        assertFalse(entrySet.stream().anyMatch(entry -> entry.getKey().equals("key1")), "Entry set should not contain key1 after removal");
    }

    @Test
    void testEntrySetContainsExpectedEntries() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        assertTrue(entrySet.contains(new AbstractMap.SimpleEntry<>("key1", "value1")), "Entry set should contain key1=value1");
        assertTrue(entrySet.contains(new AbstractMap.SimpleEntry<>("key2", "value2")), "Entry set should contain key2=value2");
        assertFalse(entrySet.contains(new AbstractMap.SimpleEntry<>("key3", "value3")), "Entry set should not contain key3=value3");
    }
}
