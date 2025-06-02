package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.UnixCrypt;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Pattern;

public class UnixCrypt_body_0_0_Test {

    @Test
    public void testBody() throws Exception {
        // Prepare input parameters
        // Example schedule, needs to be filled with appropriate values
        int[] schedule = new int[128];
        // Example value for eSwap0
        int eSwap0 = 0;
        // Example value for eSwap1
        int eSwap1 = 1;
        // Expected output for given inputs
        // Replace with actual expected output based on the input
        int[] expectedOutput = new int[2];
        // Invoke the private method using reflection
        Method method = UnixCrypt.class.getDeclaredMethod("body", int[].class, int.class, int.class);
        method.setAccessible(true);
        // Call the method and capture the output
        int[] actualOutput = (int[]) method.invoke(null, schedule, eSwap0, eSwap1);
        // Assert the output
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testBodyWithDifferentInputs() throws Exception {
        // Prepare different input parameters
        // Example schedule
        int[] schedule = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        // Example value for eSwap0
        int eSwap0 = 2;
        // Example value for eSwap1
        int eSwap1 = 3;
        // Expected output for given inputs
        // Replace with actual expected output based on the input
        int[] expectedOutput = new int[] { 123456, 654321 };
        // Invoke the private method using reflection
        Method method = UnixCrypt.class.getDeclaredMethod("body", int[].class, int.class, int.class);
        method.setAccessible(true);
        // Call the method and capture the output
        int[] actualOutput = (int[]) method.invoke(null, schedule, eSwap0, eSwap1);
        // Assert the output
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
