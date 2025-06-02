package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_decode_2_0_Test {

    private final URLCodec urlCodec = new URLCodec(StandardCharsets.UTF_8.name());

    @Test
    public void testDecode_EmptyArray() throws DecoderException {
        byte[] input = new byte[] {};
        byte[] expected = new byte[] {};
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        byte[] input = null;
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(null, actual);
    }

    @Test
    public void testDecode_SimpleEncoding() throws DecoderException {
        byte[] input = "Hello%20World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_EncodedSpaces() throws DecoderException {
        byte[] input = "Hello+World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_ComplexEncoding() throws DecoderException {
        byte[] input = "Java%20is%20fun%21".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Java is fun!".getBytes(StandardCharsets.UTF_8);
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidEncoding() {
        byte[] input = "Invalid%2GEncoding".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecode_EncodedSpecialCharacters() throws DecoderException {
        byte[] input = "%24%26%2B%2C%2F%3A%3B%3D%3F%40".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "$&+,/:;=?@".getBytes(StandardCharsets.UTF_8);
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }
}
