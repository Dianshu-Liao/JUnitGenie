package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class URLCodec_encode_8_2_Test {

    private URLCodec urlCodec;

    @BeforeEach
    void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    void testEncode_NullInput() throws EncoderException {
        assertNull(urlCodec.encode((String) null));
    }

    @Test
    void testEncode_EmptyString() throws EncoderException {
        String result = urlCodec.encode("");
        assertEquals("", result);
    }

    @Test
    void testEncode_SimpleString() throws EncoderException {
        String result = urlCodec.encode("Hello World");
        assertEquals("Hello%20World", result);
    }

    @Test
    void testEncode_SpecialCharacters() throws EncoderException {
        String result = urlCodec.encode("!@#$%^&*()_+");
        assertEquals("%21%40%23%24%25%5E%26%2A%28%29_%2B", result);
    }

    @Test
    void testEncode_NonASCIICharacters() throws EncoderException {
        String result = urlCodec.encode("你好");
        // UTF-8 encoding
        assertEquals("%E4%BD%A0%E5%A5%BD", result);
    }

    @Test
    void testEncode_WithCustomCharset() throws Exception {
        URLCodec customCodec = new URLCodec("ISO-8859-1");
        String result = customCodec.encode("Hello World");
        // No encoding needed for ISO-8859-1
        assertEquals("Hello World", result);
    }

    @Test
    void testEncode_UnsupportedEncoding() {
        URLCodec codec = new URLCodec("unsupported-charset");
        Exception exception = assertThrows(EncoderException.class, () -> {
            codec.encode("Hello World");
        });
        assertNotNull(exception);
    }

    @Test
    void testEncode_CharsetNull() {
        URLCodec codec = new URLCodec(null);
        Exception exception = assertThrows(EncoderException.class, () -> {
            codec.encode("Hello World");
        });
        assertNotNull(exception);
    }
}
