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

public class PercentCodec_decode_2_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        byte[] result = percentCodec.decode(null);
        assertArrayEquals(null, result);
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException {
        byte[] result = percentCodec.decode(new byte[] {});
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testDecode_SimpleEncoding() throws DecoderException {
        byte[] input = "Hello%20World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_MultipleEncodings() throws DecoderException {
        byte[] input = "Test%20with%20multiple%20%20spaces".getBytes();
        byte[] expected = "Test with multiple  spaces".getBytes();
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_InvalidEncoding() {
        byte[] input = "Invalid%2GEncoding".getBytes();
        assertThrows(DecoderException.class, () -> percentCodec.decode(input));
    }

    @Test
    public void testDecode_EncodingAtEnd() throws DecoderException {
        byte[] input = "End%20%".getBytes();
        assertThrows(DecoderException.class, () -> percentCodec.decode(input));
    }

    @Test
    public void testDecode_EncodingWithPlusForSpace() throws DecoderException {
        percentCodec = new PercentCodec(new byte[] { '+' }, true);
        byte[] input = "Hello+World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDecode_OnlyPlus() throws DecoderException {
        percentCodec = new PercentCodec(new byte[] { '+' }, true);
        byte[] input = "+".getBytes();
        byte[] expected = " ".getBytes();
        byte[] result = percentCodec.decode(input);
        assertArrayEquals(expected, result);
    }
}
