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

public class Base64_encodeBase64_4_0_Test {

    @Test
    public void testEncodeBase64_EmptyArray() throws Exception {
        byte[] input = new byte[0];
        // Expecting empty output for empty input
        byte[] expected = new byte[0];
        byte[] actual = invokeEncodeBase64(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_SingleByte() throws Exception {
        byte[] input = new byte[] { (byte) 'A' };
        // Base64 encoding of 'A'
        byte[] expected = new byte[] { 'Q', 'A', '=', '=' };
        byte[] actual = invokeEncodeBase64(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_TwoBytes() throws Exception {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B' };
        // Base64 encoding of 'AB'
        byte[] expected = new byte[] { 'Q', 'U', 'I', '8' };
        byte[] actual = invokeEncodeBase64(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_ThreeBytes() throws Exception {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' };
        // Base64 encoding of 'ABC'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D' };
        byte[] actual = invokeEncodeBase64(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_NonMultipleOfThree() throws Exception {
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D' };
        // Base64 encoding of 'ABCD'
        byte[] expected = new byte[] { 'Q', 'U', 'J', 'D', 'A', 'Q', '=' };
        byte[] actual = invokeEncodeBase64(input);
        assertArrayEquals(expected, actual);
    }

    private byte[] invokeEncodeBase64(byte[] input) throws Exception {
        Method method = Base64.class.getDeclaredMethod("encodeBase64", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, (Object) input);
    }
}
