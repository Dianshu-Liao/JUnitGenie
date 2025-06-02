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

public class Base64_encodeBase64_6_0_Test {

    @Test
    public void testEncodeBase64_NullInput() {
        byte[] result = invokeEncodeBase64(null, false, false);
        assertNull(result);
    }

    @Test
    public void testEncodeBase64_EmptyInput() {
        byte[] result = invokeEncodeBase64(new byte[0], false, false);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testEncodeBase64_SingleByteInput() {
        byte[] input = new byte[] { (byte) 'A' };
        // Base64 encoding of 'A'
        byte[] expected = new byte[] { 'Q', 'A', '=', '=' };
        byte[] result = invokeEncodeBase64(input, false, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_TwoBytesInput() {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B' };
        // Base64 encoding of 'AB'
        byte[] expected = new byte[] { 'Q', 'U', 'I', '=' };
        byte[] result = invokeEncodeBase64(input, false, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_ThreeBytesInput() {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' };
        // Base64 encoding of 'ABC'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D' };
        byte[] result = invokeEncodeBase64(input, false, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_FourBytesInput() {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D' };
        // Base64 encoding of 'ABCD'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D', 'Q', 'w', '=' };
        byte[] result = invokeEncodeBase64(input, false, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_Chunked() {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' };
        // Base64 encoding of 'ABC'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D' };
        byte[] result = invokeEncodeBase64(input, true, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_UrlSafe() {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' };
        // Base64 encoding of 'ABC'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D' };
        byte[] result = invokeEncodeBase64(input, false, true);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeEncodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe) {
        try {
            Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class, boolean.class);
            method.setAccessible(true);
            return (byte[]) method.invoke(null, binaryData, isChunked, urlSafe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
