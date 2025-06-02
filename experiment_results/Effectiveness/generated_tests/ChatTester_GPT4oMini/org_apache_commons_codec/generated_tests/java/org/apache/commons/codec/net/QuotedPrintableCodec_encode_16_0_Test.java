package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
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

public class QuotedPrintableCodec_encode_16_0_Test {

    @Test
    public void testEncode_NullSourceStr() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode(null, "UTF-8");
        Assertions.assertNull(result);
    }

    @Test
    public void testEncode_ValidInput() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "Hello World!";
        String sourceCharset = "UTF-8";
        // Assuming encode method just returns the input for this test
        String expected = "Hello World!";
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEncode_UnsupportedEncoding() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Assertions.assertThrows(UnsupportedEncodingException.class, () -> {
            codec.encode("Hello", "INVALID_CHARSET");
        });
    }

    @Test
    public void testEncode_EmptyString() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "";
        String sourceCharset = "UTF-8";
        // Assuming encode method handles empty strings
        String expected = "";
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEncode_SpecialCharacters() throws UnsupportedEncodingException {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "Hello, 世界!";
        String sourceCharset = "UTF-8";
        // Assuming encode method just returns the input for this test
        String expected = "Hello, 世界!";
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertEquals(expected, result);
    }
}
