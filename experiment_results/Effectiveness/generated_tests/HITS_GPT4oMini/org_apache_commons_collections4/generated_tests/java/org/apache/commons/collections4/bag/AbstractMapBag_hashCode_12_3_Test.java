package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_hashCode_12_3_Test {

    private TestMapBag bag;

    @BeforeEach
    void setUp() {
        bag = new TestMapBag();
    }

    @Test
    void testHashCode() {
        bag.add("apple", 2);
        bag.add("banana", 3);
        // Total count for apple should now be 3
        bag.add("apple", 1);
        int expectedHashCode = ("apple".hashCode() ^ 3) + ("banana".hashCode() ^ 3);
        assertEquals(expectedHashCode, bag.hashCode());
    }

    private static class TestMapBag extends AbstractMapBag<String> {

        private final Map<String, MutableInteger> map = new HashMap<>();

        @Override
        public boolean add(String element, int occurrences) {
            if (occurrences <= 0) {
                return false;
            }
            MutableInteger count = map.computeIfAbsent(element, k -> new MutableInteger(0));
            // Fix: directly modify the value field
            count.value += occurrences;
            return true;
        }

        @Override
        public int size() {
            return map.values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public Iterator<String> iterator() {
            return map.keySet().iterator();
        }
    }
}
