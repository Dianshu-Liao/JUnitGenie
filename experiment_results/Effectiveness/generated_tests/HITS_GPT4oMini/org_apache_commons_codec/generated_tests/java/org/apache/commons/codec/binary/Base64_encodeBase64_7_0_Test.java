package org.apache.commons.codec.binary;

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
        byte[] input = {};
        byte[] expected = {};
        byte[] result = Base64.encodeBase64(input, false, false, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_NonEmptyInput() {
        byte[] input = "Hello".getBytes();
        byte[] expected = "SGVsbG8=".getBytes();
        byte[] result = Base64.encodeBase64(input, false, false, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_ChunkedEncoding() {
        byte[] input = "HelloWorld".getBytes();
        byte[] expected = "SGVsbG9Xb3Js".getBytes();
        byte[] result = Base64.encodeBase64(input, true, false, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_UrlSafeEncoding() {
        byte[] input = "Hello+World".getBytes();
        byte[] expected = "SGVsbG9cV29ybGQ=".getBytes();
        byte[] result = Base64.encodeBase64(input, false, true, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_MaxResultSizeExceeded() {
        // Large input
        byte[] input = new byte[1000];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Max size is less than required
            Base64.encodeBase64(input, false, false, 500);
        });
        assertTrue(exception.getMessage().contains("Input array too big"));
    }

    @Test
    public void testEncodeBase64_NegativeMaxResultSize() {
        byte[] input = "Hello".getBytes();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Base64.encodeBase64(input, false, false, -1);
        });
        assertTrue(exception.getMessage().contains("maximum size of"));
    }

    @Test
    public void testEncodeBase64_ExactMaxResultSize() {
        byte[] input = "HelloWorld".getBytes();
        byte[] expected = "SGVsbG9Xb3Js".getBytes();
        byte[] result = Base64.encodeBase64(input, false, false, expected.length);
        assertArrayEquals(expected, result);
    }
}
