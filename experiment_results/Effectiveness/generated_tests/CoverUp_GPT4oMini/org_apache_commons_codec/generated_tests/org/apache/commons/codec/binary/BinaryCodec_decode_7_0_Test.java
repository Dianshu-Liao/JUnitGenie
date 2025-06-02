package org.apache.commons.codec.binary;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;

public class BinaryCodec_decode_7_0_Test {

    private BinaryCodec binaryCodec;

    @BeforeEach
    public void setUp() {
        binaryCodec = new BinaryCodec();
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        Object result = binaryCodec.decode(null);
        assertArrayEquals(new byte[] {}, (byte[]) result);
    }

    @Test
    public void testDecode_ByteArrayInput() throws DecoderException {
        byte[] input = "11000011".getBytes();
        // 11000011 in binary is 195 in decimal
        byte[] expected = { (byte) 195 };
        Object result = binaryCodec.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    public void testDecode_CharArrayInput() throws DecoderException {
        char[] input = new char[] { '1', '1', '0', '0', '0', '0', '1', '1' };
        // 11000011 in binary is 195 in decimal
        byte[] expected = { (byte) 195 };
        Object result = binaryCodec.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    public void testDecode_StringInput() throws DecoderException {
        String input = "11000011";
        // 11000011 in binary is 195 in decimal
        byte[] expected = { (byte) 195 };
        Object result = binaryCodec.decode(input);
        assertArrayEquals(expected, (byte[]) result);
    }

    @Test
    public void testDecode_InvalidInput() {
        Exception exception = assertThrows(DecoderException.class, () -> {
            binaryCodec.decode(new Object());
        });
        assertEquals("argument not a byte array", exception.getMessage());
    }

    @Test
    public void testDecode_EmptyByteArray() throws DecoderException {
        byte[] input = new byte[0];
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] {}, (byte[]) result);
    }

    @Test
    public void testDecode_EmptyCharArray() throws DecoderException {
        char[] input = new char[0];
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] {}, (byte[]) result);
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        String input = "";
        Object result = binaryCodec.decode(input);
        assertArrayEquals(new byte[] {}, (byte[]) result);
    }
}
