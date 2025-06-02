package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import org.apache.commons.collections4.ResettableListIterator;

public class ArrayListIterator_previous_4_0_Test {

    private ArrayListIterator iterator;

    private Object[] testArray;

    @BeforeEach
    public void setUp() {
        testArray = new Object[] { "A", "B", "C", "D", "E" };
        iterator = new ArrayListIterator(testArray, testArray.length);
    }

    @Test
    public void testPrevious_WhenCalled_ReturnsPreviousElement() {
        // Move to "E"
        iterator.previous();
        // Move to "D"
        Object result = iterator.previous();
        assertEquals("D", result);
    }

    @Test
    public void testPrevious_WhenAtStart_ThrowsNoSuchElementException() {
        // Move to the start of the iterator
        // "E"
        iterator.previous();
        // "D"
        iterator.previous();
        // "C"
        iterator.previous();
        // "B"
        iterator.previous();
        // "A"
        iterator.previous();
        // Now at the start, next call should throw exception
        assertThrows(NoSuchElementException.class, () -> iterator.previous());
    }

    @Test
    public void testPrevious_WhenCalledMultipleTimes_ReturnsElementsInReverseOrder() {
        // Move to "E"
        iterator.previous();
        // Move to "D"
        iterator.previous();
        // Move to "C"
        iterator.previous();
        // Move to "B"
        Object resultC = iterator.previous();
        // Move to "A"
        Object resultB = iterator.previous();
        assertEquals("B", resultC);
        assertEquals("A", resultB);
    }

    @Test
    public void testHasPrevious_WhenAtStart_ReturnsFalse() {
        // Move to the start of the iterator
        // "E"
        iterator.previous();
        // "D"
        iterator.previous();
        // "C"
        iterator.previous();
        // "B"
        iterator.previous();
        // "A"
        iterator.previous();
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testHasPrevious_WhenNotAtStart_ReturnsTrue() {
        // Move to "E"
        iterator.previous();
        // Move to "D"
        iterator.previous();
        assertTrue(iterator.hasPrevious());
    }
}
