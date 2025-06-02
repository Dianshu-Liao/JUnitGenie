package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_decode_5_1_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testDecode_NullInput() throws DecoderException, UnsupportedEncodingException {
        String result = urlCodec.decode(null, "UTF-8");
        assertNull(result, "Decoding a null string should return null");
    }

    @Test
    public void testDecode_ValidInput() throws DecoderException, UnsupportedEncodingException {
        String encoded = "Hello%20World";
        String expected = "Hello World";
        String result = urlCodec.decode(encoded, "UTF-8");
        assertEquals(expected, result, "Decoded string should match the expected value");
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException, UnsupportedEncodingException {
        String result = urlCodec.decode("", "UTF-8");
        assertEquals("", result, "Decoding an empty string should return an empty string");
    }

    @Test
    public void testDecode_InvalidEncoding() {
        String encoded = "Hello%20World";
        assertThrows(UnsupportedEncodingException.class, () -> {
            urlCodec.decode(encoded, "InvalidCharset");
        }, "Decoding with an invalid charset should throw UnsupportedEncodingException");
    }

    @Test
    public void testDecode_ComplexInput() throws DecoderException, UnsupportedEncodingException {
        String encoded = "%3Chtml%3E%3Cbody%3EHello%20World%3C%2Fbody%3E%3C%2Fhtml%3E";
        String expected = "<html><body>Hello World</body></html>";
        String result = urlCodec.decode(encoded, "UTF-8");
        assertEquals(expected, result, "Decoded complex input should match the expected value");
    }

    @Test
    public void testGetDefaultCharset() {
        assertEquals("UTF-8", urlCodec.getDefaultCharset(), "Default charset should be UTF-8");
    }

    @Test
    public void testGetEncoding() {
        assertEquals("UTF-8", urlCodec.getEncoding(), "Encoding should match the default charset");
    }
}
