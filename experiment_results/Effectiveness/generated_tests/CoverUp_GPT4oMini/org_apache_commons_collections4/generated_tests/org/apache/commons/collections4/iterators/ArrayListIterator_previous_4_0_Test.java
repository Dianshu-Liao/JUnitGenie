package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

public class ArrayListIterator_previous_4_0_Test {

    private ArrayListIterator<Object> iterator;

    @BeforeEach
    public void setUp() {
        Object array = Array.newInstance(Object.class, 3);
        Array.set(array, 0, "first");
        Array.set(array, 1, "second");
        Array.set(array, 2, "third");
        // Start at the last index
        iterator = new ArrayListIterator<>(array, 2);
    }

    @Test
    public void testPrevious() {
        // Move to the previous element
        assertEquals("third", iterator.previous());
        assertEquals("second", iterator.previous());
    }

    @Test
    public void testPreviousThrowsNoSuchElementException() {
        // Move to the previous element
        // Move to "third"
        iterator.previous();
        // Move to "second"
        iterator.previous();
        // Now should throw NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> iterator.previous());
    }

    @Test
    public void testHasPrevious() {
        // Should be true at index 2
        assertTrue(iterator.hasPrevious());
        // Move to index 1
        iterator.previous();
        // Should be true at index 1
        assertTrue(iterator.hasPrevious());
        // Move to index 0
        iterator.previous();
        // Should be false at index 0
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testSetThrowsIllegalStateException() throws Exception {
        // Attempt to set value without calling previous or next
        assertThrows(IllegalStateException.class, () -> {
            iterator.set("newValue");
        });
    }

    @Test
    public void testSet() throws Exception {
        // Move to the previous element and set a new value
        // Move to "third"
        iterator.previous();
        iterator.set("newThird");
        // Verify the change
        Object array = getArrayFromIterator(iterator);
        assertEquals("newThird", Array.get(array, 2));
    }

    private Object getArrayFromIterator(ArrayListIterator<Object> iterator) throws Exception {
        Field arrayField = ArrayListIterator.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        return arrayField.get(iterator);
    }
}
