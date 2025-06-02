package org.apache.commons.codec.net;

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

public class QuotedPrintableCodec_decode_10_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecode_NullSourceStr() throws Exception {
        String result = codec.decode(null, StandardCharsets.UTF_8);
        assertNull(result);
    }

    @Test
    public void testDecode_ValidInput() throws Exception {
        String sourceStr = "Hello=20World";
        Charset sourceCharset = StandardCharsets.UTF_8;
        // Using reflection to access private decode method
        String decoded = invokeDecodeMethod(sourceStr, sourceCharset);
        assertEquals("Hello World", decoded);
    }

    @Test
    public void testDecode_EmptyString() throws Exception {
        String sourceStr = "";
        Charset sourceCharset = StandardCharsets.UTF_8;
        // Using reflection to access private decode method
        String decoded = invokeDecodeMethod(sourceStr, sourceCharset);
        assertEquals("", decoded);
    }

    @Test
    public void testDecode_InvalidCharset() {
        String sourceStr = "Hello World";
        Charset sourceCharset = Charset.forName("INVALID_CHARSET");
        assertThrows(IllegalArgumentException.class, () -> {
            codec.decode(sourceStr, sourceCharset);
        });
    }

    @Test
    public void testDecode_ValidInputWithDifferentCharset() throws Exception {
        String sourceStr = "Café=20au=20lait";
        Charset sourceCharset = StandardCharsets.ISO_8859_1;
        // Using reflection to access private decode method
        String decoded = invokeDecodeMethod(sourceStr, sourceCharset);
        assertEquals("Café au lait", decoded);
    }

    private String invokeDecodeMethod(String sourceStr, Charset sourceCharset) throws Exception {
        java.lang.reflect.Method method = QuotedPrintableCodec.class.getDeclaredMethod("decode", String.class, Charset.class);
        method.setAccessible(true);
        return (String) method.invoke(codec, sourceStr, sourceCharset);
    }
}
