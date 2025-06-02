package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_10_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        String result = codec.decode(null, StandardCharsets.UTF_8);
        assertNull(result, "Decoding null should return null");
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        String result = codec.decode("", StandardCharsets.UTF_8);
        assertEquals("", result, "Decoding an empty string should return an empty string");
    }

    @Test
    public void testDecode_ValidQuotedPrintable() throws DecoderException {
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(input, StandardCharsets.UTF_8);
        assertEquals(expected, result, "Decoded string should match expected value");
    }

    @Test
    public void testDecode_ValidQuotedPrintableWithNewline() throws DecoderException {
        String input = "Hello=0AWorld";
        String expected = "Hello\nWorld";
        String result = codec.decode(input, StandardCharsets.UTF_8);
        assertEquals(expected, result, "Decoded string should match expected value with newline");
    }

    @Test
    public void testDecode_InvalidQuotedPrintable() {
        // Invalid encoding
        String input = "Hello=ZZWorld";
        assertThrows(DecoderException.class, () -> {
            codec.decode(input, StandardCharsets.UTF_8);
        }, "Should throw DecoderException for invalid quoted-printable encoding");
    }

    @Test
    public void testDecode_UsingDifferentCharset() throws DecoderException {
        // "Café" in quoted-printable
        String input = "Caf=E9";
        String expected = "Café";
        String result = codec.decode(input, Charset.forName("ISO-8859-1"));
        assertEquals(expected, result, "Decoded string should match expected value with ISO-8859-1 charset");
    }
}
