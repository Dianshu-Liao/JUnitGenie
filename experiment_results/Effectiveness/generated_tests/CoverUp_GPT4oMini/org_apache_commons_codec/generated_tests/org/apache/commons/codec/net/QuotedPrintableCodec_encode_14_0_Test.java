package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class QuotedPrintableCodec_encode_14_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    void testEncode_NullInput() throws EncoderException {
        String result = codec.encode((String) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_EmptyString() throws EncoderException {
        String result = codec.encode("");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    void testEncode_SimpleString() throws EncoderException {
        String result = codec.encode("Hello World!");
        assertEquals("Hello World!", result, "Encoding 'Hello World!' should return 'Hello World!'");
    }

    @Test
    void testEncode_SpecialCharacters() throws EncoderException {
        String result = codec.encode("Hello, =World!");
        assertEquals("Hello, =World!", result, "Encoding 'Hello, =World!' should return 'Hello, =World!'");
    }

    @Test
    void testEncode_NonPrintableCharacters() throws EncoderException {
        String result = codec.encode("Hello\tWorld\n");
        assertTrue(result.contains("Hello"), "Result should contain 'Hello'");
        assertTrue(result.contains("World"), "Result should contain 'World'");
        assertTrue(result.contains("="), "Result should encode non-printable characters");
    }

    @Test
    void testEncode_LongString() throws EncoderException {
        String longString = "This is a very long string that exceeds the safe length limit set by the QuotedPrintableCodec class.";
        String result = codec.encode(longString);
        assertNotNull(result, "Encoding a long string should not return null");
        assertTrue(result.length() > longString.length(), "Encoded string should be longer due to encoding");
    }

    @Test
    void testEncode_WithCustomCharset() throws EncoderException {
        QuotedPrintableCodec customCodec = new QuotedPrintableCodec(StandardCharsets.ISO_8859_1);
        String result = customCodec.encode("Hello World!");
        assertEquals("Hello World!", result, "Encoding with ISO-8859-1 should return 'Hello World!'");
    }

    @Test
    void testEncode_WithStrictMode() throws EncoderException {
        QuotedPrintableCodec strictCodec = new QuotedPrintableCodec(true);
        String result = strictCodec.encode("Hello World!");
        assertEquals("Hello World!", result, "Encoding with strict mode should return 'Hello World!'");
    }
}
