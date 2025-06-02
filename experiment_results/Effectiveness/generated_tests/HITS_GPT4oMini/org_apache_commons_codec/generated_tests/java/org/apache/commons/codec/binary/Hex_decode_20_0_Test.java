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

public class Hex_decode_20_0_Test {

    private final Hex hex = new Hex();

    @Test
    public void testDecode_ValidHexString() throws DecoderException {
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6f".getBytes(StandardCharsets.UTF_8));
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = hex.decode(buffer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyBuffer() throws DecoderException {
        ByteBuffer buffer = ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8));
        byte[] expected = new byte[0];
        byte[] actual = hex.decode(buffer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidHexString() {
        ByteBuffer buffer = ByteBuffer.wrap("InvalidHex".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> hex.decode(buffer));
    }

    @Test
    public void testDecode_NonHexCharacters() {
        ByteBuffer buffer = ByteBuffer.wrap("123G".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> hex.decode(buffer));
    }

    @Test
    public void testDecode_SingleByteHex() throws DecoderException {
        // 'a'
        ByteBuffer buffer = ByteBuffer.wrap("61".getBytes(StandardCharsets.UTF_8));
        // ASCII value of 'a'
        byte[] expected = new byte[] { 97 };
        byte[] actual = hex.decode(buffer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_UppercaseHex() throws DecoderException {
        ByteBuffer buffer = ByteBuffer.wrap("48656C6C6F".getBytes(StandardCharsets.UTF_8));
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] actual = hex.decode(buffer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_LargeHexString() throws DecoderException {
        // "Hello World!"
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6f20576f726c6421".getBytes(StandardCharsets.UTF_8));
        byte[] expected = "Hello World!".getBytes(StandardCharsets.UTF_8);
        byte[] actual = hex.decode(buffer);
        assertArrayEquals(expected, actual);
    }
}
