package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ObjectArrayListIterator_set_7_0_Test {

    private ObjectArrayListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        // Initialize the iterator with a sample array
        iterator = new ObjectArrayListIterator<>("first", "second", "third");
    }

    @Test
    public void testSetThrowsIllegalStateExceptionWhenLastItemIndexIsNegative() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Call set without calling next() or previous()
            iterator.set("newValue");
        });
        String expectedMessage = "must call next() or previous() before a call to set()";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetUpdatesElementAtLastItemIndex() throws Exception {
        // Use reflection to simulate calling next() and set lastItemIndex
        Method nextMethod = ObjectArrayListIterator.class.getDeclaredMethod("next");
        nextMethod.setAccessible(true);
        // Simulate moving to the first element
        nextMethod.invoke(iterator);
        // Simulate moving to the second element
        nextMethod.invoke(iterator);
        // Now lastItemIndex should be 1 (second element)
        iterator.set("updatedValue");
        // Verify the second element has been updated
        assertEquals("updatedValue", iterator.array[1]);
    }

    @Test
    public void testSetUpdatesElementAfterPreviousCall() throws Exception {
        // Simulate calling previous() to set lastItemIndex
        Method previousMethod = ObjectArrayListIterator.class.getDeclaredMethod("previous");
        previousMethod.setAccessible(true);
        // Simulate moving to the second element
        previousMethod.invoke(iterator);
        // Now lastItemIndex should be 0 (first element)
        iterator.set("updatedFirstValue");
        // Verify the first element has been updated
        assertEquals("updatedFirstValue", iterator.array[0]);
    }

    @Test
    public void testSetDoesNotAffectArrayWhenCalledWithInvalidState() {
        // Attempt to set without valid state
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            iterator.set("newValue");
        });
        // Check that the array remains unchanged
        assertEquals("first", iterator.array[0]);
        assertEquals("second", iterator.array[1]);
        assertEquals("third", iterator.array[2]);
    }
}
