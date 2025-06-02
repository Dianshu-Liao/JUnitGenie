package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.functors.InstantiateFactory;
import org.apache.commons.lang3.tuple.MutablePair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_removeAll_17_0_Test {

    private TestMapBag bag;

    @BeforeEach
    void setUp() {
        bag = new TestMapBag();
        bag.add("apple", 2);
        bag.add("banana", 3);
        bag.add("orange", 1);
    }

    @Test
    void testRemoveAll_WithExistingElements() {
        Collection<String> toRemove = new ArrayList<>();
        toRemove.add("apple");
        toRemove.add("banana");
        boolean result = bag.removeAll(toRemove);
        assertTrue(result);
        assertFalse(bag.contains("apple"));
        assertFalse(bag.contains("banana"));
        assertTrue(bag.getCount("orange") == 1);
        assertTrue(bag.size() == 1);
    }

    @Test
    void testRemoveAll_WithNonExistingElements() {
        Collection<String> toRemove = new ArrayList<>();
        toRemove.add("grape");
        toRemove.add("kiwi");
        boolean result = bag.removeAll(toRemove);
        assertFalse(result);
        assertTrue(bag.size() == 6);
    }

    @Test
    void testRemoveAll_WithEmptyCollection() {
        Collection<String> toRemove = new ArrayList<>();
        boolean result = bag.removeAll(toRemove);
        assertFalse(result);
        assertTrue(bag.size() == 6);
    }

    private static class TestMapBag extends AbstractMapBag<String> {

        private final Map<String, MutableInteger> map = new HashMap<>();

        TestMapBag() {
            super();
        }

        @Override
        protected Map<String, MutableInteger> getMap() {
            return map;
        }

        public boolean add(String item, int count) {
            MutableInteger mut = map.get(item);
            if (mut == null) {
                mut = new MutableInteger(0);
                map.put(item, mut);
            }
            mut.value += count;
            // Indicate successful addition
            return true;
        }

        public int getCount(String item) {
            MutableInteger mut = map.get(item);
            return mut == null ? 0 : mut.value;
        }

        public boolean contains(String item) {
            return map.containsKey(item);
        }
    }
}
