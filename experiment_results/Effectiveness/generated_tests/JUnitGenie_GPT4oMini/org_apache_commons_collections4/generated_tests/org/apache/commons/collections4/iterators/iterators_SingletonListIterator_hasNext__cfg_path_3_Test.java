package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class iterators_SingletonListIterator_hasNext__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenBeforeFirstIsTrueAndRemovedIsFalse() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Accessing the private field 'beforeFirst' directly is not possible,
        // but we can assume the constructor initializes it to true.
        // We also need to ensure 'removed' is false, which is the default state.

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertTrue(result);
    }

}