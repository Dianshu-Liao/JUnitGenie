package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator_ArrayIterator_10_0_Test {

    private ArrayIterator arrayIterator;

    @BeforeEach
    public void setUp() {
        // Initialize with a sample array for tests
        Object sampleArray = Array.newInstance(Integer.class, 5);
        arrayIterator = new ArrayIterator(sampleArray, 0, 5);
    }

    @Test
    public void testConstructorWithValidIndices() {
        Object sampleArray = Array.newInstance(String.class, 10);
        ArrayIterator iterator = new ArrayIterator(sampleArray, 0, 10);
        assertNotNull(iterator);
    }

    @Test
    public void testConstructorWithStartIndexGreaterThanEndIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ArrayIterator(new Object[5], 3, 2);
        });
        assertEquals("End index must not be less than start index.", exception.getMessage());
    }

    @Test
    public void testConstructorWithInvalidStartIndex() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            Object sampleArray = Array.newInstance(Integer.class, 5);
            invokeCheckBoundMethod(sampleArray, 6, "start");
        });
        assertEquals("Index 6 out of bounds for length 5", exception.getMessage());
    }

    @Test
    public void testConstructorWithInvalidEndIndex() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            Object sampleArray = Array.newInstance(Integer.class, 5);
            invokeCheckBoundMethod(sampleArray, 6, "end");
        });
        assertEquals("Index 6 out of bounds for length 5", exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativeStartIndex() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new Object[5], -1, 2);
        });
        assertEquals("Index -1 out of bounds for length 5", exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativeEndIndex() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayIterator(new Object[5], 0, -2);
        });
        assertEquals("Index -2 out of bounds for length 5", exception.getMessage());
    }

    private void invokeCheckBoundMethod(Object array, int index, String boundType) {
        try {
            Method checkBoundMethod = ArrayIterator.class.getDeclaredMethod("checkBound", int.class, int.class, String.class);
            checkBoundMethod.setAccessible(true);
            checkBoundMethod.invoke(arrayIterator, index, Array.getLength(array), boundType);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Reflection invocation failed: " + e.getMessage());
        }
    }
}
