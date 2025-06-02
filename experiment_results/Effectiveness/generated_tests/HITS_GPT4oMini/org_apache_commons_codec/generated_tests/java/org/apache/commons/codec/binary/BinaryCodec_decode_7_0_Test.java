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

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testDecode_NullInput() throws DecoderException {
        byte[] expected = new byte[0];
        byte[] actual = (byte[]) binaryCodec.decode(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyByteArray() throws DecoderException {
        byte[] expected = new byte[0];
        byte[] actual = (byte[]) binaryCodec.decode(new byte[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyCharArray() throws DecoderException {
        byte[] expected = new byte[0];
        byte[] actual = (byte[]) binaryCodec.decode(new char[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_ValidByteArray() throws DecoderException {
        // 85 in binary
        byte[] asciiInput = new byte[] { '1', '0', '1', '0', '1', '0', '1', '0' };
        byte[] expected = new byte[] { 85 };
        byte[] actual = (byte[]) binaryCodec.decode(asciiInput);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_ValidCharArray() throws DecoderException {
        // 85 in binary
        char[] asciiInput = new char[] { '1', '0', '1', '0', '1', '0', '1', '0' };
        byte[] expected = new byte[] { 85 };
        byte[] actual = (byte[]) binaryCodec.decode(asciiInput);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_ValidString() throws DecoderException {
        // 170 in binary
        String asciiInput = "10101010";
        byte[] expected = new byte[] { (byte) 170 };
        byte[] actual = (byte[]) binaryCodec.decode(asciiInput);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidInput() {
        assertThrows(DecoderException.class, () -> {
            binaryCodec.decode(new Object());
        });
    }
}
