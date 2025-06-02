package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
import java.lang.reflect.Field;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec_doEncoding_3_1_Test {

    private QCodec qCodec;

    @BeforeEach
    public void setUp() {
        qCodec = new QCodec();
    }

    @Test
    public void testDoEncoding_NullInput() {
        byte[] result = qCodec.doEncoding(null);
        assertNull(result, "Expected null output for null input");
    }

    @Test
    public void testDoEncoding_EmptyInput() {
        byte[] result = qCodec.doEncoding(new byte[0]);
        assertArrayEquals(new byte[0], result, "Expected empty output for empty input");
    }

    @Test
    public void testDoEncoding_SingleSpace() throws Exception {
        byte[] input = new byte[] { 32 };
        byte[] expected = new byte[] { 95 };
        setEncodeBlanks(qCodec, true);
        byte[] result = qCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Expected SPACE to be encoded as UNDERSCORE");
    }

    @Test
    public void testDoEncoding_SinglePrintableCharacter() {
        byte[] input = new byte[] { 65 };
        byte[] expected = QuotedPrintableCodec.encodeQuotedPrintable(new BitSet(), input);
        byte[] result = qCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Expected encoding of single printable character to match");
    }

    @Test
    public void testDoEncoding_MultiplePrintableCharacters() {
        byte[] input = new byte[] { 65, 66, 67 };
        byte[] expected = QuotedPrintableCodec.encodeQuotedPrintable(new BitSet(), input);
        byte[] result = qCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Expected encoding of multiple printable characters to match");
    }

    @Test
    public void testDoEncoding_WithBlanks() throws Exception {
        byte[] input = new byte[] { 65, 32, 66 };
        byte[] expected = new byte[] { 65, 95, 66 };
        setEncodeBlanks(qCodec, true);
        byte[] result = qCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Expected SPACE to be encoded as UNDERSCORE when encodeBlanks is true");
    }

    @Test
    public void testDoEncoding_WithoutBlanks() throws Exception {
        byte[] input = new byte[] { 65, 32, 66 };
        byte[] expected = QuotedPrintableCodec.encodeQuotedPrintable(new BitSet(), input);
        setEncodeBlanks(qCodec, false);
        byte[] result = qCodec.doEncoding(input);
        assertArrayEquals(expected, result, "Expected SPACE to remain unchanged when encodeBlanks is false");
    }

    private void setEncodeBlanks(QCodec qCodec, boolean value) throws Exception {
        Field field = QCodec.class.getDeclaredField("encodeBlanks");
        field.setAccessible(true);
        field.set(qCodec, value);
    }
}
