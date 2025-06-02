package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

class BCodec_encode_7_0_Test {

    private BCodec bCodec;

    @BeforeEach
    void setUp() {
        bCodec = new BCodec();
    }

    @Test
    void testEncode_ValidInput() throws EncoderException {
        String input = "Hello, World!";
        String charset = "UTF-8";
        // Assuming encodeText simply returns the input string for valid encoding
        String result = bCodec.encode(input, charset);
        assertNotNull(result);
        // Replace this with the actual expected behavior
        assertEquals(input, result);
    }

    @Test
    void testEncode_UnsupportedCharset() {
        String input = "Hello, World!";
        String charset = "INVALID_CHARSET";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            bCodec.encode(input, charset);
        });
        assertEquals("Unsupported charset: INVALID_CHARSET", exception.getMessage());
    }

    @Test
    void testEncode_NullInput() {
        String charset = "UTF-8";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            bCodec.encode(null, charset);
        });
        assertEquals("Input string cannot be null", exception.getMessage());
    }

    @Test
    void testEncode_NullCharset() {
        String input = "Hello, World!";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            // Fixed ambiguous reference by casting to String
            bCodec.encode(input, (String) null);
        });
        assertEquals("Charset cannot be null", exception.getMessage());
    }
}
