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

public class URLCodec_decode_4_3_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec("UTF-8");
    }

    @Test
    public void testDecode_NullInput() throws Exception {
        String result = invokeDecodeMethod(urlCodec, null);
        assertNull(result);
    }

    @Test
    public void testDecode_ValidEncodedString() throws Exception {
        String encoded = "Hello%20World";
        String expected = "Hello World";
        String result = invokeDecodeMethod(urlCodec, encoded);
        assertEquals(expected, result);
    }

    @Test
    public void testDecode_EmptyString() throws Exception {
        String result = invokeDecodeMethod(urlCodec, "");
        assertEquals("", result);
    }

    @Test
    public void testDecode_InvalidEncoding() {
        URLCodec codec = new URLCodec("InvalidCharset");
        assertThrows(DecoderException.class, () -> {
            invokeDecodeMethod(codec, "Hello%20World");
        });
    }

    @Test
    public void testDecode_ValidEncodedStringWithDifferentCharset() throws Exception {
        URLCodec codec = new URLCodec("ISO-8859-1");
        String encoded = "C%F3digo";
        String expected = "Código";
        String result = invokeDecodeMethod(codec, encoded);
        assertEquals(expected, result);
    }

    private String invokeDecodeMethod(URLCodec codec, String input) throws Exception {
        Method decodeMethod = URLCodec.class.getDeclaredMethod("decode", String.class);
        decodeMethod.setAccessible(true);
        return (String) decodeMethod.invoke(codec, input);
    }
}
