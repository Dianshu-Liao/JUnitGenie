package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
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

class Hex_decode_20_0_Test {

    private Hex hex;

    @BeforeEach
    void setUp() {
        // Using default charset (UTF-8)
        hex = new Hex();
    }

    @Test
    void testDecode_ValidHexString() throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6f".getBytes(StandardCharsets.UTF_8));
        byte[] result = invokeDecode(buffer);
        assertArrayEquals("Hello".getBytes(StandardCharsets.UTF_8), result);
    }

    @Test
    void testDecode_EmptyString() throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8));
        byte[] result = invokeDecode(buffer);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testDecode_InvalidHexString() {
        // 'g' is invalid
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6g".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> invokeDecode(buffer));
    }

    @Test
    void testDecode_NullBuffer() {
        assertThrows(NullPointerException.class, () -> invokeDecode(null));
    }

    @Test
    void testDecode_BufferWithNonHexCharacters() {
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6f!@#".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> invokeDecode(buffer));
    }

    @Test
    void testDecode_BufferWithOddLength() {
        // Odd length
        ByteBuffer buffer = ByteBuffer.wrap("48656c6c6".getBytes(StandardCharsets.UTF_8));
        assertThrows(DecoderException.class, () -> invokeDecode(buffer));
    }

    private byte[] invokeDecode(ByteBuffer buffer) throws Exception {
        Method decodeMethod = Hex.class.getDeclaredMethod("decode", ByteBuffer.class);
        decodeMethod.setAccessible(true);
        return (byte[]) decodeMethod.invoke(hex, buffer);
    }
}
