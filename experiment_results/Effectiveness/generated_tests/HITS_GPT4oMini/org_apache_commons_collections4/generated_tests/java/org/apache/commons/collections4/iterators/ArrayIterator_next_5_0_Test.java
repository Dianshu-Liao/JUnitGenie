package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_next_5_0_Test {

    private ArrayIterator arrayIterator;

    private Object testArray;

    @BeforeEach
    public void setUp() {
        testArray = new String[] { "one", "two", "three" };
        arrayIterator = new ArrayIterator(testArray);
    }

    @Test
    public void testNextReturnsFirstElement() {
        assertEquals("one", arrayIterator.next());
    }

    @Test
    public void testNextReturnsSecondElement() {
        // Move to the first element
        arrayIterator.next();
        assertEquals("two", arrayIterator.next());
    }

    @Test
    public void testNextReturnsThirdElement() {
        // Move to the first element
        arrayIterator.next();
        // Move to the second element
        arrayIterator.next();
        assertEquals("three", arrayIterator.next());
    }

    @Test
    public void testNextThrowsNoSuchElementExceptionWhenNoMoreElements() {
        // Move to the first element
        arrayIterator.next();
        // Move to the second element
        arrayIterator.next();
        // Move to the third element
        arrayIterator.next();
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testHasNextReturnsTrueWhenElementsAreAvailable() {
        assertTrue(arrayIterator.hasNext());
        // Move to the first element
        arrayIterator.next();
        assertTrue(arrayIterator.hasNext());
        // Move to the second element
        arrayIterator.next();
        assertTrue(arrayIterator.hasNext());
        // Move to the third element
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    public void testHasNextReturnsFalseWhenNoMoreElements() {
        // Move to the first element
        arrayIterator.next();
        // Move to the second element
        arrayIterator.next();
        // Move to the third element
        arrayIterator.next();
        assertFalse(arrayIterator.hasNext());
    }

    @Test
    public void testNextWithEmptyArray() {
        arrayIterator = new ArrayIterator(new String[] {});
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testNextWithSingleElementArray() {
        arrayIterator = new ArrayIterator(new String[] { "only" });
        assertEquals("only", arrayIterator.next());
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testNextWithStartIndex() {
        arrayIterator = new ArrayIterator(testArray, 1);
        assertEquals("two", arrayIterator.next());
        assertEquals("three", arrayIterator.next());
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testNextWithStartAndEndIndex() {
        arrayIterator = new ArrayIterator(testArray, 0, 2);
        assertEquals("one", arrayIterator.next());
        assertEquals("two", arrayIterator.next());
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testConstructorThrowsExceptionForInvalidIndices() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayIterator(testArray, 2, 1));
    }
}
