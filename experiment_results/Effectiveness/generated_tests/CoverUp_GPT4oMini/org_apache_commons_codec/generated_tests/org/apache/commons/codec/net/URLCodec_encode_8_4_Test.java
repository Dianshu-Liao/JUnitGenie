package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_8_4_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testEncode_NullInput() throws Exception {
        // Test with null input
        Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        String result = (String) encodeMethod.invoke(urlCodec, (Object) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() throws Exception {
        // Test with empty string
        Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        String result = (String) encodeMethod.invoke(urlCodec, "");
        assertEquals("", result, "Encoding empty string should return empty string");
    }

    @Test
    public void testEncode_SimpleString() throws Exception {
        // Test with a simple string
        Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        String result = (String) encodeMethod.invoke(urlCodec, "Hello World");
        assertEquals("Hello%20World", result, "Encoding 'Hello World' should return 'Hello%20World'");
    }

    @Test
    public void testEncode_SpecialCharacters() throws Exception {
        // Test with special characters
        Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        String result = (String) encodeMethod.invoke(urlCodec, "!@#$%^&*()");
        assertEquals("%21%40%23%24%25%5E%26%2A%28%29", result, "Encoding '!@#$%^&*()' should return '%21%40%23%24%25%5E%26%2A%28%29'");
    }

    @Test
    public void testEncode_UnsupportedEncoding() {
        // Test for unsupported encoding
        URLCodec codec = new URLCodec("unsupported-charset");
        assertThrows(EncoderException.class, () -> {
            Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", String.class);
            encodeMethod.setAccessible(true);
            encodeMethod.invoke(codec, "Test");
        }, "Encoding with unsupported charset should throw EncoderException");
    }
}
