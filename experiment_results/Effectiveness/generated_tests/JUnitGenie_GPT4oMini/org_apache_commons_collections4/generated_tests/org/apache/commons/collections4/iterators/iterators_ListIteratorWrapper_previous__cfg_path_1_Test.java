package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_ListIteratorWrapper_previous__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPreviousWhenIteratorIsListIterator() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        ListIteratorWrapper<Integer> listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
        
        try {
            Integer previous = listIteratorWrapper.previous();
            assertEquals(Integer.valueOf(3), previous);
        } catch (NoSuchElementException e) {
            fail("NoSuchElementException should not have been thrown.");
        }
    }

    @Test(timeout = 4000)
    public void testPreviousWhenCurrentIndexIsZero() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        ListIterator<Integer> listIterator = list.listIterator(0);
        ListIteratorWrapper<Integer> listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
        
        try {
            listIteratorWrapper.previous();
            fail("NoSuchElementException expected.");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testPreviousWhenIteratorIsNotListIterator() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        ListIteratorWrapper<Integer> listIteratorWrapper = new ListIteratorWrapper<>(iterator);
        
        try {
            listIteratorWrapper.previous();
            fail("NoSuchElementException expected.");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }


}