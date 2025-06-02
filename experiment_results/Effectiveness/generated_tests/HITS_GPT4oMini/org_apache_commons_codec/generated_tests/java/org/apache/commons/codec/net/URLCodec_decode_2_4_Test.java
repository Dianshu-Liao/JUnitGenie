package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
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

public class URLCodec_decode_2_4_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testDecode_ValidUrlEncoding() throws DecoderException {
        byte[] input = "Hello%20World%21".getBytes();
        byte[] expected = "Hello World!".getBytes();
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_ValidUrlEncodingWithPlus() throws DecoderException {
        byte[] input = "Hello+World%21".getBytes();
        byte[] expected = "Hello World!".getBytes();
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException {
        byte[] input = "".getBytes();
        byte[] expected = "".getBytes();
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        byte[] input = null;
        byte[] expected = null;
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidUrlEncoding() {
        byte[] input = "Hello%2".getBytes();
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecode_OnlyEscapeCharacter() throws DecoderException {
        byte[] input = "%".getBytes();
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecode_MultipleEncodedCharacters() throws DecoderException {
        byte[] input = "C%3A%5Cpath%5Cto%5Cfile.txt".getBytes();
        byte[] expected = "C:\\path\\to\\file.txt".getBytes();
        byte[] actual = urlCodec.decode(input);
        assertArrayEquals(expected, actual);
    }
}
