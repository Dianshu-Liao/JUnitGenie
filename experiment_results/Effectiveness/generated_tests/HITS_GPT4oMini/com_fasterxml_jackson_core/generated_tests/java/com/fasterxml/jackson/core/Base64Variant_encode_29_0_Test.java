package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_29_0_Test {

    @Test
    public void testEncodeWithQuotesAndLinefeed() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = "Hello World".getBytes();
        String expected = "\"SGVsbG8gV29ybGQ=\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithoutQuotesAndLinefeed() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', 76);
        byte[] input = "Hello".getBytes();
        String expected = "SGVsbG8=";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithNoLinefeed() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', Integer.MAX_VALUE);
        byte[] input = "Hello".getBytes();
        String expected = "SGVsbG8=";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithEmptyInput() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[0];
        String expected = "\"\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithSingleByteInput() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', 76);
        byte[] input = new byte[] { (byte) 'A' };
        String expected = "QQ==";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithTwoBytesInput() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', 76);
        byte[] input = new byte[] { (byte) 'A', (byte) 'B' };
        String expected = "QUI=";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithThreeBytesInput() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', 76);
        byte[] input = new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' };
        String expected = "QUJD";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithMaxLineLength() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '=', 4);
        byte[] input = "ABCD".getBytes();
        String expected = "QUJD\n";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }
}
