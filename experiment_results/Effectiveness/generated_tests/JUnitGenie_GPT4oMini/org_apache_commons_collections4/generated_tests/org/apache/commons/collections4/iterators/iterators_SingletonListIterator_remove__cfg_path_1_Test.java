package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_SingletonListIterator_remove__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveThrowsIllegalStateException() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // The nextCalled variable is initially false, which should trigger the exception
        
        // Act
        try {
            iterator.remove();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Test passes
        }
    }

}