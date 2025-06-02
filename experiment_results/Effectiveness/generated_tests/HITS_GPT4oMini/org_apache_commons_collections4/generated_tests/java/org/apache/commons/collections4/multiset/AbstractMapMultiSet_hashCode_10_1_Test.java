package org.apache.commons.collections4.multiset;

import java.util.HashMap;
import java.util.Iterator;
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
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

class AbstractMapMultiSet_hashCode_10_1_Test extends AbstractMapMultiSet<String> {

    private Map<String, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        setMap(map);
    }

    protected void setMap(Map<String, MutableInteger> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }

    @Test
    void testHashCode_emptyMap() {
        assertEquals(0, hashCode());
    }

    @Test
    void testHashCode_singleElement() {
        map.put("A", new MutableInteger(1));
        assertEquals("A".hashCode() ^ 1, hashCode());
    }

    @Test
    void testHashCode_multipleElements() {
        map.put("A", new MutableInteger(1));
        map.put("B", new MutableInteger(2));
        int expectedHashCode = ("A".hashCode() ^ 1) + ("B".hashCode() ^ 2);
        assertEquals(expectedHashCode, hashCode());
    }

    @Test
    void testHashCode_nullElement() {
        map.put(null, new MutableInteger(1));
        assertEquals(0 ^ 1, hashCode());
    }

    @Test
    void testHashCode_differentCount() {
        map.put("A", new MutableInteger(1));
        // should update the count
        map.put("A", new MutableInteger(2));
        assertEquals("A".hashCode() ^ 2, hashCode());
    }

    @Test
    void testHashCode_differentElements() {
        map.put("A", new MutableInteger(1));
        map.put("B", new MutableInteger(1));
        int expectedHashCode = ("A".hashCode() ^ 1) + ("B".hashCode() ^ 1);
        assertEquals(expectedHashCode, hashCode());
    }

    @Test
    void testHashCode_differentInstances() {
        Map<String, MutableInteger> map1 = new HashMap<>();
        map1.put("A", new MutableInteger(1));
        Map<String, MutableInteger> map2 = new HashMap<>();
        map2.put("A", new MutableInteger(1));
        setMap(map1);
        int hash1 = hashCode();
        setMap(map2);
        int hash2 = hashCode();
        assertEquals(hash1, hash2);
    }
}
