package org.apache.commons.collections4.iterators;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_ArrayIterator_9_0_Test {

    private ArrayIterator arrayIterator;

    @BeforeEach
    public void setUp() {
        // Setup before each test if needed
    }

    @Test
    public void testArrayIteratorWithValidInputs() throws Exception {
        // Test case for a valid array and start index
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = 2;
        // Use reflection to access the constructor
        Constructor<ArrayIterator> constructor = ArrayIterator.class.getDeclaredConstructor(Object.class, int.class);
        constructor.setAccessible(true);
        arrayIterator = constructor.newInstance(array, startIndex);
        // Assertions to check the state of the object
        assertNotNull(arrayIterator);
        assertEquals(array, arrayIterator.getArray());
        assertEquals(startIndex, arrayIterator.getStartIndex());
        assertEquals(Array.getLength(array), arrayIterator.getEndIndex());
    }

    @Test
    public void testArrayIteratorWithStartIndexOutOfBounds() throws Exception {
        // Test case for start index out of bounds
        Object array = new int[] { 1, 2, 3, 4, 5 };
        // Out of bounds
        int startIndex = 10;
        // Use reflection to access the constructor
        Constructor<ArrayIterator> constructor = ArrayIterator.class.getDeclaredConstructor(Object.class, int.class);
        constructor.setAccessible(true);
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance(array, startIndex);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IndexOutOfBoundsException);
        assertEquals("Index out of bounds", cause.getMessage());
    }

    @Test
    public void testArrayIteratorWithNegativeStartIndex() throws Exception {
        // Test case for negative start index
        Object array = new int[] { 1, 2, 3, 4, 5 };
        // Invalid index
        int startIndex = -1;
        // Use reflection to access the constructor
        Constructor<ArrayIterator> constructor = ArrayIterator.class.getDeclaredConstructor(Object.class, int.class);
        constructor.setAccessible(true);
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance(array, startIndex);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IndexOutOfBoundsException);
        assertEquals("Index out of bounds", cause.getMessage());
    }

    @Test
    public void testArrayIteratorWithNullArray() throws Exception {
        // Test case for null array
        Object array = null;
        int startIndex = 0;
        // Use reflection to access the constructor
        Constructor<ArrayIterator> constructor = ArrayIterator.class.getDeclaredConstructor(Object.class, int.class);
        constructor.setAccessible(true);
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            constructor.newInstance(array, startIndex);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof NullPointerException);
        assertEquals("Array cannot be null", cause.getMessage());
    }
}
