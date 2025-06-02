package org.apache.commons.collections4.multiset;

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
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

class AbstractMapMultiSet_hashCode_10_0_Test {

    private AbstractMapMultiSet<String> multiSet;

    @BeforeEach
    void setUp() {
        multiSet = new AbstractMapMultiSet<String>() {

            private final Map<String, MutableInteger> map = new HashMap<>();

            public int size() {
                return map.values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
            }

            public boolean isEmpty() {
                return map.isEmpty();
            }

            public boolean contains(Object o) {
                return map.containsKey(o);
            }

            public Iterator<String> iterator() {
                return map.keySet().iterator();
            }

            public int count(Object element) {
                MutableInteger count = map.get(element);
                return count == null ? 0 : count.value;
            }

            public int add(String element, int count) {
                MutableInteger currentCount = map.get(element);
                if (currentCount == null) {
                    currentCount = new MutableInteger(0);
                    map.put(element, currentCount);
                }
                currentCount.value += count;
                return currentCount.value;
            }

            class MutableInteger {

                int value;

                MutableInteger(int value) {
                    this.value = value;
                }
            }
        };
    }

    @Test
    void testHashCode_EmptyMap() {
        int result = multiSet.hashCode();
        assertEquals(0, result);
    }

    @Test
    void testHashCode_NullElement() {
        multiSet.add(null, 5);
        int result = multiSet.hashCode();
        assertEquals(5, result);
    }

    @Test
    void testHashCode_ValidEntries() {
        multiSet.add("A", 1);
        multiSet.add("B", 2);
        int result = multiSet.hashCode();
        int expectedHashCode = "A".hashCode() ^ 1 + "B".hashCode() ^ 2;
        assertEquals(expectedHashCode, result);
    }
}
