package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_6_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec();
    }

    @Test
    public void testEncode_ValidInput_UTF8() throws EncoderException {
        String input = "Hello, World!";
        Charset charset = StandardCharsets.UTF_8;
        // Assuming encodeText simply returns the same string
        String expected = "Hello, World!";
        String actual = bCodec.encode(input, charset);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncode_ValidInput_ISO88591() throws EncoderException {
        String input = "Bonjour le monde!";
        Charset charset = Charset.forName("ISO-8859-1");
        // Assuming encodeText simply returns the same string
        String expected = "Bonjour le monde!";
        String actual = bCodec.encode(input, charset);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        String input = "";
        Charset charset = StandardCharsets.UTF_8;
        // Assuming encodeText simply returns the same string
        String expected = "";
        String actual = bCodec.encode(input, charset);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncode_NullInput() {
        Charset charset = StandardCharsets.UTF_8;
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(null, charset);
        });
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        String input = "Test";
        Charset charset = Charset.forName("UnsupportedCharset");
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(input, charset);
        });
    }
}
