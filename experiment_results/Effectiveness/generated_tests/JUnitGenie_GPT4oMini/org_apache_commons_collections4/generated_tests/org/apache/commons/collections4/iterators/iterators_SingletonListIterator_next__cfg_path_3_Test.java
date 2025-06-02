package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class iterators_SingletonListIterator_next__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNext() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Act
        Object result = iterator.next();

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Act & Assert
        try {
            iterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementExceptionWhenRemoved() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Act & Assert
        try {
            iterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }


}