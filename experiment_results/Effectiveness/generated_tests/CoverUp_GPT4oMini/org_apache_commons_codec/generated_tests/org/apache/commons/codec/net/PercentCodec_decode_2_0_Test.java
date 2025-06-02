package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.PercentCodec;
import java.lang.reflect.Method;
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

class PercentCodec_decode_2_0_Test {

    @Test
    void testDecode_NullInput() throws DecoderException {
        PercentCodec codec = new PercentCodec();
        assertNull(codec.decode(null));
    }

    @Test
    void testDecode_EmptyInput() throws DecoderException {
        PercentCodec codec = new PercentCodec();
        byte[] result = codec.decode(new byte[] {});
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    void testDecode_SimpleEncoding() throws DecoderException {
        PercentCodec codec = new PercentCodec();
        // URL encoded space
        byte[] input = "%20".getBytes();
        byte[] expected = " ".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_MultipleEncodings() throws DecoderException {
        PercentCodec codec = new PercentCodec();
        // URL encoded space, exclamation, and quote
        byte[] input = "%20%21%22".getBytes();
        byte[] expected = " !\"".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_InvalidEncoding() {
        PercentCodec codec = new PercentCodec();
        // Invalid hex digit
        byte[] input = "%Z0".getBytes();
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            codec.decode(input);
        });
        assertEquals("Invalid percent decoding: ", thrown.getMessage());
    }

    @Test
    void testDecode_IncompleteEncoding() {
        PercentCodec codec = new PercentCodec();
        // Incomplete encoding
        byte[] input = "%2".getBytes();
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            codec.decode(input);
        });
        assertEquals("Invalid percent decoding: ", thrown.getMessage());
    }

    @Test
    void testDecode_PlusForSpace() throws DecoderException {
        PercentCodec codec = new PercentCodec(new byte[] {}, true);
        // Plus character should be decoded to space
        byte[] input = "+".getBytes();
        byte[] expected = " ".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDecode_MixedInput() throws DecoderException {
        PercentCodec codec = new PercentCodec(new byte[] {}, true);
        // Space, plus, exclamation
        byte[] input = "%20%2B%21".getBytes();
        byte[] expected = " +!".getBytes();
        byte[] result = codec.decode(input);
        assertArrayEquals(expected, result);
    }

    // Reflection test to invoke private method
    @Test
    void testExpectedDecodingBytes() throws Exception {
        PercentCodec codec = new PercentCodec();
        Method method = PercentCodec.class.getDeclaredMethod("expectedDecodingBytes", byte[].class);
        method.setAccessible(true);
        // URL encoded space and exclamation
        byte[] input = "%20%21".getBytes();
        // Expected decoded bytes
        int expected = 2;
        int result = (int) method.invoke(codec, (Object) input);
        assertEquals(expected, result);
    }
}
