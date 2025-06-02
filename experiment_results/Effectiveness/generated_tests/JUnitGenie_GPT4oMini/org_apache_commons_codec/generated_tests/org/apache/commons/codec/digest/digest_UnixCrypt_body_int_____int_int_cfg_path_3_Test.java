package org.apache.commons.codec.digest;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.codec.digest.UnixCrypt;
import java.lang.reflect.Method;
import org.junit.Test;

public class digest_UnixCrypt_body_int_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testBody() {
        // Prepare input parameters for the method
        int[] schedule = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        int eSwap0 = 10;
        int eSwap1 = 20;

        // Prepare expected result
        int[] expected = {0, 0}; // Replace with the actual expected output based on the test case logic

        try {
            // Access the private static method using reflection
            Method method = UnixCrypt.class.getDeclaredMethod("body", int[].class, int.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int[] result = (int[]) method.invoke(null, schedule, eSwap0, eSwap1);

            // Check the result
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}