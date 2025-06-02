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

public class Base64_encodeBase64_5_0_Test {

    @Test
    public void testEncodeBase64WithEmptyArray() throws Exception {
        byte[] input = {};
        byte[] expected = {};
        byte[] result = invokeEncodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64WithSingleByte() throws Exception {
        byte[] input = { (byte) 'A' };
        byte[] expected = { 'Q', 'Q', '=' };
        byte[] result = invokeEncodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64WithThreeBytes() throws Exception {
        byte[] input = { (byte) 'A', (byte) 'B', (byte) 'C' };
        byte[] expected = { 'Q', 'U', 'J', 'D' };
        byte[] result = invokeEncodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64WithUrlSafe() throws Exception {
        byte[] input = { (byte) 'A', (byte) 'B', (byte) 'C' };
        // Standard encoding
        byte[] expected = { 'Q', 'U', 'J', 'D' };
        byte[] result = invokeEncodeBase64(input, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64WithChunked() throws Exception {
        byte[] input = { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D' };
        // Example output
        byte[] expected = { 'Q', 'U', 'J', 'D', 'Q', 'w', '=' };
        byte[] result = invokeEncodeBase64(input, true);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeEncodeBase64(byte[] binaryData, boolean isChunked) throws Exception {
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class, boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, binaryData, isChunked);
    }
}
