package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
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
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_8_0_Test {

    @Test
    public void testDecode_NullInput() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Explicitly cast null to String
        Object result = codec.decode((String) null);
        assertNull(result, "Expected null when input is null");
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.decode("").toString();
        assertEquals("", result, "Expected empty string when input is empty");
    }

    @Test
    public void testDecode_ValidQuotedPrintableString() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Represents "Hello World"
        String input = "Hello=20World";
        String expected = "Hello World";
        String result = codec.decode(input);
        assertEquals(expected, result, "Expected decoded string to match");
    }

    @Test
    public void testDecode_InvalidInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Exception exception = assertThrows(DecoderException.class, () -> {
            // Passing an unsupported type
            codec.decode(new Object());
        });
        assertEquals("Objects of type java.lang.Object cannot be quoted-printable decoded", exception.getMessage());
    }
}
