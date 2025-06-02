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

public class URLCodec_decode_3_4_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testDecodeString_NullInput() throws DecoderException {
        assertNull(urlCodec.decode((String) null));
    }

    @Test
    public void testDecodeString_ValidInput() throws DecoderException {
        String input = "Hello%20World";
        String expected = "Hello World";
        assertEquals(expected, urlCodec.decode(input));
    }

    @Test
    public void testDecodeString_EmptyString() throws DecoderException {
        assertEquals("", urlCodec.decode(""));
    }

    @Test
    public void testDecodeString_InvalidEncoding() {
        String input = "Hello%ZZWorld";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecodeByteArray_NullInput() throws DecoderException {
        assertNull(urlCodec.decode((byte[]) null));
    }

    @Test
    public void testDecodeByteArray_ValidInput() throws DecoderException {
        byte[] input = "Hello%20World".getBytes();
        String expected = "Hello World";
        assertEquals(expected, urlCodec.decode(input));
    }

    @Test
    public void testDecodeByteArray_EmptyArray() throws DecoderException {
        assertEquals("", urlCodec.decode(new byte[0]));
    }

    @Test
    public void testDecodeByteArray_InvalidEncoding() {
        byte[] input = "Hello%ZZWorld".getBytes();
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(input);
        });
    }

    @Test
    public void testDecode_InvalidObjectType() {
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(new Object());
        });
    }
}
