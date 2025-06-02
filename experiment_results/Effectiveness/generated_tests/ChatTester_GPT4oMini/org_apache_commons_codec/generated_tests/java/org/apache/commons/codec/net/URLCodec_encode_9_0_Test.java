package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_9_0_Test {

    @Test
    public void testEncode_NullInput() throws UnsupportedEncodingException {
        URLCodec codec = new URLCodec();
        String result = codec.encode(null, "UTF-8");
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_ValidInput() throws UnsupportedEncodingException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("Hello World!", "UTF-8");
        assertNotNull(result, "Encoding valid input should not return null");
        assertEquals("Hello%20World%21", result, "Encoded output should match expected value");
    }

    @Test
    public void testEncode_EmptyString() throws UnsupportedEncodingException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("", "UTF-8");
        assertEquals("", result, "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        URLCodec codec = new URLCodec();
        assertThrows(UnsupportedEncodingException.class, () -> {
            codec.encode("Hello", "InvalidCharset");
        }, "Encoding with an unsupported charset should throw UnsupportedEncodingException");
    }
}
