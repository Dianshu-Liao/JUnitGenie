package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_ObjectBuffer_initialCapacity__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInitialCapacityWhenFreeBufferIsNull() {
        // Arrange
        ObjectBuffer objectBuffer = new ObjectBuffer();

        // Act
        int capacity = objectBuffer.initialCapacity();

        // Assert
        assertEquals(0, capacity);
    }

    @Test(timeout = 4000)
    public void testInitialCapacityWhenFreeBufferIsNotNull() {
        // Arrange
        ObjectBuffer objectBuffer = new ObjectBuffer();
        // Use reflection to set _freeBuffer to a non-null value
        try {
            java.lang.reflect.Field field = ObjectBuffer.class.getDeclaredField("_freeBuffer");
            field.setAccessible(true); // Allow access to the private field
            field.set(objectBuffer, new Object[5]); // Set _freeBuffer to an array of length 5
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        int capacity = objectBuffer.initialCapacity();

        // Assert
        assertEquals(5, capacity);
    }

}