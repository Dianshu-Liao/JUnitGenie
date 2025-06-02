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

class AbstractMapMultiSet_toArray_16_3_Test extends AbstractMapMultiSet<String> {

    private Map<String, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("apple", new MutableInteger(2));
        map.put("banana", new MutableInteger(3));
        setMap(map);
    }

    @Test
    void testToArray() {
        Object[] expected = new Object[] { "apple", "apple", "banana", "banana", "banana" };
        Object[] actual = toArray();
        assertArrayEquals(expected, actual);
    }
}
