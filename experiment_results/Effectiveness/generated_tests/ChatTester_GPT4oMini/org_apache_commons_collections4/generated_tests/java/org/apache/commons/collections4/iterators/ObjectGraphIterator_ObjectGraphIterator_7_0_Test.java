package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Transformer;

class ObjectGraphIterator_ObjectGraphIterator_7_0_Test {

    private ObjectGraphIterator<String> iterator;

    @BeforeEach
    void setUp() {
        List<String> elements = Arrays.asList("A", "B", "C");
        Iterator<String> rootIterator = elements.iterator();
        iterator = new ObjectGraphIterator<>(rootIterator);
    }

    @Test
    void testObjectGraphIteratorInitialization() {
        // Verify that the currentIterator is initialized correctly
        assertNotNull(iterator);
        // Use reflection to access the private field currentIterator
        try {
            java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("currentIterator");
            field.setAccessible(true);
            Iterator<?> currentIterator = (Iterator<?>) field.get(iterator);
            assertNotNull(currentIterator);
            assertTrue(currentIterator.hasNext());
            assertEquals("A", currentIterator.next());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testObjectGraphIteratorWithEmptyIterator() {
        Iterator<String> emptyIterator = new ArrayList<String>().iterator();
        ObjectGraphIterator<String> emptyGraphIterator = new ObjectGraphIterator<>(emptyIterator);
        // Use reflection to access the private field currentIterator
        try {
            java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("currentIterator");
            field.setAccessible(true);
            Iterator<?> currentIterator = (Iterator<?>) field.get(emptyGraphIterator);
            assertNotNull(currentIterator);
            assertFalse(currentIterator.hasNext());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testObjectGraphIteratorWithSingleElement() {
        List<String> singleElementList = Arrays.asList("X");
        Iterator<String> singleElementIterator = singleElementList.iterator();
        ObjectGraphIterator<String> singleElementGraphIterator = new ObjectGraphIterator<>(singleElementIterator);
        // Verify that the iterator has the single element
        assertTrue(singleElementGraphIterator.hasNext());
        assertEquals("X", singleElementGraphIterator.next());
        assertFalse(singleElementGraphIterator.hasNext());
    }

    @Test
    void testObjectGraphIteratorWithMultipleElements() {
        List<String> elements = Arrays.asList("A", "B", "C");
        Iterator<String> multiElementIterator = elements.iterator();
        ObjectGraphIterator<String> multiElementGraphIterator = new ObjectGraphIterator<>(multiElementIterator);
        // Verify the elements in order
        assertTrue(multiElementGraphIterator.hasNext());
        assertEquals("A", multiElementGraphIterator.next());
        assertTrue(multiElementGraphIterator.hasNext());
        assertEquals("B", multiElementGraphIterator.next());
        assertTrue(multiElementGraphIterator.hasNext());
        assertEquals("C", multiElementGraphIterator.next());
        assertFalse(multiElementGraphIterator.hasNext());
    }
}
