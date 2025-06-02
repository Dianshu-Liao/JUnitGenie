package org.apache.commons.codec.net;

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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_12_0_Test {

    @Test
    public void testEncodeWithNullInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] result = codec.encode((byte[]) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncodeWithEmptyInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] result = codec.encode(new byte[0]);
        assertArrayEquals(new byte[0], result, "Encoding empty byte array should return empty byte array");
    }

    @Test
    public void testEncodeWithPrintableChars() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello World!".getBytes();
        // No encoding needed for printable characters
        byte[] expected = "Hello World!".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding printable characters should return the same byte array");
    }

    @Test
    public void testEncodeWithNonPrintableChars() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Non-printable characters
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        // Expected quoted-printable encoding
        byte[] expected = { '=', '0', '1', '=', '0', '2', '=', '0', '3', '=', '0', '4', '=', '0', '5' };
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding non-printable characters should return quoted-printable encoded byte array");
    }

    @Test
    public void testEncodeWithStrictMode() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(true);
        byte[] input = "Hello World!".getBytes();
        // No encoding needed for printable characters in strict mode
        byte[] expected = "Hello World!".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding in strict mode with printable characters should return the same byte array");
    }

    @Test
    public void testEncodeWithStrictModeAndShortInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec(true);
        // Single non-printable character
        byte[] input = { 0x01 };
        byte[] result = codec.encode(input);
        assertNull(result, "Encoding with strict mode and less than MIN_BYTES should return null");
    }

    @Test
    public void testEncodeWithWhitespace() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello \t World!".getBytes();
        // Tab character encoded
        byte[] expected = "Hello =09 World!".getBytes();
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result, "Encoding with whitespace should return the appropriate encoded byte array");
    }
}
