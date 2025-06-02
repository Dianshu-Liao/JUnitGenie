package org.apache.commons.collections4.map;

import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

class AbstractLinkedMap_createKeySetIterator_5_0_Test {

    private AbstractLinkedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractLinkedMap<String, String>() {

            // Implementing the abstract class to create a concrete instance for testing
            @Override
            public boolean isEmpty() {
                return size == 0;
            }
        };
    }

    @Test
    void testCreateKeySetIterator_EmptyMap() {
        // Test when the map is empty
        Iterator<String> iterator = map.createKeySetIterator();
        assertNotNull(iterator, "Iterator should not be null");
        assertTrue(iterator instanceof EmptyOrderedIterator, "Iterator should be an instance of EmptyOrderedIterator");
    }

    @Test
    void testCreateKeySetIterator_NonEmptyMap() {
        // Adding an entry to the map
        map.put("key1", "value1");
        map.put("key2", "value2");
        // Test when the map is non-empty
        Iterator<String> iterator = map.createKeySetIterator();
        assertNotNull(iterator, "Iterator should not be null");
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals("key1", iterator.next(), "First key should be 'key1'");
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals("key2", iterator.next(), "Second key should be 'key2'");
        assertFalse(iterator.hasNext(), "Iterator should not have more elements");
    }
}
