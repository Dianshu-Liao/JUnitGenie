package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_decodeHex_2_1_Test {

    @Test
    public void testDecodeHex_ValidLowercaseHex() throws Exception {
        // "hello" in hex
        String input = "68656c6c6f";
        byte[] expectedOutput = "hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] actualOutput = invokeDecodeHex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeHex_ValidUppercaseHex() throws Exception {
        // "hello" in hex
        String input = "48656C6C6F";
        byte[] expectedOutput = "hello".getBytes(Hex.DEFAULT_CHARSET);
        byte[] actualOutput = invokeDecodeHex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeHex_EmptyString() throws Exception {
        String input = "";
        byte[] expectedOutput = new byte[0];
        byte[] actualOutput = invokeDecodeHex(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeHex_InvalidHexLength() {
        // Invalid hex (odd length)
        String input = "123";
        assertThrows(DecoderException.class, () -> invokeDecodeHex(input));
    }

    @Test
    public void testDecodeHex_InvalidHexCharacters() {
        // Invalid hex characters
        String input = "xyz";
        assertThrows(DecoderException.class, () -> invokeDecodeHex(input));
    }

    @Test
    public void testDecodeHex_NullInput() {
        assertThrows(NullPointerException.class, () -> invokeDecodeHex(null));
    }

    private byte[] invokeDecodeHex(String input) throws Exception {
        Method method = Hex.class.getDeclaredMethod("decodeHex", String.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, input);
    }
}
