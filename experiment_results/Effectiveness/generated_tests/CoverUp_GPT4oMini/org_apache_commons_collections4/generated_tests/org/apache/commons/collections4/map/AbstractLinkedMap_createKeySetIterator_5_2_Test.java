package org.apache.commons.collections4.map;

import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

class AbstractLinkedMap_createKeySetIterator_5_2_Test {

    private AbstractLinkedMap<String, String> abstractLinkedMap;

    @BeforeEach
    void setUp() {
        // Create an anonymous subclass of AbstractLinkedMap for testing
        abstractLinkedMap = new AbstractLinkedMap<String, String>() {

            @Override
            public boolean isEmpty() {
                return header == null;
            }
        };
    }

    @Test
    void testCreateKeySetIterator_EmptyMap() {
        // Test the createKeySetIterator method when the map is empty
        Iterator<String> iterator = invokeCreateKeySetIterator(abstractLinkedMap);
        assertTrue(iterator instanceof EmptyOrderedIterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCreateKeySetIterator_NonEmptyMap() {
        // Populate the map with a test entry
        abstractLinkedMap.put("key1", "value1");
        // Test the createKeySetIterator method when the map is not empty
        Iterator<String> iterator = invokeCreateKeySetIterator(abstractLinkedMap);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("key1", iterator.next());
    }

    private Iterator<String> invokeCreateKeySetIterator(AbstractLinkedMap<String, String> map) {
        try {
            Method method = AbstractLinkedMap.class.getDeclaredMethod("createKeySetIterator");
            method.setAccessible(true);
            return (Iterator<String>) method.invoke(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
