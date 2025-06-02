package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
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

class URLCodec_decode_5_0_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    void testDecode_ValidInput() throws DecoderException, UnsupportedEncodingException {
        String encoded = "Hello%20World";
        String charset = "UTF-8";
        String expected = "Hello World";
        String result = urlCodec.decode(encoded, charset);
        assertEquals(expected, result);
    }

    @Test
    void testDecode_NullInput() throws DecoderException, UnsupportedEncodingException {
        String result = urlCodec.decode(null, "UTF-8");
        assertNull(result);
    }

    @Test
    void testDecode_EmptyString() throws DecoderException, UnsupportedEncodingException {
        String result = urlCodec.decode("", "UTF-8");
        assertEquals("", result);
    }

    @Test
    void testDecode_UnsupportedEncoding() {
        String encoded = "Hello%20World";
        String charset = "INVALID_CHARSET";
        assertThrows(UnsupportedEncodingException.class, () -> {
            urlCodec.decode(encoded, charset);
        });
    }

    @Test
    void testDecode_ValidInputWithDifferentCharset() throws DecoderException, UnsupportedEncodingException {
        // "日本語" in percent encoding
        String encoded = "%E6%97%A5%E6%9C%AC%E8%AA%9E";
        String charset = "UTF-8";
        String expected = "日本語";
        String result = urlCodec.decode(encoded, charset);
        assertEquals(expected, result);
    }
}
