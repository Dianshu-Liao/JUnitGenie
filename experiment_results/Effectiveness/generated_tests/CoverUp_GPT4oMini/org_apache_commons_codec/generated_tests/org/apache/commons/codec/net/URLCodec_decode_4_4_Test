package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import java.lang.reflect.Method;
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

class URLCodec_decode_4_4_Test {

    private URLCodec urlCodec;

    @BeforeEach
    void setUp() {
        urlCodec = new URLCodec("UTF-8");
    }

    @Test
    void testDecode_NullInput() {
        assertNull(invokeDecodeMethod(urlCodec, null));
    }

    @Test
    void testDecode_ValidInput() {
        String encoded = "Hello%20World";
        String expected = "Hello World";
        String actual = invokeDecodeMethod(urlCodec, encoded);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_EmptyInput() {
        String encoded = "";
        String expected = "";
        String actual = invokeDecodeMethod(urlCodec, encoded);
        assertEquals(expected, actual);
    }

    @Test
    void testDecode_InvalidEncoding() {
        URLCodec codec = new URLCodec("invalid-charset");
        String encoded = "Hello%20World";
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            invokeDecodeMethod(codec, encoded);
        });
        assertNotNull(thrown);
        assertEquals("Unsupported encoding: invalid-charset", thrown.getMessage());
    }

    @Test
    void testDecode_ComplexInput() {
        String encoded = "%3Cscript%3Ealert%28%27XSS%27%29%3C%2Fscript%3E";
        String expected = "<script>alert('XSS')</script>";
        String actual = invokeDecodeMethod(urlCodec, encoded);
        assertEquals(expected, actual);
    }

    private String invokeDecodeMethod(URLCodec codec, String input) {
        try {
            Method decodeMethod = URLCodec.class.getDeclaredMethod("decode", String.class);
            decodeMethod.setAccessible(true);
            return (String) decodeMethod.invoke(codec, input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
