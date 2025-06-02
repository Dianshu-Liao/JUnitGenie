package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import java.nio.charset.StandardCharsets;
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

public class BCodec_encode_7_0_Test {

    private final BCodec bCodec = new BCodec();

    @Test
    public void testEncode_ValidInput_StandardCharset() throws EncoderException {
        String input = "Hello, World!";
        String charset = StandardCharsets.UTF_8.name();
        // Assuming encodeText is implemented correctly.
        String expected = bCodec.encodeText(input, charset);
        assertEquals(expected, bCodec.encode(input, charset));
    }

    @Test
    public void testEncode_ValidInput_AnotherCharset() throws EncoderException {
        String input = "Bonjour le monde!";
        String charset = "ISO-8859-1";
        // Assuming encodeText is implemented correctly.
        String expected = bCodec.encodeText(input, charset);
        assertEquals(expected, bCodec.encode(input, charset));
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        String input = "Test String";
        String charset = "unsupported-charset";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            bCodec.encode(input, charset);
        });
        assertTrue(exception.getMessage().contains("unsupported-charset"));
    }

    @Test
    public void testEncode_NullInput() {
        String charset = StandardCharsets.UTF_8.name();
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(null, charset);
        });
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        String input = "";
        String charset = StandardCharsets.UTF_8.name();
        // Assuming encodeText is implemented correctly.
        String expected = bCodec.encodeText(input, charset);
        assertEquals(expected, bCodec.encode(input, charset));
    }
}
