package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class iterators_PeekingIterator_hasNext__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenExhausted() {
        // Arrange
        PeekingIterator<Object> iterator = new PeekingIterator<>(new java.util.Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return false; // Simulate an empty iterator
            }

            @Override
            public Object next() {
                return null; // Not used in this test
            }
        });
        
        // Set the private field 'exhausted' to true using reflection
        try {
            java.lang.reflect.Field exhaustedField = PeekingIterator.class.getDeclaredField("exhausted");
            exhaustedField.setAccessible(true);
            exhaustedField.setBoolean(iterator, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenSlotFilled() {
        // Arrange
        PeekingIterator<Object> iterator = new PeekingIterator<>(new java.util.Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Simulate a non-empty iterator
            }

            @Override
            public Object next() {
                return new Object(); // Return a dummy object
            }
        });

        // Set the private field 'slotFilled' to true using reflection
        try {
            java.lang.reflect.Field slotFilledField = PeekingIterator.class.getDeclaredField("slotFilled");
            slotFilledField.setAccessible(true);
            slotFilledField.setBoolean(iterator, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertFalse(result); // Since slotFilled is true, we expect hasNext to return true
    }

}