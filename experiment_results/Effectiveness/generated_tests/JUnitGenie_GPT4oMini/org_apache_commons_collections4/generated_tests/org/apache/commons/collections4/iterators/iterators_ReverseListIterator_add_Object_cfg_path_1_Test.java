package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_ReverseListIterator_add_Object_cfg_path_1_Test {

    @Test(expected = IllegalStateException.class)
    public void testAddThrowsIllegalStateExceptionWhenValidForUpdateIsFalse() {
        // Arrange
        ReverseListIterator<Object> iterator = new ReverseListIterator<>(new java.util.ArrayList<>());

        // Use reflection to set validForUpdate to false since it's a private field
        try {
            java.lang.reflect.Field field = ReverseListIterator.class.getDeclaredField("validForUpdate");
            field.setAccessible(true);
            field.set(iterator, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set validForUpdate field: " + e.getMessage());
        }

        // Act
        try {
            iterator.add(new Object());
        } catch (IllegalStateException e) {
            // Assert
            assertEquals("Cannot add to list until next() or previous() called", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }


}