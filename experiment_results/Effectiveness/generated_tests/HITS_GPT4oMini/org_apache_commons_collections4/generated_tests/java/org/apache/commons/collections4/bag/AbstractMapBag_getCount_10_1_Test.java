package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
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
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_getCount_10_1_Test {

    private AbstractMapBag<Integer> bag;

    // Mock implementation of AbstractMapBag to test the getCount method
    private class TestMapBag extends AbstractMapBag<Integer> {

        private final Map<Integer, MutableInteger> map;

        public TestMapBag(Map<Integer, MutableInteger> map) {
            super();
            this.map = map;
        }

        @Override
        public int getCount(final Object object) {
            final MutableInteger count = map.get(object);
            if (count != null) {
                return count.value;
            }
            return 0;
        }
    }

    @BeforeEach
    void setUp() {
        // Set up a map with some initial counts
        Map<Integer, AbstractMapBag.MutableInteger> map = new HashMap<>();
        map.put(1, new AbstractMapBag.MutableInteger(5));
        map.put(2, new AbstractMapBag.MutableInteger(3));
        map.put(3, new AbstractMapBag.MutableInteger(0));
        bag = new TestMapBag(map);
    }

    @Test
    void testGetCount_existingKey() {
        // Test for an existing key
        assertEquals(5, bag.getCount(1), "Count for key 1 should be 5");
        assertEquals(3, bag.getCount(2), "Count for key 2 should be 3");
    }

    @Test
    void testGetCount_zeroCount() {
        // Test for a key with a count of zero
        assertEquals(0, bag.getCount(3), "Count for key 3 should be 0");
    }

    @Test
    void testGetCount_nonExistingKey() {
        // Test for a non-existing key
        assertEquals(0, bag.getCount(4), "Count for non-existing key 4 should be 0");
    }

    @Test
    void testGetCount_nullKey() {
        // Test for null key
        assertEquals(0, bag.getCount(null), "Count for null key should be 0");
    }
}
