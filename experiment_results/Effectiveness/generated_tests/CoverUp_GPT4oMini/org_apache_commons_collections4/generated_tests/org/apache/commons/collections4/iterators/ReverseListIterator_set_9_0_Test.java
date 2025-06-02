package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ReverseListIterator;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class ReverseListIterator_set_9_0_Test {

    private ReverseListIterator<String> reverseListIterator;

    private List<String> testList;

    @BeforeEach
    void setUp() {
        testList = Arrays.asList("A", "B", "C");
        reverseListIterator = new ReverseListIterator<>(testList);
    }

    @Test
    void testSetValidUpdate() {
        // Move to the first element and then set it
        // Move to "C"
        reverseListIterator.next();
        // Set "D" in place of "C"
        reverseListIterator.set("D");
        // Verify that the list has been updated
        ListIterator<String> iterator = testList.listIterator();
        // Move to "D"
        iterator.next();
        // Check if "D" is now in the list
        assertEquals("D", iterator.next());
    }

    @Test
    void testSetInvalidUpdate() {
        // Try to set without calling next() or previous()
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            reverseListIterator.set("D");
        });
        assertEquals("Cannot set to list until next() or previous() called", exception.getMessage());
    }

    @Test
    void testSetAfterNext() {
        // Move to the first element and then set it
        // Move to "C"
        reverseListIterator.next();
        // Move to "B"
        reverseListIterator.next();
        // Set "E" in place of "B"
        reverseListIterator.set("E");
        // Verify that the list has been updated
        ListIterator<String> iterator = testList.listIterator();
        // Move to "C"
        iterator.next();
        // Move to "B"
        iterator.previous();
        // Check if "E" is now in the list
        assertEquals("E", iterator.next());
    }

    @Test
    void testSetAfterPrevious() {
        // Move to the first element and then set it
        // Move to "C"
        reverseListIterator.next();
        // Move to "B"
        reverseListIterator.previous();
        // Set "F" in place of "B"
        reverseListIterator.set("F");
        // Verify that the list has been updated
        ListIterator<String> iterator = testList.listIterator();
        // Move to "C"
        iterator.next();
        // Move to "B"
        iterator.previous();
        // Check if "F" is now in the list
        assertEquals("F", iterator.next());
    }
}
