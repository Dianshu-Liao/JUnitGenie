package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_7_3_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testEncodeString_NullInput() throws EncoderException {
        // Test for null input
        assertNull(urlCodec.encode((String) null));
    }

    @Test
    public void testEncodeString_EmptyString() throws EncoderException {
        // Test for empty string
        assertEquals("", urlCodec.encode(""));
    }

    @Test
    public void testEncodeString_ValidString() throws EncoderException {
        // Test for a valid string
        String input = "Hello World!";
        // Expected URL encoded string
        String expected = "Hello%20World%21";
        assertEquals(expected, urlCodec.encode(input));
    }

    @Test
    public void testEncodeString_SpecialCharacters() throws EncoderException {
        // Test for string with special characters
        String input = "Café";
        // Expected URL encoded string
        String expected = "Caf%C3%A9";
        assertEquals(expected, urlCodec.encode(input));
    }

    @Test
    public void testEncodeByteArray_NullInput() throws EncoderException {
        // Test for null byte array input
        assertNull(urlCodec.encode((byte[]) null));
    }

    @Test
    public void testEncodeByteArray_EmptyArray() throws EncoderException {
        // Test for empty byte array
        assertEquals(new byte[0], urlCodec.encode(new byte[0]));
    }

    @Test
    public void testEncodeByteArray_ValidByteArray() throws EncoderException {
        // Test for a valid byte array
        byte[] input = "Hello".getBytes();
        // Assuming encode(byte[]) returns the same byte array
        byte[] expected = urlCodec.encode(input);
        assertEquals(expected, urlCodec.encode(input));
    }

    @Test
    public void testEncode_InvalidObject() {
        // Test for invalid object type
        assertThrows(EncoderException.class, () -> {
            urlCodec.encode(new Object());
        });
    }
}
