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

public class // Reflection test for private method if needed
QuotedPrintableCodec_encode_15_0_Test {

    @Test
    public void testEncode_NullSourceString() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode(null, StandardCharsets.UTF_8);
        Assertions.assertNull(result, "Encoding null should return null.");
    }

    @Test
    public void testEncode_ValidInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "Hello World!";
        Charset sourceCharset = StandardCharsets.UTF_8;
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertNotNull(result, "Encoding valid input should not return null.");
        Assertions.assertEquals("Hello World!", result, "Encoded string should match the original.");
    }

    @Test
    public void testEncode_EmptyString() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "";
        Charset sourceCharset = StandardCharsets.UTF_8;
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertEquals("", result, "Encoding an empty string should return an empty string.");
    }

    @Test
    public void testEncode_SpecialCharacters() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        // Includes Euro sign
        String sourceStr = "Hello, World! \u20AC";
        Charset sourceCharset = StandardCharsets.UTF_8;
        String result = codec.encode(sourceStr, sourceCharset);
        Assertions.assertNotNull(result, "Encoding string with special characters should not return null.");
        // Check if the result contains the expected encoded characters
        Assertions.assertTrue(result.contains("Hello, World! =E2=82=AC"), "Encoded string should include encoded Euro sign.");
    }

    @Test
    public void testEncode_SafeLength() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        StringBuilder longString = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            longString.append("A");
        }
        Charset sourceCharset = StandardCharsets.UTF_8;
        String result = codec.encode(longString.toString(), sourceCharset);
        Assertions.assertNotNull(result, "Encoding long string should not return null.");
        Assertions.assertTrue(result.length() > 73, "Encoded string should be longer than 73 characters.");
    }
}
