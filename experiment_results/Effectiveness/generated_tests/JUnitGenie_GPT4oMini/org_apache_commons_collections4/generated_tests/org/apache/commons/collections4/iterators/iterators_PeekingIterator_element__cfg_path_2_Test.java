package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.fail;

public class iterators_PeekingIterator_element__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testElementThrowsNoSuchElementException() {
        // Create an iterator with no elements
        Iterator<Integer> emptyIterator = Arrays.asList(new Integer[0]).iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(emptyIterator);

        // Set the internal state to simulate exhaustion
        try {
            // Directly check if the iterator is exhausted
            if (!peekingIterator.hasNext()) {
                // Now, call the element method which should throw NoSuchElementException
                peekingIterator.element();
                fail("Expected NoSuchElementException to be thrown");
            }
        } catch (NoSuchElementException e) {
            // Exception is expected, test passes
        } catch (Exception e) {
            fail("Expected NoSuchElementException, but got: " + e);
        }
    }

}