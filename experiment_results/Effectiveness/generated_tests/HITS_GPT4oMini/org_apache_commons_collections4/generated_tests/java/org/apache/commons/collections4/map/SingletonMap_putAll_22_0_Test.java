package org.apache.commons.collections4.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap_putAll_22_0_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    public void setUp() {
        singletonMap = new SingletonMap<>("key", "value");
    }

    @Test
    public void testPutAll_EmptyMap() {
        Map<String, String> emptyMap = Collections.emptyMap();
        singletonMap.putAll(emptyMap);
        assertEquals("value", singletonMap.getValue(), "Value should remain unchanged when putting an empty map");
    }

    @Test
    public void testPutAll_SingleEntryMap() {
        Map<String, String> singleEntryMap = Collections.singletonMap("key", "newValue");
        singletonMap.putAll(singleEntryMap);
        assertEquals("newValue", singletonMap.getValue(), "Value should be updated to new value from single entry map");
    }

    @Test
    public void testPutAll_MultipleEntriesMap() {
        Map<String, String> multipleEntriesMap = new HashMap<>();
        multipleEntriesMap.put("key1", "value1");
        multipleEntriesMap.put("key2", "value2");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            singletonMap.putAll(multipleEntriesMap);
        });
        assertEquals("The map size must be 0 or 1", exception.getMessage(), "Should throw an exception for multiple entries");
    }

    @Test
    public void testPutAll_NullMap() {
        assertThrows(NullPointerException.class, () -> {
            singletonMap.putAll(null);
        }, "Should throw NullPointerException when putting a null map");
    }
}
