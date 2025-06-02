package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.fail;

public class iterators_BoundedIterator_next__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        // Create a mock iterator that will be used to instantiate BoundedIterator
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return false; // No elements to iterate
            }

            @Override
            public Object next() {
                return null; // This should not be called
            }
        };

        // Instantiate BoundedIterator with parameters that will ensure checkBounds() returns false
        BoundedIterator<Object> boundedIterator = new BoundedIterator<>(mockIterator, 0, 1);
        
        try {
            boundedIterator.next(); // This should throw NoSuchElementException
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Exception is expected, test passes
        }
    }

}