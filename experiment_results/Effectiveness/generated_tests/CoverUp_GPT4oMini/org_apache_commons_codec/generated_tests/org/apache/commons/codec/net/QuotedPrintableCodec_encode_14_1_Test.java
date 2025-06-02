package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
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

class QuotedPrintableCodec_encode_14_1_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    void testEncode_NullInput() throws Exception {
        String result = invokeEncodeMethod(codec, null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_EmptyString() throws Exception {
        String result = invokeEncodeMethod(codec, "");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    void testEncode_SimpleString() throws Exception {
        String result = invokeEncodeMethod(codec, "Hello World");
        assertEquals("Hello World", result, "Encoding a simple string should return the same string");
    }

    @Test
    void testEncode_SpecialCharacters() throws Exception {
        String result = invokeEncodeMethod(codec, "Hello, World! @#$%^&*()");
        assertEquals("Hello, World! @#$%^&*()", result, "Encoding a string with special characters should return the same string");
    }

    @Test
    void testEncode_Whitespace() throws Exception {
        String result = invokeEncodeMethod(codec, "   ");
        assertEquals("   ", result, "Encoding a string with only whitespace should return the same string");
    }

    @Test
    void testEncode_LongString() throws Exception {
        String longString = "This is a long string that exceeds the typical length and should be encoded properly.";
        String result = invokeEncodeMethod(codec, longString);
        assertEquals(longString, result, "Encoding a long string should return the same string");
    }

    @Test
    void testEncode_StrictMode() throws Exception {
        codec = new QuotedPrintableCodec(true);
        String result = invokeEncodeMethod(codec, "Hello World");
        assertEquals("Hello World", result, "Encoding in strict mode should return the same string");
    }

    @Test
    void testEncode_Charset() throws Exception {
        codec = new QuotedPrintableCodec(StandardCharsets.ISO_8859_1);
        String result = invokeEncodeMethod(codec, "Hello World");
        assertEquals("Hello World", result, "Encoding with a specific charset should return the same string");
    }

    private String invokeEncodeMethod(QuotedPrintableCodec codec, String input) throws Exception {
        Method encodeMethod = QuotedPrintableCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        return (String) encodeMethod.invoke(codec, input);
    }
}
