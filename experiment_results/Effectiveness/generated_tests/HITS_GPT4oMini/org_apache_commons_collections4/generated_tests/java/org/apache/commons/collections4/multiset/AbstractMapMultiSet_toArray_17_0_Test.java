package org.apache.commons.collections4.multiset;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

class AbstractMapMultiSet_toArray_17_0_Test {

    private TestMapMultiSet multiSet;

    @BeforeEach
    void setUp() {
        multiSet = new TestMapMultiSet();
    }

    @Test
    void testToArrayWithLargerArray() {
        multiSet.add("A", 3);
        multiSet.add("B", 2);
        String[] expected = { "A", "A", "A", "B", "B", null, null };
        String[] result = multiSet.toArray(new String[7]);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithExactSizeArray() {
        multiSet.add("A", 2);
        multiSet.add("B", 1);
        String[] expected = { "A", "A", "B" };
        String[] result = multiSet.toArray(new String[3]);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithSmallerArray() {
        multiSet.add("A", 2);
        multiSet.add("B", 1);
        String[] expected = { "A", "A", "B" };
        String[] result = multiSet.toArray(new String[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithNullArray() {
        multiSet.add("A", 2);
        multiSet.add("B", 1);
        String[] expected = { "A", "A", "B" };
        String[] result = multiSet.toArray(null);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithEmptyMultiSet() {
        String[] expected = { null, null };
        String[] result = multiSet.toArray(new String[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithIncompatibleArrayType() {
        multiSet.add("A", 1);
        assertThrows(ArrayStoreException.class, () -> {
            Integer[] result = multiSet.toArray(new Integer[1]);
        });
    }

    private class TestMapMultiSet extends AbstractMapMultiSet<String> {

        private final Map<String, MutableInteger> map;

        public TestMapMultiSet() {
            this.map = new HashMap<>();
        }

        public int add(String element, int count) {
            map.put(element, new MutableInteger(count));
            super.setMap(map);
            // Return the count of occurrences added
            return count;
        }

        @Override
        public int size() {
            return map.values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
        }

        @Override
        protected Map<String, MutableInteger> getMap() {
            return map;
        }
    }

    private static class MutableInteger {

        int value;
    }
}
