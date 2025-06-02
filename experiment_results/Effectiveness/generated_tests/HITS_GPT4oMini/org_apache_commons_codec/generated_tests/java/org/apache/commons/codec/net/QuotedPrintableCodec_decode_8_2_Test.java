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

class QuotedPrintableCodec_decode_8_2_Test {

    @Test
    void testDecodeString() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Example of quoted-printable encoding
        String input = "Hello=20World";
        String expectedOutput = "Hello World";
        // This will call decode(String)
        String actualOutput = codec.decode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeByteArray() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Example of quoted-printable encoding
        byte[] input = "Hello=20World".getBytes();
        byte[] expectedOutput = "Hello World".getBytes();
        // This will call decode(byte[])
        byte[] actualOutput = codec.decode(input);
        assertEquals(new String(expectedOutput), new String(actualOutput));
    }

    @Test
    void testDecodeNull() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Object input = null;
        Object actualOutput = codec.decode(input);
        assertNull(actualOutput);
    }

    @Test
    void testDecodeInvalidType() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Invalid type
        Object input = new Object();
        try {
            codec.decode(input);
        } catch (DecoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be quoted-printable decoded", e.getMessage());
        }
    }
}
