package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterators_PeekingIterator_hasNext__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenExhausted() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);
        // Simulate exhausted state
        try {
            while (peekingIterator.hasNext()) {
                peekingIterator.next();
            }
        } catch (NoSuchElementException e) {
            // Handle exception if needed
        }
        
        // Act
        boolean result = peekingIterator.hasNext();
        
        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenSlotFilled() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);
        // Simulate slot filled state
        try {
            peekingIterator.next(); // Fill the slot
        } catch (NoSuchElementException e) {
            // Handle exception if needed
        }
        
        // Act
        boolean result = peekingIterator.hasNext();
        
        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenIteratorHasNext() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);
        
        // Act
        boolean result = peekingIterator.hasNext();
        
        // Assert
        assertTrue(result);
    }

}