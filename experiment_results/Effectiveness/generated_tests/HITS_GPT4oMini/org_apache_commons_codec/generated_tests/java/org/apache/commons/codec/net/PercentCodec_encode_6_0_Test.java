package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.DecoderException;

public class PercentCodec_encode_6_0_Test {

    @Test
    public void testEncode_NullInput() throws EncoderException {
        PercentCodec codec = new PercentCodec();
        Object result = codec.encode(null);
        Assertions.assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_ByteArray() throws EncoderException {
        PercentCodec codec = new PercentCodec();
        byte[] input = "Hello World".getBytes();
        // Assuming encoding replaces space with %20
        byte[] expected = "Hello%20World".getBytes();
        byte[] result = codec.encode(input);
        Assertions.assertArrayEquals(expected, result, "Encoding byte array should return expected encoded result");
    }

    @Test
    public void testEncode_EmptyByteArray() throws EncoderException {
        PercentCodec codec = new PercentCodec();
        byte[] input = new byte[0];
        byte[] result = codec.encode(input);
        Assertions.assertArrayEquals(input, result, "Encoding an empty byte array should return an empty byte array");
    }

    @Test
    public void testEncode_UnsupportedType() {
        PercentCodec codec = new PercentCodec();
        Assertions.assertThrows(EncoderException.class, () -> {
            // Passing a String should throw EncoderException
            codec.encode("String input");
        }, "Encoding a String should throw EncoderException");
    }

    @Test
    public void testEncode_ByteArrayWithSpaces() throws EncoderException {
        // plusForSpace is true; we need to pass an empty byte array as the first argument
        PercentCodec codec = new PercentCodec(new byte[0], true);
        byte[] input = "Hello World".getBytes();
        // Assuming plusForSpace replaces space with +
        byte[] expected = "Hello+World".getBytes();
        byte[] result = codec.encode(input);
        Assertions.assertArrayEquals(expected, result, "Encoding byte array with plusForSpace should return expected encoded result");
    }
}
