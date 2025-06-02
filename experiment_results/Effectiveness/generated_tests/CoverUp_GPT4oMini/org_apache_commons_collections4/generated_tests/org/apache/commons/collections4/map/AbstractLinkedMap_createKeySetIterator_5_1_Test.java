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

class AbstractLinkedMap_createKeySetIterator_5_1_Test {

    private AbstractLinkedMap<String, String> abstractLinkedMap;

    @BeforeEach
    void setUp() {
        abstractLinkedMap = new AbstractLinkedMap<String, String>() {

            @Override
            public boolean isEmpty() {
                return header == null;
            }
        };
    }

    @Test
    void testCreateKeySetIterator_EmptyMap() {
        Iterator<String> iterator = invokeCreateKeySetIterator(abstractLinkedMap);
        assertTrue(iterator instanceof EmptyOrderedIterator);
    }

    @Test
    void testCreateKeySetIterator_NonEmptyMap() {
        addEntryToMap(abstractLinkedMap, "key1", "value1");
        addEntryToMap(abstractLinkedMap, "key2", "value2");
        Iterator<String> iterator = invokeCreateKeySetIterator(abstractLinkedMap);
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("key1", iterator.next());
        assertEquals("key2", iterator.next());
        assertFalse(iterator.hasNext());
    }

    private void addEntryToMap(AbstractLinkedMap<String, String> map, String key, String value) {
        try {
            Method putMethod = map.getClass().getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(map, key, value);
        } catch (Exception e) {
            fail("Failed to add entry to map: " + e.getMessage());
        }
    }

    private Iterator<String> invokeCreateKeySetIterator(AbstractLinkedMap<String, String> map) {
        try {
            Method createKeySetIteratorMethod = AbstractLinkedMap.class.getDeclaredMethod("createKeySetIterator");
            createKeySetIteratorMethod.setAccessible(true);
            return (Iterator<String>) createKeySetIteratorMethod.invoke(map);
        } catch (Exception e) {
            fail("Failed to invoke createKeySetIterator: " + e.getMessage());
            // This line will never be reached due to fail()
            return null;
        }
    }
}
