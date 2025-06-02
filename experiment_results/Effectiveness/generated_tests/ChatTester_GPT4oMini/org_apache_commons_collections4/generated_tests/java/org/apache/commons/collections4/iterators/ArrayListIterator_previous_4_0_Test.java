package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

public class ArrayListIterator_previous_4_0_Test {

    private ArrayListIterator<String> iterator;

    private Object array;

    @BeforeEach
    public void setUp() {
        array = Array.newInstance(String.class, 3);
        Array.set(array, 0, "First");
        Array.set(array, 1, "Second");
        Array.set(array, 2, "Third");
        iterator = new ArrayListIterator<>(array);
    }

    @Test
    public void testPrevious_ValidCall() throws Exception {
        // Move to the second element
        invokeSetIndex(1);
        // Call previous
        String result = iterator.previous();
        assertEquals("First", result);
    }

    @Test
    public void testPrevious_NoSuchElementException() throws Exception {
        // Attempt to call previous on the first element
        invokeSetIndex(0);
        assertThrows(NoSuchElementException.class, () -> iterator.previous());
    }

    @Test
    public void testPrevious_AfterEnd_NoSuchElementException() {
        // Attempt to call previous without moving the index
        assertThrows(NoSuchElementException.class, () -> iterator.previous());
    }

    private void invokeSetIndex(int index) throws Exception {
        Field indexField = ArrayListIterator.class.getDeclaredField("index");
        indexField.setAccessible(true);
        indexField.setInt(iterator, index);
    }
}
