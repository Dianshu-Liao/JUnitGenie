package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class URLCodec_decode_4_0_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testDecode_NullInput() throws DecoderException {
        // Fixed the ambiguous reference by explicitly casting to String
        assertNull(urlCodec.decode((String) null));
    }

    @Test
    public void testDecode_ValidInput() throws DecoderException {
        String input = "Hello%20World";
        String expectedOutput = "Hello World";
        assertEquals(expectedOutput, urlCodec.decode(input));
    }

    @Test
    public void testDecode_UnsupportedEncodingException() {
        URLCodec urlCodecWithInvalidCharset = new URLCodec("invalidCharset");
        DecoderException thrown = assertThrows(DecoderException.class, () -> {
            urlCodecWithInvalidCharset.decode("Hello%20World");
        });
        assertNotNull(thrown);
        assertTrue(thrown.getMessage().contains("UnsupportedEncodingException"));
    }

    @Test
    public void testDecode_EmptyString() throws DecoderException {
        String input = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, urlCodec.decode(input));
    }

    @Test
    public void testDecode_EncodedCharacters() throws DecoderException {
        String input = "Hello%2C%20World%21";
        String expectedOutput = "Hello, World!";
        assertEquals(expectedOutput, urlCodec.decode(input));
    }
}
