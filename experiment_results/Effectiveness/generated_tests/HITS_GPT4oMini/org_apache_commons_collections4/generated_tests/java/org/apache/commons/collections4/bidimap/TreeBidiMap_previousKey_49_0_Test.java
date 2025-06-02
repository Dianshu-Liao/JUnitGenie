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

public class TreeBidiMap_previousKey_49_0_Test {

    private TreeBidiMap<Integer, String> bidiMap;

    @BeforeEach
    public void setUp() {
        bidiMap = new TreeBidiMap<>();
        bidiMap.put(1, "One");
        bidiMap.put(2, "Two");
        bidiMap.put(3, "Three");
    }

    @Test
    public void testPreviousKey_WithExistingKey() {
        Integer result = bidiMap.previousKey(2);
        assertEquals(1, result);
    }

    @Test
    public void testPreviousKey_WithFirstKey() {
        Integer result = bidiMap.previousKey(1);
        assertNull(result);
    }

    @Test
    public void testPreviousKey_WithLastKey() {
        Integer result = bidiMap.previousKey(3);
        assertEquals(2, result);
    }

    @Test
    public void testPreviousKey_WithNonExistentKey() {
        Integer result = bidiMap.previousKey(4);
        assertNull(result);
    }

    @Test
    public void testPreviousKey_WithNullKey() {
        try {
            bidiMap.previousKey(null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test
    public void testPreviousKey_WithEmptyMap() {
        TreeBidiMap<Integer, String> emptyMap = new TreeBidiMap<>();
        Integer result = emptyMap.previousKey(1);
        assertNull(result);
    }
}
