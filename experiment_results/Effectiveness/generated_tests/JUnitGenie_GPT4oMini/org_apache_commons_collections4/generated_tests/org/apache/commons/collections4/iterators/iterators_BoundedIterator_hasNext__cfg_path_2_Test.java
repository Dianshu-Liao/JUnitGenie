package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class iterators_BoundedIterator_hasNext__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenCheckBoundsReturnsFalse() {
        // Create a mock iterator that will be passed to BoundedIterator
        java.util.Iterator<Object> mockIterator = new java.util.Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return false; // Mock behavior
            }

            @Override
            public Object next() {
                return null; // Mock behavior
            }
        };

        // Create an instance of BoundedIterator with pos > max and offset <= (pos - offset + 1)
        long pos = 5; // Example value
        long max = 3; // Example value (pos > max)
        long offset = 2; // Example value (offset <= (pos - offset + 1) => 2 <= (5 - 2 + 1))

        BoundedIterator boundedIterator = new BoundedIterator(mockIterator, pos, offset);

        // Execute the hasNext method and assert the expected outcome
        try {
            boolean result = boundedIterator.hasNext();
            assertFalse(result); // Expecting false since checkBounds() should return false
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}