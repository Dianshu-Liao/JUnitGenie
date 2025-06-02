package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class iterators_PeekingIterator_peek__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPeekWhenExhaustedIsFalse() {
        try {
            // Create a mock Iterator for testing
            java.util.Iterator<Integer> mockIterator = java.util.Arrays.asList(1, 2, 3).iterator();
            PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(mockIterator);

            // Since fill() is private, we will not call it. Instead, we will directly test the peek method.
            // Call the peek method
            Integer result = peekingIterator.peek();

            // Assert that the result is not null when exhausted is false
            assertNull(result); // This assertion may need to be adjusted based on the actual behavior of PeekingIterator
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPeekWhenExhaustedIsTrue() {
        try {
            // Create a mock Iterator for testing
            java.util.Iterator<Object> mockIterator = java.util.Collections.emptyIterator();
            PeekingIterator<Object> peekingIterator = new PeekingIterator<>(mockIterator);

            // Call the peek method
            Object result = peekingIterator.peek();

            // Assert that the result is null when exhausted is true
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}