package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;

class Hex_decode_19_0_Test {

    private Hex hex;

    @BeforeEach
    void setUp() {
        hex = new Hex();
    }

    @Test
    void testDecode_ValidHexString() throws Exception {
        // "Hello" in hex
        byte[] input = "48656c6c6f".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = invokeDecode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_EmptyInput() throws Exception {
        byte[] input = "".getBytes(StandardCharsets.UTF_8);
        byte[] expected = new byte[0];
        byte[] result = invokeDecode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_InvalidHexString() {
        byte[] input = "InvalidHex".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> invokeDecode(input));
    }

    @Test
    void testDecode_NullInput() {
        assertThrows(NullPointerException.class, () -> invokeDecode(null));
    }

    @Test
    void testDecode_UpperCaseHexString() throws Exception {
        // "Hello" in hex
        byte[] input = "48656C6C6F".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = invokeDecode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_WhitespaceInHexString() {
        // "Hello" with spaces
        byte[] input = "48 65 6c 6c 6f".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> invokeDecode(input));
    }

    @Test
    void testDecode_Charset() {
        Hex hexWithCharset = new Hex(StandardCharsets.ISO_8859_1);
        assertEquals(StandardCharsets.ISO_8859_1, hexWithCharset.getCharset());
    }

    @Test
    void testDecode_CharsetName() {
        Hex hexWithCharsetName = new Hex("UTF-16");
        assertEquals("UTF-16", hexWithCharsetName.getCharsetName());
    }

    private byte[] invokeDecode(byte[] input) throws Exception {
        Method decodeMethod = Hex.class.getDeclaredMethod("decode", byte[].class);
        decodeMethod.setAccessible(true);
        return (byte[]) decodeMethod.invoke(hex, input);
    }
}
