package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
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

public class ReverseListIterator_add_0_0_Test {

    private ReverseListIterator<String> reverseListIterator;

    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        reverseListIterator = new ReverseListIterator<>(list);
    }

    @Test
    public void testAddValid() {
        // Move iterator to a valid position
        reverseListIterator.previous();
        reverseListIterator.add("D");
        ListIterator<String> iterator = list.listIterator();
        // Skip "A"
        iterator.next();
        // Skip "B"
        iterator.next();
        // Skip "C"
        iterator.next();
        // Check if "D" was added
        assertEquals("D", iterator.next());
    }

    @Test
    public void testAddInvalidState() {
        assertThrows(IllegalStateException.class, () -> reverseListIterator.add("D"));
    }

    @Test
    public void testAddAfterNext() {
        // Move iterator to a valid position
        reverseListIterator.next();
        reverseListIterator.add("D");
        ListIterator<String> iterator = list.listIterator();
        // Check if "D" was added
        assertEquals("D", iterator.next());
    }

    @Test
    public void testAddMultipleElements() {
        // Move iterator to a valid position
        reverseListIterator.previous();
        reverseListIterator.add("D");
        reverseListIterator.add("E");
        ListIterator<String> iterator = list.listIterator();
        // Skip "A"
        iterator.next();
        // Skip "B"
        iterator.next();
        // Skip "C"
        iterator.next();
        // Check if "D" was added
        assertEquals("D", iterator.next());
        // Check if "E" was added
        assertEquals("E", iterator.next());
    }

    @Test
    public void testAddAfterPrevious() {
        // Move iterator to a valid position
        reverseListIterator.previous();
        reverseListIterator.add("D");
        // Move to the added element
        reverseListIterator.previous();
        // Check if "D" was added
        assertEquals("D", reverseListIterator.next());
    }
}
