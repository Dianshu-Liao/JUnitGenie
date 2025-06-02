package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

class QCodec_doDecoding_2_0_Test {

    private QCodec qCodec;

    @BeforeEach
    void setUp() {
        qCodec = new QCodec();
    }

    @Test
    void testDoDecoding_NullInput() throws Exception {
        byte[] result = invokeDoDecoding(null);
        assertNull(result);
    }

    @Test
    void testDoDecoding_NoUnderscores() throws Exception {
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = QuotedPrintableCodec.decodeQuotedPrintable(input);
        byte[] result = invokeDoDecoding(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDoDecoding_WithUnderscores() throws Exception {
        byte[] input = "Hello_World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = QuotedPrintableCodec.decodeQuotedPrintable("Hello World".getBytes(StandardCharsets.UTF_8));
        byte[] result = invokeDoDecoding(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDoDecoding_EmptyInput() throws Exception {
        byte[] input = "".getBytes(StandardCharsets.UTF_8);
        byte[] expected = QuotedPrintableCodec.decodeQuotedPrintable(input);
        byte[] result = invokeDoDecoding(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDoDecoding_OnlyUnderscores() throws Exception {
        byte[] input = "_".getBytes(StandardCharsets.UTF_8);
        byte[] expected = " ".getBytes(StandardCharsets.UTF_8);
        byte[] result = invokeDoDecoding(input);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeDoDecoding(byte[] input) throws Exception {
        Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(qCodec, (Object) input);
    }
}
