package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

public class LoopingListIterator_previousIndex_7_0_Test {

    private LoopingListIterator<String> iteratorWithElements;

    private LoopingListIterator<String> iteratorEmpty;

    @BeforeEach
    public void setUp() {
        // Setting up a LoopingListIterator with elements
        List<String> listWithElements = Arrays.asList("A", "B", "C");
        iteratorWithElements = new LoopingListIterator<>(listWithElements);
        // Setting up an empty LoopingListIterator
        List<String> emptyList = Collections.emptyList();
        iteratorEmpty = new LoopingListIterator<>(emptyList);
    }

    @Test
    public void testPreviousIndex_WhenListIsNotEmptyAndHasPrevious() {
        // Move to the second element (index 1)
        iteratorWithElements.set("B");
        // Now the previous index should return 0
        assertEquals(0, iteratorWithElements.previousIndex());
    }

    @Test
    public void testPreviousIndex_WhenListIsNotEmptyAndAtStart() {
        // At the start of the iterator (first element)
        iteratorWithElements.set("A");
        // The previous index should return the last index (2)
        assertEquals(2, iteratorWithElements.previousIndex());
    }

    @Test
    public void testPreviousIndex_WhenListIsEmpty() {
        // Expecting NoSuchElementException when calling previousIndex on an empty list
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            iteratorEmpty.previousIndex();
        });
        assertEquals("There are no elements for this iterator to loop on", exception.getMessage());
    }

    @Test
    public void testPreviousIndex_WhenListHasOneElement() {
        // Setting up a LoopingListIterator with one element
        List<String> singleElementList = Collections.singletonList("A");
        LoopingListIterator<String> singleElementIterator = new LoopingListIterator<>(singleElementList);
        singleElementIterator.set("A");
        // Should return 0 when at the first element
        assertEquals(0, singleElementIterator.previousIndex());
    }
}
