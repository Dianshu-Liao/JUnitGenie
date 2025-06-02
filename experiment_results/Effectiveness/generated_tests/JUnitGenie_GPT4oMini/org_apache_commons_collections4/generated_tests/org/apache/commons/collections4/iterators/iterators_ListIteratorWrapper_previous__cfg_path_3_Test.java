package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_previous__cfg_path_3_Test {
    private ListIteratorWrapper<String> listIteratorWrapper;
    private List<String> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        // Add elements to the list to set up the test case
        list.add("first");
        list.add("second");
        list.add("third");
        ListIterator<String> iter = list.listIterator(list.size()); // Start at the end of the list
        listIteratorWrapper = new ListIteratorWrapper<>(iter);
    }

    @Test(timeout = 4000)
    public void testPrevious() {
        // Test getting previous element
        String result = listIteratorWrapper.previous(); // should return "third"
        assertEquals("third", result);
        
        result = listIteratorWrapper.previous(); // should return "second"
        assertEquals("second", result);
        
        result = listIteratorWrapper.previous(); // should return "first"
        assertEquals("first", result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPreviousThrowsNoSuchElementException() {
        // Attempting to call previous when at the start should throw an exception
        listIteratorWrapper.previous(); // move to "third"
        listIteratorWrapper.previous(); // move to "second"
        listIteratorWrapper.previous(); // move to "first"
        listIteratorWrapper.previous(); // this should throw an exception
    }

}