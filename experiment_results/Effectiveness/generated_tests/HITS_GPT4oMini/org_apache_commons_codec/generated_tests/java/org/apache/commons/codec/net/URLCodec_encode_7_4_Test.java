package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_7_4_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testEncode_String_Null() throws EncoderException {
        // Test encoding of null string
        assertNull(urlCodec.encode((String) null));
    }

    @Test
    public void testEncode_String_Valid() throws EncoderException {
        // Test encoding of a valid string
        String input = "Hello World!";
        // Expected URL encoded string
        String expected = "Hello%20World%21";
        assertEquals(expected, urlCodec.encode(input));
    }

    @Test
    public void testEncode_ByteArray_Null() throws EncoderException {
        // Test encoding of null byte array
        assertNull(urlCodec.encode((byte[]) null));
    }

    @Test
    public void testEncode_ByteArray_Valid() throws EncoderException {
        // Test encoding of a valid byte array
        byte[] input = "Hello World!".getBytes();
        // Expected byte array after encoding
        // Expected encoded string for comparison
        String expectedString = "Hello%20World%21";
        // Encoding the string representation
        assertEquals(expectedString, urlCodec.encode(new String(input)));
    }

    @Test
    public void testEncode_InvalidObjectType() {
        // Test encoding of an invalid object type
        assertThrows(EncoderException.class, () -> {
            urlCodec.encode(new Object());
        });
    }
}
