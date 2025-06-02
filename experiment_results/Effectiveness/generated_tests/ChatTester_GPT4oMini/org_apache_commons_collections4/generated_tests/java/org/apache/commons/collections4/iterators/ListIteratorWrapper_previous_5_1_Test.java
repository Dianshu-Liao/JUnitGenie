package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.MessageFormat;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class // Reflection test for private methods if any (not applicable here)
ListIteratorWrapper_previous_5_1_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;

    private List<String> list;

    private ListIterator<String> listIterator;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        listIterator = list.listIterator();
        listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
    }

    @Test
    void testPrevious_WithListIterator() {
        // Move iterator to "A"
        listIterator.next();
        // Move iterator to "B"
        listIterator.next();
        String result = listIteratorWrapper.previous();
        assertEquals("B", result);
    }

    @Test
    void testPrevious_WithListIteratorAtStart() {
        assertThrows(NoSuchElementException.class, () -> {
            listIteratorWrapper.previous();
        });
    }

    @Test
    void testPrevious_WithArrayList() {
        listIteratorWrapper = new ListIteratorWrapper<>(list.listIterator());
        // Move to "A"
        listIterator.next();
        // Move to "B"
        listIterator.next();
        // Move to "C"
        listIterator.next();
        String result = listIteratorWrapper.previous();
        assertEquals("C", result);
    }

    @Test
    void testPrevious_WithArrayListAtStart() {
        listIteratorWrapper = new ListIteratorWrapper<>(list.listIterator());
        assertThrows(NoSuchElementException.class, () -> {
            listIteratorWrapper.previous();
        });
    }

    @Test
    void testPrevious_WithEmptyList() {
        listIteratorWrapper = new ListIteratorWrapper<>(new ArrayList<String>().listIterator());
        assertThrows(NoSuchElementException.class, () -> {
            listIteratorWrapper.previous();
        });
    }

    @Test
    void testPrevious_WithWrappedIteratorAtEnd() {
        // Move to "A"
        listIterator.next();
        // Move to "B"
        listIterator.next();
        // Move to "C"
        listIterator.next();
        // Go back to "C"
        assertEquals("C", listIteratorWrapper.previous());
        // Go back to "B"
        assertEquals("B", listIteratorWrapper.previous());
        // Go back to "A"
        assertEquals("A", listIteratorWrapper.previous());
        assertThrows(NoSuchElementException.class, () -> {
            // Now at start, should throw
            listIteratorWrapper.previous();
        });
    }
}
