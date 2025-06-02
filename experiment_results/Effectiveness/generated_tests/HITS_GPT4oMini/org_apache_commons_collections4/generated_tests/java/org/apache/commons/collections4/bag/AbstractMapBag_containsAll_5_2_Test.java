package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_containsAll_5_2_Test {

    private class TestBag extends AbstractMapBag<Object> {

        TestBag(Map<Object, MutableInteger> map) {
            super(map);
        }

        @Override
        public boolean add(Object object) {
            // Implementation for adding an object (not needed for this test)
            return false;
        }

        @Override
        public boolean remove(Object object) {
            // Implementation for removing an object (not needed for this test)
            return false;
        }

        @Override
        public Set<Object> uniqueSet() {
            return getMap().keySet();
        }
    }

    private TestBag bag1;

    private TestBag bag2;

    @BeforeEach
    void setUp() {
        Map<Object, MutableInteger> map1 = new HashMap<>();
        map1.put("A", new MutableInteger(2));
        map1.put("B", new MutableInteger(3));
        bag1 = new TestBag(map1);
        Map<Object, MutableInteger> map2 = new HashMap<>();
        map2.put("A", new MutableInteger(1));
        map2.put("B", new MutableInteger(3));
        bag2 = new TestBag(map2);
    }

    @Test
    void testContainsAll() {
        assertTrue(bag1.containsAll(bag2), "bag1 should contain all elements of bag2");
    }

    @Test
    void testDoesNotContainAll() {
        Map<Object, MutableInteger> map3 = new HashMap<>();
        map3.put("A", new MutableInteger(2));
        // bag1 has 3, not 4
        map3.put("B", new MutableInteger(4));
        TestBag bag3 = new TestBag(map3);
        assertFalse(bag1.containsAll(bag3), "bag1 should not contain all elements of bag3");
    }
}
