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

class Base64_encodeBase64_7_0_Test {

    @Test
    void testEncodeBase64_EmptyArray() throws Exception {
        byte[] input = {};
        byte[] result = invokeEncodeBase64(input, false, false, 100);
        assertArrayEquals(input, result);
    }

    @Test
    void testEncodeBase64_ValidInput() throws Exception {
        byte[] input = "Hello".getBytes();
        // Base64 encoded result
        byte[] expected = "SGVsbG8=".getBytes();
        byte[] result = invokeEncodeBase64(input, false, false, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_Chunked() throws Exception {
        byte[] input = "HelloWorld".getBytes();
        // Base64 encoded result
        byte[] expected = "SGVsbG9Xb3JsZA==".getBytes();
        byte[] result = invokeEncodeBase64(input, true, false, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_UrlSafe() throws Exception {
        byte[] input = "Hello+World".getBytes();
        // Base64 encoded result
        byte[] expected = "SGVsbG9Xb3JsZA==".getBytes();
        byte[] result = invokeEncodeBase64(input, false, true, 100);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEncodeBase64_ExceedsMaxResultSize() {
        byte[] input = new byte[1000];
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeEncodeBase64(input, false, false, 10);
        });
        assertEquals("Input array too big, the output array would be bigger (1332) than the specified maximum size of 10", exception.getMessage());
    }

    private byte[] invokeEncodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe, int maxResultSize) throws Exception {
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class, boolean.class, int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, binaryData, isChunked, urlSafe, maxResultSize);
    }
}
