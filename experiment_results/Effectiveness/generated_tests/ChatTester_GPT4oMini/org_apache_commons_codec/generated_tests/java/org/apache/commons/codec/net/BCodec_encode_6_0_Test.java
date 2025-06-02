package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_6_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        // Initialize the BCodec instance
        bCodec = new BCodec();
    }

    @Test
    public void testEncode_ValidInput() throws Exception {
        String input = "Hello, World!";
        Charset charset = StandardCharsets.UTF_8;
        // Assuming encodeText returns the same string for this charset
        String expectedOutput = "Hello, World!";
        String actualOutput = bCodec.encode(input, charset);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_EmptyString() throws Exception {
        String input = "";
        Charset charset = StandardCharsets.UTF_8;
        // Assuming encodeText handles empty strings correctly
        String expectedOutput = "";
        String actualOutput = bCodec.encode(input, charset);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_NullInput() {
        Charset charset = StandardCharsets.UTF_8;
        Exception exception = assertThrows(EncoderException.class, () -> {
            bCodec.encode(null, charset);
        });
        // Assuming this is the expected exception message
        String expectedMessage = "Input string cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testEncode_InvalidCharset() {
        String input = "Hello, World!";
        // Assuming this charset is invalid
        Charset charset = Charset.forName("INVALID_CHARSET");
        Exception exception = assertThrows(EncoderException.class, () -> {
            bCodec.encode(input, charset);
        });
        // Assuming this is the expected exception message
        String expectedMessage = "Charset not supported";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testEncode_ValidInputWithDifferentCharset() throws Exception {
        String input = "Hello, World!";
        Charset charset = StandardCharsets.ISO_8859_1;
        // Assuming encodeText returns the same string for this charset
        String expectedOutput = "Hello, World!";
        String actualOutput = bCodec.encode(input, charset);
        assertEquals(expectedOutput, actualOutput);
    }
}
