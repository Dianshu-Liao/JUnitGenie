package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.HashBag;
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

class AbstractMapBag_retainAll_18_1_Test {

    private AbstractMapBag<String> bag1;

    private AbstractMapBag<String> bag2;

    @BeforeEach
    void setUp() {
        Map<String, MutableInteger> map1 = new HashMap<>();
        map1.put("apple", new MutableInteger(5));
        map1.put("banana", new MutableInteger(3));
        bag1 = new TestMapBag(map1);
        Map<String, MutableInteger> map2 = new HashMap<>();
        map2.put("apple", new MutableInteger(2));
        map2.put("orange", new MutableInteger(1));
        bag2 = new TestMapBag(map2);
    }

    @Test
    void testRetainAllWithNoCommonElements() {
        Map<String, MutableInteger> map3 = new HashMap<>();
        map3.put("grape", new MutableInteger(1));
        AbstractMapBag<String> bag3 = new TestMapBag(map3);
        boolean result = bag1.retainAll(bag3);
        assertFalse(result);
        assertEquals(5, bag1.getCount("apple"));
        assertEquals(3, bag1.getCount("banana"));
    }

    @Test
    void testRetainAllWithPartialOverlap() {
        boolean result = bag1.retainAll(bag2);
        assertTrue(result);
        assertEquals(3, bag1.getCount("apple"));
        assertEquals(3, bag1.getCount("banana"));
        assertEquals(0, bag1.getCount("orange"));
    }

    @Test
    void testRetainAllWithAllElementsRemoved() {
        Map<String, MutableInteger> map4 = new HashMap<>();
        map4.put("apple", new MutableInteger(6));
        AbstractMapBag<String> bag4 = new TestMapBag(map4);
        boolean result = bag1.retainAll(bag4);
        assertTrue(result);
        assertEquals(0, bag1.getCount("banana"));
        assertEquals(0, bag1.getCount("apple"));
    }

    @Test
    void testRetainAllWithEmptyBag() {
        AbstractMapBag<String> emptyBag = new TestMapBag(new HashMap<>());
        boolean result = bag1.retainAll(emptyBag);
        assertTrue(result);
        assertEquals(0, bag1.getCount("apple"));
        assertEquals(0, bag1.getCount("banana"));
    }

    private static class TestMapBag extends AbstractMapBag<String> {

        TestMapBag(Map<String, MutableInteger> map) {
            super(map);
        }
    }
}
