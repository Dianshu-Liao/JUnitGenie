package org.apache.commons.collections4.iterators;
import static org.junit.Assert.*;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class iterators_LoopingListIterator_previousIndex__cfg_path_3_Test {
    private List<Integer> list;
    private LoopingListIterator<Integer> iterator;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        iterator = new LoopingListIterator<>(list);
    }

    @Test(timeout = 4000)
    public void testPreviousIndex_ThrowException_WhenListIsEmpty() {
        try {
            iterator.previousIndex();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("There are no elements for this iterator to loop on", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPreviousIndex_ReturnsLastIndex_WhenHasNoPrevious() {
        list.add(1);  // Adding an element to make the list non-empty
        iterator = new LoopingListIterator<>(list);
        
        // Attempt to call previousIndex before moving the iterator
        int index = iterator.previousIndex();
        assertEquals(0, index);  // Since there's only one element, the previous index should be 0
    }

    // Additional test cases can be added here as necessary.

}