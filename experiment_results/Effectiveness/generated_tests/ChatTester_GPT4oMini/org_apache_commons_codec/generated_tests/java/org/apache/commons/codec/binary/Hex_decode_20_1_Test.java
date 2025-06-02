// Test method
package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Hex_decode_20_1_Test {

    private Hex hex;

    @BeforeEach
    public void setUp() {
        hex = new Hex();
    }

    @Test
    public void testDecode_ValidHexString() throws DecoderException {
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6f".getBytes(Hex.DEFAULT_CHARSET));
        byte[] result = hex.decode(buffer);
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result);
    }

    @Test
    public void testDecode_EmptyBuffer() throws DecoderException {
        ByteBuffer buffer = ByteBuffer.wrap("".getBytes(Hex.DEFAULT_CHARSET));
        byte[] result = hex.decode(buffer);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testDecode_InvalidHexString() {
        ByteBuffer buffer = ByteBuffer.wrap("48656g6c6f".getBytes(Hex.DEFAULT_CHARSET));
        assertThrows(DecoderException.class, () -> hex.decode(buffer));
    }

    @Test
    public void testDecode_NullBuffer() {
        assertThrows(DecoderException.class, () -> hex.decode((ByteBuffer) null));
    }

    @Test
    public void testDecode_SingleHexCharacter() throws DecoderException {
        // 'a'
        ByteBuffer buffer = ByteBuffer.wrap("61".getBytes(Hex.DEFAULT_CHARSET));
        byte[] result = hex.decode(buffer);
        assertArrayEquals(new byte[] { 97 }, result);
    }

    @Test
    public void testDecode_WhitespaceInHexString() {
        ByteBuffer buffer = ByteBuffer.wrap("48656c 6c6f".getBytes(Hex.DEFAULT_CHARSET));
        assertThrows(DecoderException.class, () -> hex.decode(buffer));
    }

    @Test
    public void testDecode_OddLengthHexString() {
        ByteBuffer buffer = ByteBuffer.wrap("48656c6".getBytes(Hex.DEFAULT_CHARSET));
        assertThrows(DecoderException.class, () -> hex.decode(buffer));
    }
}
