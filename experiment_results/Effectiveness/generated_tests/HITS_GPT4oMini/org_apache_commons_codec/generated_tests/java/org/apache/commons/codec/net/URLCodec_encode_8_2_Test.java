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

public class URLCodec_encode_8_2_Test {

    @Test
    public void testEncode_NullInput() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode((String) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_SimpleString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("Hello World");
        assertEquals("Hello%20World", result, "Encoding 'Hello World' should return 'Hello%20World'");
    }

    @Test
    public void testEncode_SpecialCharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("!@#$%^&*()_+");
        assertEquals("%21%40%23%24%25%5E%26%2A%28%29_%2B", result, "Encoding special characters should return the correct encoded string");
    }

    @Test
    public void testEncode_UnicodeCharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("こんにちは");
        assertEquals("%E3%81%93%E3%81%AB%E3%81%A1%E3%81%AF", result, "Encoding Japanese characters should return the correct encoded string");
    }

    @Test
    public void testEncode_Whitespace() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("   ");
        assertEquals("%20%20%20", result, "Encoding whitespace should return the correct encoded string");
    }

    @Test
    public void testEncode_SingleCharacter() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("A");
        assertEquals("A", result, "Encoding a single character 'A' should return 'A'");
    }

    @Test
    public void testEncode_ComplexString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("This is a test: 1, 2, 3!");
        assertEquals("This%20is%20a%20test%3A%201%2C%202%2C%203%21", result, "Encoding a complex string should return the correct encoded string");
    }

    @Test
    public void testEncode_NonASCIICharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("Café");
        assertEquals("Caf%C3%A9", result, "Encoding 'Café' should return the correct encoded string");
    }

    @Test
    public void testEncode_CharsetException() {
        URLCodec codec = new URLCodec("invalid-charset");
        Exception exception = assertThrows(EncoderException.class, () -> {
            codec.encode("test");
        });
        assertTrue(exception.getMessage().contains("Unsupported encoding"), "Should throw an EncoderException with message about unsupported encoding");
    }
}
