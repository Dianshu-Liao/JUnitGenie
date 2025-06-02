package com.fasterxml.jackson.databind.util.internal;

import java.util.concurrent.atomic.AtomicLong;
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

class PrivateMaxEntriesMap_makeDead_22_0_Test {

    private static class WeightedValue<V> {

        final V value;

        final long weight;

        WeightedValue(V value, long weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    private static class Node<K, V> {

        private WeightedValue<V> value;

        Node(WeightedValue<V> value) {
            this.value = value;
        }

        WeightedValue<V> get() {
            return value;
        }

        boolean compareAndSet(WeightedValue<V> expected, WeightedValue<V> updated) {
            if (this.value.equals(expected)) {
                this.value = updated;
                return true;
            }
            return false;
        }
    }

    private static class PrivateMaxEntriesMap<K, V> {

        AtomicLong weightedSize = new AtomicLong();

        void makeDead(Node<K, V> node) {
            for (; ; ) {
                WeightedValue<V> current = node.get();
                WeightedValue<V> dead = new WeightedValue<>(current.value, 0);
                if (node.compareAndSet(current, dead)) {
                    weightedSize.lazySet(weightedSize.get() - Math.abs(current.weight));
                    return;
                }
            }
        }
    }

    private PrivateMaxEntriesMap<String, String> map;

    private Node<String, String> node;

    @BeforeEach
    void setUp() {
        map = new PrivateMaxEntriesMap<>();
        node = new Node<>(new WeightedValue<>("value", 10));
    }

    @Test
    void testMakeDeadSuccessfullyMarksNodeAsDead() {
        WeightedValue<String> initial = node.get();
        assertEquals(10, initial.weight);
        map.makeDead(node);
        WeightedValue<String> dead = node.get();
        assertEquals(0, dead.weight);
    }

    @Test
    void testMakeDeadHandlesConcurrentAccess() throws InterruptedException {
        Thread thread1 = new Thread(() -> map.makeDead(node));
        Thread thread2 = new Thread(() -> map.makeDead(node));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        WeightedValue<String> dead = node.get();
        assertEquals(0, dead.weight);
    }
}
