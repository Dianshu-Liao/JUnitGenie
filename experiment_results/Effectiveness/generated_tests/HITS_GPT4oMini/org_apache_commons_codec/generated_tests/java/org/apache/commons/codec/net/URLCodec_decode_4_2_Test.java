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

public class URLCodec_decode_4_2_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec("UTF-8");
    }

    @Test
    public void testDecode_ValidEncodedString() throws DecoderException {
        String input = "Hello%20World%21";
        String expected = "Hello World!";
        String actual = urlCodec.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        String input = "";
        String expected = "";
        String actual = urlCodec.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_NullString() throws DecoderException {
        String input = null;
        String actual = urlCodec.decode(input);
        assertNull(actual);
    }

    @Test
    public void testDecode_InvalidEncodedString() {
        // Invalid encoding
        String input = "Hello%World";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecode_EncodedSpecialCharacters() throws DecoderException {
        String input = "%21%40%23%24%25%5E%26%2A%28%29";
        String expected = "!@#$%^&*()";
        String actual = urlCodec.decode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_ValidEncodedStringWithSpaces() throws DecoderException {
        String input = "This%20is%20a%20test%21";
        String expected = "This is a test!";
        String actual = urlCodec.decode(input);
        assertEquals(expected, actual);
    }
}
