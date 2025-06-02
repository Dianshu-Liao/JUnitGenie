package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayDeque;
import java.util.Deque;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObjectGraphIterator_findNext_0_0_Test {

    private ObjectGraphIterator<Object> iterator;

    @BeforeEach
    void setUp() {
        // Setup code can be added here if necessary
    }

    @Test
    void testFindNextWithIterator() {
        Iterator<Object> mockIterator = Mockito.mock(Iterator.class);
        ObjectGraphIterator<Object> objectGraphIterator = new ObjectGraphIterator<>(mockIterator);
        // Simulate the behavior of the mock iterator
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn("testValue");
        objectGraphIterator.findNext(mockIterator);
        // Verify that the current value is set correctly
        assertEquals("testValue", getCurrentValue(objectGraphIterator));
        assertTrue(objectGraphIterator.hasNext());
    }

    @Test
    void testFindNextWithNonIteratorValue() {
        ObjectGraphIterator<Object> objectGraphIterator = new ObjectGraphIterator<>(Arrays.asList("test").iterator());
        objectGraphIterator.findNext("testValue");
        // Verify that the current value is set correctly
        assertEquals("testValue", getCurrentValue(objectGraphIterator));
        assertTrue(objectGraphIterator.hasNext());
    }

    @Test
    void testFindNextWithNullValue() {
        ObjectGraphIterator<Object> objectGraphIterator = new ObjectGraphIterator<>(Arrays.asList("test").iterator());
        objectGraphIterator.findNext(null);
        // Verify that the current value is set to null
        assertNull(getCurrentValue(objectGraphIterator));
        assertTrue(objectGraphIterator.hasNext());
    }

    @Test
    void testFindNextWithEmptyIterator() {
        Iterator<Object> emptyIterator = Arrays.asList().iterator();
        ObjectGraphIterator<Object> objectGraphIterator = new ObjectGraphIterator<>(emptyIterator);
        // Calling findNext on an empty iterator
        assertThrows(NoSuchElementException.class, () -> {
            objectGraphIterator.findNext(emptyIterator);
        });
    }

    @Test
    void testFindNextWithMultipleCalls() {
        Iterator<Object> mockIterator = Mockito.mock(Iterator.class);
        ObjectGraphIterator<Object> objectGraphIterator = new ObjectGraphIterator<>(mockIterator);
        // Simulate the behavior of the mock iterator
        Mockito.when(mockIterator.hasNext()).thenReturn(true, false);
        Mockito.when(mockIterator.next()).thenReturn("firstValue");
        objectGraphIterator.findNext(mockIterator);
        assertEquals("firstValue", getCurrentValue(objectGraphIterator));
        assertTrue(objectGraphIterator.hasNext());
        // Call findNext again
        objectGraphIterator.findNext(mockIterator);
        assertFalse(objectGraphIterator.hasNext());
    }

    private Object getCurrentValue(ObjectGraphIterator<Object> objectGraphIterator) {
        // Use reflection to access the private field currentValue
        try {
            java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("currentValue");
            field.setAccessible(true);
            return field.get(objectGraphIterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
