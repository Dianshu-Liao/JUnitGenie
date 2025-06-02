// Adjust the package name as needed
package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ArrayIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_ArrayIterator_8_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        Object array = new String[] { "a", "b", "c" };
        int startIndex = 1;
        ArrayIterator iterator = new ArrayIterator(array, startIndex);
        assertNotNull(iterator);
        assertEquals(array, iterator.getArray());
        assertEquals(startIndex, iterator.getStartIndex());
        assertEquals(Array.getLength(array), iterator.getEndIndex());
    }

    @Test
    public void testConstructorWithNegativeStartIndex() {
        Object array = new String[] { "a", "b", "c" };
        int startIndex = -1;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(array, startIndex);
        });
        String expectedMessage = "Attempt to make an ArrayIterator that starts before the start of the array.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testConstructorWithStartIndexGreaterThanArrayLength() {
        Object array = new String[] { "a", "b", "c" };
        int startIndex = 4;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(array, startIndex);
        });
        String expectedMessage = "Attempt to make an ArrayIterator that starts beyond the end of the array.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testConstructorWithValidParametersAndEmptyArray() {
        Object array = new String[] {};
        int startIndex = 0;
        ArrayIterator iterator = new ArrayIterator(array, startIndex);
        assertNotNull(iterator);
        assertEquals(array, iterator.getArray());
        assertEquals(startIndex, iterator.getStartIndex());
        assertEquals(0, iterator.getEndIndex());
    }

    @Test
    public void testConstructorWithEndIndexLessThanStartIndex() {
        Object array = new String[] { "a", "b", "c" };
        int startIndex = 2;
        int endIndex = 1;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(array, startIndex, endIndex);
        });
        String expectedMessage = "End index must not be less than start index.";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
