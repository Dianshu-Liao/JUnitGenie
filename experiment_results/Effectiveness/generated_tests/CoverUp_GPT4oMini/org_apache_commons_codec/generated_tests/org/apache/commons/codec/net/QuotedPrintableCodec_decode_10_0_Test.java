package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

class QuotedPrintableCodec_decode_10_0_Test {

    @Test
    void testDecodeNullInput() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        assertNull(codec.decode(null, StandardCharsets.UTF_8));
    }

    @Test
    void testDecodeEmptyString() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.decode("", StandardCharsets.UTF_8);
        assertEquals("", result);
    }

    @Test
    void testDecodeSimpleQuotedPrintable() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // "Hello World" in quoted-printable
        String encoded = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(encoded, StandardCharsets.UTF_8);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeWithDifferentCharset() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(StandardCharsets.ISO_8859_1);
        // "Café" in quoted-printable
        String encoded = "Caf=C3=A9";
        String expected = "Café";
        String result = codec.decode(encoded, StandardCharsets.ISO_8859_1);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeInvalidInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Invalid quoted-printable
        String invalidEncoded = "Hello=G";
        assertThrows(DecoderException.class, () -> {
            codec.decode(invalidEncoded, StandardCharsets.UTF_8);
        });
    }

    @Test
    void testDecodeStrictMode() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(true);
        // "Hello World" in quoted-printable
        String encoded = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(encoded, StandardCharsets.UTF_8);
        assertEquals(expected, result);
    }

    @Test
    void testDecodeWithCharsetName() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec("UTF-8");
        // "Hello World" in quoted-printable
        String encoded = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(encoded, StandardCharsets.UTF_8);
        assertEquals(expected, result);
    }
}
