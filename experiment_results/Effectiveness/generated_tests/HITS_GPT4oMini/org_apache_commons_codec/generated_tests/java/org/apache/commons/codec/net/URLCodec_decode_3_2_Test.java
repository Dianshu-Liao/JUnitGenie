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

public class URLCodec_decode_3_2_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testDecodeString_NullInput() throws DecoderException {
        // Test case for null input
        assertNull(urlCodec.decode((String) null));
    }

    @Test
    public void testDecodeString_ValidEncodedString() throws DecoderException {
        // Test case for valid URL encoded string
        String encoded = "Hello%20World%21";
        String expected = "Hello World!";
        assertEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeString_EmptyString() throws DecoderException {
        // Test case for empty string
        assertEquals("", urlCodec.decode(""));
    }

    @Test
    public void testDecodeString_InvalidEncodedString() {
        // Test case for invalid URL encoded string
        String invalidEncoded = "Hello%20World%2";
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(invalidEncoded);
        });
    }

    @Test
    public void testDecodeByteArray_NullInput() throws DecoderException {
        // Test case for null byte array input
        assertNull(urlCodec.decode((byte[]) null));
    }

    @Test
    public void testDecodeByteArray_ValidEncodedByteArray() throws DecoderException {
        // Test case for valid URL encoded byte array
        byte[] encoded = "Hello%20World%21".getBytes();
        String expected = "Hello World!";
        assertEquals(expected, urlCodec.decode(encoded));
    }

    @Test
    public void testDecodeByteArray_EmptyByteArray() throws DecoderException {
        // Test case for empty byte array
        assertEquals("", urlCodec.decode(new byte[0]));
    }

    @Test
    public void testDecodeByteArray_InvalidEncodedByteArray() {
        // Test case for invalid URL encoded byte array
        byte[] invalidEncoded = "Hello%20World%2".getBytes();
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(invalidEncoded);
        });
    }

    @Test
    public void testDecode_InvalidObjectType() {
        // Test case for invalid object type
        assertThrows(DecoderException.class, () -> {
            urlCodec.decode(new Object());
        });
    }
}
