package org.apache.commons.collections4.iterators;

import java.lang.reflect.Constructor;
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

    private Class<?> arrayIteratorClass;

    private Constructor<?> constructor;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        arrayIteratorClass = ArrayIterator.class;
        constructor = arrayIteratorClass.getDeclaredConstructor(Object.class, int.class, int.class);
        constructor.setAccessible(true);
    }

    @Test
    public void testValidConstructor() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = 0;
        int endIndex = 5;
        ArrayIterator iterator = (ArrayIterator) constructor.newInstance(array, startIndex, endIndex);
        assertNotNull(iterator);
        assertEquals(array, iterator.getArray());
        assertEquals(startIndex, iterator.getStartIndex());
        assertEquals(endIndex, iterator.getEndIndex());
    }

    @Test
    public void testStartIndexOutOfBounds() {
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = 6;
        int endIndex = 5;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            constructor.newInstance(array, startIndex, endIndex);
        });
        assertTrue(exception.getMessage().contains("Attempt to make an ArrayIterator that starts beyond the end of the array."));
    }

    @Test
    public void testEndIndexOutOfBounds() {
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = 0;
        int endIndex = 6;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            constructor.newInstance(array, startIndex, endIndex);
        });
        assertTrue(exception.getMessage().contains("Attempt to make an ArrayIterator that ends beyond the end of the array."));
    }

    @Test
    public void testNegativeStartIndex() {
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = -1;
        int endIndex = 4;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            constructor.newInstance(array, startIndex, endIndex);
        });
        assertTrue(exception.getMessage().contains("Attempt to make an ArrayIterator that starts before the start of the array."));
    }

    @Test
    public void testEndIndexLessThanStartIndex() {
        Object array = new int[] { 1, 2, 3, 4, 5 };
        int startIndex = 3;
        int endIndex = 2;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            constructor.newInstance(array, startIndex, endIndex);
        });
        assertEquals("End index must not be less than start index.", exception.getMessage());
    }
}
