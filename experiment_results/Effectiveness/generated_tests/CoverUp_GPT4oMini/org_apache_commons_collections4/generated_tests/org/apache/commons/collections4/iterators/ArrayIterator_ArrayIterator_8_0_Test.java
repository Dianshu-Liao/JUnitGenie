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

    private ArrayIterator arrayIterator;

    @BeforeEach
    public void setUp() {
        // Setup a sample array for testing
        Object sampleArray = new String[] { "A", "B", "C" };
        arrayIterator = new ArrayIterator(sampleArray);
    }

    @Test
    public void testArrayIteratorConstructor_withValidArray() {
        // Test that the constructor initializes correctly
        assertNotNull(arrayIterator);
        assertEquals(0, arrayIterator.getStartIndex());
        assertEquals(3, arrayIterator.getEndIndex());
        assertEquals(arrayIterator.getArray(), new String[] { "A", "B", "C" });
    }

    @Test
    public void testArrayIteratorConstructor_withEmptyArray() {
        // Test with an empty array
        Object emptyArray = new String[] {};
        ArrayIterator emptyIterator = new ArrayIterator(emptyArray);
        assertNotNull(emptyIterator);
        assertEquals(0, emptyIterator.getStartIndex());
        assertEquals(0, emptyIterator.getEndIndex());
        assertEquals(emptyIterator.getArray(), new String[] {});
    }

    @Test
    public void testArrayIteratorConstructor_withNullArray() {
        // Test with a null array
        assertThrows(NullPointerException.class, () -> {
            new ArrayIterator(null);
        });
    }

    @Test
    public void testArrayIteratorConstructor_withNegativeStartIndex() {
        // Test with a negative start index
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, -1);
        });
    }

    @Test
    public void testArrayIteratorConstructor_withStartIndexGreaterThanLength() {
        // Test with start index greater than array length
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 4);
        });
    }

    @Test
    public void testArrayIteratorConstructor_withEndIndexLessThanStartIndex() {
        // Test with end index less than start index
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 1, 0);
        });
    }
}
