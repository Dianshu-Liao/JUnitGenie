package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class digest_UnixCrypt_body_int_____int_int_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testBody() {
        // Preparing the input values for the test case
        int[] schedule = new int[32]; // An array of 32 integers
        int eSwap0 = 5;  // Example value
        int eSwap1 = 10; // Example value

        // Expected output based on the provided logic
        int[] expectedOutput = new int[2]; // Modify with the expected values if known
        
        try {
            // Accessing the private static method 'body' using reflection
            Method method = UnixCrypt.class.getDeclaredMethod("body", int[].class, int.class, int.class);
            method.setAccessible(true);
            
            // Invoking the focal method
            int[] actualOutput = (int[]) method.invoke(null, schedule, eSwap0, eSwap1);
            
            // Asserting the actual output with expected output
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            // Handle the exception that might be thrown during the method invocation
            e.printStackTrace();
        }
    }

}