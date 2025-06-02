package org.apache.commons.collections4.iterators;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

@ExtendWith(MockitoExtension.class)
public class ArrayIterator_ArrayIterator_8_0_Test {

    private ArrayIterator arrayIterator;

    @BeforeEach
    public void setUp() {
        // Initialize the ArrayIterator with a sample array
        Object sampleArray = new Object[] { 1, 2, 3, 4, 5 };
        arrayIterator = new ArrayIterator(sampleArray);
    }

    @Test
    public void testArrayIteratorInitialization() {
        // Verifying that the ArrayIterator is initialized correctly
        assertNotNull(arrayIterator);
    }

    @Test
    public void testArrayIteratorWithNull() {
        // Testing with null array
        assertThrows(NullPointerException.class, () -> {
            new ArrayIterator(null);
        });
    }

    @Test
    public void testArrayIteratorWithEmptyArray() {
        // Testing with an empty array
        Object emptyArray = new Object[] {};
        ArrayIterator emptyIterator = new ArrayIterator(emptyArray);
        assertNotNull(emptyIterator);
    }

    @Test
    public void testArrayIteratorWithValidArray() {
        // Testing with a valid array
        Object validArray = new Object[] { 10, 20, 30 };
        ArrayIterator validIterator = new ArrayIterator(validArray);
        // Verify that the iterator is not null
        assertNotNull(validIterator);
        // Verify that the start index is correctly set to 0
        assertEquals(0, validIterator.getStartIndex());
        // Fixed buggy line: Get the length of the array using the correct reference
        assertEquals(((Object[]) validArray).length - 1, validIterator.getEndIndex());
        // Verify that the array reference is correctly set
        assertSame(validArray, validIterator.getArray());
    }
}
