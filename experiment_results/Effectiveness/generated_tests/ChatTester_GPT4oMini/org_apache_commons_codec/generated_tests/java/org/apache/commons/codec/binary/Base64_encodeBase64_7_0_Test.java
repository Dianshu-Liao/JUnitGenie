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

public class Base64_encodeBase64_7_0_Test {

    @Test
    public void testEncodeBase64_EmptyInput() {
        byte[] input = new byte[0];
        byte[] result = Base64.encodeBase64(input, false, false, 100);
        Assertions.assertArrayEquals(input, result);
    }

    @Test
    public void testEncodeBase64_Chunked() {
        byte[] input = "Hello".getBytes();
        // Expected Base64 encoding
        byte[] expected = "SGVsbG8=".getBytes();
        byte[] result = Base64.encodeBase64(input, true, false, 100);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_NonChunked() {
        byte[] input = "Hello".getBytes();
        // Expected Base64 encoding
        byte[] expected = "SGVsbG8=".getBytes();
        byte[] result = Base64.encodeBase64(input, false, false, 100);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_UrlSafe() {
        byte[] input = "Hello/World".getBytes();
        // Expected Base64 URL-safe encoding
        byte[] expected = "SGVsbG9Xb3Js".getBytes();
        byte[] result = Base64.encodeBase64(input, false, true, 100);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_TooLargeInput() {
        byte[] input = new byte[1000];
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Base64.encodeBase64(input, false, false, 500);
        });
    }

    @Test
    public void testEncodeBase64_MaxResultSize() {
        byte[] input = "Hello".getBytes();
        byte[] result = Base64.encodeBase64(input, false, false, 100);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.length <= 100);
    }

    // Reflection test for private methods if needed
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = Base64.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}
