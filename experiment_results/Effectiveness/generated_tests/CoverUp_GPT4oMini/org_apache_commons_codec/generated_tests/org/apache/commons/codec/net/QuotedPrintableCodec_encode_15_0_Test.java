package org.apache.commons.codec.net;

import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
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

public class QuotedPrintableCodec_encode_15_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testEncode_NullInput() {
        String result = codec.encode(null, StandardCharsets.UTF_8);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() {
        String result = codec.encode("", StandardCharsets.UTF_8);
        assertEquals("", result, "Encoding empty string should return empty string");
    }

    @Test
    public void testEncode_RegularString() {
        String input = "Hello World!";
        // Example expected output
        String expected = "Hello=20World=21";
        String result = codec.encode(input, StandardCharsets.UTF_8);
        assertEquals(expected, result, "Encoding regular string failed");
    }

    @Test
    public void testEncode_StringWithSpecialChars() {
        String input = "Hello, this is a test: äöüß";
        // Example expected output
        String expected = "Hello=2C=20this=20is=20a=20test=3A=20=E4=F6=FC=DF";
        String result = codec.encode(input, StandardCharsets.UTF_8);
        assertEquals(expected, result, "Encoding string with special chars failed");
    }

    @Test
    public void testEncode_UsingDifferentCharset() {
        String input = "Hello World!";
        // Example expected output
        String expected = "Hello=20World=21";
        String result = codec.encode(input, Charset.forName("ISO-8859-1"));
        assertEquals(expected, result, "Encoding using different charset failed");
    }

    @Test
    public void testEncode_UsingUnsupportedCharset() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            codec.encode("Hello", Charset.forName("unsupported-charset"));
        });
        assertNotNull(exception, "Encoding with unsupported charset should throw IllegalArgumentException");
    }
}
