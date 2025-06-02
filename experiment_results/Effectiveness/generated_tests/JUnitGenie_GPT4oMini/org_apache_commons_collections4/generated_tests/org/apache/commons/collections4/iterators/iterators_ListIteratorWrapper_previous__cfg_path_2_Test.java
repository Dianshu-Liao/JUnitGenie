package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_previous__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousThrowsNoSuchElementException() {
        // Create a ListIteratorWrapper with an empty list
        List<Integer> list = Arrays.asList();
        Iterator<Integer> iterator = list.iterator();
        ListIteratorWrapper listIteratorWrapper = new ListIteratorWrapper(iterator);

        try {
            // Attempt to call previous() on an empty iterator
            listIteratorWrapper.previous();
        } catch (NoSuchElementException e) {
            // Expected exception
            return;
        }
        // If we reach here, the exception was not thrown
        throw new AssertionError("Expected NoSuchElementException was not thrown.");
    }

}