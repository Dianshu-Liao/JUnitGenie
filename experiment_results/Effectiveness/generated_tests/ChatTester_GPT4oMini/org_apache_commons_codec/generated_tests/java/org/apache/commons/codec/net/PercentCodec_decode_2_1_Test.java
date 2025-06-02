package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;

public class PercentCodec_decode_2_1_Test {

    private final PercentCodec percentCodec = new PercentCodec();

    @Test
    public void testDecode_NullInput() {
        assertThrows(DecoderException.class, () -> percentCodec.decode(null));
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException {
        byte[] result = percentCodec.decode(new byte[0]);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    public void testDecode_ValidInputWithEscape() throws DecoderException {
        // Represents ASCII character 'A'
        byte[] input = new byte[] { '%', '4', '1' };
        byte[] expected = new byte[] { 'A' };
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_ValidInputWithPlus() throws DecoderException {
        PercentCodec percentCodecWithPlus = new PercentCodec(new byte[0], true);
        byte[] input = new byte[] { '+', '%', '3', '2' };
        byte[] expected = new byte[] { ' ', '2' };
        byte[] result = percentCodecWithPlus.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_InvalidEscapeSequence() {
        // Invalid hex digit
        byte[] input = new byte[] { '%', 'Z', '1' };
        assertThrows(DecoderException.class, () -> percentCodec.decode(input));
    }

    @Test
    public void testDecode_IncompleteEscapeSequence() {
        // Incomplete escape sequence
        byte[] input = new byte[] { '%', '4' };
        assertThrows(DecoderException.class, () -> percentCodec.decode(input));
    }

    @Test
    public void testDecode_MultipleEscapes() throws DecoderException {
        byte[] input = new byte[] { '%', '4', '1', '%', '3', '2' };
        byte[] expected = new byte[] { 'A', '2' };
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_NoEscape() throws DecoderException {
        byte[] input = new byte[] { 'H', 'e', 'l', 'l', 'o' };
        byte[] expected = new byte[] { 'H', 'e', 'l', 'l', 'o' };
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }
}
