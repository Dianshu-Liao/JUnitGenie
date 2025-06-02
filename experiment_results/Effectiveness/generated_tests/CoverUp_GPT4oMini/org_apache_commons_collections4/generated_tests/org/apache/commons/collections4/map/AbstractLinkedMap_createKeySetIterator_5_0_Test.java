package org.apache.commons.collections4.map;

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

class AbstractLinkedMap_createKeySetIterator_5_0_Test {

    private AbstractLinkedMap<String, String> abstractLinkedMap;

    @BeforeEach
    void setUp() {
        abstractLinkedMap = new AbstractLinkedMap<String, String>() {

            @Override
            public boolean isEmpty() {
                // Assuming header is null when empty
                return header == null;
            }
        };
    }

    @Test
    void testCreateKeySetIterator_Empty() throws Exception {
        // Arrange
        Iterator<String> iterator = invokeCreateKeySetIterator();
        // Act & Assert
        assertTrue(iterator instanceof EmptyOrderedIterator);
    }

    @Test
    void testCreateKeySetIterator_NotEmpty() throws Exception {
        // Arrange
        abstractLinkedMap.put("key1", "value1");
        abstractLinkedMap.put("key2", "value2");
        // Act
        Iterator<String> iterator = invokeCreateKeySetIterator();
        // Assert
        assertTrue(iterator.hasNext());
        assertSame("key1", iterator.next());
        assertTrue(iterator.hasNext());
        assertSame("key2", iterator.next());
        assertFalse(iterator.hasNext());
    }

    private Iterator<String> invokeCreateKeySetIterator() throws Exception {
        Method method = AbstractLinkedMap.class.getDeclaredMethod("createKeySetIterator");
        method.setAccessible(true);
        return (Iterator<String>) method.invoke(abstractLinkedMap);
    }
}
