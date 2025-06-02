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

public class TreeBidiMap_putAll_51_0_Test {

    private TreeBidiMap<String, Integer> bidiMap;

    @BeforeEach
    public void setUp() {
        bidiMap = new TreeBidiMap<>();
    }

    @Test
    public void testPutAll_EmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        bidiMap.putAll(emptyMap);
        assertEquals(0, bidiMap.size(), "BidiMap should be empty after putting an empty map.");
    }

    @Test
    public void testPutAll_NonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        bidiMap.putAll(map);
        assertEquals(2, bidiMap.size(), "BidiMap should contain two entries after putting a map with two entries.");
        assertEquals(1, bidiMap.get("one"), "Value for key 'one' should be 1.");
        assertEquals(2, bidiMap.get("two"), "Value for key 'two' should be 2.");
    }

    @Test
    public void testPutAll_OverwriteExistingKey() {
        bidiMap.put("one", 1);
        Map<String, Integer> map = new HashMap<>();
        // This should overwrite the existing key
        map.put("one", 2);
        bidiMap.putAll(map);
        assertEquals(1, bidiMap.size(), "BidiMap should still contain one entry after overwriting a key.");
        assertEquals(2, bidiMap.get("one"), "Value for key 'one' should now be 2 after overwrite.");
    }

    @Test
    public void testPutAll_NullKeyValue() {
        Map<String, Integer> map = new HashMap<>();
        // Testing with null key
        map.put(null, 1);
        // Testing with null value
        map.put("two", null);
        bidiMap.putAll(map);
        assertNull(bidiMap.get(null), "BidiMap should return null for null key.");
        assertNull(bidiMap.get("two"), "BidiMap should return null for key 'two' after putting a null value.");
    }

    @Test
    public void testPutAll_ConcurrentModification() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        bidiMap.putAll(map);
        assertThrows(ConcurrentModificationException.class, () -> {
            // Should not throw exception, but we can test if it handles modification
            bidiMap.putAll(map);
        });
    }
}
