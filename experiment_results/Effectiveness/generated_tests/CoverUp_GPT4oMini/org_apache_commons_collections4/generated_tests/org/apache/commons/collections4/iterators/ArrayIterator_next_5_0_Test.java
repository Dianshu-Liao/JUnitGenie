package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ArrayIterator;
import java.lang.reflect.Method;
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

    @BeforeEach
    public void setUp() {
        // Setup a test array for the iterator
        String[] testArray = { "one", "two", "three" };
        arrayIterator = new ArrayIterator(testArray);
    }

    @Test
    public void testNext_WhenHasNext_ShouldReturnNextElement() {
        assertEquals("one", arrayIterator.next());
        assertEquals("two", arrayIterator.next());
        assertEquals("three", arrayIterator.next());
    }

    @Test
    public void testNext_WhenNoMoreElements_ShouldThrowNoSuchElementException() {
        // consume "one"
        arrayIterator.next();
        // consume "two"
        arrayIterator.next();
        // consume "three"
        arrayIterator.next();
        assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
    }

    @Test
    public void testNext_WithStartIndex_ShouldReturnCorrectElements() {
        String[] testArray = { "one", "two", "three", "four", "five" };
        ArrayIterator iteratorWithStartIndex = new ArrayIterator(testArray, 2);
        assertEquals("three", iteratorWithStartIndex.next());
        assertEquals("four", iteratorWithStartIndex.next());
        assertEquals("five", iteratorWithStartIndex.next());
    }

    @Test
    public void testNext_WithStartAndEndIndex_ShouldReturnCorrectElements() {
        String[] testArray = { "one", "two", "three", "four", "five" };
        ArrayIterator iteratorWithStartAndEndIndex = new ArrayIterator(testArray, 1, 4);
        assertEquals("two", iteratorWithStartAndEndIndex.next());
        assertEquals("three", iteratorWithStartAndEndIndex.next());
        assertEquals("four", iteratorWithStartAndEndIndex.next());
        assertThrows(NoSuchElementException.class, () -> iteratorWithStartAndEndIndex.next());
    }

    @Test
    public void testNext_WhenArrayIsEmpty_ShouldThrowNoSuchElementException() {
        ArrayIterator emptyIterator = new ArrayIterator(new String[0]);
        assertThrows(NoSuchElementException.class, () -> emptyIterator.next());
    }

    @Test
    public void testNext_WhenEndIndexLessThanStartIndex_ShouldThrowIllegalArgumentException() {
        String[] testArray = { "one", "two", "three" };
        assertThrows(IllegalArgumentException.class, () -> new ArrayIterator(testArray, 2, 1));
    }

    // Reflection Test for private methods (if needed)
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = ArrayIterator.class.getDeclaredMethod(methodName, new Class[args.length]);
        method.setAccessible(true);
        return method.invoke(arrayIterator, args);
    }
}
