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

public class URLCodec_encode_7_0_Test {

    @Test
    public void testEncode_NullInput() throws EncoderException {
        URLCodec urlCodec = new URLCodec();
        // Explicitly cast to String
        Object result = urlCodec.encode((String) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        URLCodec urlCodec = new URLCodec();
        String result = urlCodec.encode("");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_ValidString() throws EncoderException {
        URLCodec urlCodec = new URLCodec();
        String input = "Hello World!";
        // Expected URL-encoded string
        String expected = "Hello%20World%21";
        String result = urlCodec.encode(input);
        assertEquals(expected, result, "Encoding 'Hello World!' should return 'Hello%20World%21'");
    }

    @Test
    public void testEncode_NonAsciiCharacters() throws EncoderException {
        URLCodec urlCodec = new URLCodec();
        String input = "Café";
        // Expected URL-encoded string for "Café"
        String expected = "Caf%C3%A9";
        String result = urlCodec.encode(input);
        assertEquals(expected, result, "Encoding 'Café' should return 'Caf%C3%A9'");
    }

    @Test
    public void testEncode_NonStringObject() {
        URLCodec urlCodec = new URLCodec();
        Exception exception = assertThrows(EncoderException.class, () -> {
            urlCodec.encode(new Object());
        });
        assertEquals("Objects of type java.lang.Object cannot be URL encoded", exception.getMessage());
    }
}
