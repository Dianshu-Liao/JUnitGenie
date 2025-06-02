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

public class ArrayIterator_ArrayIterator_10_0_Test {

    private Object testArray;

    @BeforeEach
    public void setUp() {
        // Initialize testArray with some sample data
        testArray = new Integer[] { 1, 2, 3, 4, 5 };
    }

    @Test
    public void testConstructorWithValidIndices() {
        ArrayIterator iterator = new ArrayIterator(testArray, 1, 4);
        assertNotNull(iterator);
        assertEquals(1, iterator.getStartIndex());
        assertEquals(4, iterator.getEndIndex());
        assertEquals(testArray, iterator.getArray());
    }

    @Test
    public void testConstructorWithStartIndexGreaterThanEndIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(testArray, 3, 1);
        });
        assertEquals("End index must not be less than start index.", exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativeStartIndex() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(testArray, -1, 3);
        });
        assertEquals("Attempt to make an ArrayIterator that starts before the start of the array. ", exception.getMessage());
    }

    @Test
    public void testConstructorWithEndIndexGreaterThanArrayLength() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(testArray, 0, 10);
        });
        assertEquals("Attempt to make an ArrayIterator that ends beyond the end of the array. ", exception.getMessage());
    }

    @Test
    public void testConstructorWithStartIndexEqualToEndIndex() {
        ArrayIterator iterator = new ArrayIterator(testArray, 2, 2);
        assertNotNull(iterator);
        assertEquals(2, iterator.getStartIndex());
        assertEquals(2, iterator.getEndIndex());
    }
}
