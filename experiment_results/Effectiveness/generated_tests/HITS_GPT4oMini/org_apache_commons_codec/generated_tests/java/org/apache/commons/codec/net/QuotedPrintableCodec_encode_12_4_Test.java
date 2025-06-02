package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_12_4_Test {

    @Test
    public void testEncode_NullInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] result = codec.encode((byte[]) null);
        assertNull(result, "Encoding null input should return null.");
    }

    @Test
    public void testEncode_EmptyInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] result = codec.encode(new byte[0]);
        assertArrayEquals(new byte[0], result, "Encoding empty input should return an empty byte array.");
    }

    @Test
    public void testEncode_PrintableCharacters() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello World!".getBytes(StandardCharsets.UTF_8);
        // Expected output should be the same for printable characters
        byte[] expected = "Hello World!".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding printable characters should return the same byte array.");
    }

    @Test
    public void testEncode_NonPrintableCharacters() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Non-printable characters
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        // Expected encoded output
        byte[] expected = { 61, 1, 61, 2, 61, 3, 61, 4 };
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding non-printable characters should return the expected encoded byte array.");
    }

    @Test
    public void testEncode_StrictMode() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(true);
        byte[] input = "Hello World!".getBytes(StandardCharsets.UTF_8);
        // Expected output should be the same for printable characters
        byte[] expected = "Hello World!".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding in strict mode with printable characters should return the same byte array.");
    }

    @Test
    public void testEncode_StrictModeWithShortInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(true);
        // Input shorter than MIN_BYTES
        byte[] input = { 0x01 };
        byte[] result = codec.encode(input);
        assertNull(result, "Encoding input shorter than MIN_BYTES in strict mode should return null.");
    }
}
