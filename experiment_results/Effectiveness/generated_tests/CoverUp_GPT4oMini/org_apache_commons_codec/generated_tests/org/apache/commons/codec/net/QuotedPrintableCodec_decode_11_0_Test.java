package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
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

class QuotedPrintableCodec_decode_11_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    void testDecode_NullSource() throws DecoderException, UnsupportedEncodingException {
        String result = codec.decode(null, "UTF-8");
        assertNull(result);
    }

    @Test
    void testDecode_ValidInput() throws DecoderException, UnsupportedEncodingException {
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(input, "UTF-8");
        assertEquals(expected, result);
    }

    @Test
    void testDecode_EmptyString() throws DecoderException, UnsupportedEncodingException {
        String result = codec.decode("", "UTF-8");
        assertEquals("", result);
    }

    @Test
    void testDecode_InvalidCharset() {
        String input = "Hello=20World";
        assertThrows(UnsupportedEncodingException.class, () -> {
            codec.decode(input, "InvalidCharset");
        });
    }

    @Test
    void testDecode_SpecialCharacters() throws DecoderException, UnsupportedEncodingException {
        String input = "Quoted=20Printable=0ACodec";
        String expected = "Quoted Printable\nCodec";
        String result = codec.decode(input, "UTF-8");
        assertEquals(expected, result);
    }

    @Test
    void testDecode_StrictMode() throws DecoderException, UnsupportedEncodingException {
        QuotedPrintableCodec strictCodec = new QuotedPrintableCodec(true);
        String input = "Hello=World";
        // Note: In strict mode, the '=' should not be decoded
        String expected = "Hello=World";
        String result = strictCodec.decode(input, "UTF-8");
        assertEquals(expected, result);
    }

    @Test
    void testDecode_CharsetHandling() throws DecoderException, UnsupportedEncodingException {
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(input, StandardCharsets.ISO_8859_1.name());
        assertEquals(expected, result);
    }

    // Reflection test for private method (if needed)
    @Test
    void testPrivateDecodeMethod() throws Exception {
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("decode", byte[].class);
        method.setAccessible(true);
        byte[] input = "Hello=20World".getBytes(StandardCharsets.US_ASCII);
        byte[] result = (byte[]) method.invoke(codec, (Object) input);
        String decodedResult = new String(result, StandardCharsets.UTF_8);
        assertEquals("Hello World", decodedResult);
    }
}
