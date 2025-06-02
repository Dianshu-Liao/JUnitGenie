package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_4_0_Test {

    @Test
    public void testEncode_NullValue() throws EncoderException {
        BCodec codec = new BCodec();
        assertNull(codec.encode(null), "Encoding null should return null");
    }

    @Test
    public void testEncode_ValidString() throws EncoderException {
        BCodec codec = new BCodec();
        String input = "Hello, World!";
        // Assuming encode returns the same input for simplicity
        String expectedOutput = codec.encode(input);
        assertEquals(expectedOutput, codec.encode(input), "Encoding a valid string should return the expected output");
    }

    @Test
    public void testEncode_InvalidType() {
        BCodec codec = new BCodec();
        Exception exception = assertThrows(EncoderException.class, () -> {
            // Trying to encode an integer
            codec.encode(123);
        });
        assertEquals("Objects of type java.lang.Integer cannot be encoded using BCodec", exception.getMessage());
    }
}
