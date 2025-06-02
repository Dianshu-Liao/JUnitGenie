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

public class Base64_encodeBase64_6_0_Test {

    @Test
    public void testEncodeBase64_EmptyArray() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] actual = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_SingleByte() {
        // 'A'
        byte[] input = new byte[] { 65 };
        // 'A' in Base64 with padding
        byte[] expected = new byte[] { 65, 61, 61 };
        byte[] actual = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_TwoBytes() {
        // 'A' and 'B'
        byte[] input = new byte[] { 65, 66 };
        // 'AB' in Base64 with padding
        byte[] expected = new byte[] { 65, 66, 61 };
        byte[] actual = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_ThreeBytes() {
        // 'A', 'B', 'C'
        byte[] input = new byte[] { 65, 66, 67 };
        // 'ABC' in Base64
        byte[] expected = new byte[] { 65, 66, 67, 61 };
        byte[] actual = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_FourBytes() {
        // 'A', 'B', 'C', 'D'
        byte[] input = new byte[] { 65, 66, 67, 68 };
        // 'ABCD' in Base64
        byte[] expected = new byte[] { 65, 66, 67, 68 };
        byte[] actual = Base64.encodeBase64(input, false, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_ChunkedEncoding() {
        // 'A', 'B', 'C', 'D', 'E'
        byte[] input = new byte[] { 65, 66, 67, 68, 69 };
        // 'ABCDE' in Base64 with padding
        byte[] expected = new byte[] { 65, 66, 67, 68, 69, 61 };
        byte[] actual = Base64.encodeBase64(input, true, false);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeBase64_UrlSafeEncoding() {
        // 'A', 'B', 'C'
        byte[] input = new byte[] { 65, 66, 67 };
        // 'ABC' in Base64
        byte[] expected = new byte[] { 65, 66, 67, 61 };
        byte[] actual = Base64.encodeBase64(input, false, true);
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void testEncodeBase64_InputTooLarge() {
//        byte[] input = new byte[Integer.MAX_VALUE];
//        assertThrows(IllegalArgumentException.class, () -> {
//            Base64.encodeBase64(input, false, false, 10);
//        });
//    }
}
