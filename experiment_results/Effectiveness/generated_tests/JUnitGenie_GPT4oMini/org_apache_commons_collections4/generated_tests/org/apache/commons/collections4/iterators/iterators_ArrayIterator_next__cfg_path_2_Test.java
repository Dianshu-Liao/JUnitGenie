package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_ArrayIterator_next__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        // Arrange
        Object[] array = new Object[5];
        ArrayIterator iterator = new ArrayIterator(array, 0, 0); // index = 0, endIndex = 0

        // Act & Assert
        try {
            iterator.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Exception is expected
        }
    }

}