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
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap_putAll_17_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        listOrderedMap.putAll(emptyMap);
        assertEquals(0, listOrderedMap.size());
    }

    @Test
    public void testPutAllWithSingleEntry() {
        Map<String, Integer> singleEntryMap = new HashMap<>();
        singleEntryMap.put("one", 1);
        listOrderedMap.putAll(singleEntryMap);
        assertEquals(1, listOrderedMap.size());
        assertEquals(Integer.valueOf(1), listOrderedMap.get("one"));
    }

    @Test
    public void testPutAllWithMultipleEntries() {
        Map<String, Integer> multipleEntriesMap = new HashMap<>();
        multipleEntriesMap.put("one", 1);
        multipleEntriesMap.put("two", 2);
        listOrderedMap.putAll(multipleEntriesMap);
        assertEquals(2, listOrderedMap.size());
        assertEquals(Integer.valueOf(1), listOrderedMap.get("one"));
        assertEquals(Integer.valueOf(2), listOrderedMap.get("two"));
    }

    @Test
    public void testPutAllWithDuplicateKeys() {
        Map<String, Integer> duplicateKeysMap = new HashMap<>();
        duplicateKeysMap.put("one", 1);
        // This will overwrite the previous value
        duplicateKeysMap.put("one", 2);
        listOrderedMap.putAll(duplicateKeysMap);
        assertEquals(1, listOrderedMap.size());
        assertEquals(Integer.valueOf(2), listOrderedMap.get("one"));
    }

    @Test
    public void testPutAllWithNullValues() {
        Map<String, Integer> nullValueMap = new HashMap<>();
        nullValueMap.put("one", null);
        listOrderedMap.putAll(nullValueMap);
        assertEquals(1, listOrderedMap.size());
        assertNull(listOrderedMap.get("one"));
    }

    @Test
    public void testPutAllWithNullMap() {
        assertThrows(NullPointerException.class, () -> {
            listOrderedMap.putAll(null);
        });
    }
}
