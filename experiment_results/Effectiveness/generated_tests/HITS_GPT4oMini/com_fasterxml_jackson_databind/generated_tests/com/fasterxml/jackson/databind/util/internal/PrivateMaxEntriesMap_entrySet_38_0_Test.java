package com.fasterxml.jackson.databind.util.internal;

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
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
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

    private PrivateMaxEntriesMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        PrivateMaxEntriesMap.Builder<String, Integer> builder = new PrivateMaxEntriesMap.Builder<>();
        map = builder.build();
    }

    @Test
    void testEntrySet() {
        map.put("key1", 1);
        map.put("key2", 2);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertNotNull(entries);
        assertEquals(2, entries.size());
        for (Map.Entry<String, Integer> entry : entries) {
            assertTrue(entry.getKey().equals("key1") || entry.getKey().equals("key2"));
            assertTrue(entry.getValue() == 1 || entry.getValue() == 2);
        }
    }

    @Test
    void testEntrySetEmpty() {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertNotNull(entries);
        assertTrue(entries.isEmpty());
    }

    @Test
    void testEntrySetAfterRemoval() {
        map.put("key1", 1);
        map.put("key2", 2);
        map.remove("key1");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(1, entries.size());
        assertFalse(entries.stream().anyMatch(entry -> entry.getKey().equals("key1")));
    }
}
