package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_ArrayIterator_9_0_Test {

    @Test
    public void testArrayIterator_WithValidStartIndex() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        ArrayIterator iterator = new ArrayIterator(array, 1);
        assertEquals(1, iterator.getStartIndex());
        assertEquals(5, iterator.getEndIndex());
        assertEquals(array, iterator.getArray());
    }

    @Test
    public void testArrayIterator_WithZeroStartIndex() {
        Object array = new String[] { "a", "b", "c" };
        ArrayIterator iterator = new ArrayIterator(array, 0);
        assertEquals(0, iterator.getStartIndex());
        assertEquals(3, iterator.getEndIndex());
        assertEquals(array, iterator.getArray());
    }

    @Test
    public void testArrayIterator_WithEndIndexLessThanStartIndex() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(array, 2, 1);
        });
        assertEquals("End index must not be less than start index.", exception.getMessage());
    }

    @Test
    public void testArrayIterator_WithNegativeStartIndex() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(array, -1);
        });
        assertEquals("Attempt to make an ArrayIterator that starts before the start of the array. ", exception.getMessage());
    }

    @Test
    public void testArrayIterator_WithStartIndexGreaterThanArrayLength() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(array, 6);
        });
        assertEquals("Attempt to make an ArrayIterator that starts beyond the end of the array. ", exception.getMessage());
    }

    @Test
    public void testArrayIterator_WithEndIndexGreaterThanArrayLength() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(array, 0, 6);
        });
        assertEquals("Attempt to make an ArrayIterator that ends beyond the end of the array. ", exception.getMessage());
    }

    @Test
    public void testArrayIterator_WithValidStartAndEndIndex() {
        Object array = new Integer[] { 1, 2, 3, 4, 5 };
        ArrayIterator iterator = new ArrayIterator(array, 1, 4);
        assertEquals(1, iterator.getStartIndex());
        assertEquals(4, iterator.getEndIndex());
        assertEquals(array, iterator.getArray());
    }
}
