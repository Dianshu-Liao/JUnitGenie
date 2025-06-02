package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_28_0_Test {

    @Test
    public void testEncodeEmptyArray() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[0], false);
        assertEquals("", result);
    }

    @Test
    public void testEncodeSingleByte() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[] { (byte) 'A' }, false);
        assertEquals("QQ==", result);
    }

    @Test
    public void testEncodeTwoBytes() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B' }, false);
        assertEquals("QUI=", result);
    }

    @Test
    public void testEncodeThreeBytes() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' }, false);
        assertEquals("QUJD", result);
    }

    @Test
    public void testEncodeMultipleBytes() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F' }, false);
        assertEquals("QUJDRA==", result);
    }

    @Test
    public void testEncodeWithQuotes() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B', (byte) 'C' }, true);
        assertEquals("\"QUJD\"", result);
    }

    @Test
    public void testEncodeWithLineBreaks() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 4);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F' }, false);
        assertEquals("QUJD\nRA==", result);
    }

    @Test
    public void testEncodeWithMaxLineLength() {
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 8);
        String result = variant.encode(new byte[] { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F', (byte) 'G', (byte) 'H', (byte) 'I', (byte) 'J', (byte) 'K', (byte) 'L', (byte) 'M', (byte) 'N', (byte) 'O', (byte) 'P' }, false);
        assertEquals("QUJDRA==\nQUJDRA==", result);
    }
}
