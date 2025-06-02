package org.apache.commons.codec.net;

import org.apache.commons.codec.net.URLCodec;
import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class URLCodec_encode_9_0_Test {

    private URLCodec urlCodec;

    @BeforeEach
    void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    void testEncode_NullString() throws UnsupportedEncodingException {
        String result = urlCodec.encode(null, "UTF-8");
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_EmptyString() throws UnsupportedEncodingException {
        String result = urlCodec.encode("", "UTF-8");
        assertEquals("", result, "Encoding empty string should return empty string");
    }

    @Test
    void testEncode_ValidString() throws UnsupportedEncodingException {
        String result = urlCodec.encode("hello world", "UTF-8");
        assertEquals("hello%20world", result, "Encoding 'hello world' should return 'hello%20world'");
    }

    @Test
    void testEncode_SpecialCharacters() throws UnsupportedEncodingException {
        String result = urlCodec.encode("!@#$%^&*()", "UTF-8");
        assertEquals("%21%40%23%24%25%5E%26%2A%28%29", result, "Encoding special characters should work correctly");
    }

    @Test
    void testEncode_UnsupportedEncoding() {
        assertThrows(UnsupportedEncodingException.class, () -> {
            urlCodec.encode("test", "unsupported-charset");
        }, "Encoding with unsupported charset should throw UnsupportedEncodingException");
    }

    @Test
    void testEncode_UsingDifferentCharset() throws UnsupportedEncodingException {
        URLCodec customCodec = new URLCodec("ISO-8859-1");
        String result = customCodec.encode("hello world", "ISO-8859-1");
        assertEquals("hello%20world", result, "Encoding 'hello world' with ISO-8859-1 should return 'hello%20world'");
    }
}
