package org.apache.commons.collections4.bidimap;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

class TreeBidiMap_doEquals_13_1_Test {

    private TreeBidiMap<String, String> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
        treeBidiMap.put("key1", "value1");
        treeBidiMap.put("key2", "value2");
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(treeBidiMap.equals(treeBidiMap));
    }

    @Test
    void testEquals_NonMapObject() {
        assertFalse(treeBidiMap.equals(new Object()));
    }

    @Test
    void testEquals_DifferentSize() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        assertFalse(treeBidiMap.equals(otherMap));
    }

    @Test
    void testEquals_DifferentValues() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "differentValue");
        otherMap.put("key2", "value2");
        assertFalse(treeBidiMap.equals(otherMap));
    }

    @Test
    void testEquals_SameValues() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        otherMap.put("key2", "value2");
        assertTrue(treeBidiMap.equals(otherMap));
    }

    @Test
    void testEquals_WithNullValueInMap() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", null);
        otherMap.put("key2", "value2");
        treeBidiMap.put("key1", null);
        assertTrue(treeBidiMap.equals(otherMap));
    }

    @Test
    void testEquals_ThrowsException() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        otherMap.put("key2", "value2");
        treeBidiMap.put("key3", null);
        assertFalse(treeBidiMap.equals(otherMap));
    }
}
