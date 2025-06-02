package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_7_0_Test {

    @Test
    public void testDecodeValidQuotedPrintable() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello=20World=0A".getBytes(StandardCharsets.UTF_8);
        byte[] expectedOutput = "Hello World\n".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeWithSoftLineBreak() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello=0AWorld".getBytes(StandardCharsets.UTF_8);
        byte[] expectedOutput = "Hello\nWorld".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecodeInvalidQuotedPrintable() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "Hello=XYZ".getBytes(StandardCharsets.UTF_8);
        assertThrows(DecoderException.class, () -> codec.decode(input));
    }

    @Test
    public void testDecodeNullInput() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] result = codec.decode((byte[]) null);
        assertNull(result);
    }

    @Test
    public void testDecodeEmptyInput() throws DecoderException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = "".getBytes(StandardCharsets.UTF_8);
        byte[] expectedOutput = "".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
