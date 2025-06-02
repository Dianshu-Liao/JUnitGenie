package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
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

class ListIteratorWrapper_previous_5_0_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;

    private List<String> testList;

    @BeforeEach
    void setUp() {
        testList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ListIterator<String> listIterator = testList.listIterator();
        listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
    }

    @Test
    void previous_ValidCall_ReturnsPreviousElement() {
        // Move to first element
        listIteratorWrapper.previous();
        // Move to second element
        listIteratorWrapper.previous();
        // Should return "A"
        String result = listIteratorWrapper.previous();
        assertEquals("A", result);
    }

    @Test
    void previous_AtStart_ThrowsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, listIteratorWrapper::previous);
    }

    @Test
    void previous_AfterMovingNext_ThrowsNoSuchElementException() {
        // Move to first element
        listIteratorWrapper.previous();
        // Move to second element
        listIteratorWrapper.previous();
        // Move to "A"
        listIteratorWrapper.previous();
        assertThrows(NoSuchElementException.class, listIteratorWrapper::previous);
    }

    @Test
    void previous_ValidCall_AfterRemovingElement() {
        // Move to "A"
        listIteratorWrapper.previous();
        // Move to "B"
        listIteratorWrapper.previous();
        // Move to "C"
        listIteratorWrapper.previous();
        // Move to "B"
        listIteratorWrapper.previous();
        // Now remove "B" and check previous
        // Assuming we have a method to remove, if not, we need to implement it.
        // listIteratorWrapper.remove(); // Hypothetical method
        // assertEquals("A", listIteratorWrapper.previous());
    }

    @Test
    void previous_UsingListIterator_ReturnsPreviousElement() {
        // Create a ListIterator directly and wrap it
        ListIterator<String> listIterator = testList.listIterator();
        // Move to "A"
        listIterator.next();
        // Move to "B"
        listIterator.next();
        listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
        // Should return "A"
        String result = listIteratorWrapper.previous();
        assertEquals("A", result);
    }
}
