package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_decode_5_0_Test {

    private final URLCodec urlCodec = new URLCodec("UTF-8");

    @Test
    public void testDecode_ValidInput() throws DecoderException, UnsupportedEncodingException {
        String input = "hello%20world";
        String expected = "hello world";
        String actual = urlCodec.decode(input, "UTF-8");
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_EmptyInput() throws DecoderException, UnsupportedEncodingException {
        String input = "";
        String expected = "";
        String actual = urlCodec.decode(input, "UTF-8");
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_NullInput() throws DecoderException, UnsupportedEncodingException {
        String input = null;
        String actual = urlCodec.decode(input, "UTF-8");
        assertNull(actual);
    }

    @Test
    public void testDecode_ValidEncodedInputWithDifferentCharset() throws DecoderException, UnsupportedEncodingException {
        // "日本語" in percent-encoded form
        String input = "%E6%97%A5%E6%9C%AC%E8%AA%9E";
        // Expected decoded string
        String expected = "日本語";
        String actual = urlCodec.decode(input, "UTF-8");
        assertEquals(expected, actual);
    }

    @Test
    public void testDecode_InvalidInput() {
        String input = "invalid%string";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input, "UTF-8");
        });
    }

    @Test
    public void testDecode_SpecialCharacters() throws DecoderException, UnsupportedEncodingException {
        // "!@#$%^&*()"
        String input = "%21%40%23%24%25%5E%26%2A%28%29";
        String expected = "!@#$%^&*()";
        String actual = urlCodec.decode(input, "UTF-8");
        assertEquals(expected, actual);
    }
}
