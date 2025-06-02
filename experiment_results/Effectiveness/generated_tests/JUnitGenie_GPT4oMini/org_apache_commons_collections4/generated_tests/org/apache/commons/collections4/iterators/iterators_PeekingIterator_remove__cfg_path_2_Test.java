package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import static org.junit.Assert.fail;

public class iterators_PeekingIterator_remove__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveThrowsIllegalStateException() {
        // Arrange
        PeekingIterator<Object> iterator = new PeekingIterator<>(new java.util.ArrayList<Object>().iterator());
        // Set the slotFilled to true to trigger the exception
        try {
            // Accessing the private field using reflection
            java.lang.reflect.Field field = PeekingIterator.class.getDeclaredField("slotFilled");
            field.setAccessible(true);
            field.setBoolean(iterator, true);

            // Act
            iterator.remove();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Assert
            // Exception is expected, test passes
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}