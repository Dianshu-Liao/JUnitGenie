package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

public class Hex_decode_21_0_Test {

    private final Hex hex = new Hex();

    @Test
    public void testDecodeString() throws DecoderException {
        // "Hello" in hex
        String hexString = "48656c6c6f";
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = (byte[]) hex.decode(hexString);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeByteArray() throws DecoderException {
        // "Hello" in hex
        byte[] hexBytes = "48656c6c6f".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = (byte[]) hex.decode((Object) hexBytes);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeByteBuffer() throws DecoderException {
        // "Hello" in hex
        ByteBuffer byteBuffer = ByteBuffer.wrap("48656c6c6f".getBytes(StandardCharsets.UTF_8));
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = (byte[]) hex.decode((Object) byteBuffer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeCharArray() throws DecoderException {
        // "Hello" in hex
        char[] hexChars = "48656c6c6f".toCharArray();
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = (byte[]) hex.decode(hexChars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeInvalidString() {
        // Invalid hex
        String invalidHexString = "ZZZZ";
        assertThrows(DecoderException.class, () -> hex.decode(invalidHexString));
    }

    @Test
    public void testDecodeInvalidByteArray() {
        // Invalid hex
        byte[] invalidHexBytes = "ZZZZ".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> hex.decode((Object) invalidHexBytes));
    }

    @Test
    public void testDecodeInvalidByteBuffer() {
        // Invalid hex
        ByteBuffer invalidByteBuffer = ByteBuffer.wrap("ZZZZ".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> hex.decode((Object) invalidByteBuffer));
    }

    @Test
    public void testDecodeInvalidCharArray() {
        // Invalid hex
        char[] invalidHexChars = "ZZZZ".toCharArray();
        assertThrows(DecoderException.class, () -> hex.decode(invalidHexChars));
    }
}
