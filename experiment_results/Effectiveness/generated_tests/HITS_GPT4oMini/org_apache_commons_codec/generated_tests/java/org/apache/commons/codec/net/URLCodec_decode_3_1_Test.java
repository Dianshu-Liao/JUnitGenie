package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_decode_3_1_Test {

    @Test
    public void testDecode_NullInput() throws DecoderException {
        URLCodec urlCodec = new URLCodec();
        Object result = urlCodec.decode((String) null);
        assertNull(result, "Expected null when input is null");
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        URLCodec urlCodec = new URLCodec();
        String result = urlCodec.decode("");
        assertEquals("", result, "Expected empty string when input is empty string");
    }

    @Test
    public void testDecode_ValidString() throws DecoderException {
        URLCodec urlCodec = new URLCodec();
        String input = "Hello%20World";
        String expected = "Hello World";
        String result = urlCodec.decode(input);
        assertEquals(expected, result, "Expected decoded string to match");
    }

    @Test
    public void testDecode_InvalidString() {
        URLCodec urlCodec = new URLCodec();
        String input = "Invalid%String";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        }, "Expected DecoderException for invalid input");
    }
}
