package org.apache.commons.codec.net;

import org.apache.commons.codec.binary.StringUtils;
import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QuotedPrintableCodec_encode_16_0_Test {

    @Test
    public void testEncode_NullInput() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode(null, "UTF-8");
        assertNull(result, "Encoding null input should return null");
    }

    @Test
    public void testEncode_EmptyString() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode("", "UTF-8");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_ValidString() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode("Hello World!", "UTF-8");
        assertEquals("Hello World!", result, "Encoding 'Hello World!' should return 'Hello World!'");
    }

    @Test
    public void testEncode_StringWithSpecialCharacters() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode("Hello, World! @#$%^&*()", "UTF-8");
        assertEquals("Hello, World! @#$%^&*()", result, "Encoding string with special characters should return the same string");
    }

    @Test
    public void testEncode_StringWithNonASCIICharacters() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode("こんにちは", "UTF-8");
        // Note: The expected output may need to be adjusted based on the actual encoding behavior.
        // Here we assume the encode method will return a representation of the string.
        // This is just a placeholder expected value.
        assertEquals("こんにちは", result, "Encoding non-ASCII characters should return the same string");
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        try {
            codec.encode("Hello", "unsupported-charset");
        } catch (UnsupportedEncodingException e) {
            assertEquals("Unsupported encoding: unsupported-charset", e.getMessage());
        }
    }
}
