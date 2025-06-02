package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_SingletonListIterator_remove__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemove() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Simulate the state where nextCalled is true and removed is false
        setPrivateField(iterator, "nextCalled", true);
        setPrivateField(iterator, "removed", false);

        // Act
        try {
            iterator.remove();
        } catch (IllegalStateException e) {
            // Assert
            fail("Expected remove() to succeed, but it threw an IllegalStateException");
        }

        // Assert that the object is set to null and removed is true
        assertNull(getPrivateField(iterator, "object"));
        assertTrue((Boolean) getPrivateField(iterator, "removed"));
    }

    @Test(timeout = 4000)
    public void testRemoveThrowsIllegalStateExceptionWhenNextNotCalled() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Simulate the state where nextCalled is false
        setPrivateField(iterator, "nextCalled", false);
        setPrivateField(iterator, "removed", false);

        // Act
        try {
            iterator.remove();
            fail("Expected remove() to throw IllegalStateException when nextCalled is false");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRemoveThrowsIllegalStateExceptionWhenAlreadyRemoved() {
        // Arrange
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        // Simulate the state where nextCalled is true and removed is true
        setPrivateField(iterator, "nextCalled", true);
        setPrivateField(iterator, "removed", true);

        // Act
        try {
            iterator.remove();
            fail("Expected remove() to throw IllegalStateException when already removed");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(SingletonListIterator<Object> iterator, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(iterator, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Helper method to get private fields using reflection
    private Object getPrivateField(SingletonListIterator<Object> iterator, String fieldName) {
        try {
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(iterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}