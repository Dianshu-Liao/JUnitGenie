package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_9_2_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecode_NullInput() throws Exception {
        String result = invokeDecodeMethod(null);
        assertNull(result, "Decoding null should return null");
    }

    @Test
    public void testDecode_EmptyString() throws Exception {
        String result = invokeDecodeMethod("");
        assertEquals("", result, "Decoding an empty string should return an empty string");
    }

    @Test
    public void testDecode_SimpleQuotedPrintable() throws Exception {
        // Represents "Hello World"
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = invokeDecodeMethod(input);
        assertEquals(expected, result, "Decoding failed for simple quoted printable string");
    }

    @Test
    public void testDecode_WithSpaces() throws Exception {
        // Represents "Hello World"
        String input = "Hello=20=World";
        String expected = "Hello World";
        String result = invokeDecodeMethod(input);
        assertEquals(expected, result, "Decoding failed for quoted printable string with spaces");
    }

    @Test
    public void testDecode_StrictMode() throws Exception {
        QuotedPrintableCodec strictCodec = new QuotedPrintableCodec(true);
        // Represents "Hello World"
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = invokeDecodeMethod(strictCodec, input);
        assertEquals(expected, result, "Decoding failed in strict mode");
    }

    @Test
    public void testDecode_InvalidInput() {
        // Invalid quoted printable
        String input = "Invalid=ZZ";
        assertThrows(DecoderException.class, () -> {
            invokeDecodeMethod(input);
        }, "Decoding invalid quoted printable should throw DecoderException");
    }

    @Test
    public void testDecode_Charset() throws Exception {
        QuotedPrintableCodec utf8Codec = new QuotedPrintableCodec(StandardCharsets.UTF_8);
        // Represents "Hello✔" in UTF-8
        String input = "Hello=E2=9C=94";
        String expected = "Hello✔";
        String result = invokeDecodeMethod(utf8Codec, input);
        assertEquals(expected, result, "Decoding failed for UTF-8 encoded string");
    }

    private String invokeDecodeMethod(String input) throws Exception {
        Method decodeMethod = QuotedPrintableCodec.class.getDeclaredMethod("decode", String.class);
        decodeMethod.setAccessible(true);
        return (String) decodeMethod.invoke(codec, input);
    }

    private String invokeDecodeMethod(QuotedPrintableCodec codecInstance, String input) throws Exception {
        Method decodeMethod = QuotedPrintableCodec.class.getDeclaredMethod("decode", String.class);
        decodeMethod.setAccessible(true);
        return (String) decodeMethod.invoke(codecInstance, input);
    }
}
