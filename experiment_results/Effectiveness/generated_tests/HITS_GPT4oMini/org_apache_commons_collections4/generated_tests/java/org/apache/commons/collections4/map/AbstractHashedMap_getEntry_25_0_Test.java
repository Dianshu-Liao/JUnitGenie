package org.apache.commons.collections4.map;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap_getEntry_25_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }

    @Test
    public void testGetEntry_existingKey() {
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry("key1");
        assertNotNull(entry);
        assertEquals("key1", entry.key);
        assertEquals("value1", entry.value);
    }

    @Test
    public void testGetEntry_nonExistingKey() {
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry("nonExistingKey");
        assertNull(entry);
    }

    @Test
    public void testGetEntry_nullKey() {
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry(null);
        assertNull(entry);
    }

    @Test
    public void testGetEntry_caseSensitivity() {
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry("KEY1");
        assertNull(entry);
    }

    @Test
    public void testGetEntry_multipleEntriesWithSameHash() {
        // Assuming this key has the same hash as key1
        map.put("key4", "value4");
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry("key4");
        assertNotNull(entry);
        assertEquals("key4", entry.key);
        assertEquals("value4", entry.value);
    }

    @Test
    public void testGetEntry_afterRemovingEntry() {
        map.remove("key2");
        AbstractHashedMap.HashEntry<String, String> entry = map.getEntry("key2");
        assertNull(entry);
    }
}
