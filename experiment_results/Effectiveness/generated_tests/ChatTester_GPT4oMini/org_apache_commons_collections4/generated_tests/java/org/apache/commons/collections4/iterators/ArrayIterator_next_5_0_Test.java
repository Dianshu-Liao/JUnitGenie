package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import org.apache.commons.collections4.ResettableIterator;

class ArrayIterator_next_5_0_Test {

    private ArrayIterator<String> arrayIterator;

    @BeforeEach
    void setUp() {
        String[] array = { "one", "two", "three" };
        arrayIterator = new ArrayIterator<>(array);
    }

    @Test
    void testNext_ValidCall() {
        assertEquals("one", invokeNext());
        assertEquals("two", invokeNext());
        assertEquals("three", invokeNext());
    }

    @Test
    void testNext_NoMoreElements() {
        // consume "one"
        invokeNext();
        // consume "two"
        invokeNext();
        // consume "three"
        invokeNext();
        assertThrows(NoSuchElementException.class, () -> invokeNext());
    }

    @Test
    void testNext_EmptyArray() {
        String[] emptyArray = {};
        arrayIterator = new ArrayIterator<>(emptyArray);
        assertThrows(NoSuchElementException.class, () -> invokeNext());
    }

    private String invokeNext() {
        try {
            Method nextMethod = ArrayIterator.class.getDeclaredMethod("next");
            nextMethod.setAccessible(true);
            return (String) nextMethod.invoke(arrayIterator);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
