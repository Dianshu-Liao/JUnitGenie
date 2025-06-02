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

public class ArrayIterator_ArrayIterator_8_1_Test {

    private ArrayIterator iterator;

    @BeforeEach
    public void setUp() {
        // Initialize the iterator with a sample array before each test
        String[] sampleArray = { "A", "B", "C", "D", "E" };
        iterator = new ArrayIterator(sampleArray);
    }

    @Test
    public void testConstructorWithValidArray() {
        assertNotNull(iterator);
        assertEquals(0, iterator.getStartIndex());
        assertEquals(5, iterator.getEndIndex());
        assertEquals(iterator.getArray(), iterator.array);
    }

    @Test
    public void testConstructorWithStartIndex() {
        ArrayIterator iteratorWithStart = new ArrayIterator(new String[] { "A", "B", "C" }, 1);
        assertEquals(1, iteratorWithStart.getStartIndex());
        assertEquals(3, iteratorWithStart.getEndIndex());
    }

    @Test
    public void testConstructorWithStartAndEndIndex() {
        ArrayIterator iteratorWithBounds = new ArrayIterator(new String[] { "A", "B", "C", "D" }, 1, 3);
        assertEquals(1, iteratorWithBounds.getStartIndex());
        assertEquals(3, iteratorWithBounds.getEndIndex());
    }

    @Test
    public void testConstructorThrowsExceptionForInvalidStartIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 5);
        });
    }

    @Test
    public void testConstructorThrowsExceptionForNegativeStartIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, -1);
        });
    }

    @Test
    public void testConstructorThrowsExceptionForEndIndexLessThanStartIndex() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 2, 1);
        });
    }

    @Test
    public void testConstructorThrowsExceptionForEndIndexOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 0, 5);
        });
    }

    @Test
    public void testConstructorThrowsExceptionForNegativeEndIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new String[] { "A", "B", "C" }, 0, -1);
        });
    }
}
