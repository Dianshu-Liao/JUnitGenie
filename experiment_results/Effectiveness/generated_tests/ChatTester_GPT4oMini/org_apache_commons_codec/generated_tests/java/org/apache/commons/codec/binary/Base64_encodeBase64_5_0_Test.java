package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base64_encodeBase64_5_0_Test {

    @Test
    public void testEncodeBase64() throws Exception {
        // Test input
        byte[] input = "Hello".getBytes();
        boolean isChunked = false;
        // Expected output (Base64 encoded)
        byte[] expectedOutput = "SGVsbG8=".getBytes();
        // Invoke the focal method using reflection
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class);
        method.setAccessible(true);
        byte[] actualOutput = (byte[]) method.invoke(null, input, isChunked);
        // Verify the result
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeBase64WithChunking() throws Exception {
        // Test input
        byte[] input = "HelloWorld".getBytes();
        boolean isChunked = true;
        // Expected output (Base64 encoded with chunking)
        // Adjust expected output based on actual encoding logic
        byte[] expectedOutput = "SGVsbG9s".getBytes();
        // Invoke the focal method using reflection
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class);
        method.setAccessible(true);
        byte[] actualOutput = (byte[]) method.invoke(null, input, isChunked);
        // Verify the result
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeBase64WithNullInput() throws Exception {
        // Test input
        byte[] input = null;
        boolean isChunked = false;
        // Invoke the focal method using reflection and expect an exception
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class);
        method.setAccessible(true);
        assertThrows(NullPointerException.class, () -> {
            method.invoke(null, input, isChunked);
        });
    }

    @Test
    public void testEncodeBase64WithEmptyInput() throws Exception {
        // Test input
        byte[] input = new byte[0];
        boolean isChunked = false;
        // Expected output (Base64 encoded)
        byte[] expectedOutput = "".getBytes();
        // Invoke the focal method using reflection
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class);
        method.setAccessible(true);
        byte[] actualOutput = (byte[]) method.invoke(null, input, isChunked);
        // Verify the result
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
