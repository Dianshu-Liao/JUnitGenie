package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
import org.junit.Test;

public class iterators_ObjectArrayListIterator_set_Object_cfg_path_2_Test {

    @Test(expected = IllegalStateException.class)
    public void testSetThrowsIllegalStateExceptionWhenLastItemIndexIsNegativeOne() {
        // Arrange
        ObjectArrayListIterator<Object> iterator = new ObjectArrayListIterator<>(new Object[]{});
        
        // Act
        try {
            iterator.set(new Object());
        } catch (IllegalStateException e) {
            // Assert
            // Exception is expected, so we can just rethrow it to satisfy the test framework
            throw e;
        }
    }

}