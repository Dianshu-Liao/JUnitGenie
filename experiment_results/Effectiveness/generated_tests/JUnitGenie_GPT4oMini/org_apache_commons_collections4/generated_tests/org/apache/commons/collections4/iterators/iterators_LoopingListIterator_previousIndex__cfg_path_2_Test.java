package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import static org.junit.Assert.assertEquals;

public class iterators_LoopingListIterator_previousIndex__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousIndexWhenListIsNotEmptyAndHasPrevious() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        LoopingListIterator<Integer> iterator = new LoopingListIterator<>(list);
        iterator.previous(); // Move to the last element to have a previous
        int index = iterator.previousIndex();
        assertEquals(1, index); // The previous index should be 1
    }

    @Test(expected = NoSuchElementException.class)
    public void testPreviousIndexWhenListIsEmpty() {
        List<Integer> list = Arrays.asList();
        LoopingListIterator<Integer> iterator = new LoopingListIterator<>(list);
        try {
            iterator.previousIndex(); // This should throw NoSuchElementException
        } catch (NoSuchElementException e) {
            // Exception is expected, we can assert the message if needed
            assertEquals("There are no elements for this iterator to loop on", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPreviousIndexWhenListIsNotEmptyAndHasNoPrevious() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        LoopingListIterator<Integer> iterator = new LoopingListIterator<>(list);
        // Move to the first element
        iterator.next();
        int index = iterator.previousIndex();
        assertEquals(0, index); // The previous index should be 0
    }

}