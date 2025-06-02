package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_5_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec(StandardCharsets.UTF_8);
    }

    @Test
    public void testEncode_ValidString_ReturnsEncodedString() throws EncoderException {
        String input = "Hello, World!";
        // Base64 encoding of the input
        String expectedOutput = "SGVsbG8sIFdvcmxkIQ==";
        String actualOutput = bCodec.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_EmptyString_ReturnsEncodedEmptyString() throws EncoderException {
        String input = "";
        // Base64 encoding of an empty string is also an empty string
        String expectedOutput = "";
        String actualOutput = bCodec.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_NullString_ThrowsEncoderException() {
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(null);
        });
    }

    @Test
    public void testEncode_SpecialCharacters_ReturnsEncodedString() throws EncoderException {
        String input = "!@#$%^&*()_+";
        // Base64 encoding of the input
        String expectedOutput = "IUAjJCVeJiooKV8r";
        String actualOutput = bCodec.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_UnicodeCharacters_ReturnsEncodedString() throws EncoderException {
        // Japanese for "Hello"
        String input = "こんにちは";
        // Base64 encoding of the input
        String expectedOutput = "44GT44KT44Gr44Gh44Gv";
        String actualOutput = bCodec.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
