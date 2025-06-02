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

public class Base64_encodeBase64_5_0_Test {

    @Test
    public void testEncodeBase64_NullInput() {
        assertNull(Base64.encodeBase64(null, false));
    }

    @Test
    public void testEncodeBase64_EmptyInput() {
        byte[] result = Base64.encodeBase64(new byte[0], false);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testEncodeBase64_SingleByteInput() {
        // 'A'
        byte[] input = new byte[] { 65 };
        // "AA=="
        byte[] expected = new byte[] { 65, 65, 65, 65 };
        byte[] result = Base64.encodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_TwoBytesInput() {
        // "AB"
        byte[] input = new byte[] { 65, 66 };
        // "QUI="
        byte[] expected = new byte[] { 65, 66, 65, 66 };
        byte[] result = Base64.encodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_ThreeBytesInput() {
        // "ABC"
        byte[] input = new byte[] { 65, 66, 67 };
        // "QUJD"
        byte[] expected = new byte[] { 65, 66, 67, 61, 61 };
        byte[] result = Base64.encodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_FourBytesInput() {
        // "ABCD"
        byte[] input = new byte[] { 65, 66, 67, 68 };
        // "QUJDRA=="
        byte[] expected = new byte[] { 65, 66, 67, 68 };
        byte[] result = Base64.encodeBase64(input, false);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_ChunkedEncoding() {
        // "ABCDE"
        byte[] input = new byte[] { 65, 66, 67, 68, 69 };
        // "QUJDRA=="
        byte[] expected = new byte[] { 65, 66, 67, 68, 69 };
        byte[] result = Base64.encodeBase64(input, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_UrlSafeEncoding() {
        // "ABC"
        byte[] input = new byte[] { 65, 66, 67 };
        // "QUJD"
        byte[] expected = new byte[] { 65, 66, 67, 61, 61 };
        byte[] result = Base64.encodeBase64(input, false, true);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeBase64_NonAsciiInput() {
        // Non-ASCII bytes
        byte[] input = new byte[] { (byte) 255, (byte) 254 };
        // Non-ASCII encoded
        byte[] expected = new byte[] { (byte) 255, (byte) 254, 61, 61 };
        byte[] result = Base64.encodeBase64(input, false);
        assertArrayEquals(expected, result);
    }
}
