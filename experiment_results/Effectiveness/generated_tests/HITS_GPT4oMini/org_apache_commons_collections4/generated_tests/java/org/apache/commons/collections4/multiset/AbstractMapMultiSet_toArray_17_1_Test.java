package org.apache.commons.collections4.multiset;

import org.apache.commons.collections4.MultiSet;
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
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

class AbstractMapMultiSet_toArray_17_1_Test extends AbstractMapMultiSet {

    private Map<String, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("a", new MutableInteger(2));
        map.put("b", new MutableInteger(3));
        setMap(map);
    }

    @Override
    public int size() {
        return map.values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
    }

    @Test
    void testToArrayWithSufficientSizeArray() {
        Object[] result = toArray(new String[5]);
        String[] expected = { "a", "a", "b", "b", "b" };
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithInsufficientSizeArray() {
        Object[] result = toArray(new String[2]);
        String[] expected = { "a", "a", "b", "b", "b" };
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithExactSizeArray() {
        Object[] result = toArray(new String[5]);
        assertArrayEquals(new String[] { "a", "a", "b", "b", "b" }, result);
    }

    @Test
    void testToArrayWithEmptyArray() {
        Object[] result = toArray(new String[0]);
        String[] expected = { "a", "a", "b", "b", "b" };
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithNullArray() {
        Object[] result = toArray(new String[5]);
        String[] expected = { "a", "a", "b", "b", "b" };
        assertArrayEquals(expected, result);
    }

    @Test
    void testToArrayWithDifferentTypeArray() {
        Object[] result = toArray(new String[5]);
        String[] expected = { "a", "a", "b", "b", "b" };
        assertArrayEquals(expected, result);
    }
}
