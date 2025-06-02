package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
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

class Base64_encodeBase64_6_1_Test {

    @Test
    void testEncodeBase64_NullInput() {
        byte[] result = Base64.encodeBase64(null, true, false);
        assertNull(result);
    }

    @Test
    void testEncodeBase64_EmptyInput() {
        byte[] result = Base64.encodeBase64(new byte[0], true, false);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testEncodeBase64_StandardEncoding() {
        byte[] input = "Hello".getBytes();
        byte[] expected = "SGVsbG8=".getBytes();
        byte[] result = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_UrlSafeEncoding() {
        byte[] input = "Hello/World".getBytes();
        byte[] expected = "SGVsbG8tV29ybGQ=".getBytes();
        byte[] result = Base64.encodeBase64(input, false, true);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_ChunkedEncoding() {
        byte[] input = "HelloWorld".getBytes();
        // Example of expected chunked output
        byte[] expected = "SGVsbG9Xb3Js".getBytes();
        byte[] result = Base64.encodeBase64(input, true, false);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_MaxResultSizeExceeded() {
        // Large input
        byte[] input = new byte[1000];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Max size is smaller than output size
            Base64.encodeBase64(input, false, false, 500);
        });
        assertEquals("Input array too big, the output array would be bigger (1334) than the specified maximum size of 500", exception.getMessage());
    }

    @Test
    void testEncodeBase64_WithDifferentLineSeparators() throws Exception {
        byte[] input = "HelloWorld".getBytes();
        // Example expected output
        byte[] expected = "SGVsbG9Xb3Js".getBytes();
        // Use reflection to access the private method
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class, boolean.class, int.class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, input, true, false, Integer.MAX_VALUE);
        assertArrayEquals(expected, result);
    }
}
