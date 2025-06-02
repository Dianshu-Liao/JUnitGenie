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
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_11_0_Test {

    private final QuotedPrintableCodec codec = new QuotedPrintableCodec();

    @Test
    public void testDecode_NullInput() throws DecoderException, UnsupportedEncodingException {
        String result = codec.decode(null, "UTF-8");
        assertNull(result, "Decoding null should return null.");
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException, UnsupportedEncodingException {
        String result = codec.decode("", "UTF-8");
        assertEquals("", result, "Decoding an empty string should return an empty string.");
    }

    @Test
    public void testDecode_SimpleEncodedString() throws DecoderException, UnsupportedEncodingException {
        String encoded = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(encoded, "UTF-8");
        assertEquals(expected, result, "Decoded value should match the expected value.");
    }

    @Test
    public void testDecode_EncodedStringWithSpecialChars() throws DecoderException, UnsupportedEncodingException {
        String encoded = "C%3D%3D";
        String expected = "C==";
        String result = codec.decode(encoded, "UTF-8");
        assertEquals(expected, result, "Decoded value should match the expected value with special characters.");
    }

    @Test
    public void testDecode_WithUnsupportedCharset() {
        String encoded = "Hello=20World";
        assertThrows(UnsupportedEncodingException.class, () -> {
            codec.decode(encoded, "unsupported-charset");
        }, "Should throw UnsupportedEncodingException for unsupported charset.");
    }

    @Test
    public void testDecode_ValidStringWithDifferentCharset() throws DecoderException, UnsupportedEncodingException {
        String encoded = "Bonjour=20le=20monde";
        String expected = "Bonjour le monde";
        String result = codec.decode(encoded, "UTF-8");
        assertEquals(expected, result, "Decoded value should match the expected value in UTF-8.");
    }
}
