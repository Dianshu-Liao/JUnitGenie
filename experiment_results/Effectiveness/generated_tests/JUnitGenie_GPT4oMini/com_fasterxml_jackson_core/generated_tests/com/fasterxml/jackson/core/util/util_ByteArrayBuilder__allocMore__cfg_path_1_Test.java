package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class util_ByteArrayBuilder__allocMore__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAllocMoreThrowsIllegalStateException() {
        try {
            // Create an instance of ByteArrayBuilder
            ByteArrayBuilder builder = new ByteArrayBuilder();

            // Set the private fields using reflection
            java.lang.reflect.Field pastLenField = ByteArrayBuilder.class.getDeclaredField("_pastLen");
            pastLenField.setAccessible(true);
            pastLenField.setInt(builder, Integer.MAX_VALUE); // Set _pastLen to a value that will cause overflow

            java.lang.reflect.Field currBlockField = ByteArrayBuilder.class.getDeclaredField("_currBlock");
            currBlockField.setAccessible(true);
            currBlockField.set(builder, new byte[1]); // Set _currBlock to a non-null byte array

            // Access the private method _allocMore using reflection
            Method allocMoreMethod = ByteArrayBuilder.class.getDeclaredMethod("_allocMore");
            allocMoreMethod.setAccessible(true);

            // Invoke the method, expecting an IllegalStateException to be thrown
            allocMoreMethod.invoke(builder);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}