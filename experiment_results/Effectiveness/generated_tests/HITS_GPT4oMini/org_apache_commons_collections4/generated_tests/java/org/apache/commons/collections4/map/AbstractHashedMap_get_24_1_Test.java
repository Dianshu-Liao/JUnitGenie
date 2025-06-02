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

public class AbstractHashedMap_get_24_1_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }

    @Test
    public void testGetExistingKey() {
        String value = map.get("key1");
        assertEquals("value1", value, "The value for 'key1' should be 'value1'");
    }

    @Test
    public void testGetNonExistingKey() {
        String value = map.get("key4");
        assertNull(value, "The value for a non-existing key should be null");
    }

    @Test
    public void testGetNullKey() {
        map.put(null, "valueNull");
        String value = map.get(null);
        assertEquals("valueNull", value, "The value for null key should be 'valueNull'");
    }

    @Test
    public void testGetKeyWithDifferentHashCode() {
        // Assuming that key1 and key2 produce different hash codes
        String value = map.get("key2");
        assertEquals("value2", value, "The value for 'key2' should be 'value2'");
    }

    @Test
    public void testGetAfterRemove() {
        map.remove("key3");
        String value = map.get("key3");
        assertNull(value, "The value for 'key3' after removal should be null");
    }

    @Test
    public void testGetWithModifiedKey() {
        // Same content, different object
        String modifiedKey = new String("key1");
        String value = map.get(modifiedKey);
        assertEquals("value1", value, "The value for 'key1' should be 'value1' even with a modified key");
    }

    @Test
    public void testGetWithDifferentKeyType() {
        // Testing with an Integer instead of String
        String value = map.get((Object) 123);
        assertNull(value, "The value for a key of different type should be null");
    }
}
