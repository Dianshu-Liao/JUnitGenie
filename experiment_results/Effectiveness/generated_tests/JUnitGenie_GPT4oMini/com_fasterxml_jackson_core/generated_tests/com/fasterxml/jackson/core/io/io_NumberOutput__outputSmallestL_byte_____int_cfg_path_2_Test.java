package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

public class io_NumberOutput__outputSmallestL_byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void test_outputSmallestL() {
        try {
            // Arrange
            byte[] b = new byte[100];
            int off = 0;

            // Accessing the private static method using reflection
            Method method = NumberOutput.class.getDeclaredMethod("_outputSmallestL", byte[].class, int.class);
            method.setAccessible(true);

            // Act
            int result = (int) method.invoke(null, b, off); // Invoke the method with null for static

            // Assert
            assertEquals(19, result); // Length of Long.MIN_VALUE string representation
            String smallestLongString = String.valueOf(Long.MIN_VALUE);
            for (int i = 0; i < smallestLongString.length(); i++) {
                assertEquals((byte) smallestLongString.charAt(i), b[off + i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}