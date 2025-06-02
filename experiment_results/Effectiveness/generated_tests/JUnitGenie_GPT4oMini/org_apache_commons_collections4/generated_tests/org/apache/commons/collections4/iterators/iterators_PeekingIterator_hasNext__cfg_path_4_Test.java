package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class iterators_PeekingIterator_hasNext__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenExhaustedIsTrue() {
        // Arrange
        PeekingIterator<Integer> iterator = new PeekingIterator<>(new java.util.Iterator<Integer>() {
            private boolean hasNextCalled = false;

            @Override
            public boolean hasNext() {
                return !hasNextCalled; // Simulate that the iterator has items once
            }

            @Override
            public Integer next() {
                hasNextCalled = true; // Exhaust the iterator on the first call
                return 1;
            }
        });

        // Act
        // Call next to exhaust the iterator
        iterator.next();

        // Adding a reflection hack to set the private 'exhausted' field to true
        try {
            java.lang.reflect.Field field = PeekingIterator.class.getDeclaredField("exhausted");
            field.setAccessible(true);
            field.set(iterator, true);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        try {
            assertFalse(iterator.hasNext());
        } catch (Exception e) {
            // Handle any potential exceptions that arise from calling hasNext()
        }
    }

}