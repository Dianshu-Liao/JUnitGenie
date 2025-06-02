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

public class URLCodec_decode_3_0_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testDecodeString_NullInput() throws DecoderException {
        assertNull(urlCodec.decode((String) null));
    }

    @Test
    public void testDecodeString_EmptyInput() throws DecoderException {
        assertEquals("", urlCodec.decode(""));
    }

    @Test
    public void testDecodeString_ValidEncodedString() throws DecoderException {
        String encoded = "Hello%20World%21";
        String expected = "Hello World!";
        assertEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeString_InvalidEncodedString() {
        String invalidEncoded = "Hello%20World%2";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(invalidEncoded);
        });
    }

    @Test
    public void testDecodeByteArray_NullInput() throws DecoderException {
        assertNull(urlCodec.decode((byte[]) null));
    }

    @Test
    public void testDecodeByteArray_EmptyInput() throws DecoderException {
        assertArrayEquals(new byte[0], urlCodec.decode(new byte[0]));
    }

    @Test
    public void testDecodeByteArray_ValidEncodedByteArray() throws DecoderException {
        // "Hello World!"
        byte[] encoded = new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33 };
        byte[] expected = "Hello World!".getBytes();
        assertArrayEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeByteArray_InvalidEncodedByteArray() {
        // Incomplete byte sequence
        byte[] invalidEncoded = new byte[] { 72, 101, 108, 108, 111 };
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(invalidEncoded);
        });
    }

    @Test
    public void testDecodeObject_NullInput() throws DecoderException {
        assertNull(urlCodec.decode((Object) null));
    }

    @Test
    public void testDecodeObject_ValidStringInput() throws DecoderException {
        String encoded = "Hello%20World%21";
        String expected = "Hello World!";
        assertEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeObject_ValidByteArrayInput() throws DecoderException {
        // "Hello World!"
        byte[] encoded = new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33 };
        byte[] expected = "Hello World!".getBytes();
        assertArrayEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeObject_InvalidInputType() {
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(new Object());
        });
    }
}
