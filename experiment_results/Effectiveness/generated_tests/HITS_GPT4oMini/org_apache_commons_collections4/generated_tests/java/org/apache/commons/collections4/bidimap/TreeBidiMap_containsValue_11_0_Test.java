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

public class TreeBidiMap_containsValue_11_0_Test {

    private TreeBidiMap<String, Integer> bidiMap;

    @BeforeEach
    public void setUp() {
        bidiMap = new TreeBidiMap<>();
        bidiMap.put("One", 1);
        bidiMap.put("Two", 2);
        bidiMap.put("Three", 3);
    }

    @Test
    public void testContainsValue_ExistingValue() {
        assertTrue(bidiMap.containsValue(2), "Should return true for existing value 2");
    }

    @Test
    public void testContainsValue_NonExistingValue() {
        assertFalse(bidiMap.containsValue(4), "Should return false for non-existing value 4");
    }

    @Test
    public void testContainsValue_NullValue() {
        assertThrows(NullPointerException.class, () -> {
            bidiMap.containsValue(null);
        }, "Should throw NullPointerException for null value");
    }

    @Test
    public void testContainsValue_EmptyMap() {
        TreeBidiMap<String, Integer> emptyBidiMap = new TreeBidiMap<>();
        assertFalse(emptyBidiMap.containsValue(1), "Should return false for any value in an empty map");
    }

    @Test
    public void testContainsValue_WithDifferentType() {
        assertFalse(bidiMap.containsValue("One"), "Should return false when checking for a String in a map of Integers");
    }

    @Test
    public void testContainsValue_MultipleEntries() {
        assertTrue(bidiMap.containsValue(1), "Should return true for existing value 1");
        assertTrue(bidiMap.containsValue(3), "Should return true for existing value 3");
        assertFalse(bidiMap.containsValue(5), "Should return false for non-existing value 5");
    }
}
