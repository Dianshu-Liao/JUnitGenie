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

public class QuotedPrintableCodec_decode_7_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecodeValidQuotedPrintable() throws DecoderException {
        byte[] input = "Hello=20World".getBytes();
        byte[] expected = "Hello World".getBytes();
        byte[] actual = codec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeWithSoftLineBreak() throws DecoderException {
        byte[] input = "Hello=0D=0AWorld".getBytes();
        byte[] expected = "HelloWorld".getBytes();
        byte[] actual = codec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeWithMultipleSoftLineBreaks() throws DecoderException {
        byte[] input = "Hello=0D=0A=0D=0AWorld".getBytes();
        byte[] expected = "HelloWorld".getBytes();
        byte[] actual = codec.decode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDecodeInvalidQuotedPrintable() {
        byte[] input = "Hello=G0World".getBytes();
        assertThrows(DecoderException.class, () -> codec.decode(input));
    }

    @Test
    public void testDecodeNullInput() throws DecoderException {
        byte[] actual = codec.decode((byte[]) null);
        assertNull(actual);
    }

    @Test
    public void testDecodeEmptyInput() throws DecoderException {
        byte[] input = "".getBytes();
        byte[] expected = "".getBytes();
        byte[] actual = codec.decode(input);
        assertArrayEquals(expected, actual);
    }
}
