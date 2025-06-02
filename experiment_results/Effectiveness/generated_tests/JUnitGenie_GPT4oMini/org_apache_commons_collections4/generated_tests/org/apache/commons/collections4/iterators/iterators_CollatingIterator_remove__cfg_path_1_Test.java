package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.*;

public class iterators_CollatingIterator_remove__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveThrowsIllegalStateExceptionWhenLastReturnedIsNegativeOne() {
        CollatingIterator<String> collatingIterator = new CollatingIterator<>();
        
        try {
            collatingIterator.remove();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("No value can be removed at present", e.getMessage());
        }
    }



}
