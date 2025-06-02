package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class iterators_PeekingIterator_peek__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPeekWhenNotExhausted() {
        // Create a mock iterator that will be used to instantiate PeekingIterator
        java.util.Iterator<Object> mockIterator = new java.util.Iterator<Object>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < 1; // Only one element to return
            }

            @Override
            public Object next() {
                count++;
                return new Object(); // Return a dummy object
            }
        };

        // Instantiate PeekingIterator with the mock iterator
        PeekingIterator<Object> peekingIterator = new PeekingIterator<>(mockIterator);

        // Instead of calling fill(), we can directly call peek() since the iterator is not exhausted
        // Now call peek and assert that it does not return null
        Object result = peekingIterator.peek();
        assertNotNull(result); // Since we are testing the case where it should return a non-null object
    }

}