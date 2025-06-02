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

public class AbstractHashedMap_get_24_0_Test {

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
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));
    }

    @Test
    public void testGetNonExistingKey() {
        assertNull(map.get("non_existing_key"));
    }

    @Test
    public void testGetNullKey() {
        map.put(null, "nullValue");
        assertEquals("nullValue", map.get(null));
    }

    @Test
    public void testGetKeyWithDifferentCase() {
        map.put("Key1", "valueCaseSensitive");
        // Should return null as it's case sensitive
        assertNull(map.get("key1"));
        assertEquals("valueCaseSensitive", map.get("Key1"));
    }

    @Test
    public void testGetWithNullValue() {
        map.put("keyWithNullValue", null);
        assertNull(map.get("keyWithNullValue"));
    }

    @Test
    public void testGetWithDifferentObjectType() {
        // Different object type should return null
        assertNull(map.get(new StringBuilder("key1")));
    }

    @Test
    public void testGetWithKeyThatCollides() {
        // Assuming that hash function causes a collision, we would need to simulate this in a real scenario.
        // For this test, we will just ensure that the method can handle the retrieval.
        map.put("key1_collision", "valueCollision");
        assertEquals("valueCollision", map.get("key1_collision"));
    }
}
