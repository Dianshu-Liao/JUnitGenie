package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Blake3;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class digest_Blake3_compress_int_____int_____int_long_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCompress() {
        // Prepare input parameters
        int[] chainingValue = new int[16]; // Example input
        int[] blockWords = new int[16]; // Example input
        int blockLength = 16; // Example input
        long counter = 1L; // Example input
        int flags = 0; // Example input

        // Expected output based on the input parameters
        int[] expectedOutput = new int[16]; // Replace with the actual expected output

        try {
            // Access the private static method using reflection
            Method method = Blake3.class.getDeclaredMethod("compress", int[].class, int[].class, int.class, long.class, int.class);
            method.setAccessible(true);
            int[] actualOutput = (int[]) method.invoke(null, chainingValue, blockWords, blockLength, counter, flags);

            // Assert the output
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}