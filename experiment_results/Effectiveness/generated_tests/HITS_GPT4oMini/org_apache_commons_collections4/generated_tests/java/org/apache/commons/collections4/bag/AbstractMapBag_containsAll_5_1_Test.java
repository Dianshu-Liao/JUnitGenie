package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
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

class AbstractMapBag_containsAll_5_1_Test {

    private TestMapBag bag1;

    private TestMapBag bag2;

    @BeforeEach
    void setUp() {
        bag1 = new TestMapBag();
        bag2 = new TestMapBag();
    }

    @Test
    void testContainsAll_WhenBag1ContainsAllElementsOfBag2() {
        bag1.add("apple", 3);
        bag1.add("banana", 2);
        bag2.add("apple", 2);
        bag2.add("banana", 2);
        assertTrue(bag1.containsAll(bag2));
    }

    @Test
    void testContainsAll_WhenBag1DoesNotContainAllElementsOfBag2() {
        bag1.add("apple", 1);
        bag2.add("apple", 1);
        bag2.add("banana", 1);
        assertFalse(bag1.containsAll(bag2));
    }

    @Test
    void testContainsAll_WhenBag1ContainsInsufficientCountOfElementInBag2() {
        bag1.add("apple", 1);
        bag1.add("banana", 2);
        bag2.add("apple", 2);
        bag2.add("banana", 1);
        assertFalse(bag1.containsAll(bag2));
    }

    @Test
    void testContainsAll_WhenBothBagsAreEmpty() {
        assertTrue(bag1.containsAll(bag2));
    }

    @Test
    void testContainsAll_WhenBag2IsEmpty() {
        bag1.add("apple", 3);
        bag1.add("banana", 2);
        assertTrue(bag1.containsAll(bag2));
    }

    // A simple implementation of AbstractMapBag for testing purposes
    private static class TestMapBag extends AbstractMapBag<String> {

        private final Map<String, MutableInteger> map = new HashMap<>();

        protected TestMapBag() {
            super();
        }

        @Override
        public int getCount(final Object object) {
            final MutableInteger count = map.get(object);
            return count != null ? count.value : 0;
        }

        public boolean add(String element, int count) {
            map.put(element, new MutableInteger(count));
            // Assuming the add operation is always successful
            return true;
        }

        @Override
        protected Map<String, MutableInteger> getMap() {
            return map;
        }

        @Override
        public Set<String> uniqueSet() {
            return map.keySet();
        }
    }

    private static class MutableInteger {

        int value;
    }
}
