package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractLinkedMap;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import java.lang.reflect.Method;
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

class AbstractLinkedMap_createKeySetIterator_5_3_Test {

    private AbstractLinkedMap<String, String> abstractLinkedMap;

    // Concrete implementation of AbstractLinkedMap for testing purposes
    private static class TestLinkedMap extends AbstractLinkedMap<String, String> {

        public TestLinkedMap() {
            super();
        }
    }

    @BeforeEach
    void setUp() {
        abstractLinkedMap = new TestLinkedMap();
    }

    @Test
    void testCreateKeySetIterator_EmptyMap() throws Exception {
        // Invoke the createKeySetIterator method using reflection
        Method method = AbstractLinkedMap.class.getDeclaredMethod("createKeySetIterator");
        method.setAccessible(true);
        Iterator<String> iterator = (Iterator<String>) method.invoke(abstractLinkedMap);
        // Verify that the iterator is an instance of EmptyOrderedIterator
        assertNotNull(iterator);
        assertTrue(iterator instanceof EmptyOrderedIterator);
    }

    @Test
    void testCreateKeySetIterator_NonEmptyMap() throws Exception {
        // Add a method to simulate adding elements to the map (not implemented in AbstractLinkedMap)
        // For testing, we would need to implement the methods to add elements, but since we don't have them,
        // we will create a subclass that allows adding elements.
        // Assume put method exists in the concrete class
        abstractLinkedMap.put("key1", "value1");
        // Invoke the createKeySetIterator method using reflection
        Method method = AbstractLinkedMap.class.getDeclaredMethod("createKeySetIterator");
        method.setAccessible(true);
        Iterator<String> iterator = (Iterator<String>) method.invoke(abstractLinkedMap);
        // Verify that the iterator is not empty
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
    }
}
