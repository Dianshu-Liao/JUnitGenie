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

public class Base64_encodeBase64_4_0_Test {

    @Test
    public void testEncodeBase64_EmptyArray() {
        byte[] input = {};
        byte[] expected = {};
        byte[] actual = Base64.encodeBase64(input);
        assertArrayEquals(expected, actual, "Encoding an empty array should return an empty array.");
    }

    @Test
    public void testEncodeBase64_SingleByte() {
        // 1 in binary
        byte[] input = { 0b00000001 };
        // Base64 encoding of 1
        byte[] expected = { 'A' };
        byte[] actual = Base64.encodeBase64(input);
        assertArrayEquals(expected, actual, "Encoding a single byte should return the correct Base64 value.");
    }

    @Test
    public void testEncodeBase64_TwoBytes() {
        // 1 and 2 in binary
        byte[] input = { 0b00000001, 0b00000010 };
        // Base64 encoding of 1 and 2
        byte[] expected = { 'A', 'g' };
        byte[] actual = Base64.encodeBase64(input);
        assertArrayEquals(expected, actual, "Encoding two bytes should return the correct Base64 value.");
    }

    @Test
    public void testEncodeBase64_ThreeBytes() {
        // 1, 2, 3 in binary
        byte[] input = { 0b00000001, 0b00000010, 0b00000011 };
        // Base64 encoding of 1, 2, and 3
        byte[] expected = { 'A', 'g', 'M' };
        byte[] actual = Base64.encodeBase64(input);
        assertArrayEquals(expected, actual, "Encoding three bytes should return the correct Base64 value.");
    }

    @Test
    public void testEncodeBase64_FourBytes() {
        // 1, 2, 3, 4 in binary
        byte[] input = { 0b00000001, 0b00000010, 0b00000011, 0b00000100 };
        // Base64 encoding of 1, 2, 3, and 4
        byte[] expected = { 'A', 'g', 'M', 'E' };
        byte[] actual = Base64.encodeBase64(input);
        assertArrayEquals(expected, actual, "Encoding four bytes should return the correct Base64 value.");
    }

    @Test
    public void testEncodeBase64_NullInput() {
        byte[] input = null;
        byte[] actual = Base64.encodeBase64(input);
        assertNull(actual, "Encoding a null array should return null.");
    }

    @Test
    public void testEncodeBase64_ChunkedInput() {
        // 1, 2, 3, 4, 5 in binary
        byte[] input = { 0b00000001, 0b00000010, 0b00000011, 0b00000100, 0b00000101 };
        // Base64 encoding of 1, 2, 3, 4, 5
        byte[] expected = { 'A', 'g', 'M', 'E', 'B' };
        byte[] actual = Base64.encodeBase64(input, true);
        assertArrayEquals(expected, actual, "Encoding chunked input should return the correct Base64 value.");
    }
}
