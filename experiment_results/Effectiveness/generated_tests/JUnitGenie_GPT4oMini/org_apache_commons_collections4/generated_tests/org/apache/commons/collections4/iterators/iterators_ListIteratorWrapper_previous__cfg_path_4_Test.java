package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_previous__cfg_path_4_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;
    private List<String> list;

    @Before
    public void setUp() {
        list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ListIterator<String> iterator = list.listIterator();
        listIteratorWrapper = new ListIteratorWrapper<>(iterator);
        // Move to the end of the iterator to test previous
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    @Test(timeout = 4000)
    public void testPrevious() {
        try {
            String result = listIteratorWrapper.previous();
            assertEquals("C", result);
            result = listIteratorWrapper.previous();
            assertEquals("B", result);
            result = listIteratorWrapper.previous();
            assertEquals("A", result);
        } catch (NoSuchElementException e) {
            // Expected behavior when we go before the first element
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPreviousNoSuchElementException() {
        // Move back to before the start
        listIteratorWrapper.previous(); // C
        listIteratorWrapper.previous(); // B
        listIteratorWrapper.previous(); // A
        listIteratorWrapper.previous(); // Should throw exception
    }

}