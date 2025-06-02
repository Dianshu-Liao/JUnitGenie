package com.fasterxml.jackson.databind.util.internal;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.IDLE;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.PROCESSING;
import static com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.REQUIRED;

@ExtendWith(MockitoExtension.class)
class PrivateMaxEntriesMap_makeDead_22_1_Test {

    private PrivateMaxEntriesMap<String, String> privateMaxEntriesMap;

    private Node<String, String> mockNode;

    private WeightedValue<String> mockWeightedValue;

    @BeforeEach
    void setUp() {
        privateMaxEntriesMap = new PrivateMaxEntriesMap<>(new PrivateMaxEntriesMap.Builder<>());
        mockNode = mock(Node.class);
        mockWeightedValue = mock(WeightedValue.class);
        // Assuming the initial weight and value for the mock
        when(mockWeightedValue.value).thenReturn("value");
        when(mockWeightedValue.weight).thenReturn(10L);
        when(mockNode.get()).thenReturn(mockWeightedValue);
    }

    @Test
    void testMakeDeadSuccessfullyUpdatesNode() {
        when(mockNode.compareAndSet(any(), any())).thenReturn(true);
        // Call the method using reflection
        invokeMakeDead(privateMaxEntriesMap, mockNode);
        // Verify the weightedSize is updated correctly
        assertEquals(-10L, privateMaxEntriesMap.weightedSize.get());
    }

    @Test
    void testMakeDeadRetriesUntilSuccessful() {
        when(mockNode.compareAndSet(any(), any())).thenReturn(false).thenReturn(true);
        // Call the method using reflection
        invokeMakeDead(privateMaxEntriesMap, mockNode);
        // Verify that weightedSize is updated correctly
        assertEquals(-10L, privateMaxEntriesMap.weightedSize.get());
    }

    private void invokeMakeDead(PrivateMaxEntriesMap<String, String> map, Node<String, String> node) {
        try {
            Method method = PrivateMaxEntriesMap.class.getDeclaredMethod("makeDead", Node.class);
            method.setAccessible(true);
            method.invoke(map, node);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Mock classes for Node and WeightedValue
    static class Node<K, V> {

        WeightedValue<V> get() {
            // Mocked
            return null;
        }

        boolean compareAndSet(WeightedValue<V> expect, WeightedValue<V> update) {
            // Mocked
            return false;
        }
    }

    static class WeightedValue<V> {

        final V value;

        final long weight;

        WeightedValue(V value, long weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
