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

public class TreeBidiMap_doRemoveValue_20_0_Test {

    private TreeBidiMap<String, Integer> bidiMap;

    @BeforeEach
    public void setUp() {
        bidiMap = new TreeBidiMap<>();
        bidiMap.put("One", 1);
        bidiMap.put("Two", 2);
        bidiMap.put("Three", 3);
    }

    @Test
    public void testRemoveValue_ExistingValue() {
        String removedKey = bidiMap.removeValue(2);
        assertEquals("Two", removedKey);
    }

    @Test
    public void testRemoveValue_NonExistingValue() {
        String removedKey = bidiMap.removeValue(4);
        assertNull(removedKey);
    }

    @Test
    public void testRemoveValue_MultipleRemovals() {
        String firstRemovedKey = bidiMap.removeValue(1);
        assertEquals("One", firstRemovedKey);
        String secondRemovedKey = bidiMap.removeValue(3);
        assertEquals("Three", secondRemovedKey);
        String thirdRemovedKey = bidiMap.removeValue(2);
        assertEquals("Two", thirdRemovedKey);
        // Should be null after removal
        assertNull(bidiMap.removeValue(1));
    }

    @Test
    public void testRemoveValue_EmptyMap() {
        TreeBidiMap<String, Integer> emptyMap = new TreeBidiMap<>();
        String removedKey = emptyMap.removeValue(1);
        assertNull(removedKey);
    }

    @Test
    public void testRemoveValue_NullValue() {
        String removedKey = bidiMap.removeValue(null);
        assertNull(removedKey);
    }
}
