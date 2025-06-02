package org.apache.commons.collections4.iterators;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_ArrayIterator_9_0_Test {

    private ArrayIterator arrayIterator;

    @BeforeEach
    public void setUp() {
        // Setting up a sample array for testing
        Integer[] sampleArray = { 1, 2, 3, 4, 5 };
        arrayIterator = new ArrayIterator(sampleArray, 0);
    }

    @Test
    public void testConstructorWithValidParameters() {
        try {
            Constructor<ArrayIterator> constructor = ArrayIterator.class.getDeclaredConstructor(Object.class, int.class, int.class);
            constructor.setAccessible(true);
            ArrayIterator iterator = constructor.newInstance(new Integer[] { 1, 2, 3 }, 0, 3);
            assertNotNull(iterator);
            assertArrayEquals(new Integer[] { 1, 2, 3 }, (Integer[]) iterator.getArray());
            assertEquals(0, iterator.getStartIndex());
            assertEquals(3, iterator.getEndIndex());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            fail("Constructor with valid parameters should not throw an exception");
        }
    }

    @Test
    public void testConstructorWithNegativeStartIndex() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new Integer[] { 1, 2, 3 }, -1);
        });
        assertEquals("Attempt to make an ArrayIterator that starts before the start of the array. ", exception.getMessage());
    }

    @Test
    public void testConstructorWithExceedingStartIndex() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new Integer[] { 1, 2, 3 }, 4);
        });
        assertEquals("Attempt to make an ArrayIterator that starts beyond the end of the array. ", exception.getMessage());
    }

    @Test
    public void testConstructorWithEndIndexLessThanStartIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(new Integer[] { 1, 2, 3 }, 2, 1);
        });
        assertEquals("End index must not be less than start index.", exception.getMessage());
    }

    @Test
    public void testConstructorWithValidEndIndex() {
        try {
            ArrayIterator iterator = new ArrayIterator(new Integer[] { 1, 2, 3 }, 0, 2);
            assertNotNull(iterator);
            assertEquals(0, iterator.getStartIndex());
            assertEquals(2, iterator.getEndIndex());
        } catch (Exception e) {
            fail("Constructor with valid end index should not throw an exception");
        }
    }
}
