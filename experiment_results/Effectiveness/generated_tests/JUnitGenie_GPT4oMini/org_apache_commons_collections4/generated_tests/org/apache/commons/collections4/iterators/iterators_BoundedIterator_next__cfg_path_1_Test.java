package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_BoundedIterator_next__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextWhenCheckBoundsReturnsTrue() {
        // Setup
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(iterator, 0, 3);
        
        // Execute
        Integer result = boundedIterator.next();
        
        // Verify
        assertEquals(Integer.valueOf(1), result);
    }

    @Test(timeout = 4000)
    public void testNextWhenCheckBoundsReturnsFalse() {
        // Setup
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(iterator, 3, 3);
        
        try {
            // Execute
            boundedIterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Verify
            assertNotNull(e);
        }
    }

}