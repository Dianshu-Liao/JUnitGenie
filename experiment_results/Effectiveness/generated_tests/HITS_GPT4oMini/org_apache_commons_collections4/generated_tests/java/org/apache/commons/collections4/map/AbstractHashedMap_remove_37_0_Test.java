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
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap_remove_37_0_Test {

    private AbstractHashedMap<Integer, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
    }

    @Test
    public void testRemoveExistingKey() {
        String removedValue = map.remove(2);
        assertEquals("Two", removedValue);
        // Verify the key is removed
        assertNull(map.get(2));
    }

    @Test
    public void testRemoveNonExistingKey() {
        String removedValue = map.remove(4);
        // Verify that removing a non-existing key returns null
        assertNull(removedValue);
    }

    @Test
    public void testRemoveNullKey() {
        map.put(null, "NullValue");
        String removedValue = map.remove(null);
        assertEquals("NullValue", removedValue);
        // Verify the null key is removed
        assertNull(map.get(null));
    }

    @Test
    public void testRemoveKeyAfterMultipleRemovals() {
        map.remove(1);
        map.remove(2);
        String removedValue = map.remove(3);
        assertEquals("Three", removedValue);
        // Verify the key is removed
        assertNull(map.get(3));
    }

    @Test
    public void testRemoveKeyFromEmptyMap() {
        AbstractHashedMap<Integer, String> emptyMap = new AbstractHashedMap<>(16, 0.75f);
        String removedValue = emptyMap.remove(1);
        // Verify that removing from an empty map returns null
        assertNull(removedValue);
    }

    @Test
    public void testRemoveKeyWithCollisions() {
        // Assuming hash collisions, we will add elements that collide
        // Assuming this collides with key 1
        map.put(17, "Seventeen");
        String removedValue = map.remove(1);
        assertEquals("One", removedValue);
        // Verify the key is removed
        assertNull(map.get(1));
    }

    @Test
    public void testRemoveWithConcurrentModification() {
        assertThrows(ConcurrentModificationException.class, () -> {
            map.remove(1);
            // Modifying the map after removal
            map.put(4, "Four");
            // This should throw ConcurrentModificationException
            map.remove(2);
        });
    }
}
