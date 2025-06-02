package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class ListIteratorWrapper_previousIndex_6_0_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;

    private List<String> testList;

    private ListIterator<String> listIterator;

    @BeforeEach
    void setUp() {
        testList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        listIterator = testList.listIterator();
        listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
    }

    @Test
    void testPreviousIndex_WithListIterator() {
        // Move to index 0
        listIterator.next();
        // Previous index should be 0
        assertEquals(0, listIteratorWrapper.previousIndex());
        // Move to index 1
        listIterator.next();
        // Previous index should be 1
        assertEquals(1, listIteratorWrapper.previousIndex());
        // Move to index 2
        listIterator.next();
        // Previous index should be 2
        assertEquals(2, listIteratorWrapper.previousIndex());
        // Move back to index 1
        listIterator.previous();
        // Previous index should be 1
        assertEquals(1, listIteratorWrapper.previousIndex());
    }

    @Test
    void testPreviousIndex_AtStart() {
        // At start, previous index should be -1
        assertEquals(-1, listIteratorWrapper.previousIndex());
    }

    @Test
    void testPreviousIndex_WithoutListIterator() {
        // Create an iterator that is not a ListIterator
        Iterator<String> nonListIterator = testList.iterator();
        listIteratorWrapper = new ListIteratorWrapper<>(nonListIterator);
        // Since we haven't called next(), currentIndex should be 0
        // previousIndex should return -1
        assertEquals(-1, listIteratorWrapper.previousIndex());
    }

    @Test
    void testPreviousIndex_WithEmptyList() {
        listIterator = new ArrayList<String>().listIterator();
        listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
        // previousIndex should return -1 for empty list
        assertEquals(-1, listIteratorWrapper.previousIndex());
    }
}
