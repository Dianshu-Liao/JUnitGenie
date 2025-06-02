package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.util.Random;

class B64_b64from24bit_0_0_Test {

    @Test
    void testB64from24bit() throws Exception {
        // Prepare input values
        // 11111111
        byte b2 = (byte) 0xFF;
        // 00000000
        byte b1 = (byte) 0x00;
        // 00000001
        byte b0 = (byte) 0x01;
        // Length of output
        int outLen = 4;
        StringBuilder buffer = new StringBuilder();
        // Invoke the focal method using reflection
        Method method = B64.class.getDeclaredMethod("b64from24bit", byte.class, byte.class, byte.class, int.class, StringBuilder.class);
        method.setAccessible(true);
        method.invoke(null, b2, b1, b0, outLen, buffer);
        // Expected output calculation
        // Based on B64T_ARRAY mapping
        String expectedOutput = "///A";
        // Assert
        assertEquals(expectedOutput, buffer.toString());
    }

    @Test
    void testB64from24bitWithDifferentInputs() throws Exception {
        // Prepare different input values
        // 00000001
        byte b2 = (byte) 0x01;
        // 00000010
        byte b1 = (byte) 0x02;
        // 00000011
        byte b0 = (byte) 0x03;
        // Length of output
        int outLen = 4;
        StringBuilder buffer = new StringBuilder();
        // Invoke the focal method using reflection
        Method method = B64.class.getDeclaredMethod("b64from24bit", byte.class, byte.class, byte.class, int.class, StringBuilder.class);
        method.setAccessible(true);
        method.invoke(null, b2, b1, b0, outLen, buffer);
        // Expected output calculation
        // Based on B64T_ARRAY mapping
        String expectedOutput = "./A";
        // Assert
        assertEquals(expectedOutput, buffer.toString());
    }

    @Test
    void testB64from24bitWithZeroes() throws Exception {
        // Prepare input values
        // 00000000
        byte b2 = (byte) 0x00;
        // 00000000
        byte b1 = (byte) 0x00;
        // 00000000
        byte b0 = (byte) 0x00;
        // Length of output
        int outLen = 4;
        StringBuilder buffer = new StringBuilder();
        // Invoke the focal method using reflection
        Method method = B64.class.getDeclaredMethod("b64from24bit", byte.class, byte.class, byte.class, int.class, StringBuilder.class);
        method.setAccessible(true);
        method.invoke(null, b2, b1, b0, outLen, buffer);
        // Expected output calculation
        // Based on B64T_ARRAY mapping
        String expectedOutput = "AAAA";
        // Assert
        assertEquals(expectedOutput, buffer.toString());
    }
}
