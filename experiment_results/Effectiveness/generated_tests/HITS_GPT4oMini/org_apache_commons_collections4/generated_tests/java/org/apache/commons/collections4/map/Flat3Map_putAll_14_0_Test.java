package org.apache.commons.collections4.map;

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
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class Flat3Map_putAll_14_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    void testPutAllWithEmptyMap() {
        Map<String, String> emptyMap = new HashMap<>();
        flat3Map.putAll(emptyMap);
        assertEquals(0, flat3Map.size());
    }

    @Test
    void testPutAllWithLessThanFourEntries() {
        Map<String, String> smallMap = new HashMap<>();
        smallMap.put("key1", "value1");
        smallMap.put("key2", "value2");
        flat3Map.putAll(smallMap);
        assertEquals(2, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
    }

    @Test
    void testPutAllWithExactlyThreeEntries() {
        Map<String, String> threeEntriesMap = new HashMap<>();
        threeEntriesMap.put("key1", "value1");
        threeEntriesMap.put("key2", "value2");
        threeEntriesMap.put("key3", "value3");
        flat3Map.putAll(threeEntriesMap);
        assertEquals(3, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
    }

    @Test
    void testPutAllWithMoreThanThreeEntries() {
        Map<String, String> largeMap = new HashMap<>();
        largeMap.put("key1", "value1");
        largeMap.put("key2", "value2");
        largeMap.put("key3", "value3");
        largeMap.put("key4", "value4");
        flat3Map.putAll(largeMap);
        assertEquals(4, flat3Map.size());
        assertEquals("value1", flat3Map.put("key1", "value1"));
        assertEquals("value2", flat3Map.put("key2", "value2"));
        assertEquals("value3", flat3Map.put("key3", "value3"));
        assertEquals("value4", flat3Map.put("key4", "value4"));
    }

    @Test
    void testPutAllWithNullKeysAndValues() {
        Map<String, String> nullMap = new HashMap<>();
        nullMap.put(null, "value1");
        nullMap.put("key2", null);
        flat3Map.putAll(nullMap);
        assertEquals(2, flat3Map.size());
        assertNull(flat3Map.put("key2", null));
        assertEquals("value1", flat3Map.put(null, "value1"));
    }

    @Test
    void testPutAllWithDuplicateKeys() {
        Map<String, String> duplicateKeysMap = new HashMap<>();
        duplicateKeysMap.put("key1", "value1");
        // Duplicate key
        duplicateKeysMap.put("key1", "value2");
        flat3Map.putAll(duplicateKeysMap);
        assertEquals(1, flat3Map.size());
        assertEquals("value2", flat3Map.put("key1", "value2"));
    }
}
