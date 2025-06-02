package org.apache.commons.codec.net;

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
import org.apache.commons.codec.EncoderException;

public class PercentCodec_encode_5_0_Test {

    @Test
    public void testEncode_NullInput() throws Exception {
        PercentCodec codec = new PercentCodec();
        byte[] result = codec.encode(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyInput() throws Exception {
        PercentCodec codec = new PercentCodec();
        byte[] result = codec.encode(new byte[0]);
        assertArrayEquals(new byte[0], result, "Encoding empty byte array should return empty byte array");
    }

    @Test
    public void testEncode_NoEncodingNeeded() throws Exception {
        PercentCodec codec = new PercentCodec();
        byte[] input = "HelloWorld".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(input, result, "Encoding should return the same byte array when no encoding is needed");
    }

    @Test
    public void testEncode_WithSpaces() throws Exception {
        PercentCodec codec = new PercentCodec(new byte[] { ' ' }, true);
        byte[] input = "Hello World".getBytes();
        byte[] expected = "Hello+World".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding should convert spaces to plus signs");
    }

    @Test
    public void testEncode_WithSpecialCharacters() throws Exception {
        PercentCodec codec = new PercentCodec();
        byte[] input = "Hello@World!".getBytes();
        // Assuming '@' and '!' are to be encoded
        byte[] expected = "Hello%40World%21".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding should convert special characters to percent-encoded format");
    }
}
