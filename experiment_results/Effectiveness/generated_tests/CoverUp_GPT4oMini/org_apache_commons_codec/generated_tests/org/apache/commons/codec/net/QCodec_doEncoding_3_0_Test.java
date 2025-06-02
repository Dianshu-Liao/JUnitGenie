package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class QCodec_doEncoding_3_0_Test {

    private QCodec qCodec;

    @BeforeEach
    void setUp() {
        qCodec = new QCodec();
    }

    @Test
    void testDoEncoding_NullInput() {
        byte[] result = invokeDoEncoding(null);
        assertNull(result);
    }

    @Test
    void testDoEncoding_EmptyInput() {
        byte[] result = invokeDoEncoding(new byte[] {});
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    void testDoEncoding_NoSpaces() {
        byte[] input = "HelloWorld".getBytes(StandardCharsets.UTF_8);
        byte[] expected = QuotedPrintableCodec.encodeQuotedPrintable(getPrintableChars(), input);
        byte[] result = invokeDoEncoding(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testDoEncoding_WithSpaces() {
        qCodec.setEncodeBlanks(true);
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = QuotedPrintableCodec.encodeQuotedPrintable(getPrintableChars(), input);
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] == 32) {
                // SPACE
                // UNDERSCORE
                expected[i] = 95;
            }
        }
        byte[] result = invokeDoEncoding(input);
        assertArrayEquals(expected, result);
    }

    private BitSet getPrintableChars() {
        try {
            java.lang.reflect.Field field = QCodec.class.getDeclaredField("PRINTABLE_CHARS");
            field.setAccessible(true);
            return (BitSet) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] invokeDoEncoding(byte[] input) {
        try {
            java.lang.reflect.Method method = QCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true);
            return (byte[]) method.invoke(qCodec, (Object) input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
