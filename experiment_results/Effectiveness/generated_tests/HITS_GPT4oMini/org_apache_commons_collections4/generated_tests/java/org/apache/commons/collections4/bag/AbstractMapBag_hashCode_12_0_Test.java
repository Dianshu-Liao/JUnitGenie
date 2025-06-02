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

class AbstractMapBag_hashCode_12_0_Test {

    private TestMapBag abstractMapBag;

    private static class TestMapBag extends AbstractMapBag<Object> {

        private Map<Object, MutableInteger> map = new HashMap<>();

        private int size;

        @Override
        public int size() {
            return size;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean add(Object item, int count) {
            if (item == null) {
                return false;
            }
            if (map.containsKey(item)) {
                size += count;
                map.get(item).value += count;
            } else {
                size += count;
                map.put(item, new MutableInteger(count));
            }
            return true;
        }

        @Override
        public Map<Object, MutableInteger> getMap() {
            return map;
        }
    }

    private static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    @BeforeEach
    void setUp() {
        abstractMapBag = new TestMapBag();
    }

    @Test
    void testHashCodeWithEmptyBag() {
        assertEquals(0, abstractMapBag.hashCode());
    }

    @Test
    void testHashCodeWithSingleElement() {
        abstractMapBag.add("test", 1);
        assertEquals("test".hashCode() ^ 1, abstractMapBag.hashCode());
    }

    @Test
    void testHashCodeWithMultipleElements() {
        abstractMapBag.add("test1", 1);
        abstractMapBag.add("test2", 2);
        int expectedHashCode = ("test1".hashCode() ^ 1) + ("test2".hashCode() ^ 2);
        assertEquals(expectedHashCode, abstractMapBag.hashCode());
    }
}
