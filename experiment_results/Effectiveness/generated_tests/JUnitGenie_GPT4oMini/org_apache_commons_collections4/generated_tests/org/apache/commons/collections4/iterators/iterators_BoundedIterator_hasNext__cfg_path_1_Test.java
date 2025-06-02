package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterators_BoundedIterator_hasNext__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenCheckBoundsReturnsFalse() {
        // Create an iterator with no elements
        Iterator<Integer> emptyIterator = Arrays.<Integer>asList().iterator();
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(emptyIterator, 0, 0);

        // Test hasNext() should return false
        try {
            assertFalse(boundedIterator.hasNext());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHasNextWhenCheckBoundsReturnsTrue() {
        // Create an iterator with one element
        Iterator<Integer> singleElementIterator = Arrays.asList(1).iterator();
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(singleElementIterator, 0, 1);

        // Test hasNext() should return true
        try {
            assertTrue(boundedIterator.hasNext());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHasNextWhenIteratorIsExhausted() {
        // Create an iterator with one element
        Iterator<Integer> singleElementIterator = Arrays.asList(1).iterator();
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(singleElementIterator, 0, 1);

        // Advance the iterator
        boundedIterator.hasNext(); // Should return true
        boundedIterator.hasNext(); // Should return true again

        // Exhaust the iterator
        try {
            singleElementIterator.next(); // Move to the next element
            assertFalse(boundedIterator.hasNext()); // Now should return false
        } catch (NoSuchElementException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}