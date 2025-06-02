package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_ObjectBuffer_initialCapacity__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInitialCapacityWhenFreeBufferIsNull() {
        ObjectBuffer objectBuffer = new ObjectBuffer();
        // _freeBuffer is null by default since it's private and not initialized
        int capacity = objectBuffer.initialCapacity();
        assertEquals(0, capacity);
    }

    @Test(timeout = 4000)
    public void testInitialCapacityWhenFreeBufferIsNotNull() {
        ObjectBuffer objectBuffer = new ObjectBuffer();
        // Using reflection to set the private _freeBuffer field for testing
        try {
            java.lang.reflect.Field field = ObjectBuffer.class.getDeclaredField("_freeBuffer");
            field.setAccessible(true);
            field.set(objectBuffer, new Object[5]); // Setting _freeBuffer to a non-null array
            int capacity = objectBuffer.initialCapacity();
            assertEquals(5, capacity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}