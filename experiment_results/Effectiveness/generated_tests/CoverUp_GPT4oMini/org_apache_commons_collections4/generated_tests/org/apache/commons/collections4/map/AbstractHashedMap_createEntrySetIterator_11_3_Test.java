package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import java.lang.reflect.Method;
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
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap_createEntrySetIterator_11_3_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<String, String>() {
        };
    }

    @Test
    public void testCreateEntrySetIterator_EmptyMap() throws Exception {
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator(map);
        assertTrue(iterator instanceof EmptyIterator);
    }

    @Test
    public void testCreateEntrySetIterator_NonEmptyMap() throws Exception {
        // Add an entry to the map
        map.put("key1", "value1");
        // Invoke the method
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator(map);
        // Check if the iterator is not empty
        assertTrue(iterator.hasNext());
    }

    private Iterator<Map.Entry<String, String>> invokeCreateEntrySetIterator(AbstractHashedMap<String, String> map) throws Exception {
        Method method = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
        method.setAccessible(true);
        return (Iterator<Map.Entry<String, String>>) method.invoke(map);
    }
}
