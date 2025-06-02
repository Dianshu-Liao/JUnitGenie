package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_29_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testEncodeWithQuotes() {
        byte[] input = "Hello".getBytes();
        String expected = "\"SGVsbG8=\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithoutQuotes() {
        byte[] input = "Hello".getBytes();
        String expected = "SGVsbG8=";
        String actual = base64Variant.encode(input, false, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithLineFeed() {
        byte[] input = "Hello World".getBytes();
        String expected = "\"SGVsbG8gV29ybGQ=\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeEmptyInput() {
        byte[] input = new byte[0];
        String expected = "\"\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeSingleByteInput() {
        byte[] input = new byte[] { 0x1 };
        String expected = "\"AQ==\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeTwoByteInput() {
        byte[] input = new byte[] { 0x1, 0x2 };
        String expected = "\"AQIA\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeThreeByteInput() {
        byte[] input = new byte[] { 0x1, 0x2, 0x3 };
        String expected = "\"AQID\"";
        String actual = base64Variant.encode(input, true, "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeWithMaxLineLength() {
        // 80 bytes
        byte[] input = new byte[80];
        for (int i = 0; i < 80; i++) {
            input[i] = (byte) i;
        }
        String actual = base64Variant.encode(input, false, "\n");
        String[] lines = actual.split("\n");
        for (String line : lines) {
            assertEquals(76, line.length());
        }
    }

    @Test
    public void testEncodeInvalidBase64Alphabet() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Base64Variant("Test", "InvalidAlphabet", true, '=', 76);
        });
    }

    @Test
    public void testPrivateMethodReflection() throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("encodeBase64Chunk", StringBuilder.class, int.class);
        method.setAccessible(true);
        StringBuilder sb = new StringBuilder();
        method.invoke(base64Variant, sb, 0b110000001111111100000000);
        assertEquals("AABg", sb.toString());
    }
}
