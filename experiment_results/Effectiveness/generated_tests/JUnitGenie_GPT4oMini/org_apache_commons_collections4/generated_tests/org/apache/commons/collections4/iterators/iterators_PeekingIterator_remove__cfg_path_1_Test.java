package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_PeekingIterator_remove__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemove() {
        // Create an iterator
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        
        // Create an instance of PeekingIterator with the iterator
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);
        
        // To test the successful removal, we first need to call next to 'fill' the iterator
        peekingIterator.next();
        
        // Check the iterator's state before removal
        assertTrue(peekingIterator.hasNext());

        // Now we can call remove
        try {
            peekingIterator.remove();
            // Check that the iterator has one less element
            assertTrue(!peekingIterator.hasNext());
        } catch (Exception e) {
            fail("Removal should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRemoveWithoutCallingNext() {
        // Create an iterator
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        
        // Create an instance of PeekingIterator with the iterator
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);

        // Attempting to call remove without calling next should throw IllegalStateException
        try {
            peekingIterator.remove();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }

}