package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.junit.Test;
import static org.junit.Assert.fail;

public class iterators_CollatingIterator_remove__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemove_ThrowsIllegalStateException_WhenLastReturnedIsNegativeOne() {
        // Arrange
        CollatingIterator collatingIterator = new CollatingIterator();
        // lastReturned is initialized to -1, which is the default value

        try {
            // Act
            collatingIterator.remove();
            // If no exception is thrown, the test should fail
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Assert
            // Exception is expected, no action needed
        }
    }

}