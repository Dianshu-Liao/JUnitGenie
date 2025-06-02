package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec_doDecoding_2_0_Test {

    private QCodec qCodec;

    @BeforeEach
    public void setUp() {
        qCodec = new QCodec();
    }

    @Test
    public void testDoDecoding_NullInput() throws DecoderException {
        byte[] result = qCodec.doDecoding(null);
        assertNull(result, "Decoding null input should return null.");
    }

    @Test
    public void testDoDecoding_EmptyInput() throws DecoderException {
        byte[] result = qCodec.doDecoding(new byte[0]);
        assertArrayEquals(new byte[0], result, "Decoding empty input should return empty byte array.");
    }

    @Test
    public void testDoDecoding_NoUnderscores() throws DecoderException {
        // Example input
        byte[] input = "Hello=20World".getBytes();
        byte[] expectedOutput = QuotedPrintableCodec.decodeQuotedPrintable(input);
        byte[] result = qCodec.doDecoding(input);
        assertArrayEquals(expectedOutput, result, "Decoding input without underscores should match expected output.");
    }

    @Test
    public void testDoDecoding_WithUnderscores() throws DecoderException {
        // Example input
        byte[] input = "Hello_20World".getBytes();
        byte[] expectedOutput = QuotedPrintableCodec.decodeQuotedPrintable(new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' });
        byte[] result = qCodec.doDecoding(input);
        assertArrayEquals(expectedOutput, result, "Decoding input with underscores should convert underscores to spaces and match expected output.");
    }

    @Test
    public void testDoDecoding_MultipleUnderscores() throws DecoderException {
        // Example input
        byte[] input = "Hello__World".getBytes();
        byte[] expectedOutput = QuotedPrintableCodec.decodeQuotedPrintable(new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', ' ', 'W', 'o', 'r', 'l', 'd' });
        byte[] result = qCodec.doDecoding(input);
        assertArrayEquals(expectedOutput, result, "Decoding input with multiple underscores should convert underscores to spaces correctly.");
    }

    @Test
    public void testDoDecoding_OnlyUnderscores() throws DecoderException {
        // Example input
        byte[] input = "____".getBytes();
        byte[] expectedOutput = QuotedPrintableCodec.decodeQuotedPrintable(new byte[] { ' ', ' ', ' ', ' ' });
        byte[] result = qCodec.doDecoding(input);
        assertArrayEquals(expectedOutput, result, "Decoding input with only underscores should return spaces.");
    }
}
