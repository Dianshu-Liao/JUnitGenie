package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterators_PeekingIterator_hasNext__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenExhausted() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);
        // Simulate exhausted state by consuming all elements
        while (peekingIterator.hasNext()) {
            peekingIterator.next();
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
        // Fill the slot by calling next
        if (peekingIterator.hasNext()) {
            peekingIterator.next();
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

    @Test(timeout = 4000)
    public void testHasNextWhenIteratorIsEmpty() {
        // Arrange
        Iterator<Integer> iterator = Arrays.<Integer>asList().iterator(); // Corrected line
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);

        // Act
        boolean result = peekingIterator.hasNext();

        // Assert
        assertFalse(result);
    }


}